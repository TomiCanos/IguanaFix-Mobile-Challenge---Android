package com.example.admin.iguanafixandroidchallenge.View;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.iguanafixandroidchallenge.Model.Contact;
import com.example.admin.iguanafixandroidchallenge.R;

public class MainActivity extends AppCompatActivity implements ContactListFragment.OnClickContactCellNotifier {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.mainActivityContainer, new ContactListFragment(), "tag");
        fragmentTransaction.commit();
    }

    @Override
    public void openClickedContact(Contact contact) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(ContactDetailFragment.CONTACT_ID, contact);
        ContactDetailFragment contactDetailFragment = new ContactDetailFragment();
        contactDetailFragment.setArguments(bundle);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.mainActivityContainer, contactDetailFragment, "tag");
        fragmentTransaction.addToBackStack(null).commit();
    }
}
