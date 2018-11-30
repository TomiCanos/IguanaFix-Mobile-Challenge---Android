package com.example.admin.iguanafixandroidchallenge.Model;

import android.widget.ImageView;

public class Contact {
    private String first_name;
    private String last_name;
    private String thumb;
    private String photo;

    public Contact() {
    }

    public Contact(String first_name, String last_name) {
        this.first_name = first_name;
        this.last_name = last_name;
    }

    public Contact(String first_name, String last_name, String thumb, String photo) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.thumb = thumb;
        this.photo = photo;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
