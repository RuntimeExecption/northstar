package com.yusw.northstar.biz.model.query;

import com.yusw.northstar.biz.enums.JobOriginType;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by yusw on 2016/12/4.
 */
public class JobQueryDTO implements Serializable{
    private static final long serialVersionUID = 6297038948549830724L;
    public String url;
    public JobOriginType type;
    public List<String> domains;//领域，移动互联网，电子商务
    public String city;//工作地点
    public Date beginTime;
    public Date endTime;

    public JobQueryDTO() {}

    public JobQueryDTO(String url, JobOriginType type, List<String> domains, String city, Date beginTime, Date endTime) {
        this.url = url;
        this.type = type;
        this.domains = domains;
        this.city = city;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public JobOriginType getType() {
        return type;
    }

    public void setType(JobOriginType type) {
        this.type = type;
    }

    public List<String> getDomains() {
        return domains;
    }

    public void setDomains(List<String> domains) {
        this.domains = domains;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
