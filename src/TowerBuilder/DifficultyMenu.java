package TowerBuilder;

import javax.swing.*;
import java.awt.event.ActionListener;

public class DifficultyMenu extends JMenu {

    private JRadioButtonMenuItem easyMenu;
    private JRadioButtonMenuItem normalMenu;
    private JRadioButtonMenuItem hardMenu;
    private ButtonGroup difficultyGroup;

    public DifficultyMenu(ActionListener listener){
        super("Difficulty");
        easyMenu = new JRadioButtonMenuItem("Easy");
        normalMenu = new JRadioButtonMenuItem("Normal",true);
        hardMenu = new JRadioButtonMenuItem("Hard");

        easyMenu.setActionCommand("Easy");
        normalMenu.setActionCommand("Normal");
        hardMenu.setActionCommand("Hard");

        easyMenu.addActionListener(listener);
        normalMenu.addActionListener(listener);
        hardMenu.addActionListener(listener);

        difficultyGroup = new ButtonGroup();
        difficultyGroup.add(easyMenu);
        difficultyGroup.add(normalMenu);
        difficultyGroup.add(hardMenu);

        add(easyMenu);
        add(normalMenu);
        add(hardMenu);
    }

    public int getSelectedDifficulty(){
        if (easyMenu.isSelected()){
            return 1;
        } else if (normalMenu.isSelected()) {
            return 2;
        } else if (hardMenu.isSelected()) {
            return 3;
        }else {
            return 2;
        }
    }
}
