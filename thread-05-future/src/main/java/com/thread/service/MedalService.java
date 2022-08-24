package com.thread.service;

import com.thread.future.MedalInfo;

/**
 * @author dongchao
 * @date 2022/8/24 14:04
 */
public class MedalService {

    public MedalInfo getMedalInfo(long userId) {
        try {
            Thread.sleep(500); //模拟调用耗时
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new MedalInfo("666", "守护勋章");
    }

}
