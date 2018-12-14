package com.example.admin.iguanafixandroidchallenge.ViewModel;

import android.arch.lifecycle.ViewModel;
import android.os.Build;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.iguanafixandroidchallenge.Adapter.ContactListRecyclerViewAdapter;
import com.example.admin.iguanafixandroidchallenge.Model.Contact;
import com.example.admin.iguanafixandroidchallenge.Retrofit.ContactDAO;
import com.example.admin.iguanafixandroidchallenge.Retrofit.ResultListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ContactListViewModel extends ViewModel {

    private ContactListRecyclerViewAdapter adapter;
    private List<Contact> contacts;


    public ContactListViewModel() {
        contacts = new ArrayList<>();
    }

    public void setRecyclerView(RecyclerView contactsRecyclerView, FragmentActivity fragmentActivity) {
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(fragmentActivity, LinearLayoutManager.VERTICAL, false));
        contactsRecyclerView.setAdapter(adapter);
    }

    //cuando traigo los contactos le notifico que cambio el set de datos al adapter para que los muestre
    public void getContactsfromAPIandNotifyAdapter() {
        ContactDAO contactDAO = new ContactDAO();

        contactDAO.getContactsAsync(new ResultListener<List<Contact>>() {
            @Override
            public void finish(List<Contact> result) {
                contacts = result;
                setsortedListToAdapter(contacts);
            }
        });
    }

    public void inicializeAdapterAndSetOnClickContactSell(ContactListRecyclerViewAdapter adapter) {
        this.adapter = adapter;
    }

    public List<Contact> searchContactbyName(String contactName) {
        List<Contact> results = new ArrayList<>();

        for (Contact contact : this.contacts) {
            String fullNameToLowerCase = contact.getFirst_name().toLowerCase() + contact.getLast_name().toLowerCase();

            //paso todo a lower case para que no haya problema con mayusculas y minusculas
            if (fullNameToLowerCase.contains(contactName.toLowerCase())) {
                results.add(contact);
            }
        }

        return results;
    }

    public void setsortedListToAdapter(List<Contact> contacts) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Collections.sort(contacts, Comparator.comparing(Contact::getFirst_name));
        }

        adapter.setContacts(contacts);
    }

}
