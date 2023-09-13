package sanctuary;

import sanctuary.controller.SanctuaryController;
import sanctuary.model.Sanctuary;
import sanctuary.view.JFrameView;
import sanctuary.view.SanctuaryView;

/**
 * Run a sanctuary interactively in Swing.
 */
public class Main {
  /**
   * Run a sanctuary interactively in Swing.
   */
  public static void main(String[] args) {
    Sanctuary m = new Sanctuary();
    SanctuaryController c = new SanctuaryController(m);
    SanctuaryView v = new JFrameView("Sanctuary");
    c.setView(v);
  }
}
