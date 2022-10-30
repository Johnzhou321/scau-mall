package org.scau.mall.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

public final class DateUtil {

    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";
    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String DATE_TIME_FORMAT_YYYYMMDDHHMMSSSSS = "yyyyMMddHHmmssSSS";
    public static final String DATE_TIME_FORMATE_YYYY_MM_DD_HH_MM = "yyyy-MM-dd HH:mm";
    public static final String DATE_TIME_FORMATE_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String DATE_TIME_FORMATE_HH = "HH";
    public static final String DATE_TIME_FORMATE_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";
    public static final String DATE_FORMAT_YYYY_MM_DD_CN = "yyyy年MM月dd日";

    /**
     * 返回当前时间长整型
     * 
     * @return
     */
    public static long getLongTime() {
        return System.currentTimeMillis();
    }

    /**
     * 返回当前时间字符型
     * 
     * @return
     */
    public static String getLongDate() {
        long d = System.currentTimeMillis();
        return String.valueOf(d);
    }

    public static boolean isDate(String str, String format) {
        if (null == str || str.length() == 0) {
            return false;
        }

        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            sdf.parse(str);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }

    /**
     * 格式化日期,格式化后可直接insert into [DB]
     * 
     * @return
     */
    public static String dateToStr(Date date) {

        if (date == null)
            return "";
        else {
            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
            String str_Date = sdFormat.format(date);
            return str_Date;
        }
    }

    public static String dateToStrYMD(Date date) {

        if (date == null)
            return "";
        else {
            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
            String str_Date = sdFormat.format(date);
            return str_Date;
        }
    }
    
    public static String dateToStrYYYYMMDD(long time) {
        SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        String str_Date = sdFormat.format(time);
        return str_Date;
    }

    public static String dateToStrYyyyMMdd(Date date) {
        if (date == null)
            return "";
        else {
            SimpleDateFormat sdFormat = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
            String str_Date = sdFormat.format(date);
            return str_Date;
        }
    }

    public static String dateToStrMMdd(Date date) {
        if (date == null)
            return "";
        else {
            SimpleDateFormat sdFormat = new SimpleDateFormat("MMdd", Locale.getDefault());
            String str_Date = sdFormat.format(date);
            return str_Date;
        }
    }

    public static String dateToStrHHmmss(Date date) {
        if (date == null)
            return "";
        else {
            SimpleDateFormat sdFormat = new SimpleDateFormat("HHmmss", Locale.getDefault());
            String str_Date = sdFormat.format(date);
            return str_Date;
        }
    }

    public static String dateToStr(Date date, String format) {
        if (date == null)
            return "";
        else {
            SimpleDateFormat sdFormat = new SimpleDateFormat(format, Locale.getDefault());
            String str_Date = sdFormat.format(date);
            return str_Date;
        }
    }

    /**
     * 反向格式化日期
     * 
     * @return
     */
    public static Date strToDate(String str) {
        if (str == null)
            return null;
        // DateFormat defaultDate = DateFormat.getDateInstance();
        // 细化日期的格式
        SimpleDateFormat defaultDate = new SimpleDateFormat("yyyy-MM-dd HH:mm");

        Date date = null;
        try {
            date = defaultDate.parse(str);
        } catch (ParseException pe) {
        }
        return date;
    }

    /**
     * 反向格式化日期
     * 
     * @param str
     *            要格式化字符串
     * @param formatStr
     *            字符串的日期格式
     * @return
     */
    public static Date strToDate(String str, String formatStr) {
        try {
            if (str == null)
                return null;
            if (formatStr == null) {
                formatStr = "yyyy-MM-dd HH:mm";
            }

            SimpleDateFormat defaultDate = new SimpleDateFormat(formatStr);

            Date date = null;
            try {
                date = defaultDate.parse(str);
            } catch (ParseException pe) {
            }
            return date;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 日期计算
     * 
     * @param date
     *            起始日期
     * @param yearNum
     *            年增减数
     * @param monthNum
     *            月增减数
     * @param dateNum
     *            日增减数
     */
    public static String calDate(String date, int yearNum, int monthNum, int dateNum) {
        String result = "";
        try {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sd.parse(date));
            cal.add(Calendar.MONTH, monthNum);
            cal.add(Calendar.YEAR, yearNum);
            cal.add(Calendar.DATE, dateNum);
            result = sd.format(cal.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * 日期计算
     * 
     * @param date
     *            起始日期
     * @param yearNum
     *            年增减数
     * @param monthNum
     *            月增减数
     * @param dateNum
     *            日增减数
     * @param hourNum
     *            小时增减数
     * @param minuteNum
     *            分钟增减数
     * @param secondNum
     *            秒增减数
     * @return
     */
    public static String calDate(String date, int yearNum, int monthNum, int dateNum, int hourNum, int minuteNum, int secondNum) {
        String result = "";
        try {
            SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Calendar cal = Calendar.getInstance();
            cal.setTime(sd.parse(date));
            cal.add(Calendar.MONTH, monthNum);
            cal.add(Calendar.YEAR, yearNum);
            cal.add(Calendar.DATE, dateNum);
            cal.add(Calendar.HOUR_OF_DAY, hourNum);
            cal.add(Calendar.MINUTE, minuteNum);
            cal.add(Calendar.SECOND, secondNum);
            result = sd.format(cal.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Date calDate(Date date, int yearNum, int monthNum, int dateNum) {
        Date result = null;
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MONTH, monthNum);
            cal.add(Calendar.YEAR, yearNum);
            cal.add(Calendar.DATE, dateNum);
            result = cal.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 日期计算
     * 
     * @param date
     *            起始日期
     * @param yearNum
     *            年增减数
     * @param monthNum
     *            月增减数
     * @param dateNum
     *            日增减数
     * @param hourNum
     *            小时增减数
     * @param minuteNum
     *            分钟增减数
     * @param secondNum
     *            秒增减数
     * @return
     */
    public static Date calDate(Date date, int yearNum, int monthNum, int dateNum, int hourNum, int minuteNum, int secondNum) {
        Date result = null;
        try {
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.MONTH, monthNum);
            cal.add(Calendar.YEAR, yearNum);
            cal.add(Calendar.DATE, dateNum);
            cal.add(Calendar.HOUR_OF_DAY, hourNum);
            cal.add(Calendar.MINUTE, minuteNum);
            cal.add(Calendar.SECOND, secondNum);
            result = cal.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 返回当前时间，格式'yyyy-mm-dd HH:mm:ss' 可为插入当前时间
     * 
     * @return
     */
    public static String getLocalDate() {
        java.util.Date dt = new java.util.Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        df.setTimeZone(TimeZone.getDefault());
        return df.format(dt);
    }

    public static String getYYYYMMDD() {
        java.util.Date dt = new java.util.Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        df.setTimeZone(TimeZone.getDefault());
        return df.format(dt);
    }

    public static String getLocalDate(String f) {
        java.util.Date dt = new java.util.Date();
        SimpleDateFormat df = new SimpleDateFormat(f);
        df.setTimeZone(TimeZone.getDefault());
        return df.format(dt);
    }

    /**
     * 返回当前时间，格式'yyyyMMddHHmmss' 可为插入当前时间
     * 
     * @return
     */
    public static String getSimpleDate() {
        //
        SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
        Date dt = new Date();
        return df.format(dt);
    }

    /**
     * 返回当前时间，格式'f' 可为插入当前时间
     * 
     * @return
     */
    public static String getFormatDate(String f) {
        //
        SimpleDateFormat df = new SimpleDateFormat(f);
        Date dt = new Date();
        return df.format(dt);
    }

    public static String getFormatDate(String f, Date dt) {
        //
        SimpleDateFormat df = new SimpleDateFormat(f);
        return df.format(dt);

    }

    public static Date getXDaysDate(int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -days);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    public static Date getXDaysDate(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, -days);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }

    /**
     * 得到当天凌晨的6点，包括明天凌晨6点前的
     * 
     * @return
     */
    public static String getTodaySixStr() {
        Date date = new Date();
        Date toDaySix = strToDate(dateToStr(date, "yyyy-MM-dd") + " 06:00");
        if (date.getTime() - toDaySix.getTime() > 0) {
            // //大于6点
            return dateToStr(date, "yyyy-MM-dd");
        } else {
            return dateToStr(calDate(date, 0, 0, -1), "yyyy-MM-dd");
        }
    }

    /**
     * 得到当天日期和之前日期列表
     * 
     * @return
     */
    public static List<String> getSixList() {
        Date date = new Date();
        Date toDaySix = strToDate(dateToStr(date, "yyyy-MM-dd") + " 06:00");
        Date daySix = null;
        if (date.getTime() - toDaySix.getTime() > 0) {
            // //大于6点
            daySix = date;
        } else {
            daySix = calDate(date, 0, 0, -1);
        }
        List<String> l = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            l.add(dateToStr(calDate(daySix, 0, 0, -i), "yyyy-MM-dd"));
        }
        return l;
    }
    
    /**
     * 得到当天凌晨的6点
     * 
     * @return
     */
    public static Date getTodaySixDate() {
        Date toDaySix = strToDate(dateToStrYMD(new Date()) + " 06:00");
        return toDaySix;
    }

    /**
     * 得到当天凌晨的6点
     * 
     * @return
     */
    public static Date getTodaySixDate(String dateStr) {
        Date toDaySix = strToDate(dateStr + " 06:00");
        return toDaySix;
    }

    /**
     * 得到明天凌晨的6点
     * 
     * @param todaysix
     *            今天6点
     * @return
     */
    public static Date getNextdaySixDate(Date todaysix) {
        return calDate(todaysix, 0, 0, 1);
    }

    /**
     * 格式化日期为“2004年9月13日”
     * 
     * @param orlTime
     * @return
     */
    public static String parseCnDate(String orlTime) {
        if (orlTime == null || orlTime.length() <= 0) {
            return "";
        }

        if (orlTime.length() < 10) {
            return "";
        }
        String sYear = orlTime.substring(0, 4);
        String sMonth = delFrontZero(orlTime.substring(5, 7));
        String sDay = delFrontZero(orlTime.substring(8, 10));
        return sYear + "年" + sMonth + "月" + sDay + "日";
    }

    public static String parseCnDateNoYear(String orlTime) {
        if (orlTime == null || orlTime.length() <= 0) {
            return "";
        }

        if (orlTime.length() < 10) {
            return "";
        }
        String sMonth = delFrontZero(orlTime.substring(5, 7));
        String sDay = delFrontZero(orlTime.substring(8, 10));
        return sMonth + "月" + sDay + "日";
    }

    /**
     * 格式化日期为"9.13"
     * 
     * @param orlTime
     * @return
     */
    public static String parsePointDate(String orlTime) {
        if (orlTime == null || orlTime.length() <= 0) {
            return "";
        }
        String sMonth = delFrontZero(orlTime.substring(5, 7));
        String sDay = delFrontZero(orlTime.substring(8, 10));
        return sMonth + "." + sDay;
    }

    /**
     * 取整函数
     * 
     * @param mord
     * @return
     */
    public static String delFrontZero(String mord) {
        int im = -1;
        try {
            im = Integer.parseInt(mord);
            return String.valueOf(im);
        } catch (Exception e) {
            return mord;
        }
    }

    public static String getWeekStr(Date time) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        return getWeekStr(c);
    }

    public static String getWeekStr(Calendar c) {
        int a = c.get(Calendar.DAY_OF_WEEK);
        switch (a) {
            case 1:
                return "星期日";
            case 2:
                return "星期一";
            case 3:
                return "星期二";
            case 4:
                return "星期三";
            case 5:
                return "星期四";
            case 6:
                return "星期五";
            case 7:
                return "星期六";
            default:
                return null;
        }
    }

    public static String getSimWeekStr(Calendar c) {
        int a = c.get(Calendar.DAY_OF_WEEK);
        switch (a) {
            case 1:
                return "周日";
            case 2:
                return "周一";
            case 3:
                return "周二";
            case 4:
                return "周三";
            case 5:
                return "周四";
            case 6:
                return "周五";
            case 7:
                return "周六";
            default:
                return null;
        }
    }

    public static Integer getCNDayOfWeek(Date time) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        int a = c.get(Calendar.DAY_OF_WEEK);
        switch (a) {
            case 1:
                return 7;
            case 2:
                return 1;
            case 3:
                return 2;
            case 4:
                return 3;
            case 5:
                return 4;
            case 6:
                return 5;
            case 7:
                return 6;
            default:
                return 1;
        }
    }

    public static Integer getWeek(Date time) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        return c.get(Calendar.WEEK_OF_YEAR);
    }

    public static Integer getYear(Date time) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        return c.get(Calendar.YEAR);
    }

    public static Integer getMonth(Date time) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        return c.get(Calendar.MONTH) + 1;
    }

    public static Integer getQuarter(Date time) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        int month = c.get(Calendar.MONTH);
        if (month < 3) {
            return 1;
        } else if (month >= 3 && month < 6) {
            return 2;
        } else if (month >= 6 && month < 9) {
            return 3;
        } else if (month >= 9 && month < 12) {
            return 4;
        } else {
            return null;
        }
    }

    public static Date getdecDateOfMinute(Date time, int minute) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        c.add(Calendar.MINUTE, -minute);
        return c.getTime();
    }

    public static Date getdecDateOfDate(Date time, int date) {
        Calendar c = Calendar.getInstance();
        c.setTime(time);
        c.add(Calendar.DATE, -date);
        return c.getTime();
    }

    /**
     * 构造函数
     */
    private DateUtil() {
    }

    public static String getStringMonday(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.HOUR, 23);
        c.set(Calendar.SECOND, 59);
        return new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());
    }

    public static Date getTodayDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    public static Date getYesterDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DATE, c.get(Calendar.DATE) - 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    // 获取本周 第一天
    public static Date getFirstDateOfWeek(Date date) {

        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.MONDAY);

        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);

        return c.getTime();
    }

    // 获取本周 第几天
    public static Date getDateOfWeek(Date date, int dayOfWeek) {

        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.MONDAY);

        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);

        return c.getTime();
    }

    // 获取前几个周几
    // 前50个周二
    public static Date getDateOfWeeks(Date date, int dayOfWeek, int total) {
        Calendar c = Calendar.getInstance();
        c.setFirstDayOfWeek(Calendar.MONDAY);

        c.setTime(date);
        c.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);

        c.add(Calendar.WEDNESDAY, total);
        return c.getTime();
    }

    public static Date getMonthFirstDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.DAY_OF_MONTH, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        return c.getTime();
    }

    /**
     * 将/YYY/MM/DD相对时间转为绝对时间
     * 
     * @param dateStr /年/月/日 例：/000/00/28表前28天
     * @param date null时使用当前时间
     * @return
     */
    public static Date calBeforeYYYMMDDDate(String dateStr, Date date) {
        if (dateStr == null || !dateStr.matches("\\/\\d+\\/\\d+\\/\\d+")) {
            return null;
        }
        if (date == null) {
            date = new Date();
        }
        String[] arr = dateStr.split("\\/");
        int year = Integer.parseInt(arr[1]);
        int month = Integer.parseInt(arr[2]);
        int day = Integer.parseInt(arr[3]);
        return calDate(date, -year, -month, -day);
    }

    /**
     * 计算周岁
     * 
     * @param birthDay 生日日期
     * @param date 参照时间，null时以当前时间作为参照
     * @return 满周年后的当天加多一岁
     */
    public static int getAge(Date birthDay, Date date) {
        Calendar cal = Calendar.getInstance();
        if (date != null) {
            cal.setTime(date);
        }
        if (cal.getTime().before(birthDay)) {
            throw new IllegalArgumentException("The birthDay is after date.");
        }

        int yearEnd = cal.get(Calendar.YEAR);
        int monthEnd = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthEnd = cal.get(Calendar.DAY_OF_MONTH);

        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH) + 1;
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearEnd - yearBirth;

        if (monthEnd <= monthBirth) {
            if (monthEnd == monthBirth) {
                if (dayOfMonthEnd < dayOfMonthBirth) {
                    age--;
                }
            } else {
                age--;
            }
        }
        return age;
    }

    /**
     * 计算日期差[年月日]
     * 
     * @param startDate
     * @param endDate
     * @return
     */
    public static Integer[] calDateDifference(Date startDate, Date endDate) {
        if (startDate == null || endDate == null || endDate.before(startDate)) {
            return new Integer[] { 0, 0, 0 };
        }

        Calendar bDate = Calendar.getInstance();
        bDate.setTime(startDate);

        Calendar eDate = Calendar.getInstance();
        eDate.setTime(endDate);
        eDate.add(Calendar.DAY_OF_MONTH, 1);

        int day = eDate.get(Calendar.DAY_OF_MONTH) - bDate.get(Calendar.DAY_OF_MONTH);//天
        int month = eDate.get(Calendar.MONTH) - bDate.get(Calendar.MONTH);//月
        int year = eDate.get(Calendar.YEAR) - bDate.get(Calendar.YEAR);//年

        if (day < 0) {
            month -= 1;
            int tempMonth = eDate.get(Calendar.MONTH) - 1;//获取截至计算的月减去1
            int tempYear = eDate.get(Calendar.YEAR);//获取截至计算的年
            if (tempMonth < 0) {         			//如果月份是1（下标0）月份，那么年份就减1,月份设置成11，也就是上一年度的12月份
                tempYear -= 1;
                tempMonth = 11;
            }
            int addDay = getDayByMonth(tempYear, tempMonth);//获取上一月的天数。    
            day = day + addDay;
        }
        if (month < 0) {
            month = (month + 12) % 12;
            year--;
        }
        return new Integer[] { year, month, day };
    }

//    public static void main(String[] args) throws ParseException {
//        System.out.println((DateUtil.strToDate(DateUtil.dateToStr(DateUtil.addDays(DateUtil.addYears(DateUtil.strToDate("2019-03-02", DATE_FORMAT_YYYY_MM_DD), 1), -1), "yyyy-MM-dd")+ " 23:59:59")));
//        System.out.println((DateUtil.strToDate(DateUtil.dateToStr(DateUtil.addDays(DateUtil.addYears(DateUtil.strToDate("2019-03-02", DATE_FORMAT_YYYY_MM_DD), 1), -2), "yyyy-MM-dd")+ " 23:59:59")));
//
//        Date start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2017-01-19 00:00:00");
//        Date end = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-01-18 23:59:59");
 //       int days = calDateDifferenceDay(start, end, false);
 //       System.out.println(days);
//        System.out.println(days);
//        System.out.println((365 - 100) / (365 * 1.00));
//
//        BigDecimal prem = new BigDecimal("100");
//        BigDecimal premTemp = prem;
//
//        BigDecimal effectiveDays = new BigDecimal("100");
//        //层级保险期限天数
//        BigDecimal policyDays = new BigDecimal("365");
//
//        BigDecimal dayPercentParam1 = policyDays.subtract(effectiveDays);
//        System.out.println("percent param1=" + dayPercentParam1.doubleValue());
//        System.out.println("policyDays=" + policyDays.doubleValue());
//        BigDecimal dayPercent = dayPercentParam1.divide(policyDays, 2, BigDecimal.ROUND_HALF_UP);
//        System.out.println("dayPercent=" + dayPercent.doubleValue());
//        prem = prem.multiply(dayPercent);
//
//        System.out.println(prem.doubleValue());
//        System.out.println(premTemp.doubleValue());
        //Date date = DateUtil.calDate(new Date(), -6, 0, 0);
//        Date start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-05-28 06:00:05");
//        Date sixDate = DateUtil.getTodaySixDate();
//        int i = DateUtil.compareDate(start,DateUtil.getTodaySixDate());
//        System.out.println(start);
//        System.out.println(sixDate);
//        Date date = DateUtil.calDate(new Date(), 0, -6, 0);
//
//        date = DateUtil.getEndOfDay(date);
//        date = DateUtil.calDate(date, 0, 0, 1);
//        
//         System.out.println(date);
//         
//        Date date1 = DateUtil.getBeginTimeOfDay(new Date());
//        Date date2 = DateUtil.getEndTimeOfDay(new Date());
//        Date start = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-05-28 06:00:05");
//        Date date1 = DateUtil.getDayOfThisYear(start);
        
        //Date date = DateUtil.calDate(new Date(), 0, -6, 0);
//        System.out.println(date1);
        //System.out.println(date2);
//        System.out.println(new Date());
//        int i = DateUtil.calDateDifferenceDay(date, new Date(), false);
//        System.out.println(i);

  //  }

    /**
     * 计算日期差天
     * 
     * @param startDate
     * @param endDate
     * @param calendDat 是否计算最后一天 比如 8月1日和8月2日, true 相差两天，false相差1天
     * @return
     */
    public static int calDateDifferenceDay(Date startDate, Date endDate, boolean calendDat) {
        if (startDate == null || endDate == null || endDate.before(startDate)) {
            return 0;
        }
        Calendar bDate = Calendar.getInstance();
        bDate.setTime(startDate);

        Calendar eDate = Calendar.getInstance();
        eDate.setTime(endDate);
        //判断是否在同一年
        int bYear = bDate.get(Calendar.YEAR);
        int eYear = eDate.get(Calendar.YEAR);
        if (bYear == eYear) {
            return eDate.get(Calendar.DAY_OF_YEAR) - bDate.get(Calendar.DAY_OF_YEAR) + (calendDat ? 1 : 0);
        }

        //第一年剩余的天数
        int nums = bDate.getActualMaximum(Calendar.DAY_OF_YEAR) - bDate.get(Calendar.DAY_OF_YEAR);
        for (int i = 1, len = eYear - bYear; i < len; i++) {
            //计算之间的天数 1年以上才执行，一年不用执行
            bDate.add(Calendar.YEAR, 1);
            nums += bDate.getActualMaximum(Calendar.DAY_OF_YEAR);
        }
        nums += eDate.get(Calendar.DAY_OF_YEAR);
        //计算end的天数
        return nums + (calendDat ? 1 : 0);
    }

    /**
     * 计算日期差天
     * 
     * @param startDate
     * @param endDate
     * @return
     */
    public static int calDateDifferenceYear(Date startDate, Date endDate) {
        if (startDate == null || endDate == null || endDate.before(startDate)) {
            return 0;
        }
        Calendar bDate = Calendar.getInstance();
        bDate.setTime(startDate);

        Calendar eDate = Calendar.getInstance();
        eDate.setTime(endDate);
        //判断是否在同一年
        int bYear = bDate.get(Calendar.YEAR);
        int eYear = eDate.get(Calendar.YEAR);
        if (bYear == eYear) {
            return 0;
        }

        //第一年剩余的月数
        int nums = 11 - bDate.get(Calendar.MONDAY);
        if (eYear - bYear > 1) {
            //计算中间的月份
            nums += 12 * (eYear - bYear - 1);
        }
        nums += eDate.get(Calendar.MONDAY) + 1;
        //计算end的天数

        return nums / 12 + (nums % 12 > 0 ? 1 : 0);
    }

    //判断是否是闰年
    private static boolean isLeapYear(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || year % 100 == 0);
    }

    //获取指定月份的天数
    private static int getDayByMonth(int year, int month) {
        Integer[] days = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (!isLeapYear(year)) {//平年28天
            days[1] = 28;
        }
        return days[month];
    }

    public static Date parseDate(String strdate, String format) {
        Date bdate = null;
        try {
            if (null == strdate) {
                return bdate;
            }
            SimpleDateFormat dFormat = new SimpleDateFormat(format);
            dFormat.setLenient(false);
            bdate = new Date(dFormat.parse(strdate).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return bdate;
    }

    public static Date addSeconds(Date date, int amount) {
        return add(date, Calendar.SECOND, amount);
    }

    public static Date addHours(Date date, int amount) {
        return add(date, Calendar.HOUR_OF_DAY, amount);
    }

    public static Date addDays(Date date, int amount) {
        return add(date, Calendar.DAY_OF_MONTH, amount);
    }

    public static Date addMins(Date date, int amount) {
        return add(date, Calendar.MINUTE, amount);
    }

    public static Date addYears(Date date, int amount) {
        return add(date, Calendar.YEAR, amount);
    }

    public static Date addMonths(Date date, int amount) {
        return add(date, Calendar.MONTH, amount);
    }

    private static Date add(Date date, int calendarField, int amount) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(calendarField, amount);
        return c.getTime();
    }

    public static Date transform(Date date, String format) {
        if (date == null) {
            return null;
        }
        SimpleDateFormat dFormat = new SimpleDateFormat(format);
        try {
            return dFormat.parse(dFormat.format(date));
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 计算出生日期范围
     * 
     * @param dateStr
     * @param isStart
     * @param date
     * @return
     */
    public static Date calBeforeDate(String dateStr, boolean isStart, Date date) {
        if (dateStr == null || !dateStr.matches("\\/\\d+\\/\\d+\\/[-]{0,1}\\d+")) {
            return null;
        }
        //date为null时取当前时间
        if (date == null) {
            date = new Date();
        }
        String[] arr = dateStr.split("\\/");
        int year = Integer.parseInt(arr[1]);
        int month = Integer.parseInt(arr[2]);
        int day = Integer.parseInt(arr[3]);

        if (year > 0 && month == 0 && day == 0) {//按周年计算
            if (isStart) {//起始时间要往前一年后加一天
                return DateUtil.calDate(date, -year - 1, 0, 1);
            }
            return DateUtil.calDate(date, -year, 0, 0);
        } else {//精准计算
            return DateUtil.calDate(date, -year, -month, -day);
        }
    }

    // 获得当前日期与本周日相差的天数  
    private static int getMondayPlus(Date gmtCreate) {
        Calendar cd = Calendar.getInstance();
        cd.setTime(gmtCreate);
        // 获得今天是一周的第几天，星期日是第一天，星期二是第二天......  
        int dayOfWeek = cd.get(Calendar.DAY_OF_WEEK) - 1; // 因为按中国礼拜一作为第一天所以这里减1  
        if (dayOfWeek == 1) {
            return 0;
        } else {
            return 1 - dayOfWeek;
        }
    }

    // 获得下周星期一的日期  
    public static Date getNextMondayStartTime(Date gmtCreate) {
        int mondayPlus = getMondayPlus(gmtCreate);
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7);
        currentDate.set(GregorianCalendar.HOUR_OF_DAY, 0);
        currentDate.set(GregorianCalendar.MINUTE, 0);
        currentDate.set(GregorianCalendar.SECOND, 0);
        currentDate.set(GregorianCalendar.MILLISECOND, 0);
        Date monday = currentDate.getTime();
        return monday;
    }

    // 获得去年下周星期一的日期  
    public static Date getLastYearNextMondayStartTime(Date now) {
        int mondayPlus = getMondayPlus(now);
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.YEAR, -1);
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 7 + 1);
        currentDate.set(GregorianCalendar.HOUR_OF_DAY, 0);
        currentDate.set(GregorianCalendar.MINUTE, 0);
        currentDate.set(GregorianCalendar.SECOND, 0);
        currentDate.set(GregorianCalendar.MILLISECOND, 0);
        Date monday = currentDate.getTime();
        return monday;
    }

    // 获得下周星期日的日期，结尾时间  
    public static Date getNextSundayEndTime(Date gmtCreate) {
        int mondayPlus = getMondayPlus(gmtCreate);
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 13);
        currentDate.set(GregorianCalendar.HOUR_OF_DAY, 23);
        currentDate.set(GregorianCalendar.MINUTE, 59);
        currentDate.set(GregorianCalendar.SECOND, 59);
        currentDate.set(GregorianCalendar.MILLISECOND, 999);
        Date monday = currentDate.getTime();
        return monday;
    }

    // 获得去年下周星期日的日期，结尾时间  
    public static Date getLastYearNextSundayEndTime(Date now) {
        int mondayPlus = getMondayPlus(now);
        GregorianCalendar currentDate = new GregorianCalendar();
        currentDate.add(GregorianCalendar.YEAR, -1);
        currentDate.add(GregorianCalendar.DATE, mondayPlus + 13 + 1);
        currentDate.set(GregorianCalendar.HOUR_OF_DAY, 23);
        currentDate.set(GregorianCalendar.MINUTE, 59);
        currentDate.set(GregorianCalendar.SECOND, 59);
        currentDate.set(GregorianCalendar.MILLISECOND, 999);
        Date monday = currentDate.getTime();
        return monday;
    }

    // 获取指定日期当天的开始时间
    public static Date getBeginTimeOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(GregorianCalendar.HOUR_OF_DAY, 0);
        calendar.set(GregorianCalendar.MINUTE, 0);
        calendar.set(GregorianCalendar.SECOND, 0);
        calendar.set(GregorianCalendar.MILLISECOND, 0);

        return calendar.getTime();
    }

    // 获取指定日期当天的结束时间
    public static Date getEndTimeOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(GregorianCalendar.HOUR_OF_DAY, 23);
        calendar.set(GregorianCalendar.MINUTE, 59);
        calendar.set(GregorianCalendar.SECOND, 59);
        calendar.set(GregorianCalendar.MILLISECOND, 999);

        return calendar.getTime();
    }

    // 获取带秒的默认日期格式器
    public static DateFormat getDefaultFormaterWithSecond() {
        return new SimpleDateFormat(DATE_TIME_FORMATE_YYYY_MM_DD_HH_MM_SS);
    }

    public static int getTimeOfDay(Date endDate, Date beginDate) {
        long diff = endDate.getTime() - beginDate.getTime();//这样得到的差值是微秒级别  
        int days = Integer.parseInt(String.valueOf(diff / (1000 * 60 * 60 * 24)));
        return days;
    }

    /**
     * 根据毫秒处理相差天数
     * 
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDaysByMillisecond(Date date1, Date date2) {
        String dateStr1 = dateToStr(date1, DATE_FORMAT_YYYY_MM_DD);
        String dateStr2 = dateToStr(date2, DATE_FORMAT_YYYY_MM_DD);
        long value = strToDate(dateStr2, DATE_FORMAT_YYYY_MM_DD).getTime() - strToDate(dateStr1, DATE_FORMAT_YYYY_MM_DD).getTime();
        int days = (int) ((value) / (1000 * 3600 * 24));
        return days;
    }
    
    /**
     * 获取日期里面的年月日的具体数值
     * 
     */
    public static Map<String, Integer> getSpecificDate(String str) {
    	Map<String, Integer> map =  new HashMap<>();
    	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    	try {
    		Date date = sf.parse(str);
    		Calendar calendar = Calendar.getInstance();
    		calendar.setTime(date);
    		map.put("year", calendar.get(Calendar.YEAR));
    		map.put("month", calendar.get(Calendar.MONTH) + 1);
    		map.put("day", calendar.get(Calendar.DAY_OF_MONTH));

    	} catch (ParseException e) {
    		e.printStackTrace();
    	}
		return map;
    }

    // 获得当前时间n天后的日期
    public static Date getDaysLaterStartTime(Date now, int n) {
        GregorianCalendar currentDate = new GregorianCalendar();        
        currentDate.add(GregorianCalendar.DATE, n + 1);
        currentDate.set(GregorianCalendar.HOUR_OF_DAY, 0);
        currentDate.set(GregorianCalendar.MINUTE, 0);
        currentDate.set(GregorianCalendar.SECOND, 0);
        currentDate.set(GregorianCalendar.MILLISECOND, 0);
        Date monday = currentDate.getTime();
        return monday;
    }
    
    // 获得当前时间n天后的日期，结尾时间  
    public static Date getDaysLaterEndTime(Date now, int n) {
        GregorianCalendar currentDate = new GregorianCalendar();        
        currentDate.add(GregorianCalendar.DATE, n + 1);
        currentDate.set(GregorianCalendar.HOUR_OF_DAY, 23);
        currentDate.set(GregorianCalendar.MINUTE, 59);
        currentDate.set(GregorianCalendar.SECOND, 59);
        currentDate.set(GregorianCalendar.MILLISECOND, 999);
        Date monday = currentDate.getTime();
        return monday;
    }
    
    public static Date getFirstDayOfYear(Date date) {
        Calendar c = Calendar.getInstance();

        c.setTime(date);
        c.set(Calendar.MONTH, Calendar.JANUARY);
        c.set(Calendar.DATE, 1);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        return c.getTime();
    }
    
    public static Date getLastDayOfYear(Date date) {     
        Calendar c = Calendar.getInstance();     
        c.setTime(date);
        //设置月份  
        c.set(Calendar.MONTH, Calendar.DECEMBER); 
        //获取某月最大天数
        int lastDay = c.getActualMaximum(Calendar.DATE);
        //设置日历中月份的最大天数  
        c.set(Calendar.DATE, lastDay);  
        c.set(Calendar.HOUR_OF_DAY, 23);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 59);
        c.set(Calendar.MILLISECOND, 999);
        
        return c.getTime();
    }
    
    // 获取一个范围内的日期集合
    public static List<Date> getDateList(Date startDate, Date endDate) {     
        List<Date> dateList = new ArrayList<Date>();
        int days = calDateDifferenceDay(startDate,endDate, true);
        for(int i = 0; i < days; i++) {
            Date date = addDays(startDate, i);
            dateList.add(date);
        }
        return dateList;
    }
    
    /**
     * 日期比较
     * @param startDate
     * @param endDate
     * @return  1 大于;   0等于； -1 小于
     */
    public static int compareDate(Date startDate, Date endDate) {
        if (endDate.getTime() > startDate.getTime()) {
            return 1;
        } else if (endDate.getTime() < startDate.getTime()) {
            return -1;
        } else {
            return 0;
        }
    }
    
    /**
     * 日期比较
     * @param startDate
     * @param endDate
     * @return  大于0，说明endDate比startDate大
     */
    public static long getCompareDateTime(Date startDate, Date endDate) {
    	 return endDate.getTime() - startDate.getTime();
    }

    // 获取指定日期当天的结束时间
    public static Date getEndOfDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(GregorianCalendar.HOUR_OF_DAY, 23);
        calendar.set(GregorianCalendar.MINUTE, 59);
        calendar.set(GregorianCalendar.SECOND, 59);
        calendar.set(Calendar.MILLISECOND, 00);
        return calendar.getTime();
    }

    // 获取今年的日期
    public static Date getDayOfThisYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        // 获取年份
        int year = calendar.get(Calendar.YEAR);
        calendar.setTime(date);
        calendar.set(GregorianCalendar.YEAR, year);
        return calendar.getTime();
    }

//    public static void main(String[] args) {
//        String aa="2021-07-04 00:00:00";
//        Date date=DateUtil.parseDate(aa,DATE_TIME_FORMATE_YYYY_MM_DD_HH_MM_SS);
//        String bb="2021-07-13 23:59:59";
//        Date date2=DateUtil.parseDate(bb, DATE_TIME_FORMATE_YYYY_MM_DD_HH_MM_SS);
//        
//    }
    
    public static Date asDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
    
}
