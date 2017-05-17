package com.carl.breakfast.web.ctrl.util;

import java.util.Random;

/**
 * @author Carl
 * @date 2017/5/17
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.卡尔工作室
 */
public final class SleepUtil {
    public static final boolean OPEN = true;
    /**
     * 随机睡眠（秒）
     *
     * @param start 最短时间
     * @param end   最长时间
     */
    public static void sleep(int start, int end) {
        if(!OPEN) {
            return;
        }
        java.util.Random random = new Random();
        int num = random.nextInt(end * 1000) + start * 1000;
        try {
            Thread.sleep(num);
        } catch (InterruptedException e) {

        }
    }

}
