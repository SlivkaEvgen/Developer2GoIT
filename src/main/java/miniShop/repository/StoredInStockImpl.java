package miniShop.repository;

import miniShop.model.Product;

import java.util.HashMap;
import java.util.Map;

final class StoredInStockImpl implements Store {
    private static final Map<String, Product> stockList = new HashMap<>();

    StoredInStockImpl(){
        stockList.put("A", new Product("A", 1.25d, 3.0d, 0.0d, 3.0d));
        stockList.put("B", new Product("B", 4.25d, 0.0d, 0.0d, 0.0d));
        stockList.put("C", new Product("C", 1.00d, 5.0d, 0.0d, 6.0d));
        stockList.put("D", new Product("D", 0.75d, 0.0d, 0.0d, 0.0d));
    }

    @Override
    public Map<String, Product> getStoreProducts() {
        return stockList;
    }
}
