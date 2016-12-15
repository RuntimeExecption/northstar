package com.yusw.northstar.client.model.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yusw on 2016/11/20.
 */
public class JobDTO implements Serializable{
    public long id;
    public long rank;/**排名*/

    public String positionAdvantage;/**招聘亮点*/
    public String workYear;/**要求年限*/
    public String createTime;/**发布时间*/
    public List<String> positionLables;/**招聘亮点*/

    public JobDTO jobDTO;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    public String getPositionAdvantage() {
        return positionAdvantage;
    }

    public void setPositionAdvantage(String positionAdvantage) {
        this.positionAdvantage = positionAdvantage;
    }

    public String getWorkYear() {
        return workYear;
    }

    public void setWorkYear(String workYear) {
        this.workYear = workYear;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public List<String> getPositionLables() {
        return positionLables;
    }

    public void setPositionLables(List<String> positionLables) {
        this.positionLables = positionLables;
    }

    public JobDTO getJobDTO() {
        return jobDTO;
    }

    public void setJobDTO(JobDTO jobDTO) {
        this.jobDTO = jobDTO;
    }
}
