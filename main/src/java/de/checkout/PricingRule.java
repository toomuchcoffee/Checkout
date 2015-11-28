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
        if (specialPrice!=null) {
            return amount / specialPrice.getAmount() * specialPrice.getPrice()
                    + amount % specialPrice.getAmount() * unitPrice;
        } else {
            return amount * unitPrice;
        }
    }
}
