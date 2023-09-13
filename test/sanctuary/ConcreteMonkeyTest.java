package sanctuary;

import static org.junit.Assert.*;

import org.junit.Test;
import sanctuary.model.enums.Food;
import sanctuary.model.enums.Sex;
import sanctuary.model.enums.Size;
import sanctuary.model.enums.Troop;
import sanctuary.model.base.ConcreteMonkey;
import sanctuary.model.base.Monkey;

/**
 * This class include all the unit test for all concrete monkeys
 */
public class ConcreteMonkeyTest {
  Monkey Leo;
  Monkey Monica;
  Monkey Ross;
  Monkey one;
  Monkey two;
  Monkey three;

  /**
   * set up new monkey with name, troop, sex, size, weight, age, food
   * @throws Exception if the name, weight, age is invalid
   */
  @org.junit.Before
  public void setUp() throws Exception {
    Leo = new ConcreteMonkey("Leo", Troop.drill, Sex.M, Size.S,1.3, 1, Food.eggs);
    Monica = new ConcreteMonkey("Monica", Troop.guereza, Sex.F, Size.M, 2.5, 2, Food.fruits);
    Ross = new ConcreteMonkey("Ross", Troop.howler, Sex.M, Size.L, 3.3, 3, Food.leaves);
  }

  /**
   * test if the name is invalid
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalName() {
    one = new ConcreteMonkey("", Troop.drill, Sex.M, Size.S, 1.3, 1, Food.eggs);
  }

  /**
   * test if the weight is invalid
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalWeight() {
    two = new ConcreteMonkey("Ross", Troop.howler, Sex.M, Size.L, -3.3, 3, Food.leaves);
  }
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalAge() {
    three = new ConcreteMonkey("Ross", Troop.howler, Sex.M, Size.L, 3.3, -3, Food.leaves);
  }

  /**
   * test if the getName method works correctly
   */
  @Test
  public void getName() {
    assertEquals("Leo", Leo.getName());
    assertEquals("Monica", Monica.getName());
    assertEquals("Ross", Ross.getName());
  }

  /**
   * test if the getSpeciesDesignation method works correctly
   */
  @Test
  public void getSpeciesDesignation() {
    assertEquals(Troop.drill, Leo.getSpeciesDesignation());
  }

  /**
   * test if the getSex method works correctly
   */
  @Test
  public void getSex() {
    assertEquals(Sex.M, Leo.getSex());
    assertEquals(Sex.F, Monica.getSex());
  }
  /**
   * test if the getSize method works correctly
   */
  @Test
  public void getSize(){
    assertEquals(Size.S, Leo.getSize());
    assertEquals(Size.L, Ross.getSize());
  }
  /**
   * test if the getWeight method works correctly
   */
  @Test
  public void getWeight() {
    assertEquals(1.3, Leo.getWeight(), 0.01);
  }
  /**
   * test if the getApproximateAge method works correctly
   */
  @Test
  public void getApproximateAge() {
    assertEquals(1, Leo.getApproximateAge());
  }
  /**
   * test if the getFavoriteFood method works correctly
   */
  @Test
  public void getFavoriteFood() {
    assertEquals(Food.eggs, Leo.getFavoriteFood());
  }
  /**
   * test if the needMedicalAttention and updateMedicalAttention method works correctly
   */
  @Test
  public void testMedicalAttention(){
    assertFalse(Leo.needMedicalAttention());
    Ross.updateMedicalAttention(true);
    assertTrue(Ross.needMedicalAttention());
  }
  /**
   * test if the toString method works correctly
   */
  @Test
  public void testToString(){
    assertEquals("Leo/M/eggs", Leo.toString());
  }

}

