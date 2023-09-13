package sanctuary.controller;

import sanctuary.model.base.Enclosure;
import sanctuary.model.base.Monkey;
import sanctuary.model.enums.Food;
import sanctuary.model.enums.Sex;
import sanctuary.model.enums.Size;
import sanctuary.model.enums.Troop;

/**
 * this class represents the controller of the model
 */
public interface SanctuaryFeatures {

  /**
   * register a monkey to sanctuary
   * @param name the name of monkey
   * @param troop the troop of the monkey
   * @param sex the sex of the monkey
   * @param size the size of the monkey
   * @param weight the weight of the monkey
   * @param age the age of the monkey
   * @param food the food of the monkey
   * @throws IllegalArgumentException if the information is illegal
   */
  void registerMonkey(String name, String troop, String sex, String size,
      Double weight, Integer age, String food) throws IllegalArgumentException;

  /**
   * move monkey to enclosure
   * @param name the name of the monkey
   */
  void moveMonkeyToEnclosure(String name);

  /**
   * move the monkey to the isolation
   * @param name the name of the monkey
   */
  void moveMonkeyToIsolation(String name);

  /**
   * switch the enclosures
   * @param t the troop
   */
  void switchEnclosure(Troop t);

  /**
   *exit the program
   */
  void exitProgram();



}
