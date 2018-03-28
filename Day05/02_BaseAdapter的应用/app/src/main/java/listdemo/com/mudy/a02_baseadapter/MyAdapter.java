package listdemo.com.mudy.a02_baseadapter;

import android.util.Log;
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

    /**
     *
     * @param position 相当于当前的索引
     * @param convertView 表示的就是缓存view
     * @param parent 表示一个容器 每个itemview里边的容器 返回的View直接添加到容器上
     * @return 就是每一个ItemView要显示的内容
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.v("mudy","convertView=" + convertView + "  position" + position);
        if (convertView == null){
            //LayoutInflater 布局充气的一个类，就是可以将一个布局转换成一个view
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            View view = layoutInflater.inflate(android.R.layout.simple_list_item_checked,null);//如果只有一个textview的话，可以使用安卓提供的这个控件

            convertView = view;
        }else {

        }

        TextView tv = (TextView)convertView.findViewById(android.R.id.text1);
        tv.setText(mDatas.get(position));
        //TextView tv2 = (TextView)view.findViewById(android.R.id.text2);
        //tv2.setText(mDatas.get(position));
        return convertView;
    }
}

/**
 * 每一个view都可以获取context  v.getContext()
 *
 * 通过布局文件直接转换成view  layoutInflater.inflate()
 *
 * 通过某个容器conteiner找到它的子控件: view.findViewById();
 *
 *
 * * 安卓已经帮我们定义好了的一些子项目布局
 * android.R.layout.simple_list_item_checked 有一个对勾的
 *
 * android.R.layout.simple_list_item_2 有子标题的
 *
 *
 *
 *
 */
