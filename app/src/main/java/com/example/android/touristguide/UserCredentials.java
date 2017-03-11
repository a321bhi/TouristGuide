package com.example.android.touristguide;

import java.util.Date;

/**
 * Created by anjanavelil on 06-04-2016.
 */
public class UserCredentials {
    String userName , name, pass, mob, email;
    String dob;
    public UserCredentials(String name, String mob, String email, String dob, String userName, String pass){
        this.name= name;
        this.mob= mob;
        this.email= email;
        this.dob= dob;
        this.userName= userName;
        this.pass= pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public String getMob() {
        return mob;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }

    public String getPass() {
        return pass;
    }
}
