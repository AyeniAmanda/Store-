package model;

import org.junit.jupiter.api.Test;
import services.impl.CustomerImplementation;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    protected Products cart;
    CustomerImplementation customerImplementation = new CustomerImplementation("Faith");
    Customer successfulOrder = new Customer("Nancy",6,"cookies","chocolate chip");
    Customer unSuccessfulOrder = new Customer("Micheal",6,"cookies","Arrowroot");
    Products products = new Products("Snacks","potato chips",5,300);
    public String customerTransaction(Customer customer, Products products) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the convenience store "+ customer.getName());
        System.out.println("Enter name of category: ");
        System.out.println("\n");
        System.out.println("Cookies");
        System.out.println("Bars");
        System.out.println("Snacks");
        System.out.println("Crackers");
        String categoryName = "bars";
        System.out.println("Enter product name: ");
        String nameOfProduct = "bran";
        System.out.println("Enter product quantity: ");
        int qty = 6;



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

    @Test
    void salesTest (){
      String actual = customerTransaction(successfulOrder,products);
      String expected = "Dear " + successfulOrder.getName() + " kindly add the product to ur cart";
      assertEquals(actual,expected);
  }

    @Test
    void nonSalesTest (){
        String actual = customerTransaction(unSuccessfulOrder,products);
        String expected = "Dear " + unSuccessfulOrder.getName() + " your preferred product is not in this category or out of stock!";

    }



}
