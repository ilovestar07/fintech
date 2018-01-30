/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: FCTransCoupon.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0
 * 开发人员: 陈斌
 * 开发时间: 2014-11-04
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.financial.calculator.asset.formula;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import com.financial.calculator.asset.bean.AssetInfo;
import com.financial.calculator.asset.bean.PayPlanInfo;
import com.financial.calculator.asset.bean.PayPlanInfoSort;
import com.financial.calculator.asset.bean.RateInfo;
import com.financial.calculator.util.constant.FCBasisDict;
import com.financial.calculator.util.constant.FCConstant;
import com.financial.calculator.util.constant.FCDict;
import com.fintech.util.common.MathUtil;
import com.fintech.util.date.DateUtil;

public class FCTransCoupon {

	public static final String VERSION = "@version 1.0.0.1";

	/**
	 * 收益计算
	 * 
	 * @param assetInfo
	 * @param date
	 * @return
	 */
	public static Double fcCoupon(AssetInfo assetInfo, String date) {
		Double shares = 100.00;
		if (MathUtil.convObjToDou(assetInfo.getF_face_value()) != 0.00) {
			shares = MathUtil.convObjToDou(assetInfo.getF_face_value());
		}
		return fcCoupon(assetInfo, date, shares, FCConstant.DEF_COUPON_DATA);
	}

	/**
	 * 收益计算
	 * 
	 * @param assetInfo
	 * @param date
	 * @param shares
	 * @return
	 */
	public static Double fcCoupon(AssetInfo assetInfo, String date, Double shares) {
		return fcCoupon(assetInfo, date, shares, FCConstant.DEF_COUPON_DATA);
	}

	/**
	 * 收益计算
	 * 
	 * @param assetInfo
	 * @param date
	 * @param data_type
	 * @return
	 */
	public static Double fcCoupon(AssetInfo assetInfo, String date, String data_type) {
		Double shares = 100.00;
		if (MathUtil.convObjToDou(assetInfo.getF_face_value()) != 0.00) {
			shares = MathUtil.convObjToDou(assetInfo.getF_face_value());
		}
		return fcCoupon(assetInfo, date, shares, data_type);
	}

	/**
	 * 收益计算
	 * 
	 * @param assetInfo
	 * @param date
	 * @param shares
	 * @param data_type
	 * @return
	 */
	public static Double fcCoupon(AssetInfo assetInfo, String date, Double shares, String data_type) {
		if (FCDict.ASSET_NATURE_01.equals(assetInfo.getC_asset_nature())) {
			return calPeriodPay(assetInfo, date, shares, data_type);
		} else if (FCDict.ASSET_NATURE_02.equals(assetInfo.getC_asset_nature())) {
			return calEndPay(assetInfo, date, shares, data_type);
		} else if (FCDict.ASSET_NATURE_03.equals(assetInfo.getC_asset_nature())) {
			if (FCConstant.DEF_COUPON_DATA.equals(data_type)) {
				return calNoPay(assetInfo, date, shares);
			} else {
				return calPeriodPay(assetInfo, date, shares, data_type);
			}
		}
		return 0.00;
	}

	/**
	 * 期间付息
	 * 
	 * @param assetInfo
	 * @param date
	 * @param shares
	 * @param data_type
	 * @return
	 */
	private static Double calPeriodPay(AssetInfo assetInfo, String date, Double shares, String data_type) {
		Double amt = 0.00;
		if (DateUtil.isDateBefore(assetInfo.getD_end_date(), date) == FCDict.DATA_BEFORE) {
			date = assetInfo.getD_end_date();
		}
		if (DateUtil.isDateBefore(date, assetInfo.getD_value_date()) == FCDict.DATA_BEFORE) {
			date = assetInfo.getD_value_date();
		}
		ArrayList<PayPlanInfo> payPlanList = assetInfo.getPayPlanMap().get(data_type);
		if (payPlanList == null) {
			payPlanList = assetInfo.getPayPlanMap().get(FCConstant.DEF_COUPON_DATA);
		}
		PayPlanInfoSort payPlanInfoSort = new PayPlanInfoSort();
		Collections.sort(payPlanList, payPlanInfoSort);
		if (payPlanList != null && payPlanList.size() > 0) {
			PayPlanInfo payPlanInfo;
			for (int i = 0; i < payPlanList.size(); i++) {
				payPlanInfo = payPlanList.get(i);
				if (payPlanInfo != null
						&& (DateUtil.isDateBefore(payPlanInfo.getD_start_date(), date) == FCDict.DATA_BEFORE || DateUtil
								.isDateBefore(payPlanInfo.getD_start_date(), date) == FCDict.DATA_THEN)
						&& DateUtil.isDateBefore(payPlanInfo.getD_end_date(), date) == FCDict.DATA_AFTER) {
					amt = FCCoupon.fcCoupon(assetInfo, payPlanInfo, payPlanInfo.getD_start_date(), date, shares, data_type);
					break;
				}
			}
		}
		return amt;
	}

	/**
	 * 到期付息
	 * 
	 * @param assetInfo
	 * @param date
	 * @param shares
	 * @param data_type
	 * @return
	 */
	private static Double calEndPay(AssetInfo assetInfo, String date, Double shares, String data_type) {
		Double amt = 0.00;
		if (DateUtil.isDateBefore(assetInfo.getD_end_date(), date) == FCDict.DATA_BEFORE) {
			date = assetInfo.getD_end_date();
		}
		if (DateUtil.isDateBefore(date, assetInfo.getD_value_date()) == FCDict.DATA_BEFORE) {
			date = assetInfo.getD_value_date();
		}
		ArrayList<PayPlanInfo> payPlanList = assetInfo.getPayPlanMap().get(data_type);
		if (payPlanList == null) {
			payPlanList = assetInfo.getPayPlanMap().get(FCConstant.DEF_COUPON_DATA);
		}
		if (payPlanList != null && payPlanList.size() > 0) {
			PayPlanInfo payPlanInfo = payPlanList.get(0);
			amt = FCCoupon.fcCoupon(assetInfo, payPlanInfo, assetInfo.getD_value_date(), date, shares, data_type);
		}
		return amt;
	}

	/**
	 * 贴现
	 * 
	 * @param assetInfo
	 * @param date
	 * @param shares
	 * @return
	 */
	private static Double calNoPay(AssetInfo assetInfo, String date, Double shares) {
		Double amt = 0.00;
		amt = FCCoupon.fcCoupon(assetInfo, assetInfo.getD_value_date(), date, shares, FCConstant.DEF_COUPON_DATA);
		return amt;
	}

	public static void main(String[] args) {
		AssetInfo assetInfo = new AssetInfo();
		assetInfo.setF_face_value("100.00");
		assetInfo.setC_asset_nature("02");
		assetInfo.setF_issue_price("80.00");
		assetInfo.setD_value_date("20130627");
		assetInfo.setD_end_date("20160627");
		PayPlanInfo p1 = new PayPlanInfo();
		PayPlanInfo p2 = new PayPlanInfo();
		PayPlanInfo p3 = new PayPlanInfo();
		p1.setC_data_type("00");
		p1.setD_start_date("20130627");
		p1.setD_end_date("20160627");
		p1.setC_cal_basis(FCBasisDict.BASIS_ACT_ACT);
		// p2.setC_data_type("00");
		// p2.setD_start_date("20140627");
		// p2.setD_end_date("20150627");
		// p2.setC_cal_basis(FCBasisDict.BASIS_ACT_ACT);
		// p3.setC_data_type("00");
		// p3.setD_start_date("20150627");
		// p3.setD_end_date("20160627");
		// p3.setC_cal_basis(FCBasisDict.BASIS_ACT_ACT);

		RateInfo r1 = new RateInfo();
		r1.setD_start_date("20130627");
		r1.setD_end_date("20160627");
		r1.setF_rate("0.058000000000");
		ArrayList<PayPlanInfo> pl = new ArrayList<PayPlanInfo>();
		// pl.add(p2);
		pl.add(p1);
		// pl.add(p3);
		HashMap<String, ArrayList<PayPlanInfo>> pm = new HashMap<String, ArrayList<PayPlanInfo>>();
		pm.put("00_1", pl);
		ArrayList<RateInfo> pr = new ArrayList<RateInfo>();
		pr.add(r1);
		HashMap<String, ArrayList<RateInfo>> rm = new HashMap<String, ArrayList<RateInfo>>();
		rm.put("00_1", pr);
		assetInfo.setPayPlanMap(pm);
		assetInfo.setRateMap(rm);
		System.out.println(fcCoupon(assetInfo, "20150629"));
	}
}
