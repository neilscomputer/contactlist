package edu.mills.contactlist;

import java.util.Iterator;

public interface ContactList {
  void addContact(Contact contact);
  Contact findContactByName(String name);
  Contact findContactByPhoneNumber(String phoneNumber);
  void deleteContact(Contact contact);
  Iterator<Contact> iterator();
}
