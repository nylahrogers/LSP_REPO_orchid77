package org.howard.edu.lsp.assignment3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads product data from the input CSV file
 * and converts valid rows into Product objects.
 */
public class ProductReader {

    private int rowsRead = 0;
    private int rowsSkipped = 0;

    /**
     * Reads products from the specified input path.
     *
     * @param inputPath the relative path to the input file
     * @return a list of valid Product objects
     * @throws IOException if a file read error occurs
     */
    public List<Product> readProducts(String inputPath) throws IOException 
{

        List<Product> products = new ArrayList<>();
        File inputFile = new File(inputPath);

        if (!inputFile.exists()) {
            System.out.println("Error: Input file not found at " + 
inputPath);
            return products;
        }

        BufferedReader reader = new BufferedReader(new 
FileReader(inputFile));

        String line = reader.readLine();
        if (line == null) {
            reader.close();
            return products;
        }

        while ((line = reader.readLine()) != null) {

            rowsRead++;

            line = line.trim();
            if (line.isEmpty()) {
                rowsSkipped++;
                continue;
            }

            String[] fields = line.split(",");
            if (fields.length != 4) {
                rowsSkipped++;
                continue;
            }

            try {
                int productId = Integer.parseInt(fields[0].trim());
                String name = fields[1].trim().toUpperCase();
                BigDecimal price = new BigDecimal(fields[2].trim());
                String category = fields[3].trim();

                products.add(new Product(productId, name, price, 
category));

            } catch (NumberFormatException e) {
                rowsSkipped++;
            }
        }

        reader.close();
        return products;
    }

    /**
     * Returns the number of rows successfully read.
     * @return rows read
     */
    public int getRowsRead() {
        return rowsRead;
    }

    /**
     * Returns the number of rows skipped due to invalid data.
     * @return rows skipped
     */
    public int getRowsSkipped() {
        return rowsSkipped;
    }
}
