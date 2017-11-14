//package th.ac.ku.foodforfun;
//
///**
// * Created by Admin on 11/12/2017.
// */
//
//import android.content.Context;
//import android.database.Cursor;
//import android.database.sqlite.SQLiteDatabase;
//import android.database.sqlite.SQLiteOpenHelper;
//import android.util.Log;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DatabaseAccess {
//    private SQLiteOpenHelper openHelper;
//    private SQLiteDatabase database;
//    private static DatabaseAccess instance;
//
//    /**
//     * Private constructor to aboid object creation from outside classes.
//     *
//     * @param context
//     */
//    private DatabaseAccess(Context context) {
//        this.openHelper = new DatabaseOpenHelper(context);
//    }
//
//    /**
//     * Return a singleton instance of DatabaseAccess.
//     *
//     * @param context the Context
//     * @return the instance of DabaseAccess
//     */
//    public static DatabaseAccess getInstance(Context context) {
//        if (instance == null) {
//            instance = new DatabaseAccess(context);
//        }
//        return instance;
//    }
//
//    /**
//     * Open the database connection.
//     */
//    public void open() {
//        this.database = openHelper.getReadableDatabase();
//    }
//
//    /**
//     * Close the database connection.
//     */
//    public void close() {
//        if (database != null) {
//            this.database.close();
//        }
//    }
//
//    /**
//     * Read all quotes from the database.
//     *
//     * @return a List of quotes
//     */
//    public List<FoodInfo> getAllData() {
//
//        List<FoodInfo> list = new ArrayList<>();
//        Cursor cursor = database.rawQuery("SELECT * FROM FoodInfo", null);
//        Log.i("check", "getAllData: cursor  " + cursor.getCount());
//        System.out.println("first " +cursor.moveToFirst());
//        System.out.println("sec " +cursor.moveToNext());
//        if (cursor != null) {
//            cursor.moveToFirst();
//        }
//        while (cursor.moveToFirst()) {
//            do {
//                Log.i("in loop", "getAllData: ");
//                String name = cursor.getString(0);
//                Log.i("Name", "getAllData: " + name);
//                String cate = cursor.getString(1);
//                String rec = cursor.getString(2);
//                String stp = cursor.getString(3);
//                String img = cursor.getString(4);
//                list.add(new FoodInfo(name,cate,rec,stp,img));
//            }while (cursor.moveToNext());
//
//
//        }
//        Log.i("listSize", "getAllData: " + list.size());
//        cursor.close();
//        return list;
//    }
//}