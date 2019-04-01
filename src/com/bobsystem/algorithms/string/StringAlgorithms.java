package com.bobsystem.algorithms.string;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

public class StringAlgorithms {

    private static final Map<Character, String> mapNumber;
    private static final Map<Integer, String> mapUnits;

    private static final String[] arrNumber;
    private static final String[] arrUnit;
    private static final String[] arrDecimalUnit;

    static {
        mapNumber = new HashMap<Character, String>();
        mapNumber.put('0', "零");
        mapNumber.put('1', "壹");
        mapNumber.put('2', "贰");
        mapNumber.put('3', "叁");
        mapNumber.put('4', "肆");
        mapNumber.put('5', "伍");
        mapNumber.put('6', "陆");
        mapNumber.put('7', "柒");
        mapNumber.put('8', "捌");
        mapNumber.put('9', "玖");

        mapUnits = new HashMap<Integer, String>();
        mapUnits.put(-4, "毫");
        mapUnits.put(-3, "厘");
        mapUnits.put(-2, "分");
        mapUnits.put(-1, "角");
        mapUnits.put(0, "元");
        mapUnits.put(1, "拾");
        mapUnits.put(2, "佰");
        mapUnits.put(3, "仟");
        mapUnits.put(4, "万");
        mapUnits.put(5, "拾");
        mapUnits.put(6, "佰");
        mapUnits.put(7, "仟");
        mapUnits.put(8, "亿");
        mapUnits.put(9, "拾");
        mapUnits.put(10, "佰");

        arrNumber = new String[] {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌","玖"};
        arrUnit = new String[] { "元","拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰"};
        arrDecimalUnit = new String[] { "毫", "厘", "分", "角"};
    }

    /*
     * 100001
     * 1000000001.
     * 1030405670
     * 1030405678.4001
     * 1030405678.1234
     */

    public String money2Hanzi(double amount) {

        String formater = "0.0000";
        if (amount - (int)amount == 0) {
            formater = "0";
        }
        DecimalFormat decimalFormater = new DecimalFormat(formater);

        String strAmount = decimalFormater.format(amount);
        int dotIndex = strAmount.indexOf('.');

        int length = strAmount.length();
        if (dotIndex != -1) {
            length = dotIndex;
        }

        StringBuilder stringBuilder = new StringBuilder("￥");
        for (int i = length - 1; i >= 0; --i) {

            char num = strAmount.charAt(length - 1 - i);
            // 数值大于0 数字和单位都要拼接
            // 个位是0 不要数字
            if (i != 0 || num != '0') {
                stringBuilder.append(mapNumber.get(num));
            }
            // 十位以上是0 不要单位，亿、万除外
            if (i == 0 || num != '0' || i == 4 || i == 8) {
                stringBuilder.append(mapUnits.get(i));
            }
        }
        //System.out.println(stringBuilder);
        if (dotIndex != -1) {

            String decimalPart = strAmount.substring(dotIndex + 1);
            for (int i = 0, c = decimalPart.length(); i < c; ++i) {

                char num = decimalPart.charAt(i);
                stringBuilder.append(mapNumber.get(num));
                stringBuilder.append(mapUnits.get(-i - 1));
            }
        }
        else {
            stringBuilder.append("整");
        }
        String result = stringBuilder.toString();
        result = result.replaceAll("零{4}(亿|万)", "");
        result = result.replaceAll("零{2,}", "零");
        result = result.replaceAll("零(亿|万)", "$1");
        //result = result.replaceAll("零(角|分|厘)", "零");

        return result;
    }

    // 推荐
    public String money2Hanzi2(double amount) {
        StringBuilder strBuilder = new StringBuilder();

        int money = (int)amount;
        int i = 0;
        while (money > 0) {
            strBuilder.insert(0, arrUnit[i++]);
            int num = money % 10;
            strBuilder.insert(0, arrNumber[num]);

            money /= 10;
        }
        if (amount - (int)amount > 0) { // 处理小数
            DecimalFormat formater = new DecimalFormat("0.0000");
            String strAmount = formater.format(amount);

            int dot = strAmount.indexOf('.');
            if (dot != -1) {
                String decimalPart = strAmount.substring(dot + 1);
                BigDecimal decimal = new BigDecimal(decimalPart);

                StringBuilder decimalStringBuilder = new StringBuilder();
                money = decimal.intValue();
                i = 0;
                while (money > 0) {

                    decimalStringBuilder.insert(0, arrDecimalUnit[i++]);
                    int num = money % 10;
                    decimalStringBuilder.insert(0, arrNumber[num]);

                    money = money / 10;
                }
                strBuilder.append(decimalStringBuilder);
            }
        }
        else {
            strBuilder.append("整");
        }
        String result = strBuilder.toString();
        //System.out.println(result);

        result = result.replaceAll("零[仟佰拾]", "零");
        result = result.replaceAll("零{2,}", "零");
        result = result.replaceAll("零(亿|万|元)", "$1");
        result = result.replaceAll("亿万", "亿");

        return result;
    }

    public String complementSubstring(byte bytes[], int subLength) {

        int length = subLength - 1;
        byte by = bytes[length];
        if (by >= 0) {
            length += 1;
        }
        while (by < 0) {

            length += 1;
            by = bytes[length];
        }
        //System.out.printf("old: %d, new: %d, result: %s%n",
        //    subLength, length, new String(bytes, 0, length));

        return new String(bytes, 0, length);
    }
}
