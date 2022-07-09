package services;

import model.Customer;
import model.Products;




public interface CustomerService {
  String customerTransaction(Customer customer, Products products) throws Exception;
}
