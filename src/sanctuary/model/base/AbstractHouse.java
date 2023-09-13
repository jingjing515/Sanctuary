package sanctuary.model.base;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * this class is an AbstractHouse defines all the operation mandated by house interface
 */
public abstract class AbstractHouse implements House{
  protected TreeMap<String, Monkey> monkeys;

  /**
   * construct a AbstractHouse object that has monkeys
   */
  public AbstractHouse(){
    monkeys = new TreeMap<String, Monkey>();
  }

  /**
   * list all monkeys in the sanctuary
   * @return the list of all the monkeys
   */
  @Override
  public ArrayList<String> getMonkeysName(){
   var list = new ArrayList<String>();
    for (var m:monkeys.values()
    ) {
      list.add(m.getName());
    }
   return list;
  }
  /**
   * report all the monkeys in the sanctuary
   * @return a String contains all information about monkeys
   */
  @Override
  public String listAllMonkeys() {
    StringBuilder sb = new StringBuilder();
    for (var name:  monkeys.keySet())
    {
      sb.append(monkeys.get(name));
      sb.append("\n");
    }
    return sb.toString();
  }

  /**
   * if there is any empty room for the monkey
   *
   * @return true or false
   */
  @Override
  public boolean hasRoom() {
    return true;
  }

  /**
   * a monkey move in the house
   *
   * @param m monkey m
   */
  @Override
  public void moveIn(Monkey m) throws IllegalArgumentException{
    if(monkeys.containsKey(m.getName())) throw new IllegalArgumentException
        ("the monkey is already in the house");
    this.monkeys.put(m.getName(),m);
  }

  /**
   * a monkey move out the house
   *
   * @param m
   */
  @Override
  public void moveOut(Monkey m) throws IllegalArgumentException{
    if(!monkeys.containsKey(m.getName())) throw new IllegalArgumentException
        ("the monkey is not in this house");
    this.monkeys.remove(m.getName());

  }

  /**
   * the monkey selected by name
   *
   * @param name the monkey's name
   * @return the monkey
   */
  @Override
  public Monkey selectBy(String name) {
    var monkey = this.monkeys.get(name);
    return monkey;
  }
}
