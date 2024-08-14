import model.Product;
import model.Stock;

public class Main {
    public static void main(String[] args) {
        Stock stock = Stock.getInstance();

        stock.addProduct(new Product(1, "Vasco", 13L, 16.77));
        stock.addProduct(new Product(2, "Flamengo", 5L, 16.77));
        stock.addProduct(new Product(3, "Bragantino", 2L, 16.77));
        stock.addProduct(new Product(4, "Avai", 9L, 16.77));


        new Thread() {
            @Override
            public void run() {
                stock.updateProductQuantity(1, 3);
                System.out.println("Removendo produto 1 por: " + this.getName() + ". Quantidade: " + stock.getProductById(1).getQuantity());
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                stock.updateProductQuantity(2, 2);
                System.out.println("Removendo produto 2 por: " + this.getName() + ". Quantidade: " + stock.getProductById(1).getQuantity());
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                stock.updateProductQuantity(3, 1);
                System.out.println("Removendo produto 3 por: " + this.getName() + ". Quantidade: " + stock.getProductById(1).getQuantity());
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                stock.updateProductQuantity(4, 2);
                System.out.println("Removendo produto 4 por: " + this.getName() + ". Quantidade: " + stock.getProductById(1).getQuantity());
            }
        }.start();
    }
}