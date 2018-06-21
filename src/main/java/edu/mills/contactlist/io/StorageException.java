package edu.mills.contactlist.io;

/**
 * This is just a wrapper around all other exceptions.
 *
 * Providing all three constructors is a common pattern. Gets a bit boring after awhile, but it
 * is useful, which you can see by looking at {@see CsvContactStorage}.
 */
public class StorageException extends Exception {
  public StorageException(String reason) {
    super(reason);
  }

  public StorageException(Throwable cause) {
    super(cause);
  }

  public StorageException(String reason, Throwable cause) {
    super(reason, cause);
  }
}
