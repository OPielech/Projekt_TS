package edu.ib.entities;

import java.sql.Date;
import java.time.LocalDate;

public class User {

    private int userId;
    private String userLogin;
    private String userPassword;
    private String userName;
    private String userSurname;
    private String userEmail;
    private Date userBirthDate;
    private String userCity;
    private String userPostcode;
    private String userPhone;

    public User(int userId, String userLogin, String userPassword, String userName, String userSurname, String userEmail, Date userBirthDate, String userCity, String userPostcode, String userPhone) {
        this.userId = userId;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
        this.userCity = userCity;
        this.userPostcode = userPostcode;
        this.userPhone = userPhone;
    }

    public User(String userLogin, String userPassword, String userName, String userSurname, String userEmail, Date userBirthDate, String userCity, String userPostcode, String userPhone) {
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userSurname = userSurname;
        this.userEmail = userEmail;
        this.userBirthDate = userBirthDate;
        this.userCity = userCity;
        this.userPostcode = userPostcode;
        this.userPhone = userPhone;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public Date getUserBirthDate() {
        return userBirthDate;
    }

    public void setUserBirthDate(Date userBirthDate) {
        this.userBirthDate = userBirthDate;
    }

    public String getUserCity() {
        return userCity;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public String getUserPostcode() {
        return userPostcode;
    }

    public void setUserPostcode(String userPostcode) {
        this.userPostcode = userPostcode;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }
}//end of class
