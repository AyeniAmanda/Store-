package implementation;

import enums.UserRole;
import model.User;
import services.ManagerInterface;

public class ManagerImplementation extends User implements ManagerInterface {

    public  ManagerImplementation(String name, UserRole role, String ExperienceLevel) {
        super(name, role, ExperienceLevel);
    }
//This method checks if the users is a manager and an applicant before checking the experience level
    //if the applicant experience level is professional the manager can hire.
    @Override
    public  String canHire(User manager, User applicant) {
        if (manager.getRole() == UserRole.MANAGER && applicant.getRole() == UserRole.APPLICANT) {
          if (applicant.getExperienceLevel().equalsIgnoreCase("Professional")) {
              return "Congratulations " + applicant.getName() + ", " + " We are pleased to inform You that you have passed the first stage of the recruitment process";
            }
       }
        return applicant.getName() + ", Thank you for applying! But we regret to inform you that you are not qualified for this role.";
    }
}
