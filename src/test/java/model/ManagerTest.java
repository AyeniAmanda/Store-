package model;

import model.Candidate;
import org.junit.jupiter.api.Test;
import services.impl.ManagerImplementation;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
   ManagerImplementation managerImplementation = new ManagerImplementation("Vanessa");
    Candidate candidate1 = new Candidate("Grace","Low",0);
    Candidate candidate2 = new Candidate("Joy","High",3);

   @Test
   void canHireTest_nonQualified() {
        String actual = managerImplementation.canHire(candidate2);
        String expected = "Congratulations " + candidate2.getName() + ", " + " We are pleased to inform You that you have passed the first stage of the recruitment process";
       assertEquals(expected, actual);
    }

   @Test
    void canHireTest_qualified() {
       String actual = managerImplementation.canHire(candidate1);
       String expected = candidate1.getName() + ", Thank you for applying! But we regret to inform you that you are not qualified for this role.";
       assertEquals(expected, actual);

   }
}