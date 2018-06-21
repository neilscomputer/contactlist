package edu.mills.contactlist;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

/**
 * Basic unit test of the contact data class.
 */
public class ContactTest {
    private Contact contact;

    @Before
    public void setUp() {
      contact = new Contact("111-222-3333", "Susan Mills");
    }

    @Test
    public void testFirstName() {
        Assert.assertEquals("Susan Mills", contact.getName());
        Assert.assertEquals("111-222-3333", contact.getPhoneNumber());
    }
}
