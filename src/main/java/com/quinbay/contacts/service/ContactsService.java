package com.quinbay.contacts.service;


import com.quinbay.contacts.api.ContactsInterface;
import com.quinbay.contacts.kafka.KafkaPublishingService;
import com.quinbay.contacts.model.Contacts;
import com.quinbay.contacts.repository.ContactsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ContactsService implements ContactsInterface {

    @Autowired
    ContactsRepo contactsRepo;

    @Autowired
    KafkaPublishingService kafkaPublishingService;

    @Override
    public Contacts addContact(String mobilenum) {
        Contacts fetchContact = null;
        fetchContact = contactsRepo.findByMobilenum(mobilenum);
        if (fetchContact != null) {
//                    return "Contact already Exists";
            return null;
        }
        Contacts addnew = new Contacts(mobilenum);
        contactsRepo.save(addnew);
        return addnew;
//        return "Contact added";
    }

    public String editContact(int id, String mobilenum){
        Contacts findContact = null;
        findContact = contactsRepo.findById(id);
        if(findContact!=null){
            findContact.setMobilenum(mobilenum);
            contactsRepo.save(findContact);
            return "Contact Edited";
        }
        return "Contact Id not found";
    }

    @Override
    public List<Contacts> findAllUsers() {
        List<Contacts> users = contactsRepo.findAll();
//        kafkaPublishingService.ContactDetails(users);
        return users;
    }


//    public Map<Object,String> addUserConatct(String mobilenum,String usercontactname) {
//        Contacts fetchContact = null;
//        fetchContact = contactsRepo.findByMobilenum(mobilenum);
//        if (fetchContact != null) {
//            Map<Object, String> addUser = new HashMap<>();
//            addUser.put(fetchContact.getMobilenum()," ");
//            addUser.put(fetchContact.getUsercontactname(),"User Already Exists");
//            return addUser;
//        }
//        Map<Object, String > existUser = new HashMap<>();
//        existUser.put(mobilenum," ");
//        existUser.put(usercontactname,"Contact Added successfully");
//        Contacts addnew = new Contacts(mobilenum, usercontactname);
//        contactsRepo.save(addnew);
//        //kafkaPublishingService.ContactDetails(addnew);
//        return existUser;
//    }






// --------------------------------------------------------------------------------------------------------------
//    public Map<String, Object> displayuser(String username , String mobilenum , String usercontactname ){
//        Contacts fetchContact = null ;
//        fetchContact = contactsRepo.findByMobilenumAndusercontactname(mobilenum,usercontactname);
//        if(fetchContact.getMobilenum() != mobilenum){
//            Map<String, Object> addUser = new HashMap<>();
//            Contacts addnew = new Contacts(mobilenum,usercontactname);
//            contactsRepo.save(addnew);
//            addUser.put("userid", addnew.getId());
//            addUser.put("mobilenum",addnew.getMobilenum());
//            addUser.put("about",addnew.getUsercontactname());
//            return addUser;
//        }
//        Map<String, Object> empUser = new HashMap<>();
//        empUser.put("ALert","Mobile number already exists");
//        return empUser;
//    }
}
