package com.creolophus.liuyi.common.json;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author magicnana
 * @date 2020/8/19 9:26 AM
 */
public class JsonCoder {

    protected ProductAppendClassVo<Product> bean;
    protected String date = "2020-02-02 12:12:12";

    public JsonCoder()  {

        List<ProductAppendClassPlatformItemVo> platformList = new ArrayList<>();
        for(int i=0;i<4;i++){

            List<ProductAppendClassClientItemVo> clientList = new ArrayList<>();
            for(int j=0;j<4;j++){

                List<PccAndClazzVo> clazzList = new ArrayList<>();
                for(int m=0;m<4;m++){
                    PccAndClazzVo vo = new PccAndClazzVo();
                    vo.setClazzName("clazz "+i+"."+j+"."+m);
                    vo.setSort(m+1000);
                    clazzList.add(vo);
                }

                Client client = new Client();
                client.setClientKey("client"+i+"."+j);

                ProductAppendClassClientItemVo vo = new ProductAppendClassClientItemVo();
                vo.setClient(client);
                vo.setClazzList(clazzList);

                clientList.add(vo);
            }

            Platform platform = new Platform();
            platform.setPlatformKey("platform"+i);

            ProductAppendClassPlatformItemVo vo = new ProductAppendClassPlatformItemVo();
            vo.setPlatform(platform);
            vo.setClientList(clientList);

            platformList.add(vo);
        }

        Product product = new Product();
        product.setTitle("测试 Product");
        product.setId(100L);
        product.setCreateTime(getDate());

        bean = new ProductAppendClassVo();
        bean.setProduct(product);
        bean.setPlatformList(platformList);

        bean.setBody(product);
    }

    private Date getDate(){
        try {
            return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(date);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

}
