package edu.mills.contactlist.impl;

import edu.mills.contactlist.ContactList;

/**
 * Standard unit test for a contact list, which uses ArrayContactList.
 */
public class ArrayContactListTest extends BaseContactListTest {
  @Override
  protected ContactList createContactList() {
    return new ArrayContactList(BaseContactListTest.DEFAULT_CONTACTS);
  }
}
