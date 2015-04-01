package views.formdata;

import java.util.HashMap;
import java.util.Map;

/**
 * Utility class to manipulate telephone type data.
 */
public class TelephoneTypes {

  private static String[] types = {"Home", "Mobile", "Work"};

  /**
   * Create map of different telephone types, initialized to false.
   * @return The telephone type map.
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> typeMap = new HashMap<String, Boolean>();
    for (String type: types) {
      typeMap.put(type, false);
    }
    return typeMap;
  }

  /**
   * Check for valid telephone type.
   * @param type The telephone type.
   * @return True if valid type, false otherwise.
   */
  public static boolean isType(String type) {
    return getTypes().containsKey(type);
  }

  /**
   * Create map of telephone types, with map entry type set to true.
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
}
