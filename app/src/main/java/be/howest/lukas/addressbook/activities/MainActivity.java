package be.howest.lukas.addressbook.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

import be.howest.lukas.addressbook.R;
import be.howest.lukas.addressbook.contactRecyclerView.ContactRecyclerViewAdapter;
import be.howest.lukas.addressbook.models.Contact;

public class MainActivity extends AppCompatActivity {

    private static List<Contact> _contacts = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.findViewById(R.id.buttonAdd).setOnClickListener(e -> buttonAddOnClick(e));

        Intent intent = this.getIntent();
        Contact contact = (Contact)intent.getSerializableExtra(AddContactActivity.S_CONTACT);
        if(contact != null) {
            _contacts.add(contact);
        }

        RecyclerView recyclerView = this.findViewById(R.id.recyclerViewContacts);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ContactRecyclerViewAdapter(_contacts));

    }

    private void buttonAddOnClick(View v) {
        Intent intent = new Intent(this, AddContactActivity.class);

        startActivity(intent);
    }

}
