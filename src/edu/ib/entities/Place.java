package edu.ib.entities;

public class Place {
    private int placeId;
    private String placeValue;

    public Place() {
    }

    public Place(String placeValue) {
        this.placeValue = placeValue;
    }

    public Place(int placeId, String placeValue) {
        this.placeId = placeId;
        this.placeValue = placeValue;
    }

    public int getPlaceId() {
        return placeId;
    }

    public void setPlaceId(int placeId) {
        this.placeId = placeId;
    }

    public String getPlaceValue() {
        return placeValue;
    }

    public void setPlaceValue(String placeValue) {
        this.placeValue = placeValue;
    }
}//end of class
