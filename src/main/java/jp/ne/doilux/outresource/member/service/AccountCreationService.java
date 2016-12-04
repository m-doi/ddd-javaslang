package jp.ne.doilux.outresource.member.service;

import org.springframework.stereotype.Service;

@Service
public class AccountCreationService {


    public String createMemberLoginId() {
        return "loginid";
    }

    public String createMemberPassword() {
        return "loginpassword";
    }

}
