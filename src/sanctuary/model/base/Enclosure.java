package sanctuary.model.base;

public class Enclosure extends AbstractHouse {

  /**
   * this class represents a Enclosure that extends AbstractHouse
   * @param m monkey m
   * @throws IllegalArgumentException if the monkey need medical attetion
   */
  @Override
  public void moveIn(Monkey m) throws IllegalArgumentException {
    if (m.needMedicalAttention()) {
      throw new IllegalArgumentException
          ("the monkey need medical attention");
    }
    super.moveIn(m);
  }
}
