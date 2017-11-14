package th.ac.ku.foodforfun;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 11/14/2017.
 */

public class DBAccess {
    private SQLiteOpenHelper openHelper;
    private SQLiteDatabase database;
    private static DBAccess instance;

    /**
     * Private constructor to aboid object creation from outside classes.
     *
     * @param context
     */
    private DBAccess(Context context) {
        this.openHelper = new DBhelper(context);
    }

    /**
     * Return a singleton instance of DatabaseAccess.
     *
     * @param context the Context
     * @return the instance of DabaseAccess
     */
    public static DBAccess getInstance(Context context) {
        if (instance == null) {
            instance = new DBAccess(context);
        }
        return instance;
    }

    /**
     * Open the database connection.
     */
    public void open() {
        this.database = openHelper.getWritableDatabase();
    }

    /**
     * Close the database connection.
     */
    public void close() {
        if (database != null) {
            this.database.close();
        }
    }
    public void insertContact(FoodInfo foodInfo) {
        ContentValues values = new ContentValues();
        values.put("name", foodInfo.getName());
        values.put("category", foodInfo.getCategory());
        values.put("recipe", foodInfo.getRecipe());
        values.put("steps", foodInfo.getSteps());
        values.put("imageName", foodInfo.getImage());
        database.insert("FoodDB", null, values);
    }
    public List<FoodInfo> getAllData() {

        List<FoodInfo> list = new ArrayList<>();
        Cursor cursor = database.rawQuery("SELECT * FROM FoodDB", null);
        Log.i("check", "getAllData: cursor  " + cursor.getCount());
        System.out.println("first " +cursor.moveToFirst());
        System.out.println("sec " +cursor.moveToNext());

        while (cursor.moveToNext()) {

                Log.i("in loop", "getAllData: ");
                String name = cursor.getString(0);
                Log.i("Name", "getAllData: " + name);
                String cate = cursor.getString(1);
                String rec = cursor.getString(2);
                String stp = cursor.getString(3);
                String img = cursor.getString(4);
                list.add(new FoodInfo(name,cate,rec,stp,img));


        }
        Log.i("listSize", "getAllData: " + list.size());
        cursor.close();
        return list;
    }
    public void delete(){
        database.execSQL("delete from FoodDB");
        database.close();
    }
}
