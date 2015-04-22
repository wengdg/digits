package models;

import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.List;

/**
 * In-memory repository for Contacts.
 */
public class ContactDB {

  //private static Map<Long, Contact> contactList = new HashMap<>();
  //private static long currentId = 1;
  //private static Map<String, TelephoneType> telephoneTypes = new HashMap<>();
  //private static Map<String, DietType> dietTypes = new HashMap<>();

  /**
   * Create contact instance from form sdata and add to list.
   * @param formData Completed form data.
   */
  public static void createContact(ContactFormData formData) {

    TelephoneType telephoneType = getTelephoneType(formData.telType);
    List<DietType> dietTypes = new ArrayList<>();

    for (String dietString: formData.dietTypes) {
      dietTypes.add(getDietType(dietString));
    }

    Contact contact = (formData.id == 0) ? new Contact() : Contact.find().byId(formData.id);
    contact.setFirstName(formData.firstName);
    contact.setLastName(formData.lastName);
    contact.setTel(formData.tel);
    contact.setTelType(telephoneType);
    contact.setDietTypes(dietTypes);

    // Make relationships bi-directional.
    telephoneType.addContact(contact);
    for (DietType dietType : dietTypes) {
      dietType.addContact(contact);
    }
    contact.save();
  }

  /**
   * Returns contact with associated id, otherwise throw exception if not found.
   * @param id The id.
   * @return The contact.
   */
  public static Contact getContact(long id) {
    Contact contact = Contact.find().byId(id);
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
    return Contact.find().all();
  }

  /**
   * Add new diet type to database.
   * @param dietType Diet type to add.
   */
  public static void addDietType(DietType dietType) {
    dietType.save();
  }

  /**
   * Add new telephone type to database.
   * @param telephoneType Telephone type to add.
   */
  public static void addTelephoneType(TelephoneType telephoneType) {
    telephoneType.save();
  }

  /**
   * Return associated diet type.
   * @param type The diet type.
   * @return The diet type instance.
   */
  public static DietType getDietType(String type) {
    DietType dietType = DietType.find().where().eq("dietType", type).findUnique();

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
    TelephoneType telephoneType = TelephoneType.find().where().eq("telephoneType", type).findUnique();

    if(telephoneType == null) {
      throw new RuntimeException("Invalid telephone type");
    }
    return telephoneType;
  }
}