package com.oxy.utils;

import java.io.Serializable;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.github.pagehelper.PageInfo;


public class PageResult<E> implements Iterable<E>,Serializable {

    private static final long serialVersionUID = 4930312171246167210L;

    private long total;
    private List<E> list;
    private int pageNum;
    private int pageSize;

    public PageResult(PageInfo<E> pageInfo) {
        this.total = pageInfo.getTotal();
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getSize();
        this.list = pageInfo.getList();
    }
    
    @Override
    public Iterator<E> iterator() {
        if (this.list != null) {
            return this.list.iterator();
        }
        return Collections.emptyIterator();
    }

    public boolean empty(){
        return list == null || list.isEmpty();
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<E> getList() {
        return list;
    }

    public void setList(List<E> list) {
        this.list = list;
    }


	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}


}
