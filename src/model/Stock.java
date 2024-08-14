package model;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Stock {
    private static Stock instance = null;
    private final Collection<Product> stockList;

    private Stock(){
        stockList = new ArrayList<Product>();
    }

    public static Stock getInstance(){
        if(instance == null){
            instance = new Stock();
        }
        return instance;
    }

    public Collection<Product> getStock(){
       synchronized (stockList){
           return stockList;
       }
    }
    public List<Product> getList(){
        synchronized (stockList){
           return new ArrayList<>(stockList);
        }
    }
    public Product getProductById(long id){
        synchronized (stockList){
            for(Product p: stockList) {
                if(p.getId() == id) {
                    return p;
                }
            }
        }

        return null;
    }

    public boolean addProduct(Product product){
        synchronized (stockList){
            if(product != null){
                return stockList.add(product);
            }
        }

        return false;
    }

    public boolean updateProductQuantity(long id, long quantity) {
        synchronized (stockList) {
            for (Product p: stockList) {
                if(p.getId() == id) {
                    if(p.getQuantity() > 0 && quantity <= p.getQuantity()) {
                        p.setQuantity(p.getQuantity() - quantity);
                        return true;
                    }
                }
            }
        }

        return false;
    }

}
