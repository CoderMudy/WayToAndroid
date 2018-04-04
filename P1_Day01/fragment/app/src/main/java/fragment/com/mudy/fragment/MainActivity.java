package fragment.com.mudy.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("mudy","Activity-onCreate");
        setContentView(R.layout.activity_main);



//动态添加
        FirstFragment first = new FirstFragment();

        Bundle bundle = new Bundle();
        bundle.putString("title","fragment");

        first.setArguments(bundle);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.content,first,"first");
        transaction.commit();


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("mudy","Activity-onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("mudy","Activity-onResume");
    }
}
/**  Activity的生命周期
 * 1 onCreate
 * 6 onStart
 * 8 onResume 能够接受用户的事件
 *
 * onPause 可见到不可见
 * onStop 准备开始回收
 * onDestroy
 */


/** fragment的生命周期
 * add
 * 2 onAttached
 * 3 onCreate
 * 4 onCreateView 产生UI
 * 5 onActivityCreated 宿主activity的onCreate方法已经执行完成
 * 7 onStart()
 * 9 onResume()
 * Fragment is active
 */


/** 为什么没有attached？
 Activity-onCreate
 Fragment-onCreate
 Fragment-onCreateView
 Fragment-onActivityCreated
 Activity-onStart
 Fragment-onStart
 Activity-onResume
 Fragment-onResume
 */
