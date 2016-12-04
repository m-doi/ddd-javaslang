package jp.ne.doilux.isp.domain.creditcard;

import javaslang.control.Validation;
import jp.ne.doilux.isp.domain.lib.NgReason;

public interface CreditCardRepository {

    /**
     * クレジットカードをチェックする。
     * Validationを返すべきかOptionalにすべきがすごく悩んだ。
     * <p>
     * Validationにすると「チェックする」という責務がデータソース層にいく（レポジトリの責務を超えている気がする）
     * Optionalにすると「チェック済みクレジットカードオブジェクトを生成する」という責務がデータソースに行く
     * （やはりレポジトリの責務を超えている気がする）
     * <p>
     * 一旦上を採用。気になったら下にするかも。
     */
    Validation<NgReason, CheckedCreditCard> check(UnCheckedCreditCard unCheckedCreditCard);


    void save(CheckedCreditCard checkedCreditCard);
}
