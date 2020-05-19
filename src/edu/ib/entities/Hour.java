package edu.ib.entities;

import java.time.LocalTime;

public class Hour {
    private int hourId;
    private LocalTime hourValue;

    public Hour() {
    }

    public Hour(LocalTime hourValue) {
        this.hourValue = hourValue;
    }

    public Hour(int hourId, LocalTime hourValue) {
        this.hourId = hourId;
        this.hourValue = hourValue;
    }

    public int getHourId() {
        return hourId;
    }

    public void setHourId(int hourId) {
        this.hourId = hourId;
    }

    public LocalTime getHourValue() {
        return hourValue;
    }

    public void setHourValue(LocalTime hourValue) {
        this.hourValue = hourValue;
    }
}//end of class
