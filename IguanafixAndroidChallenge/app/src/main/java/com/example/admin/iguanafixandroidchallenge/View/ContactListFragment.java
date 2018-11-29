package com.example.admin.iguanafixandroidchallenge.View;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.iguanafixandroidchallenge.R;
import com.example.admin.iguanafixandroidchallenge.ViewModel.ContactListRecyclerViewAdapter;
import com.example.admin.iguanafixandroidchallenge.ViewModel.ContactListViewModel;

public class ContactListFragment extends Fragment {

    private ContactListViewModel mViewModel;
    private RecyclerView contactsRecyclerView;
    private ContactListRecyclerViewAdapter adapter;

    public static ContactListFragment newInstance() {
        return new ContactListFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.contact_list_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ContactListViewModel.class);
        // TODO: Use the ViewModel
    }

}
