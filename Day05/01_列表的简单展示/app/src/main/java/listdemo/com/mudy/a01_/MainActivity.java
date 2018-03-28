package listdemo.com.mudy.a01_;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView)findViewById(R.id.lv);
        ArrayList<String> datas = new ArrayList<>();
        for (int i = 0;i < 300;i++){
            datas.add("行"+i);
        }
        MyAdapter adapter = new MyAdapter(datas);
        listView.setAdapter(adapter);
    }
}


/** 使用列表的步骤
 * 1、在布局里创建一个ListView，给一个id
 * 2、获取该列表
 *
 */

