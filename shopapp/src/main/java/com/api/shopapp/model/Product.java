package com.api.shopapp.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Product {
    private Integer productid;
    private String productName;
    private String productDescription;
    private Integer productRate;
    private Double productPrice;
    private Integer productQuantity;
    private String productCategoryName;
    private String productImage;
    private Category categoryByProductCategoryName;
    private Collection<Review> reviewsByProductid;

    @Id
    @Column(name = "productid", nullable = false)
    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    @Basic
    @Column(name = "product_name", nullable = false, length = 100)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Basic
    @Column(name = "product_description", nullable = true, length = 5000)
    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Basic
    @Column(name = "product_rate", nullable = true)
    public Integer getProductRate() {
        return productRate;
    }

    public void setProductRate(Integer productRate) {
        this.productRate = productRate;
    }

    @Basic
    @Column(name = "product_price", nullable = false, precision = 0)
    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    @Basic
    @Column(name = "product_quantity", nullable = false)
    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Basic
    @Column(name = "product_category_name", nullable = true, length = 100)
    public String getProductCategoryName() {
        return productCategoryName;
    }

    public void setProductCategoryName(String productCategoryName) {
        this.productCategoryName = productCategoryName;
    }

    @Basic
    @Column(name = "product_image", nullable = true, length = 5000)
    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productid != null ? !productid.equals(product.productid) : product.productid != null) return false;
        if (productName != null ? !productName.equals(product.productName) : product.productName != null) return false;
        if (productDescription != null ? !productDescription.equals(product.productDescription) : product.productDescription != null)
            return false;
        if (productRate != null ? !productRate.equals(product.productRate) : product.productRate != null) return false;
        if (productPrice != null ? !productPrice.equals(product.productPrice) : product.productPrice != null)
            return false;
        if (productQuantity != null ? !productQuantity.equals(product.productQuantity) : product.productQuantity != null)
            return false;
        if (productCategoryName != null ? !productCategoryName.equals(product.productCategoryName) : product.productCategoryName != null)
            return false;
        if (productImage != null ? !productImage.equals(product.productImage) : product.productImage != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = productid != null ? productid.hashCode() : 0;
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productDescription != null ? productDescription.hashCode() : 0);
        result = 31 * result + (productRate != null ? productRate.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (productQuantity != null ? productQuantity.hashCode() : 0);
        result = 31 * result + (productCategoryName != null ? productCategoryName.hashCode() : 0);
        result = 31 * result + (productImage != null ? productImage.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "product_category_name", referencedColumnName = "category_name")
    public Category getCategoryByProductCategoryName() {
        return categoryByProductCategoryName;
    }

    public void setCategoryByProductCategoryName(Category categoryByProductCategoryName) {
        this.categoryByProductCategoryName = categoryByProductCategoryName;
    }

    @OneToMany(mappedBy = "productByProductid")
    public Collection<Review> getReviewsByProductid() {
        return reviewsByProductid;
    }

    public void setReviewsByProductid(Collection<Review> reviewsByProductid) {
        this.reviewsByProductid = reviewsByProductid;
    }
}
