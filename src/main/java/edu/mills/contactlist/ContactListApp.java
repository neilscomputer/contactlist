package edu.mills.contactlist;

import com.google.common.annotations.VisibleForTesting;
import edu.mills.contactlist.io.ContactStorage;
import edu.mills.contactlist.io.CsvContactStorage;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * A "driver program" for the contact list class.
 */
public class ContactListApp {
  public static void main(String[] args) throws Exception {
    new ContactListApp().run(args);
  }

  private ContactList contactList;
  private CsvContactStorage storage = new CsvContactStorage();

  public void run(String[] args) throws Exception {
    // To add more options to this program, modify this method appropriately.
    CommandLine cmd = parseCommandLine(args);
    if (cmd == null) {
      System.exit(0);
    }
 
    // Create a ContactList of the appropriate type.
    switch (cmd.getOptionValue("impl")) {
      case "ArrayContactList":
        contactList = ContactListFactory.createArrayContactList();
        break;
      default:
        throw new Exception("No contactlist binding for " + cmd.getOptionValue("type"));
    }

    // Read the input.
    storage.read(cmd.getOptionValue("inputfile"), contactList);
  }

  /**
   * Not terribly interesting code to read command-line options. Most of the
   * heavy lifting is delegated to "apache commons CLI", which is an API for
   * doing this kind of thing. Without using the API it's just a bunch of
   * grungy string handling code that is longer and even more boring than
   * this.
   */
  @VisibleForTesting
  CommandLine parseCommandLine(String[] args) throws ParseException {
    Options options = new Options();
    // The option for reading a particular file
    options.addOption("help", false, "Print help and exit");
    options.addOption("inputfile", true, "Input file to be read");
    options.addOption("impl", true, "Implementation of ContactList to use");

    CommandLine cmd = new DefaultParser().parse(options, args);
    if (cmd.hasOption("help") || !cmd.hasOption("impl")) {
      new HelpFormatter().printHelp("ContactListApp", options);
      return null;
    }

    return cmd;
  }
}
