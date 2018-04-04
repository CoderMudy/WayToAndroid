package fragment.com.mudy.fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirstFragment first = new FirstFragment();

        Bundle bundle = new Bundle();
        bundle.putString("title","fragment");

        first.setArguments(bundle);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.content,first,"first");
        transaction.commit();

    }
}
/**  Activity的生命周期
 * onCreate
 * onStart
 * onResume 能够接受用户的事件
 * onStop
 * onDestroy
 */


/** fragment的生命周期
 * add
 * onAttached
 * onCreate
 * onCreateView 产生UI
 * onActivityCreated 宿主activity的onCreate方法已经执行完成
 * onStart()
 * onTrsume()
 * Fragment is active
 *
 *
 *
 *
 */
