package sanctuary.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import sanctuary.controller.SanctuaryFeatures;
import sanctuary.model.Sanctuary;
import sanctuary.model.enums.Food;
import sanctuary.model.enums.Sex;
import sanctuary.model.enums.Size;
import sanctuary.model.enums.Troop;

/**
 * this class extends JFrame, implements SanctuaryView
 */
public class JFrameView extends JFrame implements SanctuaryView {


  private final JLabel display;
  private final JLabel nameLabel;
  private final JLabel troopLabel;
  private final JLabel sexLabel;
  private final JLabel sizeLabel;
  private final JLabel weightLabel;
  private final JLabel ageLabel;
  private final JLabel foodLabel;
  private final JButton registerMonkeyButton;
  private final JButton exitButton;
  private final JTextField name;
  private final JComboBox troop;
  private final JComboBox sex;
  private final JComboBox size;
  private final JTextField weight;
  private final JTextField age;
  private final JComboBox food;
  private final JLabel moveMonkeyLabel, isolationLabel, enclosureLabel;
  private final JTextField name2;
  private final JButton moveToEnclosureButton;
  private final JButton moveToIsolationButton;
  private JPanel registerMonkeyPanel, moveMonkeyPanel, enclosurePanel, isolationPanel, monkeyInfoPanel;
  private JButton enclosureButton1, enclosureButton2, enclosureButton3, enclosureButton4,
      enclosureButton5, enclosureButton6, enclosureButton7, enclosureButton8;

  private JList isolationMonkeys;
  private JList allMonkeyName;
  private JTable enclosureMonkey;

  /**
   * this constructor is to initialize view
   *
   * @param caption the caption of the frame
   */
  public JFrameView(String caption) {

    //set the layout of the frame
    super(caption);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    this.setLayout(new BorderLayout());
    this.setPreferredSize(new Dimension(950, 620));

    registerMonkeyPanel = new JPanel();
    enclosurePanel = new JPanel();
    isolationPanel = new JPanel();
    moveMonkeyPanel = new JPanel();
    monkeyInfoPanel = new JPanel();

    //set preferred size for panels
    registerMonkeyPanel.setPreferredSize(new Dimension(100, 120));
    moveMonkeyPanel.setPreferredSize(new Dimension(100, 120));
    enclosurePanel.setPreferredSize(new Dimension(100, 120));
    isolationPanel.setPreferredSize(new Dimension(100, 120));
    monkeyInfoPanel.setPreferredSize(new Dimension(100, 120));

    this.add(registerMonkeyPanel, BorderLayout.NORTH);
    this.add(moveMonkeyPanel, BorderLayout.SOUTH);
    this.add(enclosurePanel, BorderLayout.EAST);
    this.add(isolationPanel, BorderLayout.WEST);
    this.add(monkeyInfoPanel, BorderLayout.CENTER);

    //add label
    display = new JLabel("[Register New Monkeys]");
    nameLabel = new JLabel("Name:");
    troopLabel = new JLabel("Troop:");
    sexLabel = new JLabel("Sex:");
    sizeLabel = new JLabel("Size:");
    weightLabel = new JLabel("Weight:");
    ageLabel = new JLabel("Age:");
    foodLabel = new JLabel("Food:");
    moveMonkeyLabel = new JLabel("[Move Monkey] Input Name:");
    isolationLabel = new JLabel("[Isolation]");
    enclosureLabel = new JLabel("[Enclosure]");

    registerMonkeyPanel.add(display);

    //set two sub panel for monkeyInfoPanel
    var monkeyNamesPanel = new JPanel();
    var enclosureMonkeyPanel = new JPanel();
    monkeyInfoPanel.setLayout(new GridLayout(1, 2));
    monkeyInfoPanel.add(monkeyNamesPanel, BorderLayout.WEST);
    monkeyInfoPanel.add(enclosureMonkeyPanel, BorderLayout.EAST);

    //add two scroll panels
    var lb1 = new JLabel("All monkeys in the sanctuary");
    monkeyNamesPanel.add(lb1);

    var lb2 = new JLabel("Monkeys in current enclosure");
    enclosureMonkeyPanel.add(lb2);
    var sp1 = new JScrollPane();
    var sp2 = new JScrollPane();

    allMonkeyName = new JList();
    enclosureMonkey = new JTable();

    sp1.setPreferredSize(new Dimension(200, 200));
    sp2.setPreferredSize(new Dimension(300, 200));

    sp1.setViewportView(allMonkeyName);
    sp2.setViewportView(enclosureMonkey);
    monkeyNamesPanel.add(sp1);
    enclosureMonkeyPanel.add(sp2);

    //add name
    registerMonkeyPanel.add(nameLabel);
    name = new JTextField(10);
    registerMonkeyPanel.add(name);

    //add troop
    registerMonkeyPanel.add(troopLabel);
    troop = new JComboBox();
    for (Troop value : Troop.values()) {
      troop.addItem(String.valueOf(value));
    }
    registerMonkeyPanel.add(troop);

    //add sex
    registerMonkeyPanel.add(sexLabel);
    sex = new JComboBox();
    for (Sex value : Sex.values()) {
      sex.addItem(String.valueOf(value));
    }
    registerMonkeyPanel.add(sex);

    //add size
    registerMonkeyPanel.add(sizeLabel);
    size = new JComboBox();
    for (Size value : Size.values()) {
      size.addItem(String.valueOf(value));
    }
    registerMonkeyPanel.add(size);

    //add weight
    registerMonkeyPanel.add(weightLabel);
    weight = new JTextField(6);
    registerMonkeyPanel.add(weight);

    //add age
    registerMonkeyPanel.add(ageLabel);
    age = new JTextField(6);
    registerMonkeyPanel.add(age);

    //add food
    registerMonkeyPanel.add(foodLabel);
    food = new JComboBox();
    for (Food value : Food.values()) {
      food.addItem(String.valueOf(value));
    }
    registerMonkeyPanel.add(food);

    //register monkey button
    registerMonkeyButton = new JButton("Register");
    registerMonkeyButton.setActionCommand("Register monkey button");
    registerMonkeyPanel.add(registerMonkeyButton);

    //exit button
    exitButton = new JButton("Exit");
    exitButton.setActionCommand("Exit Button");
    registerMonkeyPanel.add(exitButton);

    //info on move monkey panel
    moveMonkeyPanel.add(moveMonkeyLabel);
    name2 = new JTextField(10);
    moveMonkeyPanel.add(name2);

    //move monkey to enclosure button
    moveToEnclosureButton = new JButton("Move to Enclosure");
    moveToEnclosureButton.setActionCommand("Move to Enclosure Button");
    moveMonkeyPanel.add(moveToEnclosureButton);

    //move monkey to isolation button
    moveToIsolationButton = new JButton("Move to Isolation");
    moveMonkeyPanel.add(moveToIsolationButton);

    //enclosure area
    enclosureButton1 = new JButton("Drill");
    enclosureButton2 = new JButton("Guereza");
    enclosureButton3 = new JButton("Howler");
    enclosureButton4 = new JButton("Mangabey");
    enclosureButton5 = new JButton("Saki");
    enclosureButton6 = new JButton("Spider");
    enclosureButton7 = new JButton("Squirrel");
    enclosureButton8 = new JButton("Tamarin");
    enclosurePanel.add(enclosureLabel);
    enclosurePanel.add(enclosureButton1);
    enclosurePanel.add(enclosureButton2);
    enclosurePanel.add(enclosureButton3);
    enclosurePanel.add(enclosureButton4);
    enclosurePanel.add(enclosureButton5);
    enclosurePanel.add(enclosureButton6);
    enclosurePanel.add(enclosureButton7);
    enclosurePanel.add(enclosureButton8);

    //isolation area
    isolationPanel.add(isolationLabel);
    isolationMonkeys = new JList(new String[]{""});

    var sp3 = new JScrollPane();
    sp3.setPreferredSize(new Dimension(90, 200));
    sp3.setViewportView(isolationMonkeys);
    isolationPanel.add(sp3);
    pack();

  }

  @Override
  public void addFeatures(SanctuaryFeatures features) {
    registerMonkeyButton.addActionListener(evt -> features.registerMonkey(name.getText(),
        troop.getSelectedItem().toString(), sex.getSelectedItem().toString(),
        size.getSelectedItem().toString(), Double.parseDouble(weight.getText()),
        Integer.parseInt(age.getText()), food.getSelectedItem().toString()));
    exitButton.addActionListener(evt -> features.exitProgram());
    setMoveToEnclosureButton(features);
    setEnclosureButton(features);
    setMoveToIsolationButton(features);
  }

  /**
   * this method set move to enclosure button
   *
   * @param features the features from interface
   */
  public void setMoveToEnclosureButton(SanctuaryFeatures features) {
    moveToEnclosureButton.addActionListener(evt -> features.moveMonkeyToEnclosure
        (name.getText()));
  }

  /**
   * this method set move to isolation button
   *
   * @param features the features from interface
   */
  public void setMoveToIsolationButton(SanctuaryFeatures features) {
    moveToIsolationButton.addActionListener(evt -> features.moveMonkeyToIsolation
        (name.getText()));
  }

  /**
   * this method set the enclosure buttons
   *
   * @param features
   */
  public void setEnclosureButton(SanctuaryFeatures features) {
    enclosureButton1.addActionListener(evt -> features.switchEnclosure(Troop.drill));
    enclosureButton2.addActionListener(evt -> features.switchEnclosure(Troop.guereza));
    enclosureButton3.addActionListener(evt -> features.switchEnclosure(Troop.howler));
    enclosureButton4.addActionListener(evt -> features.switchEnclosure(Troop.mangabey));
    enclosureButton5.addActionListener(evt -> features.switchEnclosure(Troop.saki));
    enclosureButton6.addActionListener(evt -> features.switchEnclosure(Troop.spider));
    enclosureButton7.addActionListener(evt -> features.switchEnclosure(Troop.squirrel));
    enclosureButton8.addActionListener(evt -> features.switchEnclosure(Troop.tamarin));
  }


  @Override
  public void showIsolation(ArrayList<String> s) {
    isolationMonkeys.setListData(s.toArray());
  }


  @Override
  public void showMonkeyNames(ArrayList<String> s) {
    allMonkeyName.setListData(s.toArray());
  }


  @Override
  public void showEnclosureMonkeys(String[] s) {
    String[][] e = new String[s.length][];
    String[] title = {"name", "sex", "food"};
    for (int i = 0; i < s.length; i++) {
      e[i] = s[i].split("/");
    }
    var model = new DefaultTableModel(e, title);
    enclosureMonkey.setModel(model);
  }






  @Override
  public void showMessage(String s) {
    JOptionPane.showMessageDialog(null, s, "Warning", JOptionPane.ERROR_MESSAGE);
  }


  @Override
  public boolean showConfirmation(String s) {
    int result = JOptionPane.showConfirmDialog
        (null, s, "Please confirm", JOptionPane.OK_CANCEL_OPTION);
    return result == JOptionPane.OK_OPTION;
  }
}
