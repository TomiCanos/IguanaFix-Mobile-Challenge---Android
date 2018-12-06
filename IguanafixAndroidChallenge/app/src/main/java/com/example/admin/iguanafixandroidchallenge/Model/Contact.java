package com.example.admin.iguanafixandroidchallenge.Model;

import java.io.Serializable;
import java.util.List;

public class Contact implements Serializable {
    private String user_id;
    private String first_name;
    private String last_name;
    private List<Phone> phones;
    private String thumb;
    private String photo;

    public Contact(String user_id, String first_name, String last_name, List<Phone> phones, String thumb, String photo) {
        this.user_id = user_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phones = phones;
        this.thumb = thumb;
        this.photo = photo;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public String getThumb() {
        return thumb;
    }

    public String getPhoto() {
        return photo;
    }
}
