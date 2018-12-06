package com.example.admin.iguanafixandroidchallenge.ViewModel;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.example.admin.iguanafixandroidchallenge.Model.Contact;
import com.example.admin.iguanafixandroidchallenge.R;

import java.util.ArrayList;
import java.util.List;

public class ContactListRecyclerViewAdapter extends RecyclerView.Adapter {
    private List<Contact> contacts;
    private OnClickContactCellNotifier onClickContactCellNotifier;

    public ContactListRecyclerViewAdapter(OnClickContactCellNotifier onClickContactCellNotifier) {
        contacts = new ArrayList<>();
        this.onClickContactCellNotifier = onClickContactCellNotifier;
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
        notifyDataSetChanged();
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private TextView contactName;
        private TextView contactHomePhoneNumber;
        private TextView contactCellphonePhoneNumber;
        private TextView contactOfficePhoneNumber;
        private ImageView contactPhoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            contactName = itemView.findViewById(R.id.contactCellNameTextView);
            contactPhoto = itemView.findViewById(R.id.contactCellPhotoImageView);
            contactHomePhoneNumber = itemView.findViewById(R.id.contactCellHomePhoneNumberTextView);
            contactCellphonePhoneNumber = itemView.findViewById(R.id.contactCellCellphonePhoneNumberTextView);
            contactOfficePhoneNumber = itemView.findViewById(R.id.contactCellOfficePhoneNumberTextView);

            contactPhoto.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickContactCellNotifier.openClickedContact(contacts.get(getAdapterPosition()));
                }
            });
        }

        public void bindContact(final Contact contact) {
            contactName.setText(contact.getFirst_name() + " " + contact.getLast_name());
            contactHomePhoneNumber.setText(contact.getPhones().get(0).getNumber());
            contactCellphonePhoneNumber.setText(contact.getPhones().get(1).getNumber());
            contactOfficePhoneNumber.setText(contact.getPhones().get(2).getNumber());
            RequestBuilder<Drawable> thumbDrawable = Glide.with(itemView).load(contact.getThumb());
            Glide.with(itemView).load(contact.getPhoto()).thumbnail(thumbDrawable).into(contactPhoto);
        }
    }

    public interface OnClickContactCellNotifier {
        void openClickedContact(Contact contact);
    }
}
