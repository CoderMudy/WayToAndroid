package fragment.com.mudy.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by mudy on 18/4/3.
 */
public class FirstFragment extends android.app.Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first,null);

        Bundle bundle = getArguments();
        String title = bundle.getString("title");
        TextView textView = (TextView)view.findViewById(R.id.textView);
        textView.setText(title);

        return view;
    }
}