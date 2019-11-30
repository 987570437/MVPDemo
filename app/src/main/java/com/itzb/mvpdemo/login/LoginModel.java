package com.itzb.mvpdemo.login;

import com.itzb.mvpdemo.base.BaseModel;
import com.itzb.mvpdemo.bean.UserInfo;

public class LoginModel extends BaseModel<LoginPresenter, LoginContract.Model> {


    public LoginModel(LoginPresenter loginPresenter) {
        super(loginPresenter);
    }

    @Override
    protected LoginContract.Model getContract() {
        return new LoginContract.Model() {
            @Override
            public void executeLogin(String name, String psw) throws Exception {
                if ("123".equals(name) && "123".equals(psw)) {
                    p.getContract().responseResult(new UserInfo("123", "123"));
                } else {
                    p.getContract().responseResult(null);
                }
            }
        };
    }
}
