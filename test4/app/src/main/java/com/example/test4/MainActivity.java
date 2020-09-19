package com.example.test4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String MyFileName = "fileDemo.txt";

        Button btWrite = (Button)findViewById(R.id.bt1);
        btWrite.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                OutputStream out = null;
                try{
                    FileOutputStream fileOutputStream = openFileOutput(MyFileName,MODE_PRIVATE);
                    out = new BufferedOutputStream(fileOutputStream);
                    String content = "学号：2018011320,姓名：吴佳泽";
                    try {
                        out.write(content.getBytes(StandardCharsets.UTF_8));
                    } finally {
                        if(out!=null)
                            out.close();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });

        //读取文件中的数据
        Button btRead2 = (Button)findViewById(R.id.bt2);
        btRead2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputStream in = null;
                try {
                    FileInputStream fileInputStream = openFileInput(MyFileName);
                    in = new BufferedInputStream(fileInputStream);
                    BufferedReader reader = new BufferedReader (new InputStreamReader(in));   //解决中文乱码问题
                    //之所以用BufferedReader,而不是直接用BufferedInputStream读取,是因为BufferedInputStream是InputStream的间接子类,
                    //InputStream的read方法读取的是一个byte,而一个中文占两个byte,所以可能会出现读到半个汉字的情况,就是乱码.
                    //BufferedReader继承自Reader,该类的read方法读取的是char,所以无论如何不会出现读个半个汉字的.
                    int c;
                    StringBuilder stringBuilder = new StringBuilder("");
                    try {
                        while ((c = reader.read()) != -1) {
                            stringBuilder.append((char) c);
                        }
                        Toast.makeText(MainActivity.this, stringBuilder.toString(), Toast.LENGTH_LONG).show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } finally {
                        if (reader != null)
                            reader.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}