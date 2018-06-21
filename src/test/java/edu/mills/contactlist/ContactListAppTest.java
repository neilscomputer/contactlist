package edu.mills.contactlist;

import org.apache.commons.cli.CommandLine;
import org.junit.Test;
import org.junit.Assert;

/**
 * Basic unit test of the contact list driver app.
 */
public class ContactListAppTest {
  private ContactListApp app = new ContactListApp();

  @Test
  public void testHelp() throws Exception {
    Assert.assertNotNull(app);
    String[] args = new String[] {"-help"};
    Assert.assertNull(app.parseCommandLine(args));
  }

  @Test
  public void testStandard() throws Exception {
    Assert.assertNotNull(app);
    String[] args = new String[] {"-inputfile", "foo", "-impl", "ArrayContactList"};
    CommandLine cmd = app.parseCommandLine(args);
    Assert.assertNotNull(cmd);
    Assert.assertTrue(cmd.hasOption("inputfile"));
    Assert.assertTrue(cmd.hasOption("impl"));
  }
}
