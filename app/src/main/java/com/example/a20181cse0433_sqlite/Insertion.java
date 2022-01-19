package com.example.a20181cse0433_sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class Insertion extends AppCompatActivity {

    DataBase dataBase433;  //new Class Name
    EditText ed1, ed2;
    Spinner sp1, sp2;
    EditText dateEd, timeEd ;
    Button addBtn433, dateBtn433, timeBtn433;

    String name433, mobile433, arrival433, destination433, date433, time433;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertion);

        dataBase433 = new DataBase(Insertion.this);
        ed1 = findViewById(R.id.editTextTextPersonName);
        ed2 = findViewById(R.id.editTextTextPersonName2);
        sp1 = findViewById(R.id.spinner);
        sp2 = findViewById(R.id.spinner2);
        dateEd = findViewById(R.id.editTextDate);
        timeEd = findViewById(R.id.editTextTime);

        addBtn433 = findViewById(R.id.button2);
        dateBtn433 = findViewById(R.id.buttonDate);
        timeBtn433 = findViewById(R.id.buttonTime);


    //Adding Values to Drop Down - Spinner

    ArrayAdapter arr433 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.Arrival));
    ArrayAdapter dest433 = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,getResources().getStringArray(R.array.Destination));


    //For Arrival Drop Down
        arr433.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(arr433);

    //For Destination DropDown
        dest433.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(dest433);


    //Selecting Date
        dateBtn433.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Calendar c = Calendar.getInstance();
            int mYear = c.get(Calendar.YEAR);
            int mMonth = c.get(Calendar.MONTH);
            int mDate = c.get(Calendar.DATE);
            DatePickerDialog datePickerDialog = new DatePickerDialog(Insertion.this, android.R.style.Theme_DeviceDefault_DialogWhenLarge, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    dateEd.setText(dayOfMonth+"/"+(month+1)+"/"+year);
                    dateEd.setText(year+"-"+(month+1)+"-"+dayOfMonth);
                }
            },mYear,mMonth,mDate);
            datePickerDialog.show();

        }
    });

    //Selecting Time
        timeBtn433.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR);
            int min = calendar.get(Calendar.MINUTE);

            TimePickerDialog timePickerDialog = new TimePickerDialog(Insertion.this, android.R.style.Theme_DeviceDefault_Dialog, new TimePickerDialog.OnTimeSetListener() {
                @Override
                public void onTimeSet(TimePicker timePicker, int i, int i1) {
                    timeEd.setText(i+":"+i1);
                }
            },hour,min,true);
            timePickerDialog.show();
        }
    });

    AddData433();

}

    public void AddData433(){
        addBtn433.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name433 = ed1.getText().toString();
                mobile433 = ed2.getText().toString();
                arrival433 = sp1.getSelectedItem().toString();
                destination433 = sp2.getSelectedItem().toString();
                date433 = dateEd.getText().toString();
                time433 = timeEd.getText().toString();

                if(arrival433.equals(destination433)){
                    Toast.makeText(getApplicationContext(), "Arrival & Destination Can't be Same", Toast.LENGTH_SHORT).show();
                }
                else{



                if (name433.equals("") || mobile433.equals("") || date433.equals("") || time433.equals("")) {
                    Toast.makeText(getApplicationContext(), "All Fields Are Mandatory", Toast.LENGTH_SHORT).show();
                } else {
                    boolean isInserted433 = dataBase433.insertData433
                            (
                                    name433,
                                    mobile433,
                                    arrival433,
                                    destination433,
                                    date433,
                                    time433
                            );
                    if (isInserted433)
                        Toast.makeText(Insertion.this, "Data Inserted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(Insertion.this, "Data Not Inserted", Toast.LENGTH_SHORT).show();

                    Intent intent433 = new Intent(Insertion.this, MainActivity.class);
                    startActivity(intent433);
                }
                }
            }
        });
    }
}