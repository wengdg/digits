package views.formdata;

import play.data.validation.ValidationError;
import java.util.ArrayList;
import java.util.List;
import models.Contact;

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
    this.telType = contact.getTelType();
  }

  /**
   * Initialize application with sample data.
   * @param firstName First name.
   * @param lastName Last name.
   * @param tel Telephone number.
   * @param telType Telephone type.
   */
  public ContactFormData(String firstName, String lastName, String tel, String telType) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.tel = tel;
    this.telType = telType;
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

    return errors.isEmpty() ? null : errors;

  }
}