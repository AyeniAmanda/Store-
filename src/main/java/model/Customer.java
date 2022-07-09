package model;

import services.impl.CustomerImplementation;

public class Customer extends CustomerImplementation {


    private String nameOfProduct;
    private int customerQuantity;

    private String category;




    public Customer(String name,int customerQuantity, String category,String nameOfProduct) {
        super(name);
        this.customerQuantity = customerQuantity;
        this.category = category;
        this.nameOfProduct = nameOfProduct;
    }
    public int getCustomerQuantity() {
        return customerQuantity;
    }

    public void setCustomerQuantity(int customerQuantity) {
        this.customerQuantity = customerQuantity;
    }



    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }




}




