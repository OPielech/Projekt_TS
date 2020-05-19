package edu.ib.entities;

import java.sql.Date;

public class VisitView {

    private int visitSpecialistId;
    private int visitPlaceId;
    private Date visitDate;
    private int visitHourId;

    public VisitView() {
    }

    public VisitView(int visitSpecialistId, int visitPlaceId, Date visitDate, int visitHourId) {
        this.visitSpecialistId = visitSpecialistId;
        this.visitPlaceId = visitPlaceId;
        this.visitDate = visitDate;
        this.visitHourId = visitHourId;
    }

    public int getVisitSpecialistId() {
        return visitSpecialistId;
    }

    public void setVisitSpecialistId(int visitSpecialistId) {
        this.visitSpecialistId = visitSpecialistId;
    }

    public int getVisitPlaceId() {
        return visitPlaceId;
    }

    public void setVisitPlaceId(int visitPlaceId) {
        this.visitPlaceId = visitPlaceId;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public int getVisitHourId() {
        return visitHourId;
    }

    public void setVisitHourId(int visitHourId) {
        this.visitHourId = visitHourId;
    }
}//end of class
