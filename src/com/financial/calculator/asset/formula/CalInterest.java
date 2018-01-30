/**
 * 系统名称: 核算模块
 * 模块名称: 应计息计算
 * 类 名 称   : CalInterest
 * 软件版权: 杭州恒生电子
 * 开发人员: 戴劼颖
 * 开发时间: 20141111
 * 审核人员:
 * 相关文档:
 * 修改记录: 修改日期    修改人员  修改说明
 */
package com.financial.calculator.asset.formula;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang.StringUtils;

import com.hundsun.app.accounting.entity.AssetInfo;
import com.hundsun.app.accounting.entity.Assetiposition;
import com.hundsun.app.accounting.entity.Interestrate;
import com.hundsun.app.accounting.util.HsData;
import com.hundsun.app.util.HsDate;
import com.hundsun.app.util.IRR;
import com.hundsun.bfm.util.FinancCalBasis;
import com.hundsun.tamcx.util.HsErrorMsg;
import com.hundsun.tamcx.util.HsException;
import com.hundsun.util.SysConstants;

public class CalInterest {
 
    public static final String HUNDSUN_VERSION="@system 银行资金管理系统V3.0  @version 3.0.0.0  @lastModiDate  2014-11-11  @describe 新增应计息计算类 ";
	
    /**
	 * 根据资产基本信息、利率信息计算应计息天数因子
	 * 
	 * @param startDate
	 * @param endDate
	 * @param assetInfo
	 * @param rateList
	 * @return
	 * @throws ParseException 
	 * @throws HsException 
	 */
	public static double accrfrac(String startDate, String endDate, AssetInfo assetInfo, List<Interestrate> rateList) throws HsException {
		try{
			double ret = 1d;
			String maturity = assetInfo.getEnd_date();//到期日
			String valueDate = assetInfo.getValue_date();//起息日
			String basis = assetInfo.getInterest_base();//计息基础
			String freq  = assetInfo.getInterest_frequency();//计息频率
			String type = assetInfo.getInterest_type();//计息类型 1：实际天数 2：平均值
			String sched_rule = assetInfo.getSched_reset_rule();//节假日规则
			String endMonthRule = null;//暂时为空，资产基础信息表中无对应字段
			String firstCouponDate = assetInfo.getInterest_1st_date();//首个计息截止日
			String lastCouponDate = assetInfo.getInterest_last_date();//最后一个计息开始日
			String[] dateTypes = assetInfo.getSched_reset_cal()!=null ? assetInfo.getSched_reset_cal().split(",") : null;//计息节假日
			Map holidays = SysConstants.HOLIDAYMAP;//全部节假日
			if (FinancCalBasis.BASIS_ACT_ACT.equals(basis)) {//实际天数的期间以利率信息表为准
				if ("2".equals(type)&&!(FinancCalBasis.BASIS_UNIT_T+"").equals(freq)) {//平均值付息/计息
					if(rateList!=null&&rateList.size()>0){
						Interestrate rate = rateList.get(0);
						String start = rate.getBegin_date();
						String end = rate.getEnd_date();
						//20141218 daijy 平均值支持残段
						String startNext = FinancCalBasis.cpndaten(start, FinancCalBasis.END_DATE_MAX, freq, basis, endMonthRule, valueDate, start, null, sched_rule, dateTypes, holidays);
						if(!end.equals(startNext)){
							if(start.equals(valueDate)){
								//前残段，开始日期为前残段结束日往前再推一个期间
								start = FinancCalBasis.cpndatep(HsDate.addDate(end, -1), end, freq, basis, endMonthRule, valueDate, null, null, sched_rule, dateTypes, holidays);
							}else if(end.equals(maturity)){
								//后残段，结束日期为后残段开始日往后再推一个期间
								end = startNext;
							}
						}
						int days = HsDate.diffDate(start, end);
						Object[] f = FinancCalBasis.parseFreq(freq);
						byte period = (Byte)f[0];
						char BASIS_UNIT = ((String)f[1]).charAt(0); 
						if(period==0){
							ret = days;
						}else{
							if(BASIS_UNIT==FinancCalBasis.BASIS_UNIT_M){
								ret = days * 12 / period;
							}else{
								throw new java.lang.RuntimeException("平均值法只能对应频率到月！");
							}
						}
						int differdays = FinancCalBasis.daysdif(startDate, endDate, basis);
						ret = differdays / ret;
						return ret;
					}else{
						return ret;
					}
				}else{
					//20140731 daijy 实际天数直接调用公共方法，支持利随本清非整年
					return FinancCalBasis.accrfrac(startDate, endDate, maturity, freq, basis, endMonthRule, valueDate, firstCouponDate, lastCouponDate, type, sched_rule, dateTypes, holidays);
				}
			}else{
				return FinancCalBasis.accrfrac(startDate, endDate, maturity, freq, basis, endMonthRule, valueDate, firstCouponDate, lastCouponDate, type, sched_rule, dateTypes, holidays);
			}	
		}catch(Exception e){
			e.printStackTrace();
			throw new HsException(HsErrorMsg.ERR_DEFAULT ,"应计息因子计算失败！"+e.getMessage());
		}
	}
    
    
	/**
	 * 累计法计算当日应计息
	 * @param caldate
	 * @param startDate
	 * @param endDate
	 * @param face
	 * @param assetInfo
	 * @param rateList
	 * @return
	 * @throws HsException
	 */
	public static double calInterest(String caldate, double face, double interest, AssetInfo assetInfo, List<Interestrate> rateList) throws HsException{
		if(rateList!=null&&rateList.size()>0){
			Interestrate rate = rateList.get(0);
			double totalinterest = HsData.double2double(FinancCalBasis.accrubond(face, rate.getRate(), accrfrac(rate.getBegin_date(),HsDate.addDate(caldate, 1),assetInfo,rateList)), 2);
			double dayInterest = HsData.double2double(totalinterest-interest,2);
			return dayInterest;
		}
		return 0;
	}

}
