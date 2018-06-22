package edu.mills.contactlist.impl;

import edu.mills.contactlist.Contact;
import edu.mills.contactlist.ContactList;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import java.util.Iterator;

public abstract class BaseContactListTest {
  public static final Contact[] DEFAULT_CONTACTS = new Contact[] {
    new Contact("123-456-7890", "User 1"),
    new Contact("123-456-7891", "User 2"),
    new Contact("123-456-7892", "User 3"),
    new Contact("123-456-7893", "User 4"),
  };

  protected ContactList contactList;

  /** Override this to test a particular kind of contact list. */
  protected abstract ContactList createContactList();

  @Before
  public void setUp() {
    contactList = createContactList();
  }

  @Test
  public void testFindContactByName() {
    Contact contact = contactList.findContactByName("User 1");
    Assert.assertNotNull(contact);
    Assert.assertEquals("User 1", contact.getName());
    Assert.assertNull(contactList.findContactByName("User X"));
  }

  @Test
  public void testFindContactByPhoneNumber() {
    Contact contact = contactList.findContactByPhoneNumber("123-456-7892");
    Assert.assertNotNull(contact);
    Assert.assertEquals("User 3", contact.getName());
    Assert.assertNull(contactList.findContactByPhoneNumber("999-555-1212"));
  }

  @Test
  public void testInsert() {
    contactList.addContact(new Contact("123-456-7894", "User 5"));
    Contact contact = contactList.findContactByName("User 5");
    Assert.assertNotNull(contact);
    Assert.assertEquals("User 5", contact.getName());
    assertListSize(DEFAULT_CONTACTS.length + 1);
  }

  @Test
  public void testInsert_duplicate() {
    contactList.addContact(new Contact("123-456-7890", "User 1"));
    Contact contact = contactList.findContactByName("User 1");
    Assert.assertNotNull(contact);
    Assert.assertEquals("User 1", contact.getName());
    assertListSize(DEFAULT_CONTACTS.length);
  }

  @Test
  public void testDelete() {
    contactList.deleteContact(new Contact("123-456-7890", "User 1"));
    Contact contact = contactList.findContactByName("User 1");
    Assert.assertNull(contact);
    assertListSize(DEFAULT_CONTACTS.length - 1);
  }

  private void assertListSize(int size) {
    int numContacts = 0;
    for (Iterator iter = contactList.iterator(); iter.hasNext(); iter.next()) {
      ++numContacts;
    }
    Assert.assertEquals(size, numContacts);
  }
}
