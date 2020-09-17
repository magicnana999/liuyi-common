package com.creolophus.liuyi.common.json;

import java.util.Date;


/**
 * @author magicnana
 * @date 2019-07-25
 */

public class Platform {

    private String platformKey;
    private Integer state;
    private String description;
    private Date createTime;
    private Date updateTime;
    private String url;

    public Platform() {
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlatformKey() {
        return platformKey;
    }

    public void setPlatformKey(String platformKey) {
        this.platformKey = platformKey;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }


    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String toString() {
        return platformKey;
    }
}
