package de.checkout;

public class PricingRule {
    private String sku;
    private int unitPrice;
    private SpecialPrice specialPrice;

    public PricingRule(String sku, int unitPrice, SpecialPrice specialPrice) {
        this.sku = sku;
        this.unitPrice = unitPrice;
        this.specialPrice = specialPrice;
    }

    public String getSku() {
        return sku;
    }

    public int getCumulatedPrice(int amount) {
        if (specialPrice!=null && amount>=specialPrice.getAmount()) {
            int cumulatedPrice = 0;
            cumulatedPrice += amount / specialPrice.getAmount() * specialPrice.getPrice();
            cumulatedPrice += amount % specialPrice.getAmount() * unitPrice;
            return cumulatedPrice;
        } else {
            return amount * unitPrice;
        }
    }
}
