package com.federicopopoff.contactlist.model;


public class Phone {
    private String work;
    private String home;
    private String mobile;

    public Phone (String work, String home, String mobile){
        this.work = work;
        this.home = home;
        this.mobile = mobile;
    }

    public String getHome() {
        return home;
    }

    public String getMobile() {
        return mobile;
    }

    public String getWork() {
        return work;
    }
}
