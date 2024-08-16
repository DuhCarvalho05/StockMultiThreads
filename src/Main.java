import model.Product;
import model.Stock;
import model.ThreadRemove;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        Stock stock = Stock.getInstance();

        stock.addProduct(new Product(1, "Vasco", 13L, 16.77));
        stock.addProduct(new Product(2, "Flamengo", 5L, 16.77));
        stock.addProduct(new Product(3, "Bragantino", 2L, 16.77));
        stock.addProduct(new Product(4, "Avai", 9L, 16.77));

        List<Thread> threads = new ArrayList<>();

        System.out.println(stock.toString());

        threads.add(new ThreadRemove(stock,1, 3));
        threads.add(new ThreadRemove(stock, 2, 2));
        threads.add(new ThreadRemove(stock,3, 1));

        for (Thread t: threads){
            t.start();

            try{
                t.join();
            }catch (Exception e){
                e.getMessage();
            }

        }
        System.out.println(stock.toString());



    }
}