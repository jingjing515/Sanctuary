package sanctuary.model.base;

/**
 * this class represents a Isolation class ecxtends AbstractHouse
 */
public class Isolation extends AbstractHouse {

  private int capacity;

  /**
   * construct an Isolation with certain capacity
   *
   * @param capacity
   */
  public Isolation(int capacity) {
    super();
    this.capacity = capacity;
  }

  /**
   * check if the isolation has room for monkey
   *
   * @return true if the quantity of monkeys less than the capacity
   */
  @Override
  public boolean hasRoom() {
    return this.monkeys.size() < capacity;
  }

  /**
   * move the monkey into the isolation
   *
   * @param m monkey m
   * @throws IllegalArgumentException if there is no cages for monkey
   */
  @Override
  public void moveIn(Monkey m) throws IllegalArgumentException {
    if (!hasRoom()) {
      throw new IllegalArgumentException
          ("there is no cages for any monkey");
    }
    super.moveIn(m);
  }

}
