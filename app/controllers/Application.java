package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import play.data.Form;
import views.formdata.ContactFormData;
import views.html.Index;
import views.html.NewContact;


/**
 * Provides controllers for this application.
 */
public class Application extends Controller {

  /**
   * Returns the home page.
   *
   * @return The resulting home page.
   */
  public static Result index() {
    return ok(Index.render("Welcome to the home page."));
  }

  /**
   * Returns the New Contact Page.
   *
   * @return The NewContact.
   */
  public static Result newContact() {

    Form<ContactFormData> formData = Form.form(ContactFormData.class);
    return ok(NewContact.render(formData));

  }

  /**
   * Returns posted form data from New Contact page.
   *
   * @return Page with form data
   */
  public static Result postContact() {

    Form<ContactFormData> formData = Form.form(ContactFormData.class).bindFromRequest();

    if (formData.hasErrors()) {
      System.out.println("Errors!");
      return badRequest(NewContact.render(formData));
    }
    else {
      ContactFormData data = formData.get();
      System.out.format("%s %s %s %n", data.firstName, data.lastName, data.tel);
      return ok(NewContact.render(formData));
    }
  }

}
