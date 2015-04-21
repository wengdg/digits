import models.ContactDB;
import models.DietType;
import models.TelephoneType;
import play.Application;
import play.GlobalSettings;
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

    ContactDB.addTelephoneType(new TelephoneType("Mobile"));
    ContactDB.addTelephoneType(new TelephoneType("Home"));
    ContactDB.addTelephoneType(new TelephoneType("Work"));
    ContactDB.addDietType(new DietType("Chicken"));
    ContactDB.addDietType(new DietType("Fish"));
    ContactDB.addDietType(new DietType("Beef"));
    ContactDB.addDietType(new DietType("Dairy"));
    ContactDB.addDietType(new DietType("Gluten"));
  }

}
