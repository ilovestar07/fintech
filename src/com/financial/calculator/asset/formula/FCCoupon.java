/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: FCCoupon.java
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
import com.financial.calculator.asset.bean.AssetInfo;
import com.financial.calculator.asset.bean.PayPlanInfo;
import com.financial.calculator.asset.bean.PayPlanInfoSort;
import com.financial.calculator.asset.bean.RateInfo;
import com.financial.calculator.asset.bean.RateInfoSort;
import com.financial.calculator.util.constant.FCConstant;
import com.financial.calculator.util.constant.FCDict;
import com.fintech.util.common.MathUtil;
import com.fintech.util.date.DateUtil;

public class FCCoupon {

	public static final String VERSION = "@version 1.0.0.1";

	/**
	 * 收益计算
	 * 
	 * @param assetInfo
	 * @param date
	 * @param shares
	 * @param data_type
	 * @return
	 */
	public static Double fcCoupon(AssetInfo assetInfo, String startDate, String endDate, Double shares, String data_type) {
		if (DateUtil.isDateBefore(startDate, assetInfo.getD_value_date()) == FCDict.DATA_BEFORE) {
			startDate = assetInfo.getD_value_date();
		}
		if (DateUtil.isDateBefore(assetInfo.getD_end_date(), startDate) == FCDict.DATA_BEFORE) {
			startDate = assetInfo.getD_end_date();
		}
		if (DateUtil.isDateBefore(endDate, assetInfo.getD_value_date()) == FCDict.DATA_BEFORE) {
			endDate = assetInfo.getD_value_date();
		}
		if (DateUtil.isDateBefore(assetInfo.getD_end_date(), endDate) == FCDict.DATA_BEFORE) {
			endDate = assetInfo.getD_end_date();
		}
		if (FCDict.ASSET_NATURE_01.equals(assetInfo.getC_asset_nature())) {
			return calCyclePeriodPay(assetInfo, startDate, endDate, shares, data_type);
		} else if (FCDict.ASSET_NATURE_02.equals(assetInfo.getC_asset_nature())) {
			return calEndPay(assetInfo, startDate, endDate, shares, data_type);
		} else if (FCDict.ASSET_NATURE_03.equals(assetInfo.getC_asset_nature())) {
			if (FCConstant.DEF_COUPON_DATA.equals(data_type)) {
				return calNoPay(assetInfo, startDate, endDate, shares);
			} else {
				return calCyclePeriodPay(assetInfo, startDate, endDate, shares, data_type);
			}
		}
		return 0.00;
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
	public static Double fcCoupon(AssetInfo assetInfo, PayPlanInfo payPlanInfo, String startDate, String endDate, Double shares,
			String data_type) {
		if (DateUtil.isDateBefore(startDate, assetInfo.getD_value_date()) == FCDict.DATA_BEFORE) {
			startDate = assetInfo.getD_value_date();
		}
		if (DateUtil.isDateBefore(assetInfo.getD_end_date(), startDate) == FCDict.DATA_BEFORE) {
			startDate = assetInfo.getD_end_date();
		}
		if (DateUtil.isDateBefore(endDate, assetInfo.getD_value_date()) == FCDict.DATA_BEFORE) {
			endDate = assetInfo.getD_value_date();
		}
		if (DateUtil.isDateBefore(assetInfo.getD_end_date(), endDate) == FCDict.DATA_BEFORE) {
			endDate = assetInfo.getD_end_date();
		}
		if (FCDict.ASSET_NATURE_01.equals(assetInfo.getC_asset_nature())) {
			return calPeriodPay(assetInfo, payPlanInfo, startDate, endDate, shares, data_type);
		} else if (FCDict.ASSET_NATURE_02.equals(assetInfo.getC_asset_nature())) {
			return calEndPay(assetInfo, payPlanInfo, startDate, endDate, shares, data_type);
		} else if (FCDict.ASSET_NATURE_03.equals(assetInfo.getC_asset_nature())) {
			if (FCConstant.DEF_COUPON_DATA.equals(data_type)) {
				return calNoPay(assetInfo, startDate, endDate, shares);
			} else {
				return calPeriodPay(assetInfo, payPlanInfo, startDate, endDate, shares, data_type);
			}
		}
		return 0.00;
	}

	/**
	 * 期间付息
	 * 
	 * @param assetInfo
	 * @param startDate
	 * @param endDate
	 * @param shares
	 * @param data_type
	 * @return
	 */
	private static Double calCyclePeriodPay(AssetInfo assetInfo, String startDate, String endDate, Double shares, String data_type) {
		Double amt = 0.00;
		ArrayList<PayPlanInfo> payPlanList = assetInfo.getPayPlanMap().get(data_type);
		if (payPlanList == null) {
			payPlanList = assetInfo.getPayPlanMap().get(FCConstant.DEF_COUPON_DATA);
		}
		PayPlanInfoSort payPlanInfoSort = new PayPlanInfoSort();
		Collections.sort(payPlanList, payPlanInfoSort);
		if (payPlanList != null && payPlanList.size() > 0) {
			PayPlanInfo payPlanInfo;
			for (int i = 0; i < payPlanList.size(); i++) {
				String startDateTemp;
				String endDateTemp;
				payPlanInfo = payPlanList.get(i);
				if (payPlanInfo != null
						&& (DateUtil.isDateBefore(payPlanInfo.getD_start_date(), endDate) == FCDict.DATA_BEFORE || DateUtil
								.isDateBefore(payPlanInfo.getD_start_date(), endDate) == FCDict.DATA_THEN)
						&& DateUtil.isDateBefore(payPlanInfo.getD_end_date(), startDate) == FCDict.DATA_AFTER) {
					startDateTemp = payPlanInfo.getD_start_date();
					endDateTemp = payPlanInfo.getD_end_date();
					if (DateUtil.isDateBefore(startDateTemp, startDate) == FCDict.DATA_BEFORE) {
						startDateTemp = startDate;
					}
					if (DateUtil.isDateBefore(endDateTemp, endDate) == FCDict.DATA_AFTER) {
						endDateTemp = endDate;
					}
					amt += FCCoupon.calPeriodPay(assetInfo, payPlanInfo, startDateTemp, endDateTemp, shares, data_type);
				}
			}
		}
		return amt;
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
	private static Double calPeriodPay(AssetInfo assetInfo, PayPlanInfo payPlanInfo, String startDate, String endDate,
			Double shares, String data_type) {
		Double amt = 0.00;
		ArrayList<RateInfo> rateList = assetInfo.getRateMap().get(data_type);
		RateInfoSort rateInfoSort = new RateInfoSort();
		Collections.sort(rateList, rateInfoSort);
		RateInfo rateInfo;
		if (rateList != null && rateList.size() > 0) {
			String startDateTemp;
			String endDateTemp;
			for (int j = 0; j < rateList.size(); j++) {
				rateInfo = rateList.get(j);
				if (rateInfo != null && DateUtil.isDateBefore(rateInfo.getD_start_date(), endDate) == FCDict.DATA_AFTER) {
					break;
				}
				if (rateInfo != null && DateUtil.isDateBefore(rateInfo.getD_end_date(), startDate) == FCDict.DATA_AFTER) {
					startDateTemp = rateInfo.getD_start_date();
					endDateTemp = rateInfo.getD_end_date();
					if (DateUtil.isDateBefore(startDateTemp, startDate) == FCDict.DATA_BEFORE) {
						startDateTemp = startDate;
					}
					if (DateUtil.isDateBefore(endDateTemp, endDate) == FCDict.DATA_AFTER) {
						endDateTemp = endDate;
					}
					Double basis = FCBasis.calBasis(assetInfo, payPlanInfo.getC_cal_basis(), payPlanInfo.getC_pay_type(),
							startDateTemp, endDateTemp);
					amt += MathUtil.mul(MathUtil.mul(shares, MathUtil.convObjToDou(rateInfo.getF_rate())), basis);
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
	private static Double calEndPay(AssetInfo assetInfo, String startDate, String endDate, Double shares, String data_type) {
		Double amt = 0.00;
		ArrayList<PayPlanInfo> payPlanList = assetInfo.getPayPlanMap().get(data_type);
		if (payPlanList == null) {
			payPlanList = assetInfo.getPayPlanMap().get(FCConstant.DEF_COUPON_DATA);
		}
		if (payPlanList != null && payPlanList.size() > 0) {
			PayPlanInfo payPlanInfo = payPlanList.get(0);
			amt = FCCoupon.calEndPay(assetInfo, payPlanInfo, startDate, endDate, shares, data_type);
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
	private static Double calEndPay(AssetInfo assetInfo, PayPlanInfo payPlanInfo, String startDate, String endDate,
			Double shares, String data_type) {
		Double amt = 0.00;
		ArrayList<RateInfo> rateList = assetInfo.getRateMap().get(data_type);
		RateInfoSort rateInfoSort = new RateInfoSort();
		Collections.sort(rateList, rateInfoSort);
		RateInfo rateInfo;
		if (rateList != null && rateList.size() > 0) {
			String startDateTemp;
			String endDateTemp;
			for (int j = 0; j < rateList.size(); j++) {
				rateInfo = rateList.get(j);
				if (rateInfo != null && DateUtil.isDateBefore(rateInfo.getD_start_date(), endDate) == FCDict.DATA_AFTER) {
					break;
				}
				if (rateInfo != null && DateUtil.isDateBefore(rateInfo.getD_end_date(), startDate) == FCDict.DATA_AFTER) {
					startDateTemp = rateInfo.getD_start_date();
					endDateTemp = rateInfo.getD_end_date();
					if (DateUtil.isDateBefore(startDateTemp, startDate) == FCDict.DATA_BEFORE) {
						startDateTemp = startDate;
					}
					if (DateUtil.isDateBefore(endDateTemp, endDate) == FCDict.DATA_AFTER) {
						endDateTemp = endDate;
					}
					Double basis = FCBasis.calBasis(assetInfo, payPlanInfo.getC_cal_basis(), payPlanInfo.getC_pay_type(),
							startDateTemp, endDateTemp);
					amt += MathUtil.mul(MathUtil.mul(shares, MathUtil.convObjToDou(rateInfo.getF_rate())), basis);
				}
			}
		}
		return amt;
	}

	/**
	 * 贴现
	 * 
	 * @param assetInfo
	 * @param startDate
	 * @param endDate
	 * @param shares
	 * @return
	 */
	private static Double calNoPay(AssetInfo assetInfo, String startDate, String endDate, Double shares) {
		Double amt = 0.00;
		amt = MathUtil.sub(calNoPay(assetInfo, endDate, shares), calNoPay(assetInfo, startDate, shares));
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
		Double days = DateUtil.subDate(assetInfo.getD_end_date(), assetInfo.getD_value_date());
		Double t = DateUtil.subDate(date, assetInfo.getD_value_date());
		Double discount = MathUtil.sub(
				shares,
				MathUtil.mul(
						shares,
						MathUtil.div(MathUtil.convObjToDou(assetInfo.getF_issue_price()),
								MathUtil.convObjToDou(assetInfo.getF_face_value()))));
		amt = MathUtil.mul(MathUtil.div(discount, days), t);
		return amt;
	}
}
