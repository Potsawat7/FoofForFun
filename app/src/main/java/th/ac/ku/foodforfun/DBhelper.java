package th.ac.ku.foodforfun;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Admin on 11/14/2017.
 */

public class DBhelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "test.db";
    private static final int DB_VERSION = 1;

    public DBhelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE \"FoodDB\" ( `name` TEXT, `category` TEXT, `recipe` TEXT, `steps` TEXT, `imageName` TEXT )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
