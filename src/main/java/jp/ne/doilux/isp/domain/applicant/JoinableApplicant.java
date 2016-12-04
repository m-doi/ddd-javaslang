package jp.ne.doilux.isp.domain.applicant;

import jp.ne.doilux.isp.domain.contructor.Contractor;
import lombok.Data;

/**
 * 入会可能な申込者
 */
@Data
public class JoinableApplicant {

    private final Name name;

    private final BirthDay birthDay;

    public Contractor convertToContructor() {
        return new Contractor(
                name.convertToContructorName(),
                birthDay.convertToContructorBirthday()
        );
    }

}
