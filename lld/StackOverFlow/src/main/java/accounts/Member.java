package accounts;

import java.util.List;
import java.util.ArrayList;

import components.Badge;

public class Member {
    Account account;
    List<Badge> badges;

    public Member(int id, String name, String email, String password, String mobile, String address) {
        this.account = new Account(id, name, email, password, mobile, address);
        this.badges = new ArrayList<>();
    }

    // SHOULD be accessible only to Admin
    public Account getAccount(Member member) throws RuntimeException {
        if(!member.isAdmin() || member != this) {
            throw new RuntimeException("You are not authorized to perform this operation");
        }
        return this.account;
    }

    public boolean isAdmin() {
        return false;
    }

    public boolean isModerator() {
        return false;
    }
    

    public void addBadge(Badge badge) {
        badges.add(badge);
    }
}
