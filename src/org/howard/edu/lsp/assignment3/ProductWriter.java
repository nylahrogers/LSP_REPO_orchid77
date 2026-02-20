package org.howard.edu.lsp.assignment3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Writes transformed Product objects to the output CSV file.
 */
public class ProductWriter {

    /**
     * Writes the list of products to the specified output file.
     *
     * @param outputPath the relative output file path
     * @param products the list of transformed products
     * @throws IOException if a file write error occurs
     */
    public void writeProducts(String outputPath, List<Product> products) 
throws IOException {

        BufferedWriter writer = new BufferedWriter(new 
FileWriter(outputPath));

        writer.write("ProductID,Name,Price,Category,PriceRange");
        writer.newLine();

        for (Product product : products) {
            writer.write(product.toCSV());
            writer.newLine();
        }

        writer.close();
    }
}
