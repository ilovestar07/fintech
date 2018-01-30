/**
 * ****************************************************************************
 * 系统名称: Calculator
 * 模块名称: 金融计算器
 * 类   名  称: FCUtil.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0
 * 开发人员: 陈斌
 * 开发时间: 2014-12-31
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.financial.calculator.util;

import com.financial.calculator.asset.bean.AssetInfo;

public class FCUtil {

	public static final String VERSION = "@version 1.0.0.1";

	/**
	 * 获取资产计息基础
	 * 
	 * @return
	 */
	public static Double getAssetBasis(AssetInfo assetInfo, String date) {
		Double days = 365.00;

		return days;
	}
}
