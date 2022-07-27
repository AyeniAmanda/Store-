import enums.UserRole;
import implementation.BuyingThread;
import implementation.ManagerImplementation;
import implementation.UserServiceImpl;
import implementation.SellingThread;
import model.*;




public class Main {
    public static void main(String[] args)  {

        ManagerImplementation managerImplementation = new ManagerImplementation("Efemena", UserRole.MANAGER,
                        "Professional");
                User applicant = new User("Vanessa",UserRole.APPLICANT,"Professional") ;
               User manager = new User(23L,"Amanda",UserRole.MANAGER);
               managerImplementation.canHire(manager,applicant);




        User firstCustomer = new User(1L,"Blessing",UserRole.CUSTOMER);
        User secondCustomer = new User(2L,"Chioma",UserRole.CUSTOMER);
        User thirdCustomer = new User(3L,"Uzo",UserRole.CUSTOMER);
        User forthCustomer = new User(4L,"Uju",UserRole.CUSTOMER);

        UserServiceImpl userService = new UserServiceImpl();
        System.out.println(userService.addToCart(ProductReader.myProducts, firstCustomer, "carrot", 50));
        System.out.println(userService.addToCart(ProductReader.myProducts, firstCustomer, "carrot", 40));


         userService.addToCart(ProductReader.myProducts, firstCustomer , "Bran", 2);
        userService.addToCart(ProductReader.myProducts, firstCustomer , "Carrot", 12);
        userService.addToCart(ProductReader.myProducts, firstCustomer, "potato chips", 82);


        userService.addToCart(ProductReader.myProducts, secondCustomer , "Bran", 87);
        userService.addToCart(ProductReader.myProducts, secondCustomer , "Carrot", 25);
        userService.addToCart(ProductReader.myProducts, secondCustomer , "potato chips", 6);

        userService.addToCart(ProductReader.myProducts, thirdCustomer , "Bran", 64);
        userService.addToCart(ProductReader.myProducts, thirdCustomer , "Carrot", 25);
        userService.addToCart(ProductReader.myProducts, thirdCustomer , "potato chips", 10);

        userService.addToCart(ProductReader.myProducts, forthCustomer , "Bran", 93);
        userService.addToCart(ProductReader.myProducts, forthCustomer , "Carrot", 25);
        userService.addToCart(ProductReader.myProducts, forthCustomer , "potato chips", 1);


        userService.sortCustomersCartAndAddProductsToQueue(firstCustomer);
        userService.sortCustomersCartAndAddProductsToQueue(secondCustomer);
        userService.sortCustomersCartAndAddProductsToQueue(thirdCustomer);
        userService.sortCustomersCartAndAddProductsToQueue(forthCustomer);



        userService.sellByPriority(userService.getBranQueue());
        userService.sellByPriority(userService.getCarrotQueue());
        userService.sellByPriority(userService.getPotatoChipQueue());

        Thread firstThread = new Thread(userService.addToCart(ProductReader.myProducts,firstCustomer,"bran",7));
        firstThread.start();

        Thread secondThread = new Thread(userService.addToCart(ProductReader.myProducts,secondCustomer,"potato chips",10));
        secondThread.start();


        Thread thirdThread = new Thread(userService.addToCart(ProductReader.myProducts,thirdCustomer,"carrot",90));
        thirdThread.start();


        SellingThread thread = new SellingThread(userService,userService.getBranQueue());
        Thread threadOne = new Thread(thread);
        threadOne.setName("bran");
        threadOne.start();
       try {
           threadOne.sleep(1000);
           threadOne.join();
       }  catch (InterruptedException e) {
           throw new RuntimeException(e);

        }

       SellingThread thread2 = new SellingThread(userService,userService.getPotatoChipQueue());
         Thread threadTwo = new Thread(thread2);
        threadTwo.setName("Potato Chips");
        threadTwo.start();
        try {
            threadTwo.sleep(1000);
           threadTwo.join();
        }  catch (InterruptedException e) {
            throw new RuntimeException(e);

        }

        SellingThread thread3 = new SellingThread(userService,userService.getCarrotQueue());
        Thread threadThree = new Thread(thread3);
        threadThree.setName("carrot");
       threadThree.start();
        try {
           threadThree.sleep(1000);
           threadThree.join();
        }  catch (InterruptedException e) {
            throw new RuntimeException(e);

        }





    }



 }


