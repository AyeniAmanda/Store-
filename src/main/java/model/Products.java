package model;


import java.util.Objects;

public class Products {

    private String category;
   private String productName;
   private int productQuantity;
   private double productPrice;

    public Products(String category, String productName, int productQuantity, double productPrice) {
        this.category = category;
        this.productName = productName;
        this.productQuantity = productQuantity;
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

    public int getProductQuantity() {
        return productQuantity;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    @Override
    public String toString() {
        return "Products{" +
                "category='" + category + '\'' +
                ", productName='" + productName + '\'' +
                ", productQuantity=" + productQuantity +
                ", productPrice=" + productPrice +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return Objects.equals(productName, products.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName);
    }



}

