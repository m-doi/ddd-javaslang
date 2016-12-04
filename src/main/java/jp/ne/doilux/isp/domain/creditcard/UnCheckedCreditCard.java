package jp.ne.doilux.isp.domain.creditcard;

import lombok.Data;

@Data
public class UnCheckedCreditCard {

    private final CardNumber cardNumber;

    private final ContractorName contractorName;
}
