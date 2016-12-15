package com.yusw.northstar.client.serviceImpl.findjobs;


import com.yusw.northstar.biz.enums.JobOriginType;
import com.yusw.northstar.biz.model.query.JobQueryDTO;
import com.yusw.northstar.biz.service.findjobs.FindJobsService;
import com.yusw.northstar.biz.utils.http.HttpClientUtil;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by yusw on 2016/11/20.
 */
public class FindJobsServiceImpl implements FindJobsService {
    public void getJobs(JobQueryDTO query) {
        String responseContent = HttpClientUtil.getInstance().sendHttpPost(query.getUrl());
    }

    public void getJobs(String url) {
        String responseContent = HttpClientUtil.getInstance().sendHttpPost(url);

    }

}
