package edu.mills.contactlist;

import java.util.Iterator;

public interface ContactList extends Iterable<Contact> {
  void addContact(Contact contact);
  Contact findContactByName(String name);
  Contact findContactByPhoneNumber(String phoneNumber);
  void deleteContact(Contact contact);
  Iterator<Contact> iterator();
}
