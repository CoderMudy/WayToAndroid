package listdemo.com.mudy.a02_baseadapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mudy on 18/3/28.
 * Ctrl + o
 */
public class MyAdapter extends BaseAdapter{
    private ArrayList<String> mDatas;

    public MyAdapter(ArrayList<String> datas) {
        mDatas = datas;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //TextView tv = new TextView(parent.getContext());
        //tv.setLayoutParams(new AbsListView.LayoutParams(-1,-2));
        //tv.setTextSize(15);
        //tv.setText(mDatas.get(position));

        //LayoutInflater 布局充气的一个类，就是可以将一个布局转换成一个view
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.lv_item_layout,null);
        TextView tv = (TextView)view.findViewById(R.id.tv);
        tv.setText(mDatas.get(position));
        return tv;
    }
}

/**
 * 每一个view都可以获取context  v.getContext()
 *
 * 通过布局文件直接转换成view
 *
 */
