package th.ac.ku.foodforfun;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Template extends Fragment {

    GridView gridView;
    FoodTemplateAdapter adapter = null;

    NavigationMainActivity mainActivity;

    private List<FoodInfo> showdataLst;



    private List<FoodInfo> allData = new ArrayList<>();
    private String searchFor ;

    public Template() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_template, container, false);
//
        gridView = (GridView) view.findViewById(R.id.gridView);
//        List<FoodInfo> allData = mainActivity.getDataLst();
        showdataLst = new ArrayList<>();

        adapter = new FoodTemplateAdapter(getContext(),R.layout.template_item,showdataLst);


        for (FoodInfo info: allData) {

            if(info.getCategory().equals(getSearchFor())){
                Log.i("In Template after if", "onCreateView: food cate "+ info.getCategory() + "   search for " + getSearchFor() + "image : " + info.getImage());
                showdataLst.add(info);
            }
        }
        gridView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return view;
    }

    public String getSearchFor() {
        return searchFor;
    }

    public void setSearchFor(String searchFor) {
        this.searchFor = searchFor;
    }
    public List<FoodInfo> getShowdataLst() {
        return showdataLst;
    }

    public void setShowdataLst(List<FoodInfo> showdataLst) {
        this.showdataLst = showdataLst;
    }

    public List<FoodInfo> getAllData() {
        return allData;
    }

    public void setAllData(List<FoodInfo> allData) {
        this.allData = allData;
    }

}
