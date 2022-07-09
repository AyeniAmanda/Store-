package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class SalesReader {
    static String category;
    static String productName;
    static int productQuantity;
    static double productPrice;

    static Products products;
    static List<Products> totalProducts = new ArrayList<>();
    public static List<Products> myProducts;

    static {
        try {
            myProducts = myProductFile();
        } catch (IOException e) {
               throw new RuntimeException(e);

        }
    }


    public static List myProductFile() throws IOException {



        String path = "/Users/decagon/Documents/Conveniencestore/src/main/java/FoodSales (1) (2).csv";
        String line = "";

        try {
           BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
            while ((line = bufferedReader.readLine()) != null) {
                String[] productData = line.toLowerCase().split(",");

                 category = productData[0].toLowerCase();
                 productName = productData[1].toLowerCase();
                 productQuantity = Integer.parseInt(productData[2]);
                 productPrice = Double.parseDouble(productData[3]);
                products = new Products(category,productName,productQuantity,productPrice);
                if(!totalProducts.contains(products)){
                    totalProducts.add(products);
                }else {
                    Products j = totalProducts.get(totalProducts.indexOf(products));

                    j.setProductQuantity(j.getProductQuantity() + Integer.parseInt(productData[2]));
                }




            }
        } catch (IOException e) {

            System.out.println("Error while retrieving data…");
        }


    return totalProducts;

}


}

