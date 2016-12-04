package jp.ne.doilux.isp.domain.applicant;

import lombok.Data;

@Data
public class Name {

    private final String value;

    jp.ne.doilux.isp.domain.contructor.Name convertToContructorName() {
        return new jp.ne.doilux.isp.domain.contructor.Name(value);
    }
}
