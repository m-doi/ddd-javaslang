package jp.ne.doilux.isp.domain.lib;

import lombok.Data;
import org.joda.time.LocalDate;

@Data
public class BaseDay {

    private final LocalDate localDate;

    public static BaseDay createByNow() {
        return new BaseDay(LocalDate.now());
    }
}
