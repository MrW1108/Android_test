# Android_test
# test1   登录对话框
界面有两个按钮，点击时分别弹出提示对话框和登录对话框，其中登录对话框要求用户输入UserId和Password，如果UserId和Password不是“abc”、“123”，则使用Toast提示错误，否则提示成功。

# test2  Activity间来回传递数据
使用Intent将数据传递给指定的Activity，也能够获得Activity返回的数据。
```
Intent intent = new Intent(MainActivity.this,MainActivity2.class);
intent.putExtra("name","wjz");
intent.putExtra("age",20);
startActivity(intent);
```

# test3
