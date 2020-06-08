package com.longhe.util;

public class RandomUtils {

    public static Integer getNewRandomCode01(int codeLen) {
        Integer integer = getInteger(codeLen);
        integer = integer%2;
        return integer;
    }

    public static Integer getNewRandomCode15(int codeLen) {
        Integer integer = getInteger(codeLen);
        return integer;
    }

    private static Integer getInteger(int codeLen) {
        java.util.Random randomCode = new java.util.Random();
        String strCode = "";
        while (codeLen > 0) {
            int charCode = randomCode.nextInt(4);
            strCode += charCode;
            codeLen--;
        }
        Integer random = Integer.parseInt(strCode);

        return random;
    }


}
