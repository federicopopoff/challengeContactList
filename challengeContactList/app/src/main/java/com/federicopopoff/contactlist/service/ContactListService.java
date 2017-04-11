package com.federicopopoff.contactlist.service;

import com.federicopopoff.contactlist.model.Contact;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ContactListService {
    @GET("https://s3.amazonaws.com/technical-challenge/Contacts.json")
    Call<List<Contact>> getContacts();

    @GET
    Call<Contact> getContact(@Url String detailsURL);
}
