package demo.practice.class33_sqlitedemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProductsHelper extends SQLiteOpenHelper {

    public ProductsHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //this onCreate() calls only one time  at the time of object creation
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table myproducts1(id integer primary key,name varchar2(50),price integer not null)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // to add table or upgrade database write query here
    }

    //use to downgrade the version of database
    //less used methods
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
    }
}
