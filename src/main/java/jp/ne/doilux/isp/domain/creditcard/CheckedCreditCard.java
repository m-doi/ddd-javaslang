package jp.ne.doilux.isp.domain.creditcard;

import lombok.Data;

@Data
public class CheckedCreditCard {

    private final CardNumber cardNumber;

    private final ContractorName contractorName;
}
