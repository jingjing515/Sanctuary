package sanctuary.model.base;

import sanctuary.model.enums.Food;
import sanctuary.model.enums.Sex;
import sanctuary.model.enums.Size;
import sanctuary.model.enums.Troop;

/**
 * a single monkey
 */
public interface Monkey {

  /**
   * get the name of the moneky
   * @return name
   */
  String getName();

  /**
   * get the species designation of the monkey
   * @return the troop of the monkey
   */
  Troop getSpeciesDesignation();

  /**
   * get the sex of the monkey
   * @return F or M
   */
  Sex getSex();

  /**
   * get the size of the monkey
   * @return S, M ,or L
   */
  Size getSize();
  /**
   * get the weight of the monkey
   * @return the weight
   */
  double getWeight();

  /**
   * get the approximate age of the monkey
   * @return the age
   */
  int getApproximateAge();

  /**
   * get the favorite food of the monkey
   * @return the food
   */
  Food getFavoriteFood();

  /**
   * check if the monkey need medical attention
   * @return true or false
   */
  boolean needMedicalAttention();

  /**
   * update if the monkey need medical attention
   * @param need medical attention
   */
 void updateMedicalAttention(boolean need);
}
