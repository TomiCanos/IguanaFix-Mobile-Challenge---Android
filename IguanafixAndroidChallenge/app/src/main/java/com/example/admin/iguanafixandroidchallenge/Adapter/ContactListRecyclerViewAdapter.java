package com.example.admin.iguanafixandroidchallenge.Adapter;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
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
import com.example.admin.iguanafixandroidchallenge.Model.RecyclerViewFastScroller;

import java.util.ArrayList;
import java.util.List;

public class ContactListRecyclerViewAdapter extends RecyclerView.Adapter implements RecyclerViewFastScroller.BubbleTextGetter{
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

    //elije a cual contanto de la vista inflar
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

    //le da el texto para mostrar a la burbujita del fastscroller
    @Override
    public String getTextToShowInBubble(int pos) {

        char result = contacts.get(pos).getFirst_name().charAt(0);
        return Character.toString(result).toUpperCase();
    }

    //une los datos de la vista con los del contacto recibido
    private class ViewHolder extends RecyclerView.ViewHolder {
        private TextView contactName;
        private ImageView contactPhoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            contactName = itemView.findViewById(R.id.contactCellNameTextView);
            contactPhoto = itemView.findViewById(R.id.contactCellPhotoImageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onClickContactCellNotifier.openClickedContact
                            (contacts.get(getAdapterPosition()));
                }
            });
        }

        public void bindContact(final Contact contact) {
            contactName.setText(contact.getFirst_name() + " " + contact.getLast_name());
            RequestBuilder<Drawable> thumbDrawable = Glide.with(itemView).load(contact.getThumb());

            //Hay un contacto que no tiene foto y como thumb trae un archivo svg en vez de un png
            if (!contact.getThumb().contains(".png")) {
                Glide.with(itemView).load(R.drawable.wonder_woman_thumbnail).into(contactPhoto);
            } else {
                Glide.with(itemView).load(contact.getPhoto()).thumbnail(thumbDrawable)
                        .into(contactPhoto);
            }
        }
    }

    // funcion para abrir el detalle del contacto
    public interface OnClickContactCellNotifier {
        void openClickedContact(Contact contact);
    }
}
