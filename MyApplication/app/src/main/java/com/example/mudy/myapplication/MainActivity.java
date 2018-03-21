package com.example.mudy.myapplication;

import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.*;

import java.io.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText mPassportEt;
    private EditText mPasswordEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /* 按钮相关
        setContentView(R.layout.layout_relative);

        Button btn1 = (Button) findViewById(R.id.center_btn);
        btn1.setOnClickListener(this);

        Button btn2 = (Button) findViewById(R.id.btn2);
        btn2.setOnClickListener(this);

        Button btn3 = (Button) findViewById(R.id.btn3);
        btn3.setOnClickListener(this);*/


        /*setContentView(R.layout.layout_ui);
        RadioGroup rg = (RadioGroup) findViewById(R.id.radio_group);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {//checkedId 就是你选中的那个的ID
                if (checkedId == R.id.radio_male){
                    Toast.makeText(MainActivity.this,"男",800).show();
                }else {
                    Toast.makeText(MainActivity.this,"女",800).show();
                }
            }
        });*/

        /*
        setContentView(R.layout.layout_ui);
        SeekBar seekbar = (SeekBar)findViewById(R.id.seek_bar);
        */

        /*
        setContentView(R.layout.layout_btn_self);
        EditText text = (EditText) findViewById(R.id.edite_text);

        text.addTextChangedListener(new TextWatcher() {
            TextView tv = (TextView) findViewById(R.id.show_text);
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }


            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tv.setText(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        */

//        DatePicker dp = (DatePicker) findViewById(R.id.datepicker);
//        dp.init(2017, 9, 9, new DatePicker.OnDateChangedListener() {
//            @Override
//            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
//                String showStr = year + "年"+(monthOfYear+1)+"月";
//                Toast.makeText(MainActivity.this,showStr,800).show();
//            }
//        });
//        Log.v("mudy","message");
//        Log.d("mudy","message");
//        Log.i("mudy","message");
//        Log.w("mudy","message");
//        Log.e("mudy","message");
        setContentView(R.layout.qq_layout);
        mPassportEt = (EditText)findViewById(R.id.passport_et);
        mPasswordEt = (EditText)findViewById(R.id.password_et);
//        readData();

        //1、内部存储
//        File dataFile = Environment.getDataDirectory();
//        Log.v("mudy",dataFile.getAbsolutePath());
//        //2、内部存储
//        File extraFile = Environment.getExternalStorageDirectory();
//        Log.v("mudy",extraFile.getAbsolutePath());




    }

    @Override
    public void onClick(View arg0){
        System.out.print(arg0);
        Toast.makeText(this,arg0.getTag().toString(),800).show();
    }

    /*
    * 1、获取两个输入框中的值
    * 2、做一个值的校验 判断不为空
    * 3、模拟一个登录成功
    * 4、保存到手机
    * */
    public void loginClick(View v){
        String passport = mPassportEt.getText().toString();
        String password = mPasswordEt.getText().toString();

        if (TextUtils.isEmpty(passport)||TextUtils.isEmpty(password)){
            Toast.makeText(this,"不可以为空",0).show();
            return;
        }

        //登录成功 保存数据
        saveData(passport,password);
    }

    //保存数据到手机中
    private void saveData(String passport,String password){

//        try {
//            File file = new File("/data/data/com.example.mudy.myapplication/info.txt");
//            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
//            writer.write(passport + "#" + password);
//            writer.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
        // MODE_APPEND 如果一个文件已经有内容了 再次写文件就是在文件后边继续追加
        // MODE_PRIVATE 对其他应用私有化 但是本应用是可读可写的
        // MODE_WORLD_READABLE 任何应用都能读取
        // MODE_WORLD_WRITEABLE 任何应用都能写入

//        try {
//            FileOutputStream fos = openFileOutput("qqinfo.txt",MODE_WORLD_WRITEABLE);
//            //OutputStreamWriter 转换流  对接字符流与字节流
//            BufferedWriter write = new BufferedWriter(new OutputStreamWriter(fos));
//        }catch (FileNotFoundException e){
//            e.printStackTrace();
//        }

        SharedPreferences sp = getSharedPreferences("spinfo.txt",MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("password",password);
        edit.putString("passport",passport);
        edit.commit();
        
    }

    /*
    * 读取文件里面的数据 回显文本
    * */
    private void readData(){
//        File file = new File("/data/data/com.example.mudy.myapplication/info.txt");
//        File file = new File(getCacheDir(),"info.txt"); 对应的是缓存文件夹 清除缓存的时候会删除
//        File file = new File(getFilesDir(),"info.txt");//会新建一个files文件夹 清除数据的时候会删除，并且会同时删除缓存文件夹
//        if(file.exists() && file.length()>0){
//            try{
//                BufferedReader reader = new BufferedReader(new FileReader(file));
//                String line = reader.readLine();
//                if (line.contains("#")){
//                    String[] datas = line.split("#");
//                    mPassportEt.setText(datas[0]);
//                    mPasswordEt.setText(datas[1]);
//                }
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//        }
        SharedPreferences sp = getSharedPreferences("spinfo.txt",MODE_PRIVATE);
        String password = sp.getString("password","null");

    }

}
