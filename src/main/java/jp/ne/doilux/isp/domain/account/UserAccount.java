package jp.ne.doilux.isp.domain.account;

import lombok.Data;

@Data
public class UserAccount {

    private final Id id;

    private final Password password;
}
