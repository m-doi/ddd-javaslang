package jp.ne.doilux.isp.domain.applicant;

import javaslang.control.Validation;
import jp.ne.doilux.isp.domain.lib.BaseDay;
import jp.ne.doilux.isp.domain.lib.NgReason;
import lombok.Data;
import lombok.Getter;

/**
 * 申込者（この段階では入会できるかどうか不明）
 */
@Data
public class Applicant {

    @Getter
    private final Name name;

    private final BirthDay birthDay;


    public Validation<NgReason, JoinableApplicant> check(BaseDay baseDay) {
        return birthDay.isJoinableAge(baseDay) ?
                Validation.valid(createJoinable())
                : Validation.invalid(NgReason.UNDER_18);
    }

    JoinableApplicant createJoinable() {
        return new JoinableApplicant(name, birthDay);
    }
}
