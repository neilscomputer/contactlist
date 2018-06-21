package edu.mills.contactlist;

/**
 * A "driver program" for the contact list class.
 *
 * TODO: add documentation here.
 */
public class ContactListApp {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        System.out.println(new ContactListApp().getGreeting());
    }
}
