package model;

import lombok.ToString;

import java.util.Comparator;

@ToString
public class CustomerDto  {
    String name;
    int quantity;
    String productName;
    double price;


    public CustomerDto(String name, int quantity, String productName, double price) {
        this.name = name;
        this.quantity = quantity;
        this.productName = productName;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }
}


