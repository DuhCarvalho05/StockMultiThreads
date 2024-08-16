package model;

import java.util.List;

public class ThreadRemove extends Thread {
    private final Stock stock;
    private final int quantity;
    private final int productId;

    public ThreadRemove(Stock stock, int productId, int quantity) {
        this.stock = stock;
        this.productId = productId;
        this.quantity = quantity;
    }

    @Override
    public void run() {
        stock.updateProductQuantity(productId, quantity);
        System.out.println("PRODUTO: " + productId + "\nREMOVIDO POR: " + Thread.currentThread().getName());
    }
}
