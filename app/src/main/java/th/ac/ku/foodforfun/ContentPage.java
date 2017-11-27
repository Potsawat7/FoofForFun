package th.ac.ku.foodforfun;


import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContentPage extends Fragment {

    private List<FoodInfo> allLstData = new ArrayList<>();

    private ImageView imgViewContent;
    private TextView contentTextView, contentName;
    private CheckBox checkBox;
    private String contentTo, foodName;
    public ContentPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_content_page, container, false);
        init(view);

        Log.i("in content", "getView: in");
        String allContent="";

        int resID=0;
        for(FoodInfo info: allLstData){
            Log.i("in content", "getView: in loop");
            if(info.getImage().equals(getContentTo())){
                Resources res = this.getResources();
                String mDrawableName = info.getImage();
                Log.i("in content", "getView: imageName " + mDrawableName);
                resID = res.getIdentifier(mDrawableName , "drawable", this.getContext().getPackageName());

                foodName = info.getName().toUpperCase()
                ;
                String[] conLst = info.getRecipe().split(",");
                String[] stepLst = info.getSteps().split(",");
                int i = 1;
                String content = "";
                String steps = "";
                for(String s: conLst){
                    content += i+". " + s +"\n";
                    i++;
                }
                int j = 1;
                for(String s: stepLst){
                    steps += j+". " + s +"\n";
                    j++;
                }

                allContent = "Material" + "\n"
                            + content + "\n"
                            + "Steps" + "\n"
                            + steps;

            }
        }

        imgViewContent.setImageResource(resID);
        contentName.setText(foodName);
        contentTextView.setText(allContent);
        return view;
    }

    private void init(View view) {
        imgViewContent = (ImageView)view.findViewById(R.id.imgViewContent);
        contentTextView = (TextView)view.findViewById(R.id.contentTextView);
        contentName = (TextView)view.findViewById(R.id.contentName);

    }

    public void setAllLstData(List<FoodInfo> allLstData) {
        this.allLstData = allLstData;
    }

    public void setContentTo(String contentFor) {
        this.contentTo = contentFor;
    }
    public String getContentTo() {
        return contentTo;
    }
}
