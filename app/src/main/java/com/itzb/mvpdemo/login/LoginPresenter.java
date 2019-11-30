package com.itzb.mvpdemo.login;

import com.itzb.mvpdemo.base.BasePresenter;
import com.itzb.mvpdemo.bean.UserInfo;

public class LoginPresenter extends BasePresenter<LoginModel, LoginActivity, LoginContract.Presenter> {
    @Override
    public LoginModel getModel() {
        return new LoginModel(this);
    }

    @Override
    public LoginContract.Presenter getContract() {
        return new LoginContract.Presenter<UserInfo>() {
            @Override
            public void requestLogin(String name, String psw) {
                try {
                    //3种风格，P层很极端，要不不做事制作转发，要不拼命一个人干活,Google的MVPDemo中在P端做了所有的业务逻辑
                    m.getContract().executeLogin(name, psw);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void responseResult(UserInfo userInfo) {
                getView().getContract().handleResult(userInfo);
            }

        };
    }
}
