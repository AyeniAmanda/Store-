package model;

import org.junit.jupiter.api.Test;
import services.impl.CashierImplementation;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CashierTest {
    CashierImplementation cashierImplementation = new CashierImplementation("Efemena");
    Customer successfulCustomer = new Customer("Amanda",6,"cookies","chocolate chip");
    Customer unSuccessfulCustomer = new Customer("amanda",0,"bras","bran");
    Products products = new Products("bars","bran",5,50);
    public String cashierTransaction(Customer customer, Products products) {
        double total = 0;
        if (customer.cart != null){
            total = customer.cart.getProductPrice() * customer.cart.getProductQuantity();
            return "Dear "+ customer.getName()+" The price of your product is " + total + "Here is your receipt";
        }

        return "Hello " + customer.getName() + " you have not made any purchase, please kindly had to your cart";
    }

    @Test
    void cashierSales(){
        String actual = cashierTransaction(successfulCustomer,products);
        String expected = "Dear Amanda the price of your product is " + (50 * 6) + "Here is your receipt";
        //assertEquals(actual,expected);

    }

    @Test
    void nonCashierSales(){
        String actual = cashierTransaction(unSuccessfulCustomer,products);
        String expected = "Hello amanda"  + " you have not made any purchase, please kindly had to your cart";
        assertEquals(actual,expected);

    }

}
