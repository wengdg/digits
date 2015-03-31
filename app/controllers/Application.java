package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;
import views.formdata.ContactFormData;
import views.html.Index;
import views.html.NewContact;
import models.ContactDB;
import java.util.Map;
import views.formdata.TelephoneTypes;


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
    Map<String, Boolean> telTypeMap = TelephoneTypes.getTypes(data.telType);
    return ok(NewContact.render(formData, telTypeMap));

  }

  /**
   * Returns posted form data from New Contact page.
   * @return Page with form data
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      System.out.println("Error occurred!");
      return badRequest(NewContact.render(formData, TelephoneTypes.getTypes()));
    }
    else {
      ContactFormData data = formData.get();
      ContactDB.createContact(data);
      System.out.format("Recieved %s %s %s %s\n", data.firstName, data.lastName, data.tel, data.telType);
      return ok(NewContact.render(formData, TelephoneTypes.getTypes(data.telType)));
    }
  }

}