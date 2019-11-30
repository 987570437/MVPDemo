package com.itzb.mvpdemo.login;

import com.itzb.mvpdemo.bean.BaseEntity;

/**
 * 将M、V、P层协商的共同业务封装成接口
 */
public interface LoginContract {

    interface Model {
        //Model层子类完成方法的具体实现
        void executeLogin(String name, String psw) throws Exception;
    }

    interface View<T extends BaseEntity> {
        //项目中往往是以Javabean
        void handleResult(T t);
    }

    interface Presenter<T extends BaseEntity> {
        //登录请求(接受View层的指令，可以自己去做，也可以让model层去做)
        void requestLogin(String name, String psw);

        //结果响应(接受Model层处理的结果，通知View层去刷新)
        void responseResult(T t);
    }

}
