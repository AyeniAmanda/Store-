package implementation;

import lombok.*;
import model.*;

import java.util.*;

@Data

public class UserServiceImpl {

    private Queue<CustomerDto> carrotQueue = new PriorityQueue<>(new CompareDto());
    private Queue<CustomerDto> arrowRootQueue = new PriorityQueue<>(new CompareDto());
    private Queue<CustomerDto> branQueue = new PriorityQueue<>(new CompareDto());
    private Queue<CustomerDto> bananaQueue = new PriorityQueue<>(new CompareDto());
    private Queue<CustomerDto> chocolateChipQueue = new PriorityQueue<>(new CompareDto());
    private Queue<CustomerDto> wholeWheatQueue = new PriorityQueue<>(new CompareDto());
    private Queue<CustomerDto> potatoChipQueue = new PriorityQueue<>(new CompareDto());
    private Queue<CustomerDto> crackersQueue = new PriorityQueue<>(new CompareDto());




    public  String addToCart(List<Product> myProducts, User customer, String productName, int quantityToBuy) {
        String message = "";


        for (Product productInInventory : myProducts) {
            if (productName.equalsIgnoreCase(productInInventory.getProductName())) {

                if (productInInventory.getProductQuantity() >= quantityToBuy) {

                    if (customer.getCarts().containsKey(productName)) {
                        Product repeatedProduct = customer.getCarts().get(productName);
                        repeatedProduct.setProductQuantity(repeatedProduct.getProductQuantity() + quantityToBuy);
                        System.out.println(quantityToBuy + "  more " + productName + " has been added to the cart! ");
                        message = "Updated!";
                    } else {
                        customer.getCarts().put(productName, new Product(productInInventory.getCategory(), productName, quantityToBuy, productInInventory.getProductPrice()));
                        productInInventory.setProductQuantity(productInInventory.getProductQuantity() - quantityToBuy);

                        message = productName + "  has been added to cart!";
                        break;
                    }


                } else {
                    message = "out of stock!";
                }

            } else {
                message = "product not found";
            }
        }


        return message;
    }


    public  String sortCustomersCartAndAddProductsToQueue(User customer) {
        String message = "";

        for (Map.Entry<String, Product> productInCart : customer.getCarts().entrySet()) {
            if (productInCart.getValue().getProductName().equalsIgnoreCase("carrot")) {
                carrotQueue.add(new CustomerDto(customer.getName(), productInCart.getValue().getProductQuantity(), productInCart.getValue().getProductName(), productInCart.getValue().getProductPrice()));
                message = "carrot has been added";

            } else if (productInCart.getValue().getProductName().equalsIgnoreCase("arrowRoot")) {
                arrowRootQueue.add(new CustomerDto(customer.getName(), productInCart.getValue().getProductQuantity(), productInCart.getValue().getProductName(), productInCart.getValue().getProductPrice()));
                message = "Arrowroot has been added";

            } else if (productInCart.getValue().getProductName().equalsIgnoreCase("bran")) {
                branQueue.add(new CustomerDto(customer.getName(), productInCart.getValue().getProductQuantity(), productInCart.getValue().getProductName(), productInCart.getValue().getProductPrice()));
                message = "bran has been added";

            } else if (productInCart.getValue().getProductName().equalsIgnoreCase("banana")) {
                bananaQueue.add(new CustomerDto(customer.getName(), productInCart.getValue().getProductQuantity(), productInCart.getValue().getProductName(), productInCart.getValue().getProductPrice()));
                message = "banana has been added";

            } else if (productInCart.getValue().getProductName().equalsIgnoreCase("chocolate chip")) {
                chocolateChipQueue.add(new CustomerDto(customer.getName(), productInCart.getValue().getProductQuantity(), productInCart.getValue().getProductName(), productInCart.getValue().getProductPrice()));
                message = "chocolate chip has been added";

            } else if (productInCart.getValue().getProductName().equalsIgnoreCase("whole wheat")) {
                wholeWheatQueue.add(new CustomerDto(customer.getName(), productInCart.getValue().getProductQuantity(), productInCart.getValue().getProductName(), productInCart.getValue().getProductPrice()));
                message = "wholewheat has been added";

            } else if (productInCart.getValue().getProductName().equalsIgnoreCase("potato chips")) {
                potatoChipQueue.add(new CustomerDto(customer.getName(), productInCart.getValue().getProductQuantity(), productInCart.getValue().getProductName(), productInCart.getValue().getProductPrice()));
                message = "potato chip has been added";

            } else if (productInCart.getValue().getProductName().equalsIgnoreCase("cracker")) {
                crackersQueue.add(new CustomerDto(customer.getName(), productInCart.getValue().getProductQuantity(), productInCart.getValue().getProductName(), productInCart.getValue().getProductPrice()));
                message = "crackers has been added";

            }

        }
        return message;

    }

    public synchronized void sellByPriority(Queue<CustomerDto> queue){

        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }











}
