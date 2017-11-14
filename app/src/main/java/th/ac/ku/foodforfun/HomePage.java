package th.ac.ku.foodforfun;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomePage extends Fragment {
    List<FoodInfo> lstAll = new ArrayList<>();
    List<FoodHomeMenuInfo> lstData;
    private GestureDetector gestureDetector;
    public HomePage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment_home_page, container, false);


        lstData = new ArrayList<>();
        lstData.add(new FoodHomeMenuInfo("Breakfast", R.drawable.breakfast_pic));
        lstData.add(new FoodHomeMenuInfo("lunch", R.drawable.lunchpic));


        ListView listView = (ListView) view.findViewById(R.id.listViewPageHome);
        FoodHomeAdapter adapter = new FoodHomeAdapter(getContext(), R.layout.home_item, lstData);

        listView.setAdapter(adapter);

//        gestureDetector = new GestureDetector(HomePage.this, new MyGestureDetector());
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int index = (int) view.getY();

                Log.i("listView", "onItemClick: in onItem");
                Template template = new Template();
                template.setAllData(lstAll);
                Log.i("listView", "onItemClick: " + lstAll.isEmpty());
                template.setSearchFor(lstData.get(index).nameCate);
                Log.i("listView", "onItemClick: " + lstData.get(index).nameCate);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, template, "fragment1");
                fragmentTransaction.commit();
            }
        });

        return view;
    }

    class MyGestureDetector extends GestureDetector.SimpleOnGestureListener {

    }
}