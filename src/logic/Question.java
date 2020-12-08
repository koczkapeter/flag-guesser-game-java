package logic;

import java.util.List;

public class Question {
    List<String> flags;
    String correctAnswer;

    public Question(List<String> flags) {
        this.flags = flags;
        correctAnswer=flags.get(0);
    }

    public List<String> getFlags() {
        return flags;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }
}
