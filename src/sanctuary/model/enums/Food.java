package sanctuary.model.enums;

/**
 * this class represents a Food  eggs, fruits, insects, leaves, nuts, seeds, tree_sa
 */
public enum Food {
  eggs, fruits, insects, leaves, nuts, seeds, tree_sap;

  public static Food getByEnum(String str) {
    for (Food item : Food.values()) {
      if (String.valueOf(item).equals(str)) {
        return item;
      }
    }
    return null;
  }
}
