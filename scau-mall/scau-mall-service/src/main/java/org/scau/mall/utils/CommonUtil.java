package org.scau.mall.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class CommonUtil {
    
//    public static void main(String[] args) {
//        System.out.println(newUnusedOrderNo());
//    }
    
    public static String newUnusedOrderNo() {
        String orderNo = getDatePrefix() + random(4);//年月日+4位随机数
        return orderNo;
    }

    private static String getDatePrefix() {
        return new SimpleDateFormat("yyMMdd").format(new Date());
    }

    private static String random(int count) {
        StringBuilder sb = new StringBuilder(count);
        for (int i = 0; i < count; i++) {
            sb.append(new Random().nextInt(10));
        }
        return sb.toString();
    }
    
    public static String covertObjToStr(Object obj) {
        if(obj == null) {
            return null;
        }
        return obj.toString();
    }
}
