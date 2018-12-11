package com.example.admin.iguanafixandroidchallenge.View;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.example.admin.iguanafixandroidchallenge.Model.Contact;
import com.example.admin.iguanafixandroidchallenge.R;

public class ContactDetailFragment extends Fragment {

    public static final String CONTACT_ID = "CONTACT_ID";

    private Contact contact;
    private ImageView photo;
    private TextView name;
    private TextView birthDate;
    private TextView homeNumber;
    private TextView cellphoneNumber;
    private TextView officeNumber;
    private TextView workAdress;
    private TextView homeAdress;
    private ImageView backgroundImage;


    public static ContactDetailFragment newInstance() {
        return new ContactDetailFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.contact_detail_fragment, container, false);

        Bundle bundle = getArguments();

        contact = (Contact) bundle.getSerializable(CONTACT_ID);
        photo = view.findViewById(R.id.contactDetailPhotoImageView);
        name = view.findViewById(R.id.ContactDetailNameTextView);
        birthDate = view.findViewById(R.id.contactDetailBirthDateTextView);
        homeNumber = view.findViewById(R.id.contactDetailHomeNumberTextView);
        cellphoneNumber = view.findViewById(R.id.contactDetailCellphoneNumberTextView);
        officeNumber = view.findViewById(R.id.contactDetailofficeNumberTextView);
        workAdress = view.findViewById(R.id.contactDetailWorkAdressTextView);
        homeAdress = view.findViewById(R.id.contactDetailHomeAdressTextView);
        backgroundImage = view.findViewById(R.id.contactDetailBackgroundImageView);

        RequestBuilder<Drawable> thumbDrawable = Glide.with(view).load(contact.getThumb());
        Glide.with(view).load(contact.getPhoto()).thumbnail(thumbDrawable).into(photo);
        name.setText(contact.getFirst_name() + " " + contact.getLast_name());
        birthDate.setText(contact.getUser_id());
        homeNumber.setText(contact.getPhones().get(0).getNumber());
        cellphoneNumber.setText(contact.getPhones().get(1).getNumber());
        officeNumber.setText(contact.getPhones().get(2).getNumber());
        workAdress.setText(contact.getUser_id());
        homeAdress.setText(contact.getUser_id());
        Glide.with(view).load(R.drawable.contactdetailbackground2).into(backgroundImage);

        return view;
    }

}
