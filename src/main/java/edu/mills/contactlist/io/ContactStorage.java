package edu.mills.contactlist.io;

import edu.mills.contactlist.ContactList;

/**
 * A way of handling input and output of contactlists.
 *
 * @param T the class of the "storage type". For files, this would likely be a String, which
 *     represents the path.  For a database, this would be a db connection object.
 */
public interface ContactStorage<T> {
  public void read(T source, ContactList contactList) throws StorageException;
  public void write(ContactList contactList, T destination) throws StorageException;
}
