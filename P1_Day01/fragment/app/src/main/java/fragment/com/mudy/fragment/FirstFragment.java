package fragment.com.mudy.fragment;

import android.app.Fragment;
import android.os.Bundle;
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
        View view = inflater.inflate(R.layout.fragment_first,null);
        Bundle bundle = getArguments();
        String title = bundle.getString("title");

        TextView textView = (TextView)view.findViewById(R.id.textview);
        textView.setText(title);

        return view;
    }
}
