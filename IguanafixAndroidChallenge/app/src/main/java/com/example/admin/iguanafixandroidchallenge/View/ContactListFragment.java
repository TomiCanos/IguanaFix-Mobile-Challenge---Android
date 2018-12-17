package com.example.admin.iguanafixandroidchallenge.View;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.EditText;

import com.example.admin.iguanafixandroidchallenge.Model.Contact;
import com.example.admin.iguanafixandroidchallenge.R;
import com.example.admin.iguanafixandroidchallenge.Adapter.ContactListRecyclerViewAdapter;
import com.example.admin.iguanafixandroidchallenge.Model.RecyclerViewFastScroller;
import com.example.admin.iguanafixandroidchallenge.ViewModel.ContactListViewModel;

public class ContactListFragment extends Fragment {

    private EditText searchContactByNameEditText;
    private RecyclerView contactsRecyclerView;
    private RecyclerViewFastScroller contactsRecyclerViewFastScroller;
    private ContactListViewModel mViewModel;
    private OnClickContactCellNotifier onClickContactCellNotifier;
    private View view;
    private String search;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        if (view != null) {
            return view;
        }
        View view = inflater.inflate(R.layout.contact_list_fragment, container, false);
        mViewModel = ViewModelProviders.of(this).get(ContactListViewModel.class);

        searchContactByNameEditText = view.findViewById(R.id.contactListNameEditText);
        contactsRecyclerView = view.findViewById(R.id.contactListRecyclerView);
        contactsRecyclerViewFastScroller = view.findViewById(R.id.contactListRecyclerViewFastScroller);
        search = "";

        mViewModel.getContactsfromAPIandNotifyAdapter();

        mViewModel.inicializeAdapterAndSetOnClickContactSell(new ContactListRecyclerViewAdapter(
                new ContactListRecyclerViewAdapter.OnClickContactCellNotifier() {
                    @Override
                    public void openClickedContact(Contact contact) {
                        onClickContactCellNotifier.openClickedContact(contact);
                    }
                }));


        contactsRecyclerViewFastScroller.setRecyclerView(contactsRecyclerView);
        contactsRecyclerViewFastScroller.setViewsToUse(R.layout.recycler_view_fast_scroller__fast_scroller, R.id.fastscroller_bubble, R.id.fastscroller_handle);
        mViewModel.setRecyclerView(contactsRecyclerView, getActivity());

        searchContactByNameEditText.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (count == 0) {
                    mViewModel.getContactsfromAPIandNotifyAdapter();
                    contactsRecyclerViewFastScroller.setVisibility(View.VISIBLE);
                } else {
                    contactsRecyclerViewFastScroller.setVisibility(View.INVISIBLE);
                    search = s.toString();
                }
                mViewModel.setsortedListToAdapter(mViewModel.searchContactbyName(search));
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onClickContactCellNotifier = (OnClickContactCellNotifier) getActivity();
    }

    //funcion para abrir el detalle del contacto
    public interface OnClickContactCellNotifier {
        void openClickedContact(Contact contact);
    }

    // esto es para que cuando minimicen la app no vuelva a cargar los datos de la vista
    @Override
    public void onPause() {
        view = getView();
        super.onPause();
    }

}
