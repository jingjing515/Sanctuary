package sanctuary.model.base;

import java.util.ArrayList;

/**
 * a interface for house to save the monkeys
 */
public interface House {

  /**
   * list all monkeys in the sanctuary
   * @return the list of all the monkeys' name
   */
  ArrayList<String> getMonkeysName();
  /**
   * report all the monkeys in the sanctuary
   * @return a String contains all information about monkeys
   */
  String listAllMonkeys();

  /**
   * if there is any empty room for the monkey
   * @return true or false
   */
  boolean hasRoom();

  /**
   * a monkey move in the house
   * @param m monkey m
   */
  void moveIn(Monkey m);

  /**
   * a monkey move out the house
   * @param m
   */
  void moveOut(Monkey m);

  /**
   * the monkey selected by name
   * @param name the monkey's name
   * @return the monkey
   */
  Monkey selectBy(String name);
}
