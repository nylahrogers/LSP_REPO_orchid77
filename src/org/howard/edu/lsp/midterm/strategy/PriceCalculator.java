package org.howard.edu.lsp.midterm.strategy;

/**
 * Uses a strategy to calculate price
 */
public class PriceCalculator {
    private DiscountStrategy strategy;

    public PriceCalculator(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculatePrice(double price) {
        return strategy.applyDiscount(price);
    }
}
