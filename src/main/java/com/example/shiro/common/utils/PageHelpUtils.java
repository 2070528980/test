package com.example.shiro.common.utils;

import lombok.Data;

/**
 * @author liushan
 * @since 21:04
 */
@Data
public class PageHelpUtils {
    private Integer currentPage=1;
    private Integer pageSize;
    private Integer totalNum;
    /**
     * 是否有下一页
     */
    private Integer next;
    private Integer totalPage;
    private Integer startIndex;

    public PageHelpUtils() {
    }

    public PageHelpUtils(Integer currentPage, Integer pageSize, Integer totalNum) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalNum = totalNum;
        this.totalPage = (totalNum+pageSize-1)/this.pageSize;
        this.startIndex = (this.currentPage-1)*pageSize;
        this.next = this.currentPage>=this.totalPage?0:1;

    }

}
