package model;


import java.util.Comparator;
import java.util.Objects;

public class Product {

    private String category;
   private String productName;
   private int productQuantity;
   private double productPrice;



    public Product(String category, String productName, int productQuantity, double productPrice) {
        this.category = category;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.productPrice = productPrice;
    }

    public Product() {
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getCategory() {
        return category;
    }

    public String getProductName() {
        return productName;
    }



    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public  int getProductQuantity() {
        return productQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }



// The toString method is used to return string representation into an object
    // my products where previously printing out as addresses
    @Override
    public String toString() {
        return "Products{" +
                "category='" + category + '\'' +
                ", productName='" + productName + '\'' +
                ", productQuantity=" + productQuantity +
                ", productPrice=" + productPrice +
                "}\n";
    }
/// The hashcode and equal  method is comparing the objects  values (objects)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product products = (Product) o;
        return Objects.equals(productName, products.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName);
    }



}

