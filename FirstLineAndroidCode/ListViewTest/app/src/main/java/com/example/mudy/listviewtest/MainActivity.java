package com.example.mudy.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;

public class MainActivity extends AppCompatActivity {

//    private String[] data = {"Apple","Banana","Orange","Watermelon","Pear","Mango",
//            "Cherry","Grape","Apple","Banana","Orange","Watermelon","Pear","Mango",
//            "Cherry","Grape"};

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initFruits();//初始化水果数据

        FruitAdapter adapter = new FruitAdapter(MainActivity.this,R.layout.fruit_item,fruitList);

        ListView listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Fruit fruit = fruitList.get(position);
                Toast.makeText(MainActivity.this,fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initFruits() {
        for (int i = 0; i < 6; i++){
            Fruit apple = new Fruit("Apple",R.drawable.apple_pic);
            fruitList.add(apple);

            Fruit banana = new Fruit("Banana",R.drawable.banana_pic);
            fruitList.add(banana);

            Fruit orange = new Fruit("Orange",R.drawable.orange_pic);
            fruitList.add(orange);

            Fruit pear = new Fruit("梨子",R.drawable.pear_dic);
            fruitList.add(pear);

            Fruit waterMalen = new Fruit("西瓜",R.drawable.watermelon_pic);
            fruitList.add(waterMalen);

            Fruit cherry = new Fruit("草莓",R.drawable.cherry_pic);
            fruitList.add(cherry);
        }
    }
}
