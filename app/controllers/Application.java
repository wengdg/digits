package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;
import views.formdata.ContactFormData;
import views.html.Index;
import views.html.NewContact;
import models.ContactDB;


/**
 * Provides controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page.
   * @return The resulting home page.
   */
  public static Result index() {
    return ok(Index.render(ContactDB.getContacts()));
  }

  /**
   * Returns the New Contact Page.
   * @param id The id.
   * @return The NewContact.
   */
  public static Result newContact(long id) {
    ContactFormData data = (id == 0) ? new ContactFormData() : new ContactFormData(ContactDB.getContact(id));
    Form<ContactFormData> formData = Form.form(ContactFormData.class).fill(data);
    return ok(NewContact.render(formData));

  }

  /**
   * Returns posted form data from New Contact page.
   * @return Page with form data
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      System.out.println("Error occured!");
      return badRequest(NewContact.render(formData));
    }
    else {
      ContactFormData data = formData.get();
      ContactDB.createContact(data);
      System.out.format("Recieved %s %s %s \n", data.firstName, data.lastName, data.tel);
      return ok(NewContact.render(formData));
    }
  }

}