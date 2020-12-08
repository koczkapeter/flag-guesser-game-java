package logic;

import com.company.Main;
import gui.FlagGuesserGameFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FlagGuesserGameLogic {
    public static Question current;
    public FlagGuesserGameFrame frame;

    public FlagGuesserGameLogic(FlagGuesserGameFrame frame) {
        this.frame = frame;
    }

    public void generateQuestion() {
        List<String> flags = Arrays.asList(new File("flags/").list());
        Collections.shuffle(flags);
        current = new Question(flags.subList(0, 4));
        System.out.println("debug size is" + current.getFlags().size());
        System.out.println("debuggg");
        for(int i = 0; i<current.getFlags().size(); i++){
            System.out.println(i + current.getFlags().get(i));
        }
    }

    public List<JButton> getButtons(Question question) {
        ArrayList<JButton> buttons = new ArrayList<>();
        for (String current : question.getFlags()) {
            JButton currentButton = new JButton(current);
            currentButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (currentButton.getText().equals(question.correctAnswer)) {
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
