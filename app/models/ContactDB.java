package models;

import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory repository for Contacts.
 */
public class ContactDB {

  private static List<Contact> contactList = new ArrayList<>();

  /**
   * Create contact instance from form sdata and add to list.
   * @param formData Completed form data.
   */
  public static void createContact(ContactFormData formData) {
    Contact contact = new Contact(formData.firstName, formData.lastName, formData.tel);
    contactList.add(contact);
  }

  /**
   * Retrieve contact list.
   * @return contact list.
   */
  public static List<Contact> getContacts() {
    return contactList;
  }
}