package com.quinbay.contacts.controller;


import com.quinbay.contacts.model.Contacts;
import com.quinbay.contacts.repository.ContactsRepo;
import com.quinbay.contacts.service.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class ContactsController {

    @Autowired
    ContactsService contactsService;


    @PostMapping("/addUser")
    public Contacts  returnUser(@RequestParam String mobilenum) {
        return contactsService.addContact(mobilenum);
        //return userDetailsService.findUsername(username,mobilenum,password);
    }

//    @PostMapping("/addNewUser")
//    public Map<Object,String>  returnUsers(@RequestParam String mobilenum, @RequestParam String usercontactname) {
//        return contactsService.addUserConatct(mobilenum,usercontactname);
//        //return userDetailsService.findUsername(username,mobilenum,password);
//    }

    @PutMapping("/editContact")
    public String editContact(@RequestParam int id , @RequestParam String mobilenum){
        return contactsService.editContact(id,mobilenum);
    }

    @GetMapping("/displayContacts")
    public List<Contacts> getAllUsers() {
        return contactsService.findAllUsers();
    }
}
