package com.example.a20181cse0433_sqlite;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class selectBy extends Display {
    DataBase dataBase;

    EditText editText;
    Button btn;

    String value433;
    String message433;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_by);

        dataBase = new DataBase(selectBy.this);

        editText = findViewById(R.id.editTextTextPersonName4);
        btn = findViewById(R.id.button10);



        Intent intent433 = getIntent();
        message433 = intent433.getStringExtra("button");
    }

    public void display(View view) {

        value433 = editText.getText().toString();

        if(message433.equals("byName")){
            Cursor res = dataBase.findByName433(value433);
            if(res.getCount() == 0){
               showMessage433("Error","No Data Found!!!");
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
           showMessage433("Data Found By Name "+ value433,stringBuffer433.toString());
        }



        else if(message433.equals("byArrival")){
            Cursor res433 = dataBase.findByArrival433(value433);
            if(res433.getCount() == 0){
                showMessage433("Error","No Data Found!!!");
                return;
            }

            StringBuffer stringBuffer433 = new StringBuffer();
            while (res433.moveToNext()){
                stringBuffer433.append("Name: "+res433.getString(0)+"\n");
                stringBuffer433.append("Mobile Number: "+res433.getString(1)+"\n");
                stringBuffer433.append("Arrival : "+res433.getString(2)+"\n");
                stringBuffer433.append("Destination: "+res433.getString(3)+"\n");
                stringBuffer433.append("Date: "+res433.getString(4)+"\n");
                stringBuffer433.append("Time: "+res433.getString(5)+"\n\n\n");
            }
            showMessage433("Data Found By Arrival "+ value433,stringBuffer433.toString());
        }



        else if(message433.equals("byDestination")){
            Cursor res433 = dataBase.findByDestination433(value433);
            if(res433.getCount() == 0){
                showMessage433("Error","No Data Found!!!");
                return;
            }

            StringBuffer stringBuffer = new StringBuffer();
            while (res433.moveToNext()){
                stringBuffer.append("Name: "+res433.getString(0)+"\n");
                stringBuffer.append("Mobile Number: "+res433.getString(1)+"\n");
                stringBuffer.append("Arrival : "+res433.getString(2)+"\n");
                stringBuffer.append("Destination: "+res433.getString(3)+"\n");
                stringBuffer.append("Date: "+res433.getString(4)+"\n");
                stringBuffer.append("Time: "+res433.getString(5)+"\n\n\n");
            }
           showMessage433("Data Found By Destination "+ value433,stringBuffer.toString());
        }

        else if(message433.equals("byCount")){
            Cursor res433 = dataBase.findByDestination433(value433);
            int count = res433.getCount();
            showMessage433("Total No of Records found for Destination: "+value433, String.valueOf(count));
            return;
        }


    }




    public void intent433(View view) {
        Intent intent433;
        switch (view.getId()){
            case R.id.buttonHome:
                intent433 = new Intent(selectBy.this,MainActivity.class);
                startActivity(intent433);
                break;

            case R.id.buttonPrev:
                intent433 = new Intent(selectBy.this,Display.class);
                startActivity(intent433);
                break;

        }

    }
}