package models;

/**
 * Model for Contact Data.
 */
public class Contact {

  private String firstName;
  private String lastName;
  private String tel;

  /**
   * Create Contact instance.
   *
   * @param firstName First name.
   * @param lastName Last name
   * @param tel Telephone number.
   */
  public Contact(String firstName, String lastName, String tel) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.tel = tel;
  }

  /**
   * Returns first name.
   * @return The first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns last name.
   * @return The last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Returns telephone number.
   * @return The telephone number.
   */
  public String getTel() {
    return tel;
  }
}