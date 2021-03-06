package th.ac.ku.foodforfun;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

/**
 * Created by Admin on 11/09/2017.
 */

public class FoodHomeAdapter extends ArrayAdapter<FoodHomeMenuInfo> {
    List<FoodHomeMenuInfo> data;
    public FoodHomeAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List objects) {
        super(context, R.layout.home_item, objects);
        this.data = objects;
    }

    static class DataHolder{
        ImageView iv;
        TextView tv;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DataHolder holder = null;
        if (convertView == null ){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.home_item,null);

            holder = new DataHolder();
            holder.iv = (ImageView)convertView.findViewById(R.id.imageViewHome);
            holder.tv = (TextView) convertView.findViewById(R.id.itemTextField);

            convertView.setTag(holder);
        }else {
            holder = (DataHolder) convertView.getTag();
        }
        FoodHomeMenuInfo foodInfo = data.get(position);
        holder.tv.setText(foodInfo.nameCate);
        holder.iv.setImageResource(foodInfo.resIdImages);
//        holder.iv.setMaxHeight(100);


//        Resources res = getContext().getResources();
//        String mDrawableName = "breakfast_pic";
//        int resID = res.getIdentifier(mDrawableName , "drawable", getContext().getPackageName());
//        Log.d("resId", resID + "");
//        Log.d("resIdImages", foodInfo.resIdImages + "");
//        holder.iv.setImageResource(resID);
//        Drawable drawable = res.getDrawable(resID );
//        holder.iv.setImageDrawable(drawable );


        return convertView;
    }


}
