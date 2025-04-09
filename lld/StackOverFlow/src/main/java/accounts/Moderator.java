package accounts;

import components.Question;

public class Moderator extends Member {
    public Moderator(int id, String name, String email, String password, String mobile, String address) {
        super(id, name, email, password, mobile, address);
    }

    @Override
    public boolean isModerator() {
        return true;
    }

    public void closeQuestion(Question question) {
        question.close();
    }

    public void undeleteQuestion(Question question) {
        question.undelete();
    }

    public void reopenQuestion(Question question) {
        question.reopenQuestion();
    }
    
}
