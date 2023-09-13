package sanctuary.model.enums;

/**
 * this class represents the size of the monkeys, which includes S, M, L
 */
public enum Size {
  S, M, L;

  public static Size getByEnum(String str) {
    for (Size item : Size.values()) {
      if (String.valueOf(item).equals(str)) {
        return item;
      }
    }
    return null;
  }
}
