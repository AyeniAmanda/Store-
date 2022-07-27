package implementation;

import enums.UserRole;
import model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UserServiceImplTest {


    User customer;
    String productName;
    int quantity;
    List<Product> myProduct = new ArrayList<>();
    String message;


    @BeforeEach
    public void setup() {
        ProductReader productReader = new ProductReader();

        ProductReader.myProductFile();

        customer = new User(1L, "Sam", UserRole.CUSTOMER);
        productName = "carrot";
        quantity = 50;
       myProduct = productReader.getMyProducts();
         message = productName + "  has been added to cart!";


    }


    @Test
    void productAddedToCart() {
        UserServiceImpl userService = new UserServiceImpl();
        assertEquals(message,userService.addToCart(myProduct,customer, productName,quantity));

    }

    @Test
    void sortCustomersCartAndAddProductsToQueue() {
    }

    @Test
    void sellingByPriority() {
        Queue<CustomerDto> queue = new PriorityQueue<>(new CompareDto());

        //  String actual = userService.sellByPriority();
    }
}