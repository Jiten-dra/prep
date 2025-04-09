package components;

import java.util.ArrayList;
import java.util.List;


public class Question {
    public static int QUESTIONID = 0;
    List<Answer> answers;
    List<Comment> comments;
    List<Tag> tags;
    private int questionId;
    private String title;
    private String description;
    private QuestionStatus status;
    private int viewCount;
    private int voteCount;
    private int flaggedCount;
    private int answerCount;
    private int commentCount;
    private int favoriteCount;
    private int shareCount;
    private int userId;
    private int bounty;

    public Question(String title, String description, int userId) {
        this.questionId = QUESTIONID++;
        this.title = title;
        this.description = description;
        this.status = QuestionStatus.OPEN;
        this.viewCount = 0;
        this.voteCount = 0;
        this.flaggedCount = 0;
        this.answerCount = 0;
        this.commentCount = 0;
        this.favoriteCount = 0;
        this.shareCount = 0;
        this.userId = userId;
        this.bounty = 0;

        this.answers = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.tags = new ArrayList<>();
    }

    public void addBounty(int bounty) {
        this.bounty += bounty;
    }

    public void addComment(String description, int userId) {
        Comment comment = new Comment(description, userId, this.questionId, -1);
        this.comments.add(comment);
        this.commentCount++;
    }

    public void addAnswer(String description, int userId) {
        Answer answer = new Answer(description, userId, this.questionId);
        this.answers.add(answer);
        this.answerCount++;
    }

    public void addTag(String name) {
        Tag tag = TagManager.getInstance().getOrCreateTag(name);
        this.tags.add(tag);
    }

    private void setStatus(QuestionStatus status) {
        this.status = status;
    }

    public void close() {
        setStatus(QuestionStatus.CLOSED);
    }

    public void delete() {
        setStatus(QuestionStatus.DELETED);
    }

    public void undelete() {
        setStatus(QuestionStatus.OPEN);
    }

    public void reopenQuestion() {
        setStatus(QuestionStatus.OPEN);
    }
}
