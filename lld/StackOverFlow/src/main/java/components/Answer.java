package components;

import java.util.List;
import java.util.ArrayList;

public class Answer {
    public static int ANSWERID = 0;
    private int answerId;
    private String description;
    private int userId;
    private int questionId;
    private int voteCount;

    List<Comment> comments;

    public Answer(String description, int userId, int questionId) {
        this.answerId = ANSWERID++;
        this.description = description;
        this.userId = userId;
        this.questionId = questionId;
        this.voteCount = 0;

        this.comments = new ArrayList<>();
    }

    public void addComment(String description, int userId) {
        Comment comment = new Comment(description, userId, -1, this.answerId);
        this.comments.add(comment);
    }
}
