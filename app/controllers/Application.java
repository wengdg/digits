package controllers;

import models.ContactDB;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import views.formdata.ContactFormData;
import views.formdata.DietTypes;
import views.formdata.TelephoneTypes;
import views.html.Index;
import views.html.NewContact;

import java.util.Map;


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
    Map<String, Boolean> dietTypeMap = DietTypes.getTypes(data.dietTypes);
    return ok(NewContact.render(formData, telTypeMap, dietTypeMap));

  }

  /**
   * Returns posted form data from New Contact page.
   * @return Page with form data
   */
  public static Result postContact() {
    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      System.out.println("Error occurred!");
      return badRequest(NewContact.render(formData, TelephoneTypes.getTypes(), DietTypes.getTypes()));
    }
    else {
      ContactFormData data = formData.get();
      ContactDB.createContact(data);
      System.out.format("Recieved %s %s %s %s\n", data.firstName, data.lastName, data.tel, data.telType);
      return ok(NewContact.render(formData, TelephoneTypes.getTypes(data.telType),  DietTypes.getTypes(data.dietTypes)));
    }
  }

}