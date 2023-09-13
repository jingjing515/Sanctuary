package sanctuary;

import sanctuary.model.enums.Food;
import sanctuary.model.enums.Sex;
import sanctuary.model.enums.Size;
import sanctuary.model.enums.Troop;
import sanctuary.model.Sanctuary;
import sanctuary.model.base.ConcreteMonkey;

public class Driver {

  public static void main(String[] args){
    var sanctuary = new Sanctuary();
    System.out.println("Welcome to Jungle Friends");
    var Leo = new ConcreteMonkey("Leo", Troop.drill, Sex.M, Size.S,1.3, 1, Food.eggs);
    var Monica = new ConcreteMonkey("Monica", Troop.guereza, Sex.F, Size.M, 2.5, 2, Food.fruits);
    var Ross = new ConcreteMonkey("Ross", Troop.howler, Sex.M, Size.L, 3.3, 3, Food.leaves);
    sanctuary.add(Leo);
    sanctuary.add(Monica);
    sanctuary.add(Ross);
    System.out.println("3 new friends in our sanctuary! They are in the isolation place.");
    System.out.println(sanctuary.listAllMonkeys());
    System.out.println("-----------------------------------------------------------------");
    System.out.println("Now they are moved to their specific enclosures");
    sanctuary.moveMonkeyToEnclosure(Leo);
    sanctuary.moveMonkeyToEnclosure(Monica);
    sanctuary.moveMonkeyToEnclosure(Ross);
    System.out.println(sanctuary.listAllMonkeys());
    System.out.println("-----------------------------------------------------------------");
    System.out.println("Monica is sick and need medical attention");
    sanctuary.isolate(sanctuary.selectBy("Monica"));
    System.out.println(sanctuary.listAllMonkeys());
    System.out.println("-----------------------------------------------------------------");
    System.out.println("Monica cannot be moved to enclosure until she is healed");
    try{
      sanctuary.moveMonkeyToEnclosure(Monica);
    }catch(IllegalArgumentException e){
      System.out.println(e.getMessage());
    }
    System.out.println(sanctuary.listAllMonkeys());
    System.out.println("-----------------------------------------------------------------");
    Monica.updateMedicalAttention(false);
    System.out.println("Now Monica is healed, she can be moved in to the enclosure");
    sanctuary.moveMonkeyToEnclosure(Monica);
    System.out.println(sanctuary.listAllMonkeys());
    System.out.println("-----------------------------------------------------------------");
  }
}
