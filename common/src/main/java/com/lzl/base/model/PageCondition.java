package com.lzl.base.model;
/**
 * 分页条件类
 * @author admin
 * @param <T>
 */
public class PageCondition<T extends BaseModel<K>, K> {
	// 查询条件实体
	private T searchCondition;
	// 当前页码
	private Integer curPage;
	// 每页显示数量
	private Integer pageSize;

	public T getSearchCondition() {
		return searchCondition;
	}

	public void setSearchCondition(T searchCondition) {
		this.searchCondition = searchCondition;
	}

	public Integer getCurPage() {
		return curPage;
	}

	public void setCurPage(Integer curPage) {
		this.curPage = curPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

}
