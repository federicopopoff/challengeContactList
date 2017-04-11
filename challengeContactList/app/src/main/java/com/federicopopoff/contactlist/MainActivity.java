package com.federicopopoff.contactlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.federicopopoff.contactlist.adapter.ContactAdapter;
import com.federicopopoff.contactlist.model.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view_contact_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        if (findViewById(R.id.contact_detail_container) != null) {
            mTwoPane = true;
        }
        loadJSON();
    }


    private void loadJSON(){
        Call<List<Contact>> getContactsCall = ContactListApplication.sContactListService.getContacts();
        getContactsCall.enqueue(new Callback<List<Contact>>() {
            @Override
            public void onResponse(Call<List<Contact>> call, Response<List<Contact>> response) {
                mRecyclerView.setAdapter(new ContactAdapter(response.body(), mTwoPane));
            }

            @Override
            public void onFailure(Call<List<Contact>> call, Throwable t) {
            }
        });
    }


}
