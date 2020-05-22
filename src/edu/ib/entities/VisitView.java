package edu.ib.entities;

import java.sql.Date;

public class VisitView {

    private String visitSpecialistId;
    private String visitPlaceId;
    private Date visitDate;
    private String visitHourId;

    public VisitView() {
    }

    public VisitView(String visitSpecialistId, String visitPlaceId, Date visitDate, String visitHourId) {
        this.visitSpecialistId = visitSpecialistId;
        this.visitPlaceId = visitPlaceId;
        this.visitDate = visitDate;
        this.visitHourId = visitHourId;
    }

    public String getVisitSpecialistId() {
        return visitSpecialistId;
    }

    public void setVisitSpecialistId(String visitSpecialistId) {
        this.visitSpecialistId = visitSpecialistId;
    }

    public String getVisitPlaceId() {
        return visitPlaceId;
    }

    public void setVisitPlaceId(String visitPlaceId) {
        this.visitPlaceId = visitPlaceId;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    public String getVisitHourId() {
        return visitHourId;
    }

    public void setVisitHourId(String visitHourId) {
        this.visitHourId = visitHourId;
    }
}//end of class
