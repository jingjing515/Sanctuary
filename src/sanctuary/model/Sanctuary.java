package sanctuary.model;

import java.util.ArrayList;
import java.util.TreeMap;
import sanctuary.model.base.ConcreteMonkey;
import sanctuary.model.base.Enclosure;
import sanctuary.model.base.Isolation;
import sanctuary.model.base.Monkey;
import sanctuary.model.enums.Food;
import sanctuary.model.enums.Sex;
import sanctuary.model.enums.Size;
import sanctuary.model.enums.Troop;

/**
 * this class represents a sanctuary that includes isolation, enclosures, and a defaultcapacity 20
 */
public class Sanctuary {

  Isolation isolation;
  TreeMap<Troop, Enclosure> enclosures;
  public static final int DefaultIsolationCapacity = 20;

  /**
   * construct a sanctuary includes isolation and enclosures. each troop has one specific enclosure
   */
  public Sanctuary() {
    this.isolation = new Isolation(Sanctuary.DefaultIsolationCapacity);
    enclosures = new TreeMap<Troop, Enclosure>();
    for (var t : Troop.values()
    ) {
      enclosures.put(t, new Enclosure());
    }
  }



  /**
   * add a new monkey to the sanctuary
   *
   * @param m monkey m
   */
  public void add(Monkey m) {
    isolation.moveIn(m);
  }

  /**
   * report all of the monkeys, includes all of the information
   *
   * @return string format information of all the monkeys
   */
  public String listAllMonkeys() {
    var array = isolation.getMonkeysName();
    for (var t : enclosures.values()
    ) {
      array.addAll(t.getMonkeysName());
    }
    array.sort(null);
    StringBuilder sb = new StringBuilder();
    for (var n : array
    ) {
      var m = this.selectBy(n);
      sb.append(m.getName() + "\tSpecies troop: " + m.getSpeciesDesignation() + "\tSex: "
          + m.getSex() + "\tSize: " + m.getSize() + "\tWeight: " + m.getWeight() + "\tFavourite: "
          + m.getFavoriteFood() + "\tLocation: " + this.locate(n) + "\n");
    }
    return sb.toString();

  }
  public ArrayList<String> getAllMonkeyNames(){
    var array = isolation.getMonkeysName();
    for (var t : enclosures.values()
    ) {
      array.addAll(t.getMonkeysName());
    }
    array.sort(null);
    return array;
  }

  /**
   * move the monkey to enclosure, throws IllegalArgumentException if the monkey still needs medical
   * attention
   *
   * @param m monkey m
   * @throws IllegalArgumentException if the monkey is sick, he/she cannot be moved
   */
  public void moveMonkeyToEnclosure(Monkey m) throws IllegalArgumentException {
    if (m.needMedicalAttention()) {
      throw new IllegalArgumentException("the monkey cannot be moved");
    }
    isolation.moveOut(m);
    enclosures.get(m.getSpeciesDesignation()).moveIn(m);
  }

  /**
   * isolate the monkey
   *
   * @param m monkey m
   */
  public void isolate(Monkey m) {
    m.updateMedicalAttention(true);
    enclosures.get(m.getSpeciesDesignation()).moveOut(m);
    isolation.moveIn(m);
  }

  /**
   * select the monkey by name
   *
   * @param name the monkey's name
   * @return monkey
   */
  public Monkey selectBy(String name) {
    Monkey result = isolation.selectBy(name);
    if (result == null) {
      for (var t : enclosures.keySet()) {
        result = enclosures.get(t).selectBy(name);
        if (result != null) {
          break;
        }
      }
    }
    return result;
  }

  /**
   * the location of the monkey
   *
   * @param name moneky's name
   * @return a string shows the location of the monkey
   */
  public String locate(String name) {
    Monkey result = isolation.selectBy(name);
    if (result == null) {
      for (var t : enclosures.keySet()) {
        result = enclosures.get(t).selectBy(name);
        if (result != null) {
          return "[enclosure " + t + "]";
        }
      }
    } else {
      return "[isolation]";
    }
    return "not in the sanctuary";
  }

  /**
   * get the isolation of the sanctuary
   *
   * @return isolation
   */
  public Isolation getIsolation() {
    return isolation;
  }

  /**
   * get the enclosure of the sanctusry
   *
   * @param t the troop of the monkey
   * @return enclosure
   */
  public Enclosure getEnclosure(Troop t) {
    return enclosures.get(t);
  }





  public static ConcreteMonkey newMonkey(String name, Troop troop, Sex sex, Size size, double weight,
      int age, Food food) {
    ConcreteMonkey m = new ConcreteMonkey(name, troop, sex, size, weight, age, food);
    return m;
  }

}