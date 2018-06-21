package edu.mills.contactlist.io;

import com.opencsv.CSVReader;
import edu.mills.contactlist.Contact;
import edu.mills.contactlist.ContactList;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Contact storage backed by a CSV-formatted file.
 */
public class CsvContactStorage implements ContactStorage<String> {
  public void read(String source, ContactList contactList) throws StorageException {
    try {
      Reader reader = Files.newBufferedReader(Paths.get(source));
      CSVReader csvReader = new CSVReader(reader);
      int lineNumber = 0;
      for (String[] fields = csvReader.readNext(); fields != null; fields = csvReader.readNext()) {
        if (fields.length != 2) {
          throw new StorageException("Incorrect data format on line " + lineNumber);
        }
        // Perhaps implement some other validation?
        contactList.addContact(new Contact(fields[0], fields[1]));
      }
    } catch (IOException e) {
      throw new StorageException(e);
    }
  }

  public void write(ContactList contactList, String destination) throws StorageException {
  }
}
