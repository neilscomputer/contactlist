package edu.mills.contactlist;

import org.junit.Test;
import org.junit.Assert;

/**
 * Basic unit test of the contact list driver app.
 */
public class ContactListFactoryTest {
    @Test
    public void testCreateArrayContactList() {
        Assert.assertNotNull(ContactListFactory.createArrayContactList());
    }
}
