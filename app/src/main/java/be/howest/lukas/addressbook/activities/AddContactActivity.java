package be.howest.lukas.addressbook.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import be.howest.lukas.addressbook.R;
import be.howest.lukas.addressbook.models.Contact;

public class AddContactActivity extends AppCompatActivity {

    public static final String S_CONTACT = AddContactActivity.class.getCanonicalName() + ".CONTACT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        this.findViewById(R.id.buttonSave).setOnClickListener(e -> buttonSaveOnClick(e));
    }

    private void buttonSaveOnClick(View v) {
        Contact contact = new Contact();

        EditText firstName = this.findViewById(R.id.editTextFirstName);
        contact.setFirstName(firstName.getText().toString());

        EditText lastName = this.findViewById(R.id.editTextLastName);
        contact.setLastName(lastName.getText().toString());

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(S_CONTACT, contact);

        this.startActivity(intent);
    }

}
