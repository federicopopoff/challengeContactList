package com.federicopopoff.contactlist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.federicopopoff.contactlist.fragment.ContactDetailFragment;

public class ContactActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        if (savedInstanceState == null) {
            Bundle bundle = getIntent().getExtras();
            ContactDetailFragment fragment = new ContactDetailFragment();
            fragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contact_detail_container, fragment)
                    .commit();
        }
    }


}
