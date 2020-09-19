package com.example.test2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();
        final String name = intent.getStringExtra("name");
        final Integer age = intent.getIntExtra("age", 20);
        Toast.makeText(this,name+age,Toast.LENGTH_LONG).show();

        Button button = (Button)findViewById(R.id.avtivity2_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                Intent intent = new Intent(MainActivity2.this,MainActivity.class);
                intent.putExtra("result","姓名:"+name+"年龄:"+age);
                setResult(0,intent);
                finish();
            }
        });

    }
}