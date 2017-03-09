package com.troylc.cloud.bean;

/**
 * 商品信息Bean
 * Created by troylc on 2017/3/5.
 */
public class ProductBean {

    /**
     * 商品编码
     */
    private String productId;

    /**
     * 商品名称
     */
    private String productName;

    /**
     * 商品价格
     */
    private String productPrice;

    /**
     * 商品类型
     */
    private String productTypes;

    /**
     * 商品数量
     */
    private Integer productNum;

    public ProductBean() {

    }

    public ProductBean(String productId, String productName, String productPrice, String productTypes, Integer productNum) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.productTypes = productTypes;
        this.productNum = productNum;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductTypes() {
        return productTypes;
    }

    public void setProductTypes(String productTypes) {
        this.productTypes = productTypes;
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    @Override
    public String toString() {
        return "productBean{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productTypes='" + productTypes + '\'' +
                ", productNum=" + productNum +
                '}';
    }
}
