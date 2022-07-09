package services.impl;

import services.CashierService;
import model.Products;
import model.Customer;
import model.Staff;



public class CashierImplementation extends Staff implements CashierService {


    public CashierImplementation(String name) {
        super(name);
    }


    @Override
    public String cashierTransaction(Customer customer, Products products) {
        double total = 0;
        if (customer.cart != null){
            total = customer.cart.getProductPrice() * customer.cart.getProductQuantity();
            return "Dear "+ customer.getName()+" The price of your product is " + total + "Here is your receipt";
        }

        return "Hello " + customer.getName() + " you have not made any purchase, please kindly had to your cart";
    }

}





