package org.howard.edu.lsp.assignment3;

import java.io.IOException;
import java.util.List;

/**
 * Main application class for Assignment 3.
 * Coordinates reading, transforming, and writing product data.
 */
public class ETLApplication {

    /**
     * Entry point of the ETL application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        ProductReader reader = new ProductReader();
        ProductTransformer transformer = new ProductTransformer();
        ProductWriter writer = new ProductWriter();

        List<Product> products;

        try {
            products = reader.readProducts(inputPath);
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
            return;
        }

        transformer.transform(products);

        try {
            writer.writeProducts(outputPath, products);
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
            return;
        }

        System.out.println("Rows read: " + reader.getRowsRead());
        System.out.println("Rows transformed: " + 
transformer.getRowsTransformed());
        System.out.println("Rows skipped: " + reader.getRowsSkipped());
        System.out.println("Output written to: " + outputPath);
    }
}
