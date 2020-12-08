package logic;

import java.util.List;

public class Question {
    final List<String> flags;
    final String correctAnswer;

    public Question(List<String> flags) {
        this.flags = flags;
        correctAnswer=flags.get(0);
    }

    public List<String> getFlags() {
        return flags;
    }
}
