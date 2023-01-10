package com.liblab.lotrsdk.config;

public class PageCriteria {

    private Integer limit = 10;
    private Integer page = 1;
    private Integer offset = 0;


    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }


    public String getCriteria(){
        StringBuilder builder = new StringBuilder();
        builder.append("?");
        builder.append("limit="+limit);
        builder.append("&");
        builder.append("page="+page);
        builder.append("&");
        builder.append("offset="+offset);
        return builder.toString();
    }
}
