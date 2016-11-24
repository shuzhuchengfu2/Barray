package com.common.commonutils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * 金钱格式化
 */
public class MoneyUtil {
    /**
     * 格式化金额，添加千分符，小数点后保留两位
     *
     * @param money
     * @return
     */
    public static String formatMoney(String money) {
        if (money==null ||money.length() == 0) return "";
        String str_money;
        try {
            money = money.replace(",", "");
            BigDecimal bd = new BigDecimal(money);
            DecimalFormat myformat = new DecimalFormat();
            myformat.setRoundingMode(RoundingMode.DOWN);
            myformat.applyPattern("##,##0.00");
            str_money = myformat.format(bd);
        } catch (Exception e) {
            str_money = money;
        }
        return str_money;

    }

    /**
     * 格式化金额，添加千分符，没有小数
     *
     * @param money
     * @return
     */
    public static String formatMoneyWithoutDecimal(String money) {
        if (money==null ||money.length() == 0) return "";
        String str_money;
        try {
            money = money.replace(",", "");
            BigDecimal bd = new BigDecimal(money);
            DecimalFormat myformat = new DecimalFormat();
            myformat.setRoundingMode(RoundingMode.DOWN);
            myformat.applyPattern("##,##0");
            str_money = myformat.format(bd);
        } catch (Exception e) {
            str_money = money;
        }
        return str_money;
    }
}
