package components;

public class Comment {
    public static int COMMENTID = 0;
    private int commentId;
    private String description;
    private int userId;
    private int questionId;
    private int answerId;
    private int voteCount;

    public Comment(String description, int userId, int questionId, int answerId) {
        this.commentId = COMMENTID++;
        this.description = description;
        this.userId = userId;
        this.questionId = questionId;
        this.answerId = answerId;
        this.voteCount = 0;
    }
}
