package org.test.utils;

import java.util.List;

public class Page<T> {

	private Integer total;
	private List<T> rows;

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

	@Override
	public String toString() {
		return "page [total=" + total + ", rows=" + rows + "]";
	}

}
