package sanctuary.controller;

import sanctuary.model.Sanctuary;
import sanctuary.model.base.Monkey;
import sanctuary.model.enums.Food;
import sanctuary.model.enums.Sex;
import sanctuary.model.enums.Size;
import sanctuary.model.enums.Troop;
import sanctuary.view.SanctuaryView;

/**
 * this controller implements SanctuaryFeatures
 */
public class SanctuaryController implements SanctuaryFeatures {

  private Sanctuary model;
  private SanctuaryView view;
  private Troop currentEnclosure = Troop.drill;

  /**
   * constructs a SanctuaryController
   *
   * @param model
   */
  public SanctuaryController(Sanctuary model) {
    if (model == null) {
      throw new IllegalArgumentException("model is null");
    }
    this.model = model;
  }

  @Override
  public void registerMonkey(String name, String troop, String sex, String size,
      Double weight, Integer age, String food) throws IllegalArgumentException {
    try {
      Monkey m = Sanctuary.newMonkey(name, Troop.getByEnum(troop), Sex.getByEnum(sex),
          Size.getByEnum(size), weight, age, Food.getByEnum(food));

      model.add(m);
      updateMonkeyView();
      //System.out.println(model.listAllMonkeys());
      //view.setOutput(model.listAllMonkeys());
    } catch (IllegalArgumentException e) {
      view.showMessage(e.getMessage());
    }
  }

  @Override
  public void moveMonkeyToEnclosure(String name) {
    try {
      Monkey m = model.selectBy(name);
      if (m.needMedicalAttention()) {
        boolean r = view.showConfirmation("The monkey was not healthy, is it cured now? ");
        if (r) {
          //false means no need medical attention
          m.updateMedicalAttention(false);
        }
      }
      model.moveMonkeyToEnclosure(m);
      updateMonkeyView();
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
      view.showMessage(e.getMessage());
    }
  }

  @Override
  public void moveMonkeyToIsolation(String name) {
    try {
      Monkey m = model.selectBy(name);
      model.isolate(m);
      updateMonkeyView();
    } catch (IllegalArgumentException e) {
      view.showMessage(e.getMessage());
    }

  }

  @Override
  public void switchEnclosure(Troop t) {
    this.currentEnclosure = t;
    updateMonkeyView();

  }

  @Override
  public void exitProgram() {
    System.exit(0);

  }

  /**
   * set the view
   * @param v
   */
  public void setView(SanctuaryView v) {
    view = v;
    view.addFeatures(this);
  }

  /**
   * update the monkey view
   */
  public void updateMonkeyView() {
    var s = model.getIsolation().getMonkeysName();
    view.showIsolation(s);
    s = model.getAllMonkeyNames();
    view.showMonkeyNames(s);
    var s2 = model.getEnclosure(currentEnclosure).listAllMonkeys().split("\n");
    view.showEnclosureMonkeys(s2);
  }
}
