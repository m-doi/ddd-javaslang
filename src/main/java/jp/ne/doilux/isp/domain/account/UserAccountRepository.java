package jp.ne.doilux.isp.domain.account;


public interface UserAccountRepository {

    UserAccount create();

    void save(UserAccount userAccount);
}
