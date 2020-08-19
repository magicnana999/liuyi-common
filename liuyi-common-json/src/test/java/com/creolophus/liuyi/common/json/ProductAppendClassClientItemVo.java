package com.creolophus.liuyi.common.json;

import java.util.ArrayList;
import java.util.List;

/**
 * @author magicnana
 * @date 2020/8/10 下午5:53
 */
public class ProductAppendClassClientItemVo {

    private Client client;
    private List<PccAndClazzVo> clazzList = new ArrayList<>();

    public List<PccAndClazzVo> getClazzList() {
        return clazzList;
    }

    public void setClazzList(List<PccAndClazzVo> clazzList) {
        this.clazzList = clazzList;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
