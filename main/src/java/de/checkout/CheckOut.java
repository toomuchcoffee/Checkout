package de.checkout;

import java.util.HashMap;
import java.util.Map;

public class CheckOut {
    private Map<String, PricingRule> pricingRulesMap = new HashMap<>();
    private Map<String, Integer> shoppingBasket = new HashMap<>();

    public CheckOut(Map<String, PricingRule> pricingRulesMap) {
        this.pricingRulesMap = pricingRulesMap;
    }

    public void scan(String sku) {
        int amount = shoppingBasket.containsKey(sku) ? shoppingBasket.get(sku) : 0;
        amount++;
        shoppingBasket.put(sku, amount);
    }

    public int total() {
        int total = 0;
        for (Map.Entry<String, Integer> entry : shoppingBasket.entrySet()) {
            total += pricingRulesMap.get(entry.getKey()).getCumulatedPrice(entry.getValue());
        }
        return total;
    }
}
