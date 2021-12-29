package com.example.order.activity;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.order.R;

public class LoginActivity extends AppCompatActivity{
    private ShopActivity.MHandler mHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // 设置隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        EditText accountEdit = (EditText) findViewById(R.id.editText1);
        EditText passwordEdit = (EditText) findViewById(R.id.editText2);

        accountEdit.setHint( "账号/手机号/邮箱");
        Button login = (Button) findViewById(R.id.button1);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();

                ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
                progressDialog.setTitle("登录");
                progressDialog.setMessage("加载中...");
                progressDialog.setCancelable(true);
                progressDialog.show();

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressDialog.cancel();
                        // 如果账号是admin，且密码是123456，救人位是登陆成功
                        if(account.equals("08192977") && password.equals("123456")){
                            Intent intent = new Intent(LoginActivity.this, ShopActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "账号不存在", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, 3000);//3秒后执行Runnable中的run方法

            }
        });

    }
}


