package com.example.admin.iguanafixandroidchallenge.ViewModel;

import android.arch.lifecycle.ViewModel;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.admin.iguanafixandroidchallenge.Model.Contact;
import com.example.admin.iguanafixandroidchallenge.R;
import com.example.admin.iguanafixandroidchallenge.ViewModel.Retrofit.ContactDAO;
import com.example.admin.iguanafixandroidchallenge.ViewModel.Retrofit.ResultListener;

import java.util.ArrayList;
import java.util.List;

public class ContactListViewModel extends ViewModel {

    private RecyclerView contactsRecyclerView;
    private ContactListRecyclerViewAdapter adapter;
    private List<Contact> contacts;

    public ContactListViewModel() {
        contacts = new ArrayList<>();
        adapter = new ContactListRecyclerViewAdapter();
    }

    public void setRecyclerView(View view, FragmentActivity fragmentActivity) {
        contactsRecyclerView = view.findViewById(R.id.contactListRecyclerView);
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(fragmentActivity, LinearLayoutManager.VERTICAL, false));
        contactsRecyclerView.setAdapter(adapter);
    }

    public void getContactsfromAPI() {
        ContactDAO contactDAO = new ContactDAO();

        contactDAO.getContactsAsync(new ResultListener<List<Contact>>() {
            @Override
            public void finish(List<Contact> result) {
                contacts = result;
                adapter.setContacts(contacts);
            }
        });
    }

}
