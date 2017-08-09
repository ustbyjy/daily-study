package com.ustbyjy.bean;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Administrator
 * Date: 2017/8/4
 * Time: 16:32
 */
public class Channel {
    private String platName;
    private Integer status;
    private List<String> packageNames;

    public String getPlatName() {
        return platName;
    }

    public void setPlatName(String platName) {
        this.platName = platName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<String> getPackageNames() {
        return packageNames;
    }

    public void setPackageNames(List<String> packageNames) {
        this.packageNames = packageNames;
    }
}
