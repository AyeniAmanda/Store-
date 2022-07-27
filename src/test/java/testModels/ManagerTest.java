package testModels;

import enums.UserRole;
import implementation.ManagerImplementation;
import model.User;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ManagerTest {
    ManagerImplementation managerImplementation = new ManagerImplementation("faith", UserRole.MANAGER,"professional");
    User qualified = new User("Vanessa",UserRole.APPLICANT,"Professional") ;
    User unQualified = new User("Vanessa",UserRole.APPLICANT,"unprofessional") ;

    User manager = new User(23L,"Amanda",UserRole.MANAGER);


    @Test
    void managerHire() {
        String actual = managerImplementation.canHire(manager, qualified);
        String expected = "Congratulations " + qualified.getName() + ", " + " We are pleased to inform You that you have passed the first stage of the recruitment process";
       assertEquals(actual,expected);
    }

    @Test
    void nonManagerHire(){
        String actual= managerImplementation.canHire(manager,unQualified);
        String expected = unQualified.getName() + ", Thank you for applying! But we regret to inform you that you are not qualified for this role.";
        assertEquals(actual,expected);
    }

    }



