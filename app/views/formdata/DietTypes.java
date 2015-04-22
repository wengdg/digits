package views.formdata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class to support diet types.
 */
public class DietTypes {

  private static String[] types = {"Chicken", "Fish", "Beef", "Dairy", "Gluten"};


  /**
   * Initialize map with diet types.
   *
   * @return The diet type map.
   */
  public static Map<String, Boolean> getTypes() {
    Map<String, Boolean> typeMap = new HashMap<String, Boolean>();
    for (String type : types) {
      typeMap.put(type, false);
    }

    return typeMap;
  }

  /**
   * Checks to see if diet type exists in map.
   *
   * @param type The type to check.
   * @return True if diet type exist.
   */
  public static Boolean isType(String type) {
    return getTypes().containsKey(type);
  }

  /**
   * Create map of diet types set to true.
   *
   * @param type The type to set to true.
   * @return The diet type map.
   */
  public static Map<String, Boolean> getTypes(String type) {
    Map<String, Boolean> typeMap = getTypes();
    if (isType(type)) {
      typeMap.put(type, true);
    }

    return typeMap;
  }

  /**
   * Create map of diet types set to true.
   *
   * @param types The types to set to true.
   * @return The diet type map.
   */
  public static Map<String, Boolean> getTypes(List<String> types) {
    Map<String, Boolean> typeMap = getTypes();

    for (String type : types) {
      if (isType(type)) {
        typeMap.put(type, true);
      }
    }

    return typeMap;
  }

}