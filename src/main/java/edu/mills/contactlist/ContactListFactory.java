package edu.mills.contactlist;

import edu.mills.contactlist.impl.ArrayContactList;

/**
 * Responsible for instantiating a contact list of *some* type.
 */
public class ContactListFactory {
  public static ContactList createArrayContactList() {
    return new ArrayContactList();
  }
}
