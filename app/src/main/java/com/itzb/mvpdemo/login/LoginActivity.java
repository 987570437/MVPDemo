package com.itzb.mvpdemo.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itzb.mvpdemo.R;
import com.itzb.mvpdemo.base.BaseView;
import com.itzb.mvpdemo.bean.UserInfo;

public class LoginActivity extends BaseView<LoginPresenter, LoginContract.View> {

    private EditText etCount;
    private EditText etPwd;
    private Button btnLongin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();
        initListener();

    }

    private void initView() {
        etCount = findViewById(R.id.et_count);
        etPwd = findViewById(R.id.et_password);
        btnLongin = findViewById(R.id.btn_login);


    }

    private void initListener() {
        btnLongin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etCount.getText().toString();
                String psw = etPwd.getText().toString();
                p.getContract().requestLogin(name, psw);
            }
        });
    }


    @Override
    public LoginContract.View getContract() {
        return new LoginContract.View<UserInfo>() {
            @Override
            public void handleResult(UserInfo userInfo) {
                if (userInfo != null) {
                    Toast.makeText(LoginActivity.this, userInfo.toString(), Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

    @Override
    public LoginPresenter getPresenter() {
        return new LoginPresenter();
    }
}
