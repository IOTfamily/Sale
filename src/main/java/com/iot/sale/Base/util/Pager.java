package com.iot.sale.Base.util;

import java.io.Serializable;
import java.util.List;

/******************************************
 * @author: lio (yanhui@51huxin.com)
 * @createDate: 2017/11/26
 * @company: (C) Copyright 2017
 * @since: JDK 1.8
 * @Description:
 ******************************************/
public class Pager<T> implements Serializable {

    private List<T> dataList = null;

    private long totalCount = 0;

    private int pageSize = 10;

    private int currentPage = 1;

    private int pageCount = 1;

    private int start = 1;

    private int end = 1;

    public Pager(Integer pageSize, Long totalCount, Integer currentPage) {
        if (pageSize == null) {
            pageSize = Integer.valueOf(15);
        }

        setPageSize(pageSize.intValue());

        setTotalCount(totalCount.intValue());

        Double pageNum = Double.valueOf(Math.ceil((getTotalCount() + 0.0D)
                / pageSize.intValue()));

        if ((currentPage == null) || (currentPage.intValue() < 1)
                || (totalCount.intValue() == 0)) {
            setCurrentPage(1);
        } else if (currentPage.intValue() > pageNum.intValue()) {
            setCurrentPage(pageNum.intValue());
        } else {
            setCurrentPage(currentPage.intValue());
        }

        setPageCount(pageNum.intValue());
    }

    public Pager(long totalCount, int pageSize, int currentPage, List<T> dataList) {
        this.dataList = dataList;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalCount = totalCount;
    }

    public Pager() {
    }

    public List<T> getDataList() {
        return this.dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        if (pageSize == 0) {
            return (int) (totalCount / pageSize);
        } else {
            return ((int) (totalCount % pageSize)) == 0 ? ((int) (totalCount / pageSize)) : ((int) (totalCount / pageSize)) + 1;
        }
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getStart() {
        if (currentPage == 0)
            return 0;
        else
            return (currentPage - 1) * pageSize;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        if (dataList == null)
            return getStart();
        else
            return getStart() + dataList.size();
    }

    public void setEnd(int end) {
        this.end = end;
    }
}