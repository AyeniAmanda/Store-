package model;


public class Candidate extends Staff  {
    private String educationalLevel;
    private int  yearsOfExperience;


    public Candidate(String name, String educationalLevel, int yearsOfExperience) {
        super(name);
        this.educationalLevel = educationalLevel;
        this.yearsOfExperience = yearsOfExperience;
    }

    public String getEducationalLevel() {
        return educationalLevel;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }




}
