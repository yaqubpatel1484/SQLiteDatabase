package demo.practice.class33_sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class DbUtils {

    private SQLiteDatabase db;
    private String DB_NAME = "myproduct1";
    private final int DB_VERSION = 1;

    private static DbUtils dbUtils = null;

    private DbUtils(Context context) {
        db = new ProductsHelper(context, DB_NAME, null, DB_VERSION).getWritableDatabase();
    }

    public static DbUtils getInstance(Context context) {
        if (dbUtils == null) {
            dbUtils = new DbUtils(context);
        }
        return dbUtils;
    }

    public boolean addProduct(int id, String name, int price) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        contentValues.put("name", name);
        contentValues.put("price", price);

        long rowNum = db.insert("myproducts1", null, contentValues);


        return rowNum != -1;
    }

    public boolean deleteProduct(String id){



       long numRow =  db.delete(
                "myproducts1",
                "id = ?",
                new String[] {id}
        );

        return numRow != -1;
    }


    public ArrayList<ModelProduct> getAllRecord() {

        Cursor cursor = db.query(
                "myproducts1",
                null,
                null,
                null,
                null,
                null,
                "price asc"
        );

        ArrayList<ModelProduct> modelProductsList = new ArrayList<>();

        while (cursor.moveToNext()) {
            modelProductsList.add(new ModelProduct(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getInt(2)
            ));
        }

        cursor.close();
        return modelProductsList;
    }


    public boolean updateRecord(String id){
               ContentValues values = new ContentValues();
       values.put("name","product three");

       long rowNum = db.update(
               "myproducts1",
               values,
               "id =?",
               new String[]{id}
       ) ;

       return rowNum != -1;
    }


}
