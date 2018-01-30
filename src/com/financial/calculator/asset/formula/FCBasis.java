/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: FCBasis.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0
 * 开发人员: 陈斌
 * 开发时间: 2015-01-06
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.financial.calculator.asset.formula;

import com.financial.calculator.asset.bean.AssetInfo;
import com.financial.calculator.util.constant.FCBasisDict;
import com.financial.calculator.util.constant.FCDict;
import com.fintech.util.common.MathUtil;
import com.fintech.util.date.DateUtil;

public class FCBasis {

	public static final String VERSION = "@version 1.0.0.1";

	public static final String FREQ_1Y = "12m";

	/**
	 * 计算利息因子
	 * 
	 * @param basis
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static double calBasis(AssetInfo assetInfo, String basis, String payType, String startDate, String endDate) {
		Double factor = 0.00;
		if (FCBasisDict.BASIS_ACT_ACT.equals(basis)) {
			if (FCDict.PAY_TYPE_AVE.equals(payType)) {
				// TODO
			} else {
				String theoryValueDate = FCDate.getLastPayDate(assetInfo.getD_value_date(), startDate, FREQ_1Y, "");
				String theoryEndDate = FCDate.getNextPayDate(assetInfo.getD_value_date(), startDate, FREQ_1Y, "");
				Double theoryDays = DateUtil.subDate(theoryEndDate, theoryValueDate);
				if (DateUtil.isDateBefore(theoryEndDate, endDate) == FCDict.DATA_BEFORE) {
					factor = MathUtil.div(DateUtil.subDate(theoryEndDate, startDate), theoryDays);
					String lastStart = FCDate.getLastPayDate(assetInfo.getD_value_date(), endDate, FREQ_1Y, "");
					String lastEnd = FCDate.getNextPayDate(assetInfo.getD_value_date(), endDate, FREQ_1Y, "");
					theoryDays = DateUtil.subDate(lastEnd, lastStart);
					factor = MathUtil.add(MathUtil.add(factor, DateUtil.subYear(lastStart, theoryEndDate)),
							MathUtil.div(DateUtil.subDate(endDate, lastStart), theoryDays));
				} else {
					factor = MathUtil.div(DateUtil.subDate(endDate, startDate), theoryDays);
				}
			}
		} else if (FCBasisDict.BASIS_ACT_365ISDA.equals(basis)) {
			String startYear = DateUtil.getYear(startDate);
			String endYear = DateUtil.getYear(endDate);
			if (startYear.equals(endYear)) {
				factor = MathUtil.div(DateUtil.subDate(endDate, startDate), DateUtil.getNaturalYearDays(startYear));
			} else {
				String middleDate = endYear + "0101";
				factor = MathUtil.add(
						MathUtil.div(DateUtil.subDate(middleDate, startDate), DateUtil.getNaturalYearDays(startYear)),
						MathUtil.div(DateUtil.subDate(endDate, middleDate), DateUtil.getNaturalYearDays(endYear)));
			}
		} else {
			Double days = calDays(basis, startDate, endDate);
			Double base = calBase(basis);
			factor = MathUtil.div(days, base);
		}
		return factor;
	}

	/**
	 * 分子
	 * 
	 * @param basis
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	private static Double calDays(String basis, String startDate, String endDate) {
		Double base = 1.00;
		if (FCBasisDict.BASIS_ACT_360.equals(basis) || FCBasisDict.BASIS_ACT_365.equals(basis)
				|| FCBasisDict.BASIS_ACT_ACT.equals(basis)) {
			base = DateUtil.subDate(endDate, startDate);
		}
		return base;
	}

	/**
	 * 分母
	 * 
	 * @return
	 */
	private static double calBase(String basis) {
		Double base = 365.00;
		if (FCBasisDict.BASIS_ACT_360.equals(basis) || FCBasisDict.BASIS_ACT_360ISDA.equals(basis)
				|| FCBasisDict.BASIS_30_360SIA.equals(basis) || FCBasisDict.BASIS_30_360PSA.equals(basis)
				|| FCBasisDict.BASIS_30_360FIX.equals(basis) || FCBasisDict.BASIS_30_360CMO.equals(basis)) {
			base = 360.00;
		} else if (FCBasisDict.BASIS_ACT_365.equals(basis) || FCBasisDict.BASIS_ACT_365JANPAN.equals(basis)) {
			base = 365.00;
		}
		return base;
	}
}
