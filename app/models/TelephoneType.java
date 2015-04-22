package models;

import play.db.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weng on 4/20/2015.
 */
@Entity
public class TelephoneType extends Model {
  @Id
  private long id;
  private String telephoneType;
  @OneToMany(mappedBy = "telType")
  private List<Contact> contacts = new ArrayList<>();

  /**
   * Default constructor which accepts a telephone type.
   * @param telephoneType The telephone type.
   */
  public TelephoneType(String telephoneType) {
    this.telephoneType = telephoneType;
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
   * @param telephoneType The telephone type.
   */
  public void setTelephoneType(String telephoneType) {
    this.telephoneType = telephoneType;
  }

  /**
   * Retrieves the telephone type.
   * @return The telephone type.
   */
  public String getTelephoneType() {
    return this.telephoneType;
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

  /**
   * The EBean ORM finder method for database queries
   * @return The Finder method.
   */
  public static Finder<Long, TelephoneType> find() {
    return new Finder<Long, TelephoneType>(Long.class, TelephoneType.class);
  }

}
