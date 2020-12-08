package gui;

import com.company.Main;
import logic.FlagGuesserGameLogic;

import javax.swing.*;
import java.awt.*;

public class FlagGuesserGameFrame extends JFrame {
    JLabel label;
    JPanel rowPanel;
    ImageIcon icon;
    FlagGuesserGameLogic logic = new FlagGuesserGameLogic(this);
    JProgressBar progressBar;
    JProgressBar correctAnswerProgressBar;
    public FlagGuesserGameFrame() throws HeadlessException {
        logic.generateQuestion();
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        progressBar = new JProgressBar();
        correctAnswerProgressBar = new JProgressBar();

        progressBar.setMaximum(Main.QUESTIONS);
        correctAnswerProgressBar.setMaximum(Main.QUESTIONS);

        label = new JLabel();
        add(progressBar);
        add(correctAnswerProgressBar);
        rowPanel = new JPanel();

        redraw();
        rowPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        rowPanel.setLayout(new BoxLayout(rowPanel, BoxLayout.Y_AXIS));
        //rowPanel.setPreferredSize(new Dimension(600, 400));
        setVisible(true);
        setLocationRelativeTo(null);

        setLocation(40, 40);
        setSize(750, 550);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public void redraw() {
        logic.generateQuestion();
        rowPanel.removeAll();
        rowPanel.revalidate();
        rowPanel.repaint();
        icon = new ImageIcon("flags/" + logic.current.getFlags().get(0));
        label.setIcon(icon);

        add(rowPanel);

        rowPanel.add(label);
        for (int i = 0; i < 4; i++) {
            rowPanel.add(logic.getButtons(logic.current).get(i));
        }
    }

    public void updateProgressBar() {
        progressBar.setValue(++Main.progress);
        correctAnswerProgressBar.setValue(Main.correctAnswers);
    }
}
