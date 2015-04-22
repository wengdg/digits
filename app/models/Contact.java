package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Model for Contact Data.
 */
public class Contact {

  private String firstName;
  private String lastName;
  private String tel;
  private long id;
  private TelephoneType telType;
  private List<DietType> dietTypes;

  /**
   * Create Contact instance.
   *
   * @param firstName First name.
   * @param lastName  Last name
   * @param tel       Telephone number.
   * @param id        Id.
   * @param telType   Telephone type.
   * @param dietTypes Diet type.
   */
  public Contact(String firstName, String lastName, String tel, long id, TelephoneType telType, List<DietType> dietTypes) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.tel = tel;
    this.id = id;
    this.telType = telType;
    this.dietTypes = dietTypes;
  }

  /**
   * Set the first name.
   *
   * @param firstName The first name.
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Set the last name.
   *
   * @param lastName The last name.
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Set the telephone.
   *
   * @param tel The telephone.
   */
  public void setTel(String tel) {
    this.tel = tel;
  }

  /**
   * Set the id.
   *
   * @param id The id.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Set the telephone type.
   *
   * @param telType The telephone type.
   */
  public void setTelType(TelephoneType telType) {
    this.telType = telType;
  }

  /**
   * Set the diet types.
   *
   * @param dietTypes The diet types.
   */
  public void setDietTypes(List<DietType> dietTypes) {
    this.dietTypes = dietTypes;
  }

  /**
   * Return first name.
   *
   * @return The first name.
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Returns last name.
   *
   * @return The last name.
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Returns telephone number.
   *
   * @return The telephone number.
   */
  public String getTel() {
    return tel;
  }

  /**
   * Returns id.
   *
   * @return The id.
   */
  public long getId() {
    return id;
  }

  /**
   * Returns telephone type.
   *
   * @return The telephone type..
   */
  public TelephoneType getTelType() {
    return telType;
  }

  /**
   * Returns the diet types.
   *
   * @return The diet types.
   */
  public List<DietType> getDietTypes() {
    return dietTypes;
  }

  /**
   * Retrieves the diet type.
   *
   * @return The diet types.
   */
  public String getDietTypesString() {
    String diets = "";
    for (DietType diet : dietTypes) {
      diets += diet.getDietType() + ",";
    }
    if (diets.length() == 0) {
      return diets;
    } else {
      return diets.substring(0, diets.length() - 1);
    }
  }

  /**
   * Returns a string list of diet types.
   * @return The string containing diet types.
   */
  public List<String> getDietTypesList() {
    List<String> dietList = new ArrayList<>();
    for (DietType dietType : this.dietTypes) {
      dietList.add(dietType.getDietType());
    }
    return dietList;
  }
}