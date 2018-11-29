package com.example.admin.iguanafixandroidchallenge.ViewModel;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.admin.iguanafixandroidchallenge.Model.Contact;
import com.example.admin.iguanafixandroidchallenge.R;

import java.util.ArrayList;
import java.util.List;

public class ContactListViewModel extends ViewModel {

    private RecyclerView contactsRecyclerView;
    private ContactListRecyclerViewAdapter adapter;

    public void setRecyclerView(View view, FragmentActivity fragmentActivity) {
        contactsRecyclerView = view.findViewById(R.id.contactListRecyclerView);
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(fragmentActivity, LinearLayoutManager.VERTICAL, false));
        adapter = new ContactListRecyclerViewAdapter(createContactList());
        contactsRecyclerView.setAdapter(adapter);
    }

    private List<Contact> createContactList() {
        List<Contact> contacts = new ArrayList<>();
        Contact contact1 = new Contact("Pepi", "Yaya");
        Contact contact2 = new Contact("Don", "Jorge");
        Contact contact3 = new Contact("Maestro", "Splinter");
        Contact contact4 = new Contact("Jesu", "Noma");

        contacts.add(contact1);
        contacts.add(contact2);
        contacts.add(contact3);
        contacts.add(contact4);

        return contacts;
    }

}
