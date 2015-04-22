package views.formdata;

import models.Contact;
import play.data.validation.ValidationError;

import java.util.ArrayList;
import java.util.List;

/**
 * Backing class for form data.
 */
public class ContactFormData {

  /** Stores first name. **/
  public String firstName;

  /** Stores last name. **/
  public String lastName;

  /** Stores telephone number. **/
  public String tel;

  /** Stores id. **/
  public long id;

  /** Stores telephone type. **/
  public String telType;

  /** Stores diet types **/
  public List<String> dietTypes = new ArrayList<String>();

  /**
   * Default no-arg constructor.
   */
  public ContactFormData() {
  }

  /**
   * Default constructor with contact.
   * @param contact The contact.
   */
  public ContactFormData(Contact contact) {
    this.firstName = contact.getFirstName();
    this.lastName = contact.getLastName();
    this.tel = contact.getTel();
    this.id = contact.getId();
    this.telType = contact.getTelType().getTelephoneType();
    this.dietTypes = contact.getDietTypesList();
  }

  /**
   * Initialize application with sample data.
   * @param firstName First name.
   * @param lastName Last name.
   * @param tel Telephone number.
   * @param telType Telephone type.
   */
  public ContactFormData(String firstName, String lastName, String tel, String telType, List<String> dietTypes) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.tel = tel;
    this.telType = telType;
    this.dietTypes = dietTypes;
  }

  /**
   * Validates that form does not accept incorrect input.
   * @return Null if no errors, otherwise return errors.
   */
  public List<ValidationError> validate() {

    List<ValidationError> errors = new ArrayList<>();

    if ((firstName == null) || (firstName.length() == 0)) {
      errors.add(new ValidationError("firstName", "First name is required."));
    }
    if ((lastName == null) || (lastName.length() == 0)) {
      errors.add(new ValidationError("lastName", "Last name is required."));
    }
    if ((tel == null) || (tel.length() == 0)) {
      errors.add(new ValidationError("tel", "Telephone is required."));
    }
    if (tel.length() != 12) {
      errors.add(new ValidationError("tel", "Telephone must be in format xxx-xxx-xxxx."));
    }
    if (!TelephoneTypes.isType(telType)) {
      errors.add(new ValidationError("telType", "Telephone type is invalid."));
    }

    if (dietTypes.size() > 5) {
      errors.add(new ValidationError("dietTypes", "Too many diet types."));
    }

    return errors.isEmpty() ? null : errors;

  }
}