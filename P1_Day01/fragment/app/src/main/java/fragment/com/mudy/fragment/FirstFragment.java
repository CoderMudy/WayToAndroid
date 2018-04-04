package fragment.com.mudy.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by mudy on 18/4/4.
 */
public class FirstFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.v("mudy","Fragment-onCreateView");
        View view = inflater.inflate(R.layout.fragment_first,null);
        Bundle bundle = getArguments();
        String title = bundle.getString("title");

        TextView textView = (TextView)view.findViewById(R.id.textview);
        textView.setText(title);

        return view;
    }

    //代表Fragment和一个Activity开始发生超友谊关系
    @Override
    public void onAttach(Context context) {
        Log.v("mudy","Fragment-onAttach");
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.v("mudy","Fragment-onCreate");
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.v("mudy","Fragment-onStart");
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.v("mudy","Fragment-onActivityCreated");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.v("mudy","Fragment-onResume");
    }
}
