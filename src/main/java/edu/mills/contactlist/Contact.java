package edu.mills.contactlist;

/**
 * Basic data class for a contact.
 */

public class Contact {
  private final String phoneNumber;
  private final String name;

  public Contact(String phoneNumber, String name) {
    this.phoneNumber = phoneNumber;
    this.name = name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public String getName() {
    return name;
  }
}
