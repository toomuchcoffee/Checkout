import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public static List<PricingRule> getRules() {
        List<PricingRule> pricingRules = new ArrayList<>();
        pricingRules.add(new PricingRule("A", 40, new SpecialPrice(3, 100)));
        pricingRules.add(new PricingRule("B", 50, new SpecialPrice(2, 80)));
        pricingRules.add(new PricingRule("C", 25, null));
        pricingRules.add(new PricingRule("D", 20, null));
        return pricingRules;
    }

    public static Map<String, PricingRule> getRulesMap() {
        Map<String, PricingRule> pricingRulesMap = new HashMap<>();
        for (PricingRule rule : getRules()) {
            pricingRulesMap.put(rule.getSku(), rule);
        }
        return pricingRulesMap;
    }
}
