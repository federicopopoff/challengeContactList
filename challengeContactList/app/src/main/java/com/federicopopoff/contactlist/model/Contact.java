package com.federicopopoff.contactlist.model;


public class Contact {


    private String name;
    private int employeeId;
    private String company;
    private String detailsURL;
    private String smallImageURL;
    private Long birthdate;
    private Phone phone;
    private String favorite;
    private String largeImageURL;
    private String email;
    private String website;
    private Address address;

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }


    public Long getBirthdate() {
        return birthdate;
    }

    public Phone getPhone() {
        return phone;
    }

    public String getDetailsURL() {
        return detailsURL;
    }

    public String getSmallImageURL() {
        return smallImageURL;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getFavorite() {
        if(favorite==null || favorite.isEmpty() || "false".equals(favorite) || "0".equals(favorite))
            return false;
        else
            return true;

    }

    public String getLargeImageURL() {
        return largeImageURL;
    }


    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }
}
