package views.formdata;

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

    return errors.isEmpty() ? null : errors;

  }
}