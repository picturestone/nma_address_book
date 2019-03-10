package be.howest.lukas.addressbook.contactRecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import be.howest.lukas.addressbook.R;
import be.howest.lukas.addressbook.models.Contact;

public class ContactRecyclerViewAdapter extends RecyclerView.Adapter<ContactRecyclerViewHolder> {
    private List<Contact> _contacts;

    public ContactRecyclerViewAdapter(List<Contact> contacts) {
        _contacts = contacts;
    }

    @NonNull
    @Override
    public ContactRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = (View) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_recycle_view_holder, viewGroup, false);
        return new ContactRecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactRecyclerViewHolder contactRecyclerViewHolder, int i) {
        Contact contact = _contacts.get(i);
        contactRecyclerViewHolder.setContact(contact);
    }

    @Override
    public int getItemCount() {
        return _contacts.size();
    }

}
