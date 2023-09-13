package sanctuary;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import sanctuary.model.enums.Food;
import sanctuary.model.enums.Sex;
import sanctuary.model.enums.Size;
import sanctuary.model.enums.Troop;
import sanctuary.model.base.ConcreteMonkey;
import sanctuary.model.base.Enclosure;
import sanctuary.model.base.House;
import sanctuary.model.base.Isolation;
import sanctuary.model.base.Monkey;

/**
 * this class includes all the unit test for all the housing of monkeys
 */
public class HouseTest {

  Monkey Leo;
  Monkey Monica;
  Monkey Ross;
  House iso;
  House enc;

  /**
   * set up new concrete monkeys with name, troop, sex, size, weight, age, food, move them in to
   * isolation and enclosure
   */
  @Before
  public void setUp() {
    Leo = new ConcreteMonkey("Leo", Troop.drill, Sex.M, Size.S, 1.3, 1, Food.eggs);
    Monica = new ConcreteMonkey("Monica", Troop.guereza, Sex.F, Size.M, 2.5, 2, Food.fruits);
    Ross = new ConcreteMonkey("Ross", Troop.howler, Sex.M, Size.L, 3.3, 3, Food.leaves);
    iso = new Isolation(20);
    enc = new Enclosure();
    iso.moveIn(Leo);
    enc.moveIn(Ross);
    enc.moveIn(Monica);
  }

  /**
   * test moveIn method if the monkey is already in the house
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveInExistedMonkey() {
    iso.moveIn(Leo);
  }

  /**
   * test moveOut method if the monkey is not in the house
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveOutNotExistedMonkey() {
    iso.moveOut(Ross);
  }

  /**
   * test moveIn method if the house is already full
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveInFullHouse() {
    for (int i = 0; i < 20; i++) {
      var m = new ConcreteMonkey(String.valueOf(i), Troop.howler, Sex.M,
          Size.L, 3.3, 3, Food.leaves);
      iso.moveIn(m);
    }
  }

  /**
   * test moveIn method if a sick monkey moved to enclosure
   */
  @Test(expected = IllegalArgumentException.class)
  public void testMoveSickMonkeyInEnclosure() {
    Monkey illMonkey = new ConcreteMonkey("ill", Troop.howler, Sex.M,
        Size.L, 3.3, 3, Food.leaves);
    illMonkey.updateMedicalAttention(true);
    enc.moveIn(illMonkey);
  }

  /**
   * check if the listAllMonkeys method works correctly
   */
  @Test
  public void listAllMonkeys() {
    assertEquals("Leo/M/eggs\n", iso.listAllMonkeys());
    assertEquals("Monica/F/fruits\nRoss/M/leaves\n", enc.listAllMonkeys());
  }

  /**
   * test if hasRoom method works correctly
   */
  @Test
  public void hasRoom() {
    assertTrue(iso.hasRoom());
    assertTrue(enc.hasRoom());
    for (int i = 0; i < 19; i++) {
      var m = new ConcreteMonkey(String.valueOf(i), Troop.howler, Sex.M,
          Size.L, 3.3, 3, Food.leaves);
      iso.moveIn(m);
    }
    assertFalse(iso.hasRoom());

  }

  /**
   * test if moveIn method works correctly
   */
  @Test
  public void moveIn() {
    var o = new ConcreteMonkey("Ray", Troop.howler, Sex.M, Size.L, 3.3, 3, Food.leaves);
    iso.moveIn(o);
    assertEquals("Leo/M/eggs\nRay/M/leaves\n", iso.listAllMonkeys());
  }

  /**
   * test if moveOut method works correctly
   */
  @Test
  public void moveOut() {
    enc.moveOut(Ross);
    assertEquals("Monica/F/fruits\n", enc.listAllMonkeys());
  }

  /**
   * test if selectBy method works correctly
   */
  @Test
  public void selectBy() {
    var t = enc.selectBy(Monica.getName());
    assertEquals(Monica, t);
  }
}