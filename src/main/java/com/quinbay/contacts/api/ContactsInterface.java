package com.quinbay.contacts.api;

import com.quinbay.contacts.model.Contacts;

import java.util.ArrayList;
import java.util.List;

public interface ContactsInterface {
    Contacts addContact(String mobilenum);
    List<Contacts> findAllUsers();
}
