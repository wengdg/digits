package views.formdata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Weng on 3/30/2015.
 */
public class DietTypes {

  private static String[] types = {"Chicken", "Fish", "Beef", "Dairy", "Gluten"};

  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> typeMap = new HashMap<String, Boolean>();
    for (String type: types) {
      typeMap.put(type, false);
    }
    return typeMap;
  }

  public static boolean isType(String type) {
    return getTypes().containsKey(type);
  }

  /**
   * Create map of telephone types, with map entry type set to true
   * @param type Telephone type to set to true.
   * @return The telephone type map.
   */
  public static Map<String, Boolean> getTypes(String type) {
    Map<String, Boolean> typeMap = getTypes();
    if (isType(type)) {
      typeMap.put(type, true);
    }
    return typeMap;
  }

  public static Map<String, Boolean> getTypes(List<String> checked) {
    Map<String, Boolean> typeMap = getTypes();
    for (String type: checked) {
      if (isType(type)) {
        typeMap.put(type, true);
      }
    }
    return typeMap;
  }
}
