package com.yudao.util;

import java.util.ArrayList;
import java.util.List;

public class PageBean<E> {

	private int page; //页码
	private int rows; //一页显示多少条数据
	private int start;
	private int totalRows; //总数量
	private List<E> list = new ArrayList<E>();

	public PageBean() {
		super();
	}

	public PageBean(int page, int rows) {
		super();
		this.page = page;
		this.rows = rows;
		initStart();
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public void initStart() {
		start = (page - 1) * rows;
	}

	@Override
	public String toString() {
		return "PageBean [page=" + page + ", rows=" + rows + ", start=" + start + ", totalRows=" + totalRows + ", list="
				+ list + "]";
	}
}


