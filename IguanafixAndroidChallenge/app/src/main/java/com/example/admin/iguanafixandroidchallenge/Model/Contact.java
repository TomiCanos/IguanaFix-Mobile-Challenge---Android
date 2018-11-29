package com.example.admin.iguanafixandroidchallenge.Model;

import android.widget.ImageView;

public class Contact {
    private String first_name;
    private String last_name;
    private String thumb;
    private String photo;

    public Contact(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

}
