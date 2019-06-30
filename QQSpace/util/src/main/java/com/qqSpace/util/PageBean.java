/** 
* @author 作者 :luge
* @version 创建时间：2019年6月30日 下午6:13:17 
*/
package com.qqSpace.util;

import java.util.List;

/**
 * PageBean封装了分页
 * @author Luge
 *
 */
public class PageBean<T> {
	private int currpage;//当前页
	private int pageSize;//页面大小
	private int totalcount;//总数量
	private int totalpage;//总页数
	private List<T> page;
	public int getCurrpage() {
		return currpage;
	}
	public void setCurrpage(int currpage) {
		this.currpage = currpage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalcount() {
		return totalcount;
	}
	public void setTotalcount(int totalcount) {
		this.totalcount = totalcount;
	}
	public int getTotalpage() {
		return totalpage;
	}
	public void setTotalpage(int totalpage) {
		this.totalpage = totalpage;
	}
	public List<T> getPage() {
		return page;
	}
	public void setPage(List<T> page) {
		this.page = page;
	}
	
}
