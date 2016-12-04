package jp.ne.doilux.outresource.creditcard.service;

import org.springframework.stereotype.Service;

@Service
public class CardCheckService {

    /**
     * カードが有効かどうか判定する。
     *
     * @param cardNumber
     * @param cardName
     * @return
     */
    public boolean check(String cardNumber, String cardName) {
        // stub
        return true;
    }
}
