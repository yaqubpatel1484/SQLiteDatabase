package demo.practice.class33_sqlitedemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//     ..................................................................................
//      code for add record
        boolean res = DbUtils.getInstance(this).addProduct(11, "prod6", 1600);
        if (res) {
            Log.e("msg", "added");

        } else {
            Log.e("msg", "not added");
        }



//      ..................................................................................
//      code for delete record
        boolean result = DbUtils.getInstance(this).deleteProduct("101");
        if (result) {
            Log.e("msg", "removed");
        } else {
            Log.e("msg", "not removed");
        }


//       ..................................................................................
//      code for update record

        boolean updateresult = DbUtils.getInstance(this).updateRecord("103");
        if (updateresult) {
            Log.e("msg", "updated");
        } else {
            Log.e("msg", "not updated");
        }


        //       ..................................................................................
//      code for get all records
        ArrayList<ModelProduct> prodList = DbUtils.getInstance(this).getAllRecord();
        for (int i = 0; i < prodList.size(); i++) {
            ModelProduct model = prodList.get(i);
            Log.e("record", model.getId() +" "+ model.getName() +" "+ model.getPrice());

        }

    }
}
