package logic;

import com.company.Main;
import gui.FlagGuesserGameFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.*;

public class FlagGuesserGameLogic {
    public static Question current;
    public final FlagGuesserGameFrame frame;

    public FlagGuesserGameLogic(FlagGuesserGameFrame frame) {
        this.frame = frame;
    }

    public void generateQuestion() {
        List<String> labels = Arrays.asList(Objects.requireNonNull(new File("flags/").list()));
        Collections.shuffle(labels);
        current = new Question(labels.subList(0, 4));
    }

    public List<JButton> getButtons(Question question) {
        ArrayList<JButton> buttons = new ArrayList<>();
        for (String current : question.getLabels()) {
            JButton currentButton = new JButton(current);
            currentButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (currentButton.getText().equals(question.correctLabel)) {
                        Main.correctAnswers++;
                        System.out.println("OK");
                    }
                    else {
                        System.out.println("NOT OK");
                    }
                    if(Main.progress <Main.QUESTIONS) {
                        frame.redraw();
                        frame.updateProgressBar();
                    }
                    else{
                        final JFrame gameOverMessage = new JFrame();
                        JOptionPane.showMessageDialog(gameOverMessage, "Done. Result: " + Main.correctAnswers + " / " + Main.QUESTIONS);
                    }
                }
            });
            buttons.add(currentButton);
        }
        return buttons;
    }
}
