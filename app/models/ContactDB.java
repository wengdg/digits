package models;

import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * In-memory repository for Contacts.
 */
public class ContactDB {

  private static Map<Long, Contact> contactList = new HashMap<>();
  private static long currentId = 1;

  /**
   * Create contact instance from form sdata and add to list.
   * @param formData Completed form data.
   */
  public static void createContact(ContactFormData formData) {
    long idNum = (formData.id == 0) ? currentId++ : formData.id;
    Contact contact = new Contact(formData.firstName, formData.lastName, formData.tel, idNum);
    contactList.put(idNum, contact);
  }

  /**
   * Returns contact with associated id, otherwise throw exception if not found.
   * @param id The id.
   * @return The contact.
   */
  public static Contact getContact(long id) {
    Contact contact = contactList.get(id);
    if (contact == null) {
      throw new RuntimeException("Contact not found!");
    }
    return contact;
  }

  /**
   * Retrieve contact list.
   * @return contact list.
   */
  public static List<Contact> getContacts() {
    return new ArrayList<>(contactList.values());
  }
}