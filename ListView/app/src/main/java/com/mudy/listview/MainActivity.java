package com.mudy.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1 UI控件
        ListView listView = (ListView)findViewById(R.id.lv);

        //2 数据
        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0 ;i < 300 ;i++){
            //datas.add(String.valueOf(i));
            datas.add("行"+i);
        }

        //3 数据与控件如何绑定呢  adapter 适配器
        MyAdapter adapter = new MyAdapter(this,datas);

        listView.setAdapter(adapter);


    }
}
