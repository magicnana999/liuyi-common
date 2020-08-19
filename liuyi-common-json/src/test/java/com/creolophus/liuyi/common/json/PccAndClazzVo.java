package com.creolophus.liuyi.common.json;

/**
 * @author magicnana
 * @date 2019/7/10 上午10:19
 */
public class PccAndClazzVo {

    private String clazzName;
    private Integer clazzState;
    private String clazzDescription;

    private boolean exist;
    private int sort = 0;

    public String getClazzDescription() {
        return clazzDescription;
    }

    public void setClazzDescription(String clazzDescription) {
        this.clazzDescription = clazzDescription;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public Integer getClazzState() {
        return clazzState;
    }

    public void setClazzState(Integer clazzState) {
        this.clazzState = clazzState;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public boolean isExist() {
        return exist;
    }

    public void setExist(boolean exist) {
        this.exist = exist;
    }

}
