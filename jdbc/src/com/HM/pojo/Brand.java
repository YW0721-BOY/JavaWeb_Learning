package com.HM.pojo;

public class Brand {
    // id 主键
    private int id;
    // 品牌名称
    private String brandName;
    // 企业名称
    private String companyName;
    // 排序字段
    private String ordered;
    // 描述信息
    private String description;
    // 状态：0：禁用  1：启用
    private Integer status =null;


    public Brand() {
    }

    public Brand(int id, String brandName, String companyName, String ordered, String description, Integer status) {
        this.id = id;
        this.brandName = brandName;
        this.companyName = companyName;
        this.ordered = ordered;
        this.description = description;
        this.status = status;
    }

    /**
     * 获取
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * 获取
     * @return brandName
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     * 设置
     * @param brandName
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    /**
     * 获取
     * @return companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * 设置
     * @param companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * 获取
     * @return ordered
     */
    public String getOrdered() {
        return ordered;
    }

    /**
     * 设置
     * @param ordered
     */
    public void setOrdered(String ordered) {
        this.ordered = ordered;
    }

    /**
     * 获取
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String toString() {
        return "Brand{id = " + id + ", brandName = " + brandName + ", companyName = " + companyName + ", ordered = " + ordered + ", description = " + description + ", status = " + status + "}";
    }
}
