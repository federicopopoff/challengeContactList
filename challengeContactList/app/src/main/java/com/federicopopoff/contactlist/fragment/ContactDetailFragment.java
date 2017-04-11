package com.federicopopoff.contactlist.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.federicopopoff.contactlist.ContactListApplication;
import com.federicopopoff.contactlist.R;
import com.federicopopoff.contactlist.model.Address;
import com.federicopopoff.contactlist.model.Contact;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ContactDetailFragment extends Fragment {

    public static String CONTACT="CONTACT";
    private Contact contact;
    private TextView contactName, contactCompany, contactHomePhone, contactWorkPhone,
            contactMobilePhone, contactAddress, contactCity, contactBirthday, contactEmail;
    private SimpleDraweeView contactPhoto;
    private TextView labelHomePhone, labelWorkPhone, labelMobilePhone;
    private CheckBox contactFavorite;
    private ProgressBar contactProgressBar;

    public ContactDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        contact = new Contact();
        String jsonMyObject = getArguments().getString(CONTACT);
        contact = new Gson().fromJson(jsonMyObject, Contact.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.contact_detail, container, false);
        if(contact!=null){
            contactPhoto = (SimpleDraweeView)rootView.findViewById(R.id.contact_large_photo);
            contactName = (TextView)rootView.findViewById(R.id.contact_detail_name);
            contactCompany = (TextView)rootView.findViewById(R.id.contact_company);
            contactHomePhone = (TextView)rootView.findViewById(R.id.contact_home_phone);
            contactWorkPhone = (TextView)rootView.findViewById(R.id.contact_work_phone);
            contactMobilePhone = (TextView)rootView.findViewById(R.id.contact_mobile_phone);
            contactAddress = (TextView)rootView.findViewById(R.id.contact_street_address);
            contactCity = (TextView)rootView.findViewById(R.id.contact_city_address);
            contactBirthday = (TextView)rootView.findViewById(R.id.contact_birthday);
            contactEmail = (TextView)rootView.findViewById(R.id.contact_email);
            labelHomePhone = (TextView)rootView.findViewById(R.id.label_home_phone);
            labelWorkPhone = (TextView)rootView.findViewById(R.id.label_work_phone);
            labelMobilePhone = (TextView)rootView.findViewById(R.id.label_mobile_phone);
            contactFavorite = (CheckBox)rootView.findViewById(R.id.contact_favorite);
            contactProgressBar = (ProgressBar)rootView.findViewById(R.id.contact_progressbar);
            setName();
            setPhoto(contact.getLargeImageURL()); //If we want to see small photo first
            setPhones();
            setCompany();
            setEmail(contact);
            setFavorite(contact);
            setAddress(contact);
            loadJSON();
        }
        return rootView;
    }

    private void setPhoto(String url){
        contactPhoto.setImageURI(url);
    }

    private void setName(){
        contactName.setText(contact.getName());
    }

    private void setCompany(){
        contactCompany.setText(contact.getCompany());
    }

    private void setPhones(){
        if(!contact.getPhone().getHome().isEmpty()){
            contactHomePhone.setText(contact.getPhone().getHome());
            contactHomePhone.setVisibility(View.VISIBLE);
            labelHomePhone.setVisibility(View.VISIBLE);
        }
        if(contact.getPhone().getWork()!=null && !contact.getPhone().getWork().isEmpty()){
            contactWorkPhone.setText(contact.getPhone().getWork());
            contactWorkPhone.setVisibility(View.VISIBLE);
            labelWorkPhone.setVisibility(View.VISIBLE);
        }
        if(contact.getPhone().getMobile()!=null && !contact.getPhone().getMobile().isEmpty()){
            contactMobilePhone.setText(contact.getPhone().getMobile());
            contactMobilePhone.setVisibility(View.VISIBLE);
            labelMobilePhone.setVisibility(View.VISIBLE);
        }
    }

    private void setAddress(Contact contact){
        Address address = contact.getAddress();
        contactAddress.setText(address.getStreet());
        contactCity.setText(getString(R.string.contact_address, address.getCity(), address.getState()));
    }

    private void setEmail(Contact detailContact){
        contactEmail.setText(detailContact.getEmail());
    }

    private void setFavorite(Contact detailContact){
        contactFavorite.setChecked(detailContact.getFavorite());
    }

    private void loadJSON(){
        Call<Contact> getContactCall  = ContactListApplication.sContactListService.getContact(contact.getDetailsURL());
        getContactCall.enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {
                contactProgressBar.setVisibility(View.GONE);
                Contact detailContact = response.body();
                setPhoto(detailContact.getLargeImageURL());
                setAddress(detailContact);
                setEmail(detailContact);
                setFavorite(detailContact);
            }

            @Override
            public void onFailure(Call<Contact> call, Throwable t) {
                contactProgressBar.setVisibility(View.GONE);
            }
        });
    }

}
