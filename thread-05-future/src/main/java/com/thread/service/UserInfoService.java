package com.thread.service;

import com.thread.future.UserInfo;

/**
 * @author dongchao
 * @date 2022/8/24 14:04
 */
public class UserInfoService {

    public UserInfo getUserInfo(Long userId) {
        try {
            Thread.sleep(300);//模拟调用耗时
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new UserInfo("666", "捡田螺的小男孩", 27); //一般是查数据库，或者远程调用返回的
    }
}
