package miniShop.repository;

import miniShop.model.Product;

import java.util.Map;

public interface Store {

    Map<String, Product> storeList = new StoredInStockImpl().getStoreProducts();

    Map<String, Product> getStoreProducts();

}
