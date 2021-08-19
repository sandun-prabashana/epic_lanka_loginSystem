package com.epic.login.model;


public class Users {
    private int id;
    private String user_name;
    private String address;
    private String email_address;
    private String contact;
    private String password;
    private String role;
    private String image;

    public Users() {
    }

    public Users(int id, String user_name, String address, String email_address, String contact) {
        this.id = id;
        this.user_name = user_name;
        this.address = address;
        this.email_address = email_address;
        this.contact = contact;
    }

    
    public Users(String user_name, String address, String email_address, String contact, String password, String role, String image) {
        this.user_name = user_name;
        this.address = address;
        this.email_address = email_address;
        this.contact = contact;
        this.password = password;
        this.role = role;
        this.image=image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    
    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }
    
            
}
