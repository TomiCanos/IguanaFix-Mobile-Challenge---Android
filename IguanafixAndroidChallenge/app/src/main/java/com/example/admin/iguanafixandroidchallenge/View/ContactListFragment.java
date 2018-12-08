package com.example.admin.iguanafixandroidchallenge.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.iguanafixandroidchallenge.Model.Contact;
import com.example.admin.iguanafixandroidchallenge.R;
import com.example.admin.iguanafixandroidchallenge.ViewModel.ContactListRecyclerViewAdapter;
import com.example.admin.iguanafixandroidchallenge.ViewModel.ContactListViewModel;

public class ContactListFragment extends Fragment {

    private ContactListViewModel mViewModel;
    private OnClickContactCellNotifier onClickContactCellNotifier;
    private View view;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        if (view != null) {
            return view;
        }
        View view = inflater.inflate(R.layout.contact_list_fragment, container, false);
        mViewModel = ViewModelProviders.of(this).get(ContactListViewModel.class);
        mViewModel.getContactsfromAPI();
        mViewModel.inicializeAdapterAndSetOnClickContactSell(new ContactListRecyclerViewAdapter(
                new ContactListRecyclerViewAdapter.OnClickContactCellNotifier() {
                    @Override
                    public void openClickedContact(Contact contact) {
                        onClickContactCellNotifier.openClickedContact(contact);
                    }
                }));
        mViewModel.setRecyclerView(view, getActivity());
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onClickContactCellNotifier = (OnClickContactCellNotifier) getActivity();
    }

    public interface OnClickContactCellNotifier {
        void openClickedContact(Contact contact);
    }

    @Override
    public void onStop() {
        view = getView();
        super.onStop();
    }
}
