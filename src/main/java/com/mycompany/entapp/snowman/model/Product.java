/*
 * |-------------------------------------------------
 * | Copyright © 2017 Colin But. All rights reserved.
 * |-------------------------------------------------
 */
package com.mycompany.entapp.snowman.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Product {

    private int productId;
    private String title;
    private String description;
    private double price;

    private Product(int productId, String title, String description, double price) {
        this.productId = productId;
        this.title = title;
        this.description = description;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Product product = (Product) o;

        return new EqualsBuilder()
            .append(productId, product.productId)
            .append(price, product.price)
            .append(title, product.title)
            .append(description, product.description)
            .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
            .append(productId)
            .append(title)
            .append(description)
            .append(price)
            .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
            .append("productId", productId)
            .append("title", title)
            .append("description", description)
            .append("price", price)
            .toString();
    }

    public static class ProductBuilder {
        private int productId;
        private String title;
        private String description;
        private double price;

        public ProductBuilder setProductId(int productId) {
            this.productId = productId;
            return this;
        }

        public ProductBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public ProductBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public ProductBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public Product build() {
            return new Product(productId, title, description, price);
        }
    }


}
