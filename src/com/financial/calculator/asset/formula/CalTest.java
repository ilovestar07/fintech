package com.financial.calculator.asset.formula;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import com.hundsun.app.accounting.entity.AssetInfo;
import com.hundsun.app.accounting.entity.Assetiposition;
import com.hundsun.app.accounting.entity.Interestrate;
import com.hundsun.app.util.HsData;
import com.hundsun.app.util.HsDate;
import com.hundsun.bfm.util.FinancCalBasis;
import com.hundsun.tamcx.util.HsException;

public class CalTest {
	
	private AssetInfo assetInfo = new AssetInfo();
	private List<Interestrate> rateList;
	String caldate;
 
	@Before
    public void setUp() throws Exception{
		//计算要素设置
		assetInfo.setValue_date("20140804");//起息日
		assetInfo.setEnd_date("20160506");//到期日
		//assetInfo.setInterest_1st_date("20141104");
		//assetInfo.setInterest_last_date("20160204");
		assetInfo.setInterest_base(FinancCalBasis.BASIS_ACT_ACT);//计息基础
		assetInfo.setInterest_frequency("T");//计息频率
		assetInfo.setInterest_type("1");//付息方式 1：实际天数  2：平均值
		assetInfo.setFace_value(100);
		assetInfo.setRatio(0.062);//固定利率
		assetInfo.setSched_reset_rule(FinancCalBasis.SCHED_RULE_0);//重置节假日规则
		
		caldate = "20141103";
		rateList = getRateList(assetInfo, caldate);
	}
	
	/**
	 * 根据资产基本信息取得利率列表
	 * @param assetInfo
	 * @param caldate
	 * @return
	 * @throws Exception
	 */
	public List<Interestrate> getRateList(AssetInfo assetInfo,String caldate) throws Exception{
		//浮动利率默认后面几个区间利率与当前期间相同；未考虑已确认下一期利率的情况 TODO
		if(assetInfo!=null&&assetInfo.getRatio()!=0){
			//取当前期间开始日
			String date = FinancCalBasis.cpndatep(caldate, assetInfo.getEnd_date(), assetInfo.getInterest_frequency(), 
					assetInfo.getInterest_base(), null, assetInfo.getValue_date(), assetInfo.getInterest_1st_date(), assetInfo.getInterest_last_date(), assetInfo.getSched_reset_rule(), null, null);
			List<Interestrate> list = new ArrayList<Interestrate>();
			while(HsDate.beforeDate(date+" 000000", assetInfo.getEnd_date()+" 000000")){
				Interestrate rate = new Interestrate();
				rate.setAsset_id(assetInfo.getAsset_id());
				rate.setRate(assetInfo.getRatio());
				rate.setBegin_date(date);
				rate.setChange_date(date);
				date = FinancCalBasis.cpndaten(date, assetInfo.getEnd_date(), assetInfo.getInterest_frequency(), 
					assetInfo.getInterest_base(), null, assetInfo.getValue_date(), assetInfo.getInterest_1st_date(), assetInfo.getInterest_last_date(), assetInfo.getSched_reset_rule(), null, null);
				rate.setEnd_date(date);
				list.add(rate);
			}
			return list;
		}
		return null;
	}
	
	/**
	 * 计算实际日利率及摊销及公允价变动
	 * 未考虑还本
	 * @throws ParseException 
	 */
	@Test
	public void testRealRate() throws HsException, ParseException{
		Assetiposition position = new Assetiposition();
		position.setCost_date(caldate);
		position.setAsset_count(50000000.00);
		position.setCosts(49144650);
		position.setInterest(HsData.double2double(FinancCalBasis.accrubond(position.getAsset_count(), assetInfo.getRatio(), 
				FinancCalBasis.accrfrac(FinancCalBasis.cpndatep(caldate, assetInfo.getEnd_date(), assetInfo.getInterest_frequency(),
				assetInfo.getInterest_base(), null, assetInfo.getValue_date(), assetInfo.getInterest_1st_date(), assetInfo.getInterest_last_date(), assetInfo.getSched_reset_rule(), null, null), 
				caldate, assetInfo.getEnd_date(), assetInfo.getInterest_frequency(),
				assetInfo.getInterest_base(), null, assetInfo.getValue_date(), assetInfo.getInterest_1st_date(), assetInfo.getInterest_last_date(), assetInfo.getInterest_type(), assetInfo.getSched_reset_rule(), null, null)),2));
		position.setAjstinterate(HsData.double2double(position.getCosts()-position.getAsset_count(), 2));
		CalRealRate.calDailyRealRate(position, assetInfo, rateList);
		System.out.println(HsData.formatDouble(position.getRate(),12));
		double price = 98.32;
		double pricechg = 0;
		while(HsDate.beforeDate(position.getCost_date()+" 000000", assetInfo.getEnd_date()+" 000000")){
			//实际日利率摊销
			CalRealRate.calRealRateAmor(position, assetInfo, rateList);
			System.out.print("日期："+position.getCost_date()+"日终, 面值:"+HsData.formatDouble(position.getAsset_count())
					+" 摊余成本:"+HsData.formatDouble(position.getCosts())+" 应计利息:"+HsData.formatDouble(position.getInterest())
					+" 利息调整:"+HsData.formatDouble(position.getAjstinterate()));
			double daypricechg = CalFairPriceChg.cal(price, position.getAsset_count(), assetInfo.getFace_value(), position.getCosts(), pricechg);
			double pricevalue = CalFairPriceChg.getPriceValue(price, position.getAsset_count(), assetInfo.getFace_value());
			System.out.println(" 公允价:" + price + ",市值: " + HsData.formatDouble(pricevalue) + ",公允价变动:" + HsData.formatDouble(daypricechg));
			pricechg = HsData.double2double(pricechg+daypricechg,2);
			//切日处理
			position.setInterest(changeDate(position.getInterest()));
			position.setCost_date(caldate);
			price = HsData.double2double(price + 0.0012, 4);//债券公允净价保持4位小数
		}
	}
	
	/**
	 * 切日处理
	 * @return
	 */
	public double changeDate(){
		changeDate(0,0);
		return 0;
	}
	
	/**
	 * 切日处理
	 * @param interest
	 * @return
	 */
	public double changeDate(double interest){
		return changeDate(interest,0)[0];
	}
	
	/**
	 * 切日处理
	 * @param interest
	 * @param balsum
	 * @return
	 */
	public double[] changeDate(double interest,double balsum){
		double[] ret = {0,0};
		caldate = HsDate.addDate(caldate,1);
		if(rateList!=null&&rateList.size()>0){
			Interestrate rate = rateList.get(0);
			//下一期间，将利率列表更新，应计息字段更新
			if(caldate.equals(rate.getEnd_date())){
				interest = 0;
				balsum = 0;
				rateList.remove(0);
			}
		}
		ret[0] = interest;
		ret[1] = balsum;
		return ret;
	}
	
	/**
	 * 票面利率计提
	 * @throws HsException 
	 */
	//@Test
	public void testAccrualCoupon() throws HsException{
		double shares = 50000000.00;
		double interest = 657458.56;
		while(HsDate.beforeDate(caldate+" 000000", assetInfo.getEnd_date()+" 000000")){
			double dayInterest = CalInterest.calInterest(caldate, shares, interest, assetInfo, rateList);			
			interest = HsData.double2double(interest + dayInterest, 2);
			System.out.println("日期："+caldate+"日终, 面值:"+HsData.formatDouble(shares)
					+", 当日计提利息:"+HsData.formatDouble(dayInterest)+", 应计利息:"+HsData.formatDouble(interest));
			//切日处理
			interest = changeDate(interest);
		}
	}
	
	/**
	 * 积数法计提
	 * @throws HsException 
	 */
	//@Test
	public void testAccrualBalsum() throws HsException{
		double balsum = 0;
		double balance = 50000000.00;
		double interest = 657458.56;
		while(HsDate.beforeDate(caldate+" 000000", assetInfo.getEnd_date()+" 000000")){
			if(rateList!=null&&rateList.size()>0&&rateList.get(0)!=null){
				balsum = HsData.double2double(balsum+balance,2);
				double dayInterest = CalBalsum.cal(caldate, balsum, interest, rateList.get(0).getRate());
				interest = HsData.double2double(interest + dayInterest, 2);
				System.out.println("日期："+caldate+"日终, 积数:"+HsData.formatDouble(balsum)
						+", 当日计提利息:"+HsData.formatDouble(dayInterest)+", 应计利息:"+HsData.formatDouble(interest));
				//切日处理
				double ret[] = changeDate(interest,balsum);
				interest = ret[0];
				balsum = ret[1];
			}
		}
	}
	
	/**
	 * 直线摊销
	 * @throws HsException 
	 */
	//@Test
	public void testStraightLineAmor() throws HsException{
		double costs = 50043550;
		double face = 50000000.00;
		double discount = HsData.double2double(costs - face, 2);
		double alamor = 0;
		String startDate = caldate;
		while(HsDate.beforeDate(caldate+" 000000", assetInfo.getEnd_date()+" 000000")){
			double amor = CalStraightLine.cal(caldate, discount, alamor, startDate, assetInfo.getEnd_date());
			alamor = HsData.double2double(alamor + amor, 2);
			System.out.println("日期："+caldate+"日终, 面值:"+HsData.formatDouble(face)
					+", 当日摊销额:"+HsData.formatDouble(amor)+", 已摊销额:"+HsData.formatDouble(alamor));
			changeDate();
		}
	}

}
