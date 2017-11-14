package th.ac.ku.foodforfun;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by Admin on 11/12/2017.
 */

public class FoodTemplateAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<FoodInfo> foodList;
    public FoodTemplateAdapter(Context context, int layout, List<FoodInfo> foodList) {

        this.context = context;
        this.layout = layout;
        this.foodList = foodList;
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int i) {
        return foodList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    static class ViewHolder{
        ImageView imageView;
        TextView textView1, textView2;
        ViewHolder holder;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row = view;
        ViewHolder holder = null;
        if (row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout,null);
            holder = new ViewHolder();
            Log.i("kuy", "getView: in getView " + "Kuyyyyyyy");
            holder.textView1 = (TextView) row.findViewById(R.id.foodNameField);
            holder.textView2 = (TextView) row.findViewById(R.id.catNameField);
            holder.imageView = (ImageView) row.findViewById(R.id.imageView);

            row.setTag(holder);
        }else {
            holder = (ViewHolder) row.getTag();
        }
        FoodInfo foodInfo = foodList.get(i);
        Log.i("food", "getView: foodInfo" + foodInfo.getName());
//        Log.i("txt", "getView: txtView " + holder.textView1);
        holder.textView1.setText(foodInfo.getName());
        holder.textView2.setText(foodInfo.getCategory());
//        Field[] drawables = android.R.drawable.class.getFields();
//        for (Field f : drawables) {
//            if(foodInfo.getImage().equals(f.getName())){
//                holder.imageView.setImageDrawable(Drawable.createFromPath("R.drawable." + f.getName()));
//            }
//        }

//        byte[] foodImage = foodInfo.getImage();
//        Bitmap bitmap = BitmapFactory.decodeByteArray(foodImage, 0,foodImage.length);
//        holder.imageView.setImageBitmap(bitmap);

        return row;
    }
}
