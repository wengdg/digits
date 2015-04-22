import models.Contact;
import models.ContactDB;
import models.DietType;
import models.TelephoneType;
import play.Application;
import play.GlobalSettings;
import views.formdata.ContactFormData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Weng on 3/31/2015.
 */
public class Global extends GlobalSettings {

  @Override
  public void onStart(Application application) {
    super.onStart(application);

    if (TelephoneType.find().all().isEmpty()) {
      ContactDB.addTelephoneType(new TelephoneType("Mobile"));
      ContactDB.addTelephoneType(new TelephoneType("Home"));
      ContactDB.addTelephoneType(new TelephoneType("Work"));
    }

    if (DietType.find().all().isEmpty()) {
      ContactDB.addDietType(new DietType("Chicken"));
      ContactDB.addDietType(new DietType("Fish"));
      ContactDB.addDietType(new DietType("Beef"));
      ContactDB.addDietType(new DietType("Dairy"));
      ContactDB.addDietType(new DietType("Gluten"));
    }

    if (Contact.find().all().isEmpty()) {
      List<String> diets = new ArrayList<>();
      ContactDB.createContact(new ContactFormData("Danny", "Weng", "808-429-7517", "Mobile", diets));
      ContactDB.createContact(new ContactFormData("Hanson", "Weng", "808-429-7517", "Mobile", diets));
      ContactDB.createContact(new ContactFormData("Shao Fei", "Weng", "808-429-7517", "Mobile", diets));
      ContactDB.createContact(new ContactFormData("Hui Lun", "Weng", "808-429-7517", "Mobile", diets));
    }

  }

}
