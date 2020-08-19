package com.creolophus.liuyi.common.json;

import java.util.ArrayList;
import java.util.List;

/**
 * @author magicnana
 * @date 2020/8/10 下午5:53
 */
public class ProductAppendClassVo<T> {

    private Product product;

    private T body;

    private List<ProductAppendClassPlatformItemVo> platformList = new ArrayList<>();

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public List<ProductAppendClassPlatformItemVo> getPlatformList() {
        return platformList;
    }

    public void setPlatformList(List<ProductAppendClassPlatformItemVo> platformList) {
        this.platformList = platformList;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
