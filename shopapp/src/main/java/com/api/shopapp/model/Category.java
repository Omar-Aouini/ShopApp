package com.api.shopapp.model;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class Category {
    private String categoryName;
    private String categoryDescription;
    private Collection<Product> productsByCategoryName;

    @Id
    @Column(name = "category_name", nullable = false, length = 100)
    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Basic
    @Column(name = "category_description", nullable = true, length = 5000)
    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (categoryName != null ? !categoryName.equals(category.categoryName) : category.categoryName != null)
            return false;
        if (categoryDescription != null ? !categoryDescription.equals(category.categoryDescription) : category.categoryDescription != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = categoryName != null ? categoryName.hashCode() : 0;
        result = 31 * result + (categoryDescription != null ? categoryDescription.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "categoryByProductCategoryName")
    public Collection<Product> getProductsByCategoryName() {
        return productsByCategoryName;
    }

    public void setProductsByCategoryName(Collection<Product> productsByCategoryName) {
        this.productsByCategoryName = productsByCategoryName;
    }
}
