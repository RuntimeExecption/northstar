package com.yusw.northstar.biz.service.findjobs;

import com.yusw.northstar.biz.enums.JobOriginType;
import com.yusw.northstar.biz.model.query.JobQueryDTO;

/**
 * Created by yusw on 2016/11/20.
 */
public interface FindJobsService {
    public void getJobs(JobQueryDTO query);
    public void getJobs(String url);
}
