package de.checkout.config;

import de.checkout.PricingRule;
import de.checkout.SpecialPrice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by gerald on 28/11/15.
 */
public class PricingConfig {
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
