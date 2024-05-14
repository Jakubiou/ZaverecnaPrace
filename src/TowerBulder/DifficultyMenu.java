package TowerBulder;

import javax.swing.*;
import java.awt.event.ActionListener;

public class DifficultyMenu extends JMenu {

    private JRadioButtonMenuItem easyMenu;
    private JRadioButtonMenuItem normalMenu;
    private JRadioButtonMenuItem hardMenu;
    private ButtonGroup difficultyGroup;

    public DifficultyMenu(ActionListener listener){
        super("Difficulty");
    }
}
