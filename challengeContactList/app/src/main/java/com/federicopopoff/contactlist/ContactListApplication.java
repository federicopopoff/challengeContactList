package com.federicopopoff.contactlist;

import android.app.Application;

import com.federicopopoff.contactlist.service.ContactListService;
import com.facebook.drawee.backends.pipeline.Fresco;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ContactListApplication extends Application {

    public static ContactListService sContactListService;

    public static void setupServices(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.solstice.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        sContactListService = retrofit.create(ContactListService.class);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        ContactListApplication.setupServices();
    }
}
