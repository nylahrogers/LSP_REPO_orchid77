package org.howard.edu.lsp.assignment3;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

/**
 * Applies transformation rules to Product objects.
 */
public class ProductTransformer {

    private int rowsTransformed = 0;

    /**
     * Applies all transformation logic to the list of products.
     *
     * @param products the list of products to transform
     */
    public void transform(List<Product> products) {

        for (Product product : products) {

            BigDecimal price = product.getPrice();
            String category = product.getCategory();
            String originalCategory = category;

            if (category.equals("Electronics")) {
                price = price.multiply(new BigDecimal("0.90"));
            }

            price = price.setScale(2, RoundingMode.HALF_UP);

            if (price.compareTo(new BigDecimal("500.00")) > 0
                    && originalCategory.equals("Electronics")) {
                category = "Premium Electronics";
            }

            String priceRange;

            if (price.compareTo(new BigDecimal("10.00")) <= 0) {
                priceRange = "Low";
            } else if (price.compareTo(new BigDecimal("100.00")) <= 0) {
                priceRange = "Medium";
            } else if (price.compareTo(new BigDecimal("500.00")) <= 0) {
                priceRange = "High";
            } else {
                priceRange = "Premium";
            }

            product.setPrice(price);
            product.setCategory(category);
            product.setPriceRange(priceRange);

            rowsTransformed++;
        }
    }

    /**
     * Returns the number of rows transformed.
     * @return rows transformed
     */
    public int getRowsTransformed() {
        return rowsTransformed;
    }
}
