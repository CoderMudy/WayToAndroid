package com.mudy.listview;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by mudy on 18/3/28.
 */
public class MyAdapter extends BaseAdapter {

    private  ArrayList<String> mDates;
    private Context mContext;
    public MyAdapter(Context c, ArrayList<String> datas) {
        mDates = datas;
        mContext = c;
    }

    //1、展示几项
    @Override
    public int getCount() {
        return mDates.size();
    }

    /**
     *
     * @param position 表示当前那一项的索引
     * @param convertView
     * @param parent
     * @return 展示的内容
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        String string = mDates.get(position);
        TextView tv = new TextView(mContext);
        tv.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT,AbsListView.LayoutParams.WRAP_CONTENT));
        tv.setText(string);
        tv.setTextSize(15);
        Log.v("mudy","getView"+position);//你滑动的时候，这块会源源不断的打印
        return tv;
    }


    @Override
    public Object getItem(int position) {
        return null;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }
}
