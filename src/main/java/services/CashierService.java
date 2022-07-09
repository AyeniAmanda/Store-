package services;


import model.Customer;
import model.Products;

public interface CashierService {
    String cashierTransaction(Customer customer, Products products) throws Exception;
}
