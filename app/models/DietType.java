package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weng on 4/20/2015.
 */
@Entity
public class DietType extends Model {
  @Id
  private long id;
  private String dietType;
  @ManyToMany(mappedBy = "dietTypes")
  private List<Contact> contacts = new ArrayList<>();

  /**
   * The EBean ORM finder method for database queries.
   * @return The finder method.
   */
  public static Finder<Long, DietType> find() {
    return new Finder<Long, DietType>(Long.class, DietType.class);
  }

  /**
   * Default constructor which accepts a diet type.
   * @param dietType The telephone type.
   */
  public DietType(String dietType) {
    this.dietType = dietType;
  }

  /**
   * Sets the id.
   * @param id The contact id.
   */
  public void setId(long id) {
    this.id = id;
  }

  /**
   * Retrieves the id.
   * @return The id.
   */
  public long getId() {
    return this.id;
  }

  /**
   * Sets the telephone type.
   * @param dietType The telephone type.
   */
  public void setDietType(String dietType) {
    this.dietType = dietType;
  }

  /**
   * Retrieves the telephone type.
   * @return The telephone type.
   */
  public String getDietType() {
    return this.dietType;
  }

  /**
   * Sets the contact list.
   * @param contacts The contact list.
   */
  public void setContacts(List<Contact> contacts) {
    this.contacts = contacts;
  }

  /**
   * Retrieves the contact list.
   * @return The contact list.
   */
  public List<Contact> getContacts() {
    return this.contacts;
  }

  /**
   * Add a contact to the contact list.
   * @param contact The contact to be added.
   */
  public void addContact(Contact contact) {
    this.contacts.add(contact);
  }

}
