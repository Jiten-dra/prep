package accounts;

public class Admin extends Member {
    public Admin(int id, String name, String email, String password, String mobile, String address) {
        super(id, name, email, password, mobile, address);
    }

    @Override
    public boolean isAdmin() {
        return true;
    }

    boolean blockMember(Member member) {
        try {
            member.getAccount(this).setAccountStatus(AccountStatus.BLOCKED);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    boolean unblockMember(Member member) {
        try {
            member.getAccount(this).setAccountStatus(AccountStatus.ACTIVE);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
}
