package listdemo.com.mudy.a02_baseadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
