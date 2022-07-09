import model.*;
import services.impl.ManagerImplementation;

public class Main {

    public static void main(String[] args){

       Customer customer = new Customer("chioma",4,"cookies","chocolate chips");
       Cashier cashier = new Cashier("Favour");
       Candidate candidate = new Candidate("Precious","HIGH",2);
       ManagerImplementation managerImplementation = new ManagerImplementation("Chioma");
       Products products = new Products("cookies","chocolate chip",20,210);
    System.out.println(managerImplementation.canHire(candidate));
      System.out.println(customer.customerTransaction(customer,products));
        System.out.println(cashier.cashierTransaction(customer,products));





        }



}
