package com.creolophus.liuyi.common.json;

import java.util.ArrayList;
import java.util.List;

/**
 * @author magicnana
 * @date 2020/8/10 下午5:53
 */
public class ProductAppendClassPlatformItemVo {

    private Platform platform;

    private List<ProductAppendClassClientItemVo> clientList = new ArrayList<>();

    public List<ProductAppendClassClientItemVo> getClientList() {
        return clientList;
    }

    public void setClientList(List<ProductAppendClassClientItemVo> clientList) {
        this.clientList = clientList;
    }

    public Platform getPlatform() {
        return platform;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }
}
