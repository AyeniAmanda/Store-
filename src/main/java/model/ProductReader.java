package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class ProductReader {
    static String category;
    static String productName;
    static int productQuantity;
    static double productPrice;
    public static List<Product> myProducts;

    public  List<Product> getMyProducts() {
        return myProducts;
    }

    static {
            myProducts = myProductFile();
    }

//A method that reads in my file and adds it into my products as an arraylist
    public static List<Product> myProductFile()  {
         Product products;
         List<Product> totalProducts = new ArrayList<>();
         String path = "/Users/decagon/Documents/Conveniencestore/src/main/java/model/FoodSales (1) (2).csv";
         String line = "";

        try {
           BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            while ((line = bufferedReader.readLine()) != null) {
                String[] productData = line.toLowerCase().split(",");

                 category = productData[0].toLowerCase();
                 productName = productData[1].toLowerCase();
                 productQuantity = Integer.parseInt(productData[2]);
                 productPrice = Double.parseDouble(productData[3]);
                products = new Product(category,productName,productQuantity,productPrice);
                if(!totalProducts.contains(products)){
                    totalProducts.add(products);
                }else {
                    Product j = totalProducts.get(totalProducts.indexOf(products));

                    j.setProductQuantity(j.getProductQuantity() + Integer.parseInt(productData[2]));
                }




            }
        } catch (IOException e) {

            System.out.println("Error while retrieving data…");
        }


    return totalProducts;

}


}

