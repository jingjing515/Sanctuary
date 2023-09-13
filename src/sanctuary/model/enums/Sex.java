package sanctuary.model.enums;

/**
 * this class represents the sex of monkey, includes F or M
 */
public enum Sex {
  F, M;

  public static Sex getByEnum(String str) {
    for (Sex item : Sex.values()) {
      if (String.valueOf(item).equals(str)) {
        return item;
      }
    }
    return null;
  }
}
