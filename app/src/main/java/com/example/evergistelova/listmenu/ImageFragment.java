package com.example.evergistelova.listmenu;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;


public class ImageFragment extends Fragment implements OnClickListener{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.image_view, container, false);
        Button button = (Button) view.findViewById(R.id.button2);
        button.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button2:
                HomeListFragment hlf = (HomeListFragment) getFragmentManager().findFragmentByTag("home");
                if(hlf ==null)
                    hlf = new HomeListFragment();
                FragmentManager fm  = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.fragment_container, hlf);
                ft.commit();
                break;
        }
    }
}
