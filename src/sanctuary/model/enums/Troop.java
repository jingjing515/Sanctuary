package sanctuary.model.enums;

/**
 * this class represents the troop of the monkeys, includes drill, guereza, howler, mangabey, saki, spider, squirrel, tamarin
 */
public enum Troop {
  drill, guereza, howler, mangabey, saki, spider, squirrel, tamarin;

  public static Troop getByEnum(String str) {
    for (Troop item : Troop.values()) {
      if (String.valueOf(item).equals(str)) {
        return item;
      }
    }
    return null;
  }
}

