package com.example.a20181cse0433_sqlite;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Display extends AppCompatActivity  {
    Button name433, arr433, dest433, showDatabase433,count433;
    DataBase dataBase433;
    MainActivity mainActivity433;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        dataBase433 = new DataBase(Display.this);
        mainActivity433 = new MainActivity();

        name433 = findViewById(R.id.button2);
        arr433 = findViewById(R.id.button3);
        dest433 = findViewById(R.id.buttonCOUNT);
        showDatabase433 = findViewById(R.id.button1);
        count433 = findViewById(R.id.buttonCOUNT);

    }

    public void showDB433(View view) {
        Cursor res = dataBase433.display433();
        if(res.getCount() == 0){
            showMessage433("Error","No Data Found....");
            return;
        }

        StringBuffer stringBuffer433 = new StringBuffer();
        while (res.moveToNext()){
            stringBuffer433.append("Name: "+res.getString(0)+"\n");
            stringBuffer433.append("Mobile Number: "+res.getString(1)+"\n");
            stringBuffer433.append("Arrival : "+res.getString(2)+"\n");
            stringBuffer433.append("Destination: "+res.getString(3)+"\n");
            stringBuffer433.append("Date: "+res.getString(4)+"\n");
            stringBuffer433.append("Time: "+res.getString(5)+"\n\n\n");
        }
        showMessage433("Data",stringBuffer433.toString());
    }

    public void selectBy433(View view) {

        String message433;
        Intent intent433 = new Intent(Display.this,selectBy.class);

        switch (view.getId()){
            case R.id.button2:
                message433 = "byName";
                intent433.putExtra("button",message433);
                startActivity(intent433);
                break;

            case R.id.button3:
                message433 = "byArrival";
                intent433.putExtra("button",message433);
                startActivity(intent433);
                break;

            case R.id.buttonlOC:
                message433 = "byDestination";
                intent433.putExtra("button",message433);
                startActivity(intent433);
                break;

            case R.id.buttonCOUNT:
                message433 = "byCount";
                intent433.putExtra("button",message433);
                startActivity(intent433);
                break;
        }


    }

    public void showMessage433(String title, String msg){
        AlertDialog.Builder builder433 = new AlertDialog.Builder(this);
        builder433.setCancelable(true);
        builder433.setTitle(title);
        builder433.setMessage(msg);
        builder433.show();
    }

    public void intent433(View view) {
       Intent intent = new Intent(Display.this,MainActivity.class);
        startActivity(intent);
    }


}