package com.example.evergistelova.listmenu;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ListFragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;


public class HomeListFragment extends ListFragment implements AdapterView.OnItemClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.list_fragment, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.MenuItems, android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        switch (position) {
            case 0:
                ArticleFragment fragment0 = new ArticleFragment();
                ft.replace(R.id.fragment_container, fragment0,"article");
                ft.addToBackStack(null);
                break;
            case 1:
                ImageFragment fragment1 = new ImageFragment();
                ft.replace(R.id.fragment_container, fragment1,"image");
                ft.addToBackStack(null);
                break;
            case 2:
                DrawFragment fragment2 = new DrawFragment();
                ft.replace(R.id.fragment_container, fragment2,"touch");
                ft.addToBackStack(null);
                break;

            case 3:
                HandleSensorFragment fragment3 = new HandleSensorFragment();
                ft.replace(R.id.fragment_container, fragment3,"sensor");
                ft.addToBackStack(null);
                break;
            case 4:
                TextFragment fragment4 = new TextFragment();
                ft.replace(R.id.fragment_container, fragment4,"text");
                ft.addToBackStack(null);
                break;
            case 5 :
                SequenceImageFragment  fragment5 = new SequenceImageFragment ();
                ft.replace(R.id.fragment_container, fragment5,"sequence");
                ft.addToBackStack(null);

        }
        ft.commit();

    }
}
