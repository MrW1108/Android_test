package com.example.test1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //验证登录功能
    public void onButtonClick(final View view) {
        AlertDialog.Builder builder =new AlertDialog.Builder(MainActivity.this);
        final View viewDialog = getLayoutInflater().from(MainActivity.this).inflate(R.layout.customdialog,null,false);
        builder.setTitle("登录对话框").setView(viewDialog).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditText editTextUserId = viewDialog.findViewById(R.id.userID);
                EditText editTextPassword = viewDialog.findViewById(R.id.password);
                if(editTextUserId.getText().toString().equals("abc") && editTextPassword.getText().toString().equals("123"))
                    Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this,"登陆失败",Toast.LENGTH_SHORT).show();
            }
        });
        //显示对话框
        builder.create().show();
    }
}