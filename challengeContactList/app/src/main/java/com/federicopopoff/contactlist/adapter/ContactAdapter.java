package com.federicopopoff.contactlist.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.federicopopoff.contactlist.ContactActivity;
import com.federicopopoff.contactlist.R;
import com.federicopopoff.contactlist.fragment.ContactDetailFragment;
import com.federicopopoff.contactlist.model.Contact;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import java.util.List;

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    private List<Contact> contacts;
    private boolean mTwoPane;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        protected View mView;
        protected TextView contactName;
        protected TextView contactPhone;
        protected SimpleDraweeView contactPhoto;
        protected Contact contact;
        public ViewHolder(View v) {
            super(v);
            mView = v;
            this.contactName = (TextView)v.findViewById(R.id.contact_name);
            this.contactPhone = (TextView)v.findViewById(R.id.contact_phone);
            this.contactPhoto = (SimpleDraweeView)v.findViewById(R.id.contact_photo);
        }
    }

    public ContactAdapter(List<Contact> contacts, boolean mTwoPane) {
        this.contacts = contacts;
        this.mTwoPane = mTwoPane;
    }

    @Override
    public ContactAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.contact_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.contactName.setText(contacts.get(position).getName());
        if(contacts.get(position).getPhone()!=null)
            holder.contactPhone.setText(contacts.get(position).getPhone().getHome());
        holder.contactPhoto.setImageURI(contacts.get(position).getSmallImageURL());
        holder.contact = contacts.get(position);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewClick(holder.contact, holder.mView.getContext());
            }
        });
        holder.contactName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewClick(holder.contact, holder.mView.getContext());
            }
        });
        holder.contactPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewClick(holder.contact, holder.mView.getContext());
            }
        });
    }

    private void viewClick(Contact contact, Context context){
        if(mTwoPane){
            Bundle arguments = new Bundle();
            arguments.putString(ContactDetailFragment.CONTACT, new Gson().toJson(contact));
            ContactDetailFragment fragment = new ContactDetailFragment();
            fragment.setArguments(arguments);
            android.support.v4.app.FragmentManager manager = ((AppCompatActivity) context).getSupportFragmentManager();
            manager.beginTransaction()
                    .replace(R.id.contact_detail_container, fragment)
                    .commit();
        } else{
            Intent intent = new Intent(context, ContactActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString(ContactDetailFragment.CONTACT,  new Gson().toJson(contact));
            intent.putExtras(bundle);
            context.startActivity(intent);
        }
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }
}
