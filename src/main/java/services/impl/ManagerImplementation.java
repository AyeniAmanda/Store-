package services.impl;

import model.Candidate;
import model.Staff;
import services.ManagerServices;

public class ManagerImplementation extends Staff implements ManagerServices {

    public ManagerImplementation(String name) {
        super(name);
    }

    @Override
    public String canHire(Candidate candidate) {
        if (candidate.getEducationalLevel()!= "HIGH"  && candidate.getYearsOfExperience() <= 0) {

            return candidate.getName() + ", Thank you for applying! But we regret to inform you that you are not qualified for this role.";
        }
        return "Congratulations " + candidate.getName() + ", " + " We are pleased to inform You that you have passed the first stage of the recruitment process";
    }
}
