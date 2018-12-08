package com.example.admin.iguanafixandroidchallenge.Retrofit;

import com.example.admin.iguanafixandroidchallenge.Model.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ContactService {

    @GET("/contacts")
    Call<List<Contact>> getContacts();

    @GET("/contacts/{contactId}")
    Call<Contact> getContact(@Path("contactId") String contactId);
}
