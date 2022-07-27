package implementation;

import model.CustomerDto;
import model.Product;
import model.ProductReader;
import model.User;

import java.util.Queue;

public class BuyingThread  extends Thread {
    private UserServiceImpl userService;
    private User customer;
    String productName;
    int quantity;


    public BuyingThread(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void run() {
       userService.addToCart(ProductReader.myProducts,customer,productName,quantity);
        System.out.println(Thread.currentThread().getName() + " added to cart ");

    }
}
