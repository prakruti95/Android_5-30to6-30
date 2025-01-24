package com.example.fragmentobjectpass;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class fragment1 extends Fragment {

    EditText edt1,edt2,edt3;
    Button btn1;



    public fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_fragment1,null);


        edt1=v.findViewById(R.id.edt1);
        edt2=v.findViewById(R.id.edt2);
        edt3=v.findViewById(R.id.edt3);
        btn1=v.findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=edt1.getText().toString();
                String city=edt2.getText().toString();
                String course=edt3.getText().toString();



		fragment2 fragment2=new fragment2();
                FragmentManager fragmentManager=getFragmentManager();
                FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                Bundle bundle=new Bundle();
                bundle.putString("name",name);
                bundle.putString("city",city);
                bundle.putString("cource",course);
                fragment2.setArguments(bundle);

               fragmentTransaction.replace(R.id.frmid,fragment2).commit();
            }
        });


        return v;

    }

}
