package com.example.admin.iguanafixandroidchallenge.ViewModel;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.iguanafixandroidchallenge.Model.Contact;
import com.example.admin.iguanafixandroidchallenge.R;

import java.util.ArrayList;
import java.util.List;

public class ContactListRecyclerViewAdapter extends RecyclerView.Adapter {
    private List<Contact> contacts;

    public ContactListRecyclerViewAdapter(List<Contact> contacts) {
        this.contacts = contacts;
    }

    public ContactListRecyclerViewAdapter() {
        contacts = new ArrayList<>();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.contact_list_cell, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        Contact contact = contacts.get(i);
        ViewHolder viewHolder1 = (ViewHolder) viewHolder;
        viewHolder1.bindContact(contact);
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private TextView contactFirstName;
        private TextView contactLastName;
        private ImageView contactPhoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            contactFirstName = itemView.findViewById(R.id.contactCellFirstNameTextView);
            contactLastName = itemView.findViewById(R.id.contactCellLastNameTextView);
            contactPhoto = itemView.findViewById(R.id.contactCellPhotoImageView);
        }

        public void bindContact(Contact contact) {
            contactFirstName.setText(contact.getFirst_name());
            contactLastName.setText(contact.getLast_name());
        }
    }
}
