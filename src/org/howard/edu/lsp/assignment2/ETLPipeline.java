package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class ETLPipeline {

    public static void main(String[] args) {

        int rowsRead = 0;
        int rowsTransformed = 0;
        int rowsSkipped = 0;

        String inputPath = "data/products.csv";
        String outputPath = "data/transformed_products.csv";

        File inputFile = new File(inputPath);
        if (!inputFile.exists()) {
            System.out.println("ERROR: Input file not found at " + inputPath);
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            writer.write("ProductID,Name,Price,Category,PriceRange");
            writer.newLine();

            reader.readLine();

            String line;
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

                String idStr = fields[0].trim();
                String name = fields[1].trim();
                String priceStr = fields[2].trim();
                String category = fields[3].trim();

                int productId;
                BigDecimal price;

                try {
                    productId = Integer.parseInt(idStr);
                    price = new BigDecimal(priceStr);
                } catch (Exception e) {
                    rowsSkipped++;
                    continue;
                }

                name = name.toUpperCase();

                boolean wasElectronics = category.equals("Electronics");
                if (wasElectronics) {
                    price = price.multiply(new BigDecimal("0.9"));
                }

                price = price.setScale(2, RoundingMode.HALF_UP);

                if (wasElectronics && price.compareTo(new BigDecimal("500.00")) > 0) {
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

                writer.write(productId + "," + name + "," + price.toString()
                        + "," + category + "," + priceRange);
                writer.newLine();

                rowsTransformed++;
            }

        } catch (IOException e) {
            System.out.println("ERROR: Problem reading or writing files.");
            return;
        }

        System.out.println("Run Summary");
        System.out.println("Rows read: " + rowsRead);
        System.out.println("Rows transformed: " + rowsTransformed);
        System.out.println("Rows skipped: " + rowsSkipped);
        System.out.println("Output file: " + outputPath);
    }
}