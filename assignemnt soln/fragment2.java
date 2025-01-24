package com.example.fragmentobjectpass;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment2 extends Fragment {

    TextView txt1,txt2,txt3;


    public fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_fragment2, null);

        txt1=v.findViewById(R.id.txt1);
        txt2=v.findViewById(R.id.txt2);
        txt3=v.findViewById(R.id.txt3);


        Bundle bundle=getArguments();

        txt1.setText(String.valueOf(bundle.getString("name")));
        txt2.setText(String.valueOf(bundle.getString("city")));
        txt3.setText(String.valueOf(bundle.getString("course")));


        return v;
    }

}
