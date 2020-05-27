package com.b16112112.model;
/**
 * 
 * @author HP
 * 分页类页码封装
 */
public class Page {
	/**
	 * 开始查询位置
	 */
	private int start; 
	
	/**
	 * 当前页
	 */
	private int currentPage; 
	
	/**
	 * 每页记录数
	 */
	private int pageSize;
	
	public Page(int currentPage, int pageSize) {
		this.start = (currentPage-1)*pageSize;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
}
