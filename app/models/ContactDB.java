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
  private static Map<String, TelephoneType> telephoneTypes = new HashMap<>();
  private static Map<String, DietType> dietTypes = new HashMap<>();

  /**
   * Create contact instance from form sdata and add to list.
   * @param formData Completed form data.
   */
  public static void createContact(ContactFormData formData) {
    long idNum = (formData.id == 0) ? currentId++ : formData.id;

    TelephoneType telephoneType = getTelephoneType(formData.telType);
    List<DietType> dietTypes = new ArrayList<>();

    for (String dietString: formData.dietTypes) {
      dietTypes.add(getDietType(dietString));
    }

    Contact contact = new Contact(formData.firstName, formData.lastName, formData.tel, idNum, telephoneType, dietTypes);
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

  /**
   * Add new diet type to database.
   * @param dietType Diet type to add.
   */
  public static void addDietType(DietType dietType) {
    dietTypes.put(dietType.getDietType(), dietType);
  }

  /**
   * Add new telephone type to database.
   * @param telephoneType Telephone type to add.
   */
  public static void addTelephoneType(TelephoneType telephoneType) {
    telephoneTypes.put(telephoneType.getTelephoneType(), telephoneType);
  }

  /**
   * Return associated diet type.
   * @param type The diet type.
   * @return The diet type instance.
   */
  public static DietType getDietType(String type) {
    DietType dietType = dietTypes.get(type);

    if (dietType == null) {
      throw new RuntimeException("Invalid diet type");
    }
    return dietType;
  }

  /**
   * Return associated telephone type.
   * @param type The telephone type.
   * @return The telephone type instance.
   */
  public static TelephoneType getTelephoneType(String type) {
    TelephoneType telephoneType = telephoneTypes.get(type);

    if(telephoneType == null) {
      throw new RuntimeException("Invalid telephone type");
    }
    return telephoneType;
  }
}