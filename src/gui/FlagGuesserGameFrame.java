package gui;

import com.company.Main;
import logic.FlagGuesserGameLogic;

import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.List;

public class FlagGuesserGameFrame extends JFrame {
    final JLabel iconAsLabel;
    final JPanel rowPanel;
    final FlagGuesserGameLogic logic = new FlagGuesserGameLogic(this);
    final JProgressBar progressBar;
    final JProgressBar correctAnswerProgressBar;
    public FlagGuesserGameFrame() throws HeadlessException {
        logic.generateQuestion();
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        progressBar = new JProgressBar();
        correctAnswerProgressBar = new JProgressBar();

        progressBar.setMaximum(Main.QUESTIONS);
        correctAnswerProgressBar.setMaximum(Main.QUESTIONS);

        iconAsLabel = new JLabel();
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
        iconAsLabel.setIcon(new ImageIcon("flags/" + FlagGuesserGameLogic.currentQuestion.getCorrectLabel()));

        add(rowPanel);

        rowPanel.add(iconAsLabel);
        List<JButton> buttons = logic.getButtons(FlagGuesserGameLogic.currentQuestion);
        Collections.shuffle(buttons);
        for (int i = 0; i < 4; i++) {
            rowPanel.add(buttons.get(i));
        }
    }

    public void updateProgressBar() {
        progressBar.setValue(Main.progress);
        correctAnswerProgressBar.setValue(Main.correctAnswers);
    }
}
