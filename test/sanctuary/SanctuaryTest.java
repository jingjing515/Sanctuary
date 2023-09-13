package sanctuary;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import sanctuary.model.enums.Food;
import sanctuary.model.enums.Sex;
import sanctuary.model.enums.Size;
import sanctuary.model.enums.Troop;
import sanctuary.model.Sanctuary;
import sanctuary.model.base.ConcreteMonkey;
import sanctuary.model.base.Monkey;

/**
 * this class include all the unit test for all the sanctuary
 */
public class SanctuaryTest {
  Sanctuary sanctuary;
  Monkey Leo;
  Monkey Monica;
  Monkey Ross;

  /**
   * set up new concrete monkeys and new sanctuary. add the monkeys into this sanctuary
   */
  @Before
  public void setUp() {
    Leo = new ConcreteMonkey("Leo", Troop.drill, Sex.M, Size.S, 1.3, 1, Food.eggs);
    Monica = new ConcreteMonkey("Monica", Troop.guereza, Sex.F, Size.M, 2.5, 2, Food.fruits);
    Ross = new ConcreteMonkey("Ross", Troop.howler, Sex.M, Size.L, 3.3, 3, Food.leaves);
    sanctuary = new Sanctuary();
    sanctuary.add(Leo);
    sanctuary.add(Monica);
    sanctuary.add(Ross);
  }

  /**
   * test if the listAllMonkey method works correctly
   */
  @Test
  public void listAllMonkeys() {
    assertEquals("Leo\tSpecies troop: drill\tSex: M\tSize: S\tWeight: 1.3\tFavourite: eggs\tLocation: [isolation]\n"
        + "Monica\tSpecies troop: guereza\tSex: F\tSize: M\tWeight: 2.5\tFavourite: fruits\tLocation: [isolation]\n"
        + "Ross\tSpecies troop: howler\tSex: M\tSize: L\tWeight: 3.3\tFavourite: leaves\tLocation: [isolation]\n", sanctuary.listAllMonkeys());
  }

  /**
   * test if the moveMonkeyToEnclosure method works correctly
   */
  @Test
  public void moveMonkeyToEnclosure() {
    sanctuary.moveMonkeyToEnclosure(Ross);
    assertEquals("Leo\tSpecies troop: drill\tSex: M\tSize: S\tWeight: 1.3\tFavourite: eggs\tLocation: [isolation]\n"
        + "Monica\tSpecies troop: guereza\tSex: F\tSize: M\tWeight: 2.5\tFavourite: fruits\tLocation: [isolation]\n"
        + "Ross\tSpecies troop: howler\tSex: M\tSize: L\tWeight: 3.3\tFavourite: leaves\tLocation: [enclosure howler]\n", sanctuary.listAllMonkeys());
  }

  /**
   * test if the isolate method works correctly
   */
  @Test
  public void isolate() {
    sanctuary.moveMonkeyToEnclosure(Ross);
    sanctuary.moveMonkeyToEnclosure(Leo);
    sanctuary.moveMonkeyToEnclosure(Monica);

    sanctuary.isolate(Monica);
    assertEquals("Leo\tSpecies troop: drill\tSex: M\tSize: S\tWeight: 1.3\tFavourite: eggs\tLocation: [enclosure drill]\n"
        + "Monica\tSpecies troop: guereza\tSex: F\tSize: M\tWeight: 2.5\tFavourite: fruits\tLocation: [isolation]\n"
        + "Ross\tSpecies troop: howler\tSex: M\tSize: L\tWeight: 3.3\tFavourite: leaves\tLocation: [enclosure howler]\n", sanctuary.listAllMonkeys());
  }


}