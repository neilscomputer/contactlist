package edu.mills.contactlist.impl;

import com.google.common.annotations.VisibleForTesting;
import edu.mills.contactlist.Contact;
import edu.mills.contactlist.ContactList;
import java.util.Iterator;

public class ArrayContactList implements ContactList {
  private Contact[] contacts = new Contact[0];

  public ArrayContactList() {
  }

  @VisibleForTesting
  ArrayContactList(Contact[] initialContacts) {
    this.contacts = initialContacts;
  }

  public void addContact(Contact contact) {
    if (findContactByName(contact.getName()) == null) {
      Contact[] newContacts = new Contact[contacts.length + 1];
      for (int i = 0; i < contacts.length; ++i) {
        newContacts[i] = contacts[i];
      }
      newContacts[contacts.length] = contact;
      contacts = newContacts;
    }
  }

  public Contact findContactByName(String name) {
    for (Contact contact : contacts) {
      if (contact.getName().equals(name)) {
        return contact;
      }
    }
    return null;
  }

  public Contact findContactByPhoneNumber(String phoneNumber) {
    for (Contact contact : contacts) {
      if (contact.getPhoneNumber().equals(phoneNumber)) {
        return contact;
      }
    }
    return null;
  }

  public void deleteContact(Contact contact) {
    if (findContactByName(contact.getName()) != null) {
      Contact[] newContacts = new Contact[contacts.length - 1];
      int j = 0;
      for (int i = 0; i < contacts.length; i++) {
        if (!contacts[i].getName().equals(contact.getName())) {
          newContacts[j++] = contacts[i];
        }
      }
      contacts = newContacts;
    }
  }

  public Iterator<Contact> iterator() {
    return new ContactIterator();
  }

  /**
   * The thing to know about an inner class is that it maintains a reference
   * to the instance of the enclosing class that created it.
   */
  private class ContactIterator implements Iterator<Contact> {
    private int currentIndex;

    public boolean hasNext() {
      return currentIndex < ArrayContactList.this.contacts.length;
    }

    public Contact next() {
      if (hasNext()) {
        return ArrayContactList.this.contacts[currentIndex++];
      } else {
        return null;
      }
    }
  }
}
