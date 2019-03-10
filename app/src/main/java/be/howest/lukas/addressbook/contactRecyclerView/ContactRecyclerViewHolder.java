package be.howest.lukas.addressbook.contactRecyclerView;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import be.howest.lukas.addressbook.R;
import be.howest.lukas.addressbook.activities.AddContactActivity;
import be.howest.lukas.addressbook.activities.ContactDetailActivity;
import be.howest.lukas.addressbook.models.Contact;

public class ContactRecyclerViewHolder extends RecyclerView.ViewHolder {
    private Contact _contact;
    private TextView _textView;

    public static final String S_CONTACT = ContactRecyclerViewHolder.class.getCanonicalName() + ".CONTACT";

    public ContactRecyclerViewHolder(@NonNull View itemView) {
        super(itemView);
        _textView = itemView.findViewById(R.id.textViewList);

        View.OnClickListener listener = v -> ContactRecyclerViewHolder.this.onClick();
        itemView.findViewById(R.id.relativeLayout).setOnClickListener(listener);
    }

    public TextView getTextView() {
        return _textView;
    }

    public void setContact(Contact contact) {
        _contact = contact;
        _textView.setText(_contact.getFirstName());
    }

    public void onClick() {
        Intent intent = new Intent(_textView.getContext(), ContactDetailActivity.class);
        intent.putExtra(S_CONTACT, _contact);
        _textView.getContext().startActivity(intent);
    }
}
