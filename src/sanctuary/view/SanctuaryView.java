package sanctuary.view;

import java.util.ArrayList;
import sanctuary.controller.SanctuaryFeatures;

public interface SanctuaryView {



    /**
     * get features from SanctuaryFeatures
     * @param features the features from SanctuaryFeatures
     */
    void addFeatures(SanctuaryFeatures features);

    /**
     * show the monkeys in isolation
     * @param s the string of monkey's information
     */
    void showIsolation(ArrayList<String> s);

    /**
     * show all of the monkey's names
     * @param s the name of monkeys
     */
    void showMonkeyNames(ArrayList<String> s);
    /**
     * show the monkeys in enclosure, the information are split and saved in table
     *
     * @param s the String of monkey's information
     */
    void showEnclosureMonkeys(String[] s);

    /**
     * show warning messages
     *
     * @param s the string of error message
     */
    void showMessage(String s);

    /**
     * show confirmation message
     * @param s the message
     * @return true or false
     */
    boolean showConfirmation(String s);

}
