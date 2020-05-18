package edu.ib.entities;

public class Specialist {
    private int specialistId;
    private String specialistName;

    public Specialist() {
    }

    public Specialist(int specialistId, String specialistName) {
        this.specialistId = specialistId;
        this.specialistName = specialistName;
    }

    public Specialist(String specialistName) {
        this.specialistName = specialistName;
    }

    public int getSpecialistId() {
        return specialistId;
    }

    public void setSpecialistId(int specialistId) {
        this.specialistId = specialistId;
    }

    public String getSpecialistName() {
        return specialistName;
    }

    public void setSpecialistName(String specialistName) {
        this.specialistName = specialistName;
    }
}//end of class
