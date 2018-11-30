package com.example.admin.iguanafixandroidchallenge.Model;

import java.util.List;

public class Contact {
    private String user_id;
    private String created_at;
    private String birth_date;
    private String first_name;
    private String last_name;
    private List<Phone> phones;
    private String thumb;
    private String photo;

    public Contact(String user_id, String created_at, String birth_date, String first_name, String last_name, List<Phone> phones, String thumb, String photo) {
        this.user_id = user_id;
        this.created_at = created_at;
        this.birth_date = birth_date;
        this.first_name = first_name;
        this.last_name = last_name;
        this.phones = phones;
        this.thumb = thumb;
        this.photo = photo;
    }

    public String getUser_id() {
        return user_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getBirth_date() {
        return birth_date;
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
