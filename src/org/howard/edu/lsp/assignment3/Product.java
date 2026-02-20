package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;

/**
 * Represents a product from the input CSV file.
 * Stores product attributes and transformation results.
 */
public class Product {

    private int productId;
    private String name;
    private BigDecimal price;
    private String category;
    private String priceRange;

    /**
     * Constructs a Product object.
     *
     * @param productId the product ID
     * @param name the product name
     * @param price the product price
     * @param category the product category
     */
    public Product(int productId, String name, BigDecimal price, String 
category) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.category = category;
    }

    /**
     * Returns the product ID.
     * @return the product ID
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Returns the product name.
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the product price.
     * @return the product price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Returns the product category.
     * @return the product category
     */
    public String getCategory() {
        return category;
    }

    /**
     * Returns the price range classification.
     * @return the price range
     */
    public String getPriceRange() {
        return priceRange;
    }

    /**
     * Sets the product price.
     * @param price the updated price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * Sets the product category.
     * @param category the updated category
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * Sets the price range classification.
     * @param priceRange the price range
     */
    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    /**
     * Converts the product into CSV format.
     * @return a CSV string representation of the product
     */
    public String toCSV() {
        return productId + "," +
               name + "," +
               price.toPlainString() + "," +
               category + "," +
               priceRange;
    }
}
