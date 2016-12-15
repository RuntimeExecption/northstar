package com.yusw.northstar.client.model.dto;
import java.io.Serializable;
import java.util.List;

/**
 * Created by yusw on 2016/11/20.
 */
public class CompanyDTO implements Serializable{
    public long companyId;/**公司id*/
    public String city;/**公司所在城市*/
    public String district;/**公司所在区*/
    public String companySize;/**公司规模*/
    public String companyName;/**公司名*/
    public String financeStage;/**融资状况*/
    public String salary;/**薪资范围*/
    public String industryFieldTypes;/**行业领域*/
    public List<String> companyLabelList;/**公司福利*/

    public long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(long companyId) {
        this.companyId = companyId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getFinanceStage() {
        return financeStage;
    }

    public void setFinanceStage(String financeStage) {
        this.financeStage = financeStage;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getIndustryFieldTypes() {
        return industryFieldTypes;
    }

    public void setIndustryFieldTypes(String industryFieldTypes) {
        this.industryFieldTypes = industryFieldTypes;
    }

    public List<String> getCompanyLabelList() {
        return companyLabelList;
    }

    public void setCompanyLabelList(List<String> companyLabelList) {
        this.companyLabelList = companyLabelList;
    }
}
