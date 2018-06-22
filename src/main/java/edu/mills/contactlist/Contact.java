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

  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Name: ");
    sb.append(name);
    sb.append(", ");
    sb.append("Number: ");
    sb.append(phoneNumber);
    return sb.toString();
  }

  public String toCsvString() {
    StringBuilder sb = new StringBuilder();
    sb.append('"');
    sb.append(phoneNumber);
    sb.append("\",\"");
    sb.append(name);
    sb.append('"');
    return sb.toString();
  }
}
