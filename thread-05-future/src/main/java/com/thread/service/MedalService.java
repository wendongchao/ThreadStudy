package com.thread.service;

import com.thread.future.MedalInfo;

/**
 * @author dongchao
 * @date 2022/8/24 14:04
 */
public class MedalService {

    public MedalInfo getMedalInfo(long userId) throws InterruptedException {
        Thread.sleep(500); //模拟调用耗时
        return new MedalInfo("666", "守护勋章");
    }

}
