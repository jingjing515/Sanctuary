package sanctuary.model.base;

import sanctuary.model.enums.Food;
import sanctuary.model.enums.Sex;
import sanctuary.model.enums.Size;
import sanctuary.model.enums.Troop;

/**
 * this class is a concrete monkey implements all the method from monkey interface
 */
public class ConcreteMonkey implements Monkey {

  private String name;
  private Troop troop;
  private Sex sex;
  private Size size;
  private double weight;
  private int age;
  private Food food;
  private boolean needAttention = false;


  /**
   * constructs an ConcreteMonkey, which has a name, a troop, a sex,
   * a weight, an age, a food
   *
   * @param name the name of the monkey
   * @param troop the troop of the monkey
   * @param sex the sex of the monkey
   * @param weight the weight of the monkey
   * @param age the age of the monkey
   * @param food the favorite food of the monkey
   */
  public ConcreteMonkey(String name, Troop troop, Sex sex, Size size, double weight,
      int age, Food food) throws IllegalArgumentException{
    if (name.length() == 0) throw new IllegalArgumentException("invalid name");
    if (weight <= 0) throw new IllegalArgumentException("invalid weight");
    if (age <= 0) throw new IllegalArgumentException("invalid age");

    this.name = name;
    this.troop = troop;
    this.sex = sex;
    this.size = size;
    this.weight = weight;
    this.age = age;
    this.food = food;

  }


  /**
   * get the name of the monkey
   *
   * @return name
   */
  @Override
  public String getName() {
    return name;
  }

  /**
   * get the species designation of the monkey
   *
   * @return the troop of the monkey
   */
  @Override
  public Troop getSpeciesDesignation() {
    return troop;
  }

  /**
   * get the sex of the monkey
   *
   * @return F or M
   */
  @Override
  public Sex getSex() {
    return sex;
  }

  /**
   * get the size of the monkey
   *
   * @return S, M ,or L
   */
  @Override
  public Size getSize() {
    return size;
  }

  /**
   * get the weight of the monkey
   *
   * @return the weight
   */
  @Override
  public double getWeight() {
    return weight;
  }

  /**
   * get the approximate age of the monkey
   *
   * @return the age
   */
  @Override
  public int getApproximateAge() {
    return age;
  }

  /**
   * get the favorite food of the monkey
   *
   * @return the food
   */
  @Override
  public Food getFavoriteFood() {
    return food;
  }

  /**
   * check if the monkey need medical attention
   *
   * @return true or false
   */
  @Override
  public boolean needMedicalAttention() {
    return needAttention;
  }

  /**
   * update if the monkey need medical attention
   *
   * @param need medical attention
   */
  @Override
  public void updateMedicalAttention(boolean need) {
    needAttention = need;
  }

  /**
   * the String format of information includes money's name, sex, favorite food
   * @return the string format
   */
  @Override
  public String toString(){
  return String.format(name + "/" + sex +"/" + food);
  }

}
