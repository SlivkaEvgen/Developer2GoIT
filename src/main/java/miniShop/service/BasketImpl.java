package miniShop.service;

import miniShop.model.Product;
import miniShop.repository.Store;

import java.util.HashMap;
import java.util.Map;

public final class BasketImpl implements Store {

    private final Map<String, Product> basketProducts;

    public BasketImpl(Store store) {
        basketProducts = store.getStoreProducts();
    }

    @Override
    public Map<String, Product> getStoreProducts() {
        return basketProducts;
    }

    public double calculateTotalCost(String basket) {
        double totalPrice = 0.0d;
        if (basket != null) {
            Map<String, Integer> calculatorMap = countProductsInBasket(basket);
            for (String product : basketProducts.keySet()) {
                if (calculatorMap.get(product) != null) {
                    double amount = calculatorMap.get(product);
                    double price = basketProducts.get(product).getPrice();
                    double discountPrice = basketProducts.get(product).getDiscountPrice();
                    double discountAmount = basketProducts.get(product).getDiscountAmount();
                    int a = (int) (amount / discountAmount);
                    totalPrice += (amount < discountPrice) ? (amount * price) : ((price * (amount - (discountAmount * a))) + (discountPrice * a));
                }
            }
        }
        return totalPrice;
    }

    private Map<String, Integer> countProductsInBasket(String basket) {
        int count = 0;
        Map<String, Integer> mapBasket = new HashMap<>();
        for (String basketChar : basket.toUpperCase().split("")) {
                if (basketProducts.containsKey(basketChar)) {
                    mapBasket.putIfAbsent(basketChar, count);
                    mapBasket.put(basketChar, mapBasket.get(basketChar) + 1);
                }
        }
        return mapBasket;
    }
}
