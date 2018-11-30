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
import com.example.admin.iguanafixandroidchallenge.ViewModel.ContactListRecyclerViewAdapter;
import com.example.admin.iguanafixandroidchallenge.ViewModel.ContactListViewModel;

public class ContactListFragment extends Fragment {

    private ContactListViewModel mViewModel;


    public static ContactListFragment newInstance() {
        return new ContactListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.contact_list_fragment, container, false);
        mViewModel = ViewModelProviders.of(this).get(ContactListViewModel.class);
        mViewModel.setRecyclerView(view, getActivity());
        return view;
    }


}
