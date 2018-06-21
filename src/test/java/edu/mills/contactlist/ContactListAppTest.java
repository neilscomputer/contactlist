package edu.mills.contactlist;

import org.junit.Test;
import org.junit.Assert;

/**
 * Basic unit test of the contact list driver app.
 */
public class ContactListAppTest {
    @Test
    public void testAppHasAGreeting() {
        ContactListApp classUnderTest = new ContactListApp();
        Assert.assertNotNull("app should have a greeting", classUnderTest.getGreeting());
    }
}
