package jp.ne.doilux.isp.domain.applicant;

import jp.ne.doilux.isp.domain.lib.BaseDay;
import lombok.Data;

import java.time.LocalDate;

@Data
class BirthDay {

    private final LocalDate value;


    boolean isJoinableAge(BaseDay baseDay) {
        // stub
        return culcAge(baseDay).isUnder(new Age(18));
    }


    private Age culcAge(BaseDay baseDay) {
        // stub
        return new Age(18);
    }

    @Data
    private class Age {
        private final Integer value;

        boolean isUnder(Age age) {
            // stub
            return false;
        }
    }

    jp.ne.doilux.isp.domain.contructor.BirthDay convertToContructorBirthday() {
        return new jp.ne.doilux.isp.domain.contructor.BirthDay(value);
    }


}
