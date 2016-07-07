package com.example.youngwind.helloworld.FileStorage;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.youngwind.helloworld.R;

public class SharedPreferencesTest extends Activity {

    private EditText accountEdit;
    private EditText passwordEdit;
    private CheckBox rememberPass;
    private SharedPreferences pref;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences_test);

        accountEdit = (EditText) findViewById(R.id.account);
        passwordEdit = (EditText) findViewById(R.id.password);
        rememberPass = (CheckBox) findViewById(R.id.remember_pass);


        pref = getSharedPreferences("data", MODE_PRIVATE);
        Boolean isRemember = pref.getBoolean("remember_password", false);
        if (isRemember) {
            accountEdit.setText(pref.getString("account", ""));
            passwordEdit.setText(pref.getString("password", ""));
            rememberPass.setChecked(true);
        }

        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();

                if (account.equals("") && password.equals("")) {
                    Toast.makeText(view.getContext(), "账户密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }

                editor = pref.edit();

                // 是否"勾选记住密码"判断
                if (rememberPass.isChecked()) {
                    editor.putBoolean("remember_password", true);
                    editor.putString("account", account);
                    editor.putString("password", password);
                } else {
                    editor.clear();
                }
                editor.commit();
                Toast.makeText(view.getContext(), "请从主页重新进入登录", Toast.LENGTH_SHORT).show();

                finish();
            }
        });
    }
}
