package services.impl;


import model.Customer;
import model.SalesReader;
import model.Products;
import model.Staff;
import services.CustomerService;

import java.util.Scanner;

public class CustomerImplementation extends Staff implements CustomerService {
 public Products cart;

    public CustomerImplementation(String name) {
        super(name);
    }



    @Override
    public String customerTransaction(Customer customer, Products products) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the convenience store "+ customer.getName());
        System.out.println("Enter name of category: ");
        System.out.println("\n");
        System.out.println("Cookies");
        System.out.println("Bars");
        System.out.println("Snacks");
        System.out.println("Crackers");
        String categoryName = scanner.nextLine();
        System.out.println("Enter product name: ");
        String nameOfProduct = scanner.nextLine();
        System.out.println("Enter product quantity: ");
        int qty = scanner.nextInt();
        scanner.close();
        for (Products p : SalesReader.myProducts) {

            if (p.getProductQuantity() > qty
                    && p.getCategory().equalsIgnoreCase(categoryName)
                    && p.getProductName().equalsIgnoreCase(nameOfProduct)) {
                this.cart = new Products(p.getCategory(), p.getProductName(), qty, p.getProductPrice());
                System.out.println(this.cart);

                return "Dear " + customer.getName() + " kindly add the product to ur cart";
            }

        }
        return "Dear " + customer.getName() + " your preferred product is not in this category or out of stock!";


    }


}
