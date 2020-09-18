# Android_test
# test1  登录对话框
界面有两个按钮，点击时分别弹出提示对话框和登录对话框，其中登录对话框要求用户输入UserId和Password，如果UserId和Password不是“abc”、“123”，则使用Toast提示错误，否则提示成功。<br><br>

# test2  Activity间来回传递数据
使用Intent将数据传递给指定的Activity，也能够获得Activity返回的数据。
```
Intent intent = new Intent(MainActivity.this,MainActivity2.class);
intent.putExtra("name","wjz");
intent.putExtra("age",20);
startActivity(intent);
```
<br><br>
# test3  使用Intent隐式启动
Intent隐式启动,掌握<intent-filter>写法，尤其是action,category等元素写法<br><br>
```
<activity android:name=".AnotherActivity">
    <intent-filter>
        <action android:name="startAnotherActivity"/>
        <category android:name="android.intent.category.DEFAULT"/>
    </intent-filter>
</activity>
<activity android:name=".MainActivity">
    <intent-filter>
        <action android:name="android.intent.action.MAIN" />
        <category android:name="android.intent.category.LAUNCHER" />
    </intent-filter>
</activity>
```
<br><br>
# test4  内部存储文件操作
实现向内部存储卡写入学号、姓名等信息并读取、显示这些信息<br>
