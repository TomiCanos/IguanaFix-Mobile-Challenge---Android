package com.example.admin.iguanafixandroidchallenge.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.iguanafixandroidchallenge.R;
import com.example.admin.iguanafixandroidchallenge.ViewModel.ContactDetailViewModel;

public class ContactDetailFragment extends Fragment {

    private ContactDetailViewModel mViewModel;

    public static ContactDetailFragment newInstance() {
        return new ContactDetailFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.contact_detail_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ContactDetailViewModel.class);
        // TODO: Use the ViewModel
    }

}
