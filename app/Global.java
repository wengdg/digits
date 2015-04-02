import models.ContactDB;
import play.GlobalSettings;
import play.Application;
import views.formdata.ContactFormData;

/**
 * Created by Weng on 3/31/2015.
 */
public class Global extends GlobalSettings {

  @Override
  public void onStart(Application application) {
    super.onStart(application);
    ContactDB.createContact(new ContactFormData("Danny", "Weng", "808-429-7517", "Mobile"));
    ContactDB.createContact(new ContactFormData("Hanson", "Weng", "808-429-7517", "Mobile"));
    ContactDB.createContact(new ContactFormData("Shao Fei", "Weng", "808-429-7517", "Mobile"));
    ContactDB.createContact(new ContactFormData("Hui Lun", "Weng", "808-429-7517", "Mobile"));
  }

}
