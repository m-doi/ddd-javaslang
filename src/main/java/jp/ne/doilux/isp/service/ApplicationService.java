package jp.ne.doilux.isp.service;

import javaslang.Tuple;
import javaslang.collection.List;
import javaslang.control.Validation;
import jp.ne.doilux.isp.domain.account.UserAccount;
import jp.ne.doilux.isp.domain.account.UserAccountRepository;
import jp.ne.doilux.isp.domain.applicant.Applicant;
import jp.ne.doilux.isp.domain.contructor.ContructorRepository;
import jp.ne.doilux.isp.domain.creditcard.CreditCardRepository;
import jp.ne.doilux.isp.domain.creditcard.UnCheckedCreditCard;
import jp.ne.doilux.isp.domain.lib.BaseDay;
import jp.ne.doilux.isp.domain.lib.NgReason;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ApplicationService {

    private final ContructorRepository contructorRepository;
    private final CreditCardRepository creditCardRepository;
    private final UserAccountRepository userAccountRepository;


    public Validation<List<NgReason>, UserAccount> order(
            Applicant applicant, UnCheckedCreditCard unCheckedCreditCard) {

        BaseDay baseDay = BaseDay.createByNow();

        return Validation.combine(
                applicant.check(baseDay),
                contructorRepository.find(applicant.getName()).
                        map(s -> Validation.invalid(NgReason.ALREADY_EXIST)).
                        getOrElse(Validation.valid(new Object())),
                creditCardRepository.check(unCheckedCreditCard)
        ).ap((jc, dummy, cc) -> Tuple.of(jc, cc)).peek(s -> {
            contructorRepository.save(s._1.convertToContructor());
            creditCardRepository.save(s._2);
        }).map(s -> userAccountRepository.create());
    }
}
