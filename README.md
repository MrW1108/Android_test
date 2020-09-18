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
隐式启动AnotherActivity<br>
在隐式启动中，不需要明确指出要启动那个组件，仅是对要启动的组件提出要求，只要满足要求的组件就会被Android启动。<br>
在配置文件中为activity设置<intent-filter>元素来设置要求。action来指定想要执行的动作名称。Category为Intent提供了一个附加的方法来表示组件能够被启动和执行
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
使用intent隐式启动
```
    Intent intent = new Intent();
    intent.setAction("startAnotherActivity");
    startActivity(intent);
```
<br><br>
    
    
# test4  内部存储文件操作
实现向内部存储卡写入学号、姓名等信息并读取、显示这些信息<br>
#### 内部存储
    Android系统允许应用创建仅能自身访问的私有文件，文件保存在设备的内部存储器上，在Android系统下的/data/data/<package name>/files目录中
#### openFileOutput()
    为写入数据做准备而打开文件<br>
    函数语法格式：`public FileOutputStream openFileOutput(String name,int mode)`
#### openFileInput()
    为读取数据做准备而打开文件
    函数语法格式：`public FileInputStream openFileInput(String name,int mode)`
#### 读取文件的一般步骤
    1. 使用openFileInput()获取FileInputStream对象
    2. 通过FileInputStream对象的read()方法读取数据
    3. 关闭FileInputStream对象
#### 向文件写入数据的一般步骤 
    1. 使用openFileOutput()获取FileOutputStream对象
    2. 通过FileOutputStream对象的write()方法读取数据
    3. 关闭FileOutputStream对象
    
# test5 使用Handler处理消息
