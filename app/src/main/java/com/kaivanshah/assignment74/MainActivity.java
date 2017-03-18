package com.kaivanshah.assignment74;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBHelper oDBHelper = new DBHelper(this);

        // Reference to TableLayout
        TableLayout tableLayout=(TableLayout)findViewById(R.id.table_layout1);

        TableRow rowHeader = new TableRow(this);
        rowHeader.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
        rowHeader.setBackgroundColor(Color.parseColor("#c0c0c0"));
        String[] headerText={"ID","FNAME","LName"};
        for(String c:headerText) {
            TextView tv = new TextView(this);
            tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 1));
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(18);
            tv.setPadding(5, 5, 5, 5);
            tv.setText(c);
            rowHeader.addView(tv);
        }
        tableLayout.addView(rowHeader);

        ArrayList<SampleCLS> oList= oDBHelper.getAllProducts();

        final int size = oList.size();
        for (int i = 0; i < size; i++)
        {
            SampleCLS oSampleCLS = oList.get(i);
            TableRow TR = new TableRow(this);
            rowHeader.setLayoutParams(new TableLayout.LayoutParams(TableLayout.LayoutParams.MATCH_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
            int nId= oSampleCLS._Id;
            String FName= oSampleCLS._FName;
            String LName= oSampleCLS._LName;
            String[] COlText={nId+"",FName,LName};
            for (String text : COlText) {
                TextView tv = new TextView(this);
                tv.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,
                        TableRow.LayoutParams.WRAP_CONTENT,1));
                tv.setGravity(Gravity.CENTER);
                tv.setTextSize(16);
                tv.setPadding(5, 5, 5, 5);
                tv.setText(text);
                TR.addView(tv);
            }
            tableLayout.addView(TR);
            }







    }
}
