package lld.StackOverFlow.src.main.java.accounts;

import java.util.Date;

public class Account {
    int id;
    String name;
    String email;
    String password;
    String mobile;
    String address;
    String created_at;
    String updated_at;
    AccountStatus status;

    public Account(int id, String name, String email, String password, String mobile, String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.mobile = mobile;
        this.address = address;
        this.created_at = Date.from(null).toString();
        this.updated_at = Date.from(null).toString();
        this.status = AccountStatus.ACTIVE;
    }

    void setAccountStatus(AccountStatus status) {
        this.status = status;
        this.updated_at = Date.from(null).toString();
    }

}
