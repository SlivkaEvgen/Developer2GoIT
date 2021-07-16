package miniShop.client;

import miniShop.repository.Store;
import miniShop.service.BasketImpl;

public class Main {
    public static void main(String[] args) {

        BasketImpl basketImpl = new BasketImpl(() ->  Store.storeList);

        System.out.println(basketImpl.calculateTotalCost("ABCDABA"));
        System.out.println(basketImpl.calculateTotalCost(null));
        System.out.println(basketImpl.calculateTotalCost(""));
        System.out.println(basketImpl.calculateTotalCost("aaa"));
        System.out.println(basketImpl.calculateTotalCost("a120986//*(±!#"));

    }
}
