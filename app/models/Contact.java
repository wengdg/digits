package models;

/**
 * Model for Contact Data.
 */
public class Contact {

  private String firstName;
  private String lastName;
  private String tel;
  private long id;
  private String telType;

  /**
   * Create Contact instance.
   *
   * @param firstName First name.
   * @param lastName Last name
   * @param tel Telephone number.
   * @param id Id.
   * @param telType Telephone type.
   */
  public Contact(String firstName, String lastName, String tel, long id, String telType) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.tel = tel;
    this.id = id;
    this.telType = telType;
  }

  /**
   * Return first name.
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

  /**
   * Returns id.
   * @return The id.
   */
  public long getId() {
    return id;
  }

  /**
   * Returns telephone type.
   * @return The telephone type..
   */
  public String getTelType() {
    return telType;
  }
}