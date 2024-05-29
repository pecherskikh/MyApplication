package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView textViewData;
    Button buttonMy;
    EditText editTextMy;
    ListView listViewInfo;
    ArrayAdapter<String> listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //-------------------------------------------------------------------------------------
        //                      Initialization
        //-------------------------------------------------------------------------------------
        textViewData = findViewById(R.id.textView);
        textViewData.setText("Привет !!!");

        buttonMy = findViewById(R.id.button);
        buttonMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonMyFunction();
            }
        });

        editTextMy = findViewById(R.id.editTextRead);

        listViewInfo = findViewById(R.id.ListView1);

        String[] countries = {"Январь","Февраль","Март","Апрель","Май","Июнь",
                              "Июль","Август","Сентябрь","Октябрь","Ноябрь","Декабрь"};
        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countries);
        listViewInfo.setAdapter(listAdapter);

        listViewInfo.setOnItemClickListener((listAdapter, view, position, id) -> {
            String selectedItem = countries[position];
            editTextMy.setText(selectedItem);
         });
    }
    //----------------------------------------------------------------------------------------
    //                          Function
    //----------------------------------------------------------------------------------------
    public void buttonMyFunction()
    {
        textViewData.setText("У меня всё получится !!!");
        editTextMy.setText("Я уверен");
    }
}