/**
 * ****************************************************************************
 * 系统名称: Fintech
 * 模块名称: 分页参数实体类
 * 类   名  称: PageBean.java
 * 软件版权: 陈斌 
 * 系统版本: V1.0.0.1
 * 开发人员: 陈斌
 * 开发时间: 2015-02-04
 * 修改记录: 修改日期   修改人员  修改说明
 * 			
 *****************************************************************************
 */
package com.fintech.base.bean;

import java.io.Serializable;

public class PageBean implements Serializable {

	public static final String VERSION = "@version 1.0.0.1";

	private static final long serialVersionUID = -5494470895235318982L;

	/**
	 * 总记录数
	 */
	private Integer totalCount;

	/**
	 * 页码
	 */
	private Integer page = 1;

	/**
	 * 显示条数
	 */
	private Integer rows = 10;

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public Integer getStartNum() {
		return ((page == 0 ? 1 : page) - 1) * rows;
	}

	public Integer getEndNum() {
		return (page == 0 ? 1 : page) * rows;
	}

}
