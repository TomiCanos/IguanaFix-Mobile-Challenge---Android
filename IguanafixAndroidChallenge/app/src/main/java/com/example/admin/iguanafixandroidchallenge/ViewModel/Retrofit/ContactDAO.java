package com.example.admin.iguanafixandroidchallenge.ViewModel.Retrofit;

import com.example.admin.iguanafixandroidchallenge.Model.Contact;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactDAO {
    private Retrofit retrofit;

    public ContactDAO() {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                .baseUrl("https://private-d0cc1-iguanafixtest.apiary-mock.com/")
                .addConverterFactory(GsonConverterFactory.create());

        retrofit = retrofitBuilder.client(httpClient.build()).build();
    }

    public void getContactsAsync(final ResultListener<List<Contact>> vmlistener) {
        ContactService contactService = retrofit.create(ContactService.class);
        Call<List<Contact>> call = contactService.getContacts();
        call.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                vmlistener.finish(response.body());
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
                vmlistener.finish(new ArrayList<Contact>());
            }
        });
    }
}
