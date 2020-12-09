package logic;

import java.util.List;

public class Question {
    final List<String> labels;
    final String correctLabel;

    public Question(List<String> labels) {
        this.labels = labels;
        correctLabel = labels.get(0);
    }

    public List<String> getLabels() {
        return labels;
    }

    public String getCorrectLabel() {
        return correctLabel;
    }
}
