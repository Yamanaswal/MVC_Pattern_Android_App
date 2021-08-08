package com.yaman.mvc_pattern_android_app.views_and_controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.yaman.mvc_pattern_android_app.R;
import com.yaman.mvc_pattern_android_app.models.MainModel;

import java.util.Observable;
import java.util.Observer;

//View and Controller.
public class MainActivity extends AppCompatActivity implements Observer {

    // Creating object of Model class
    private MainModel mainModel;

    // Creating object of Button class
    private Button Button1;
    private Button Button2;
    private Button Button3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Creating relationship between the observable Model and Activity (Model - View and controller)
        mainModel = new MainModel();
        mainModel.addObserver(this);

        // Assigning button IDs to the objects
        Button1 = findViewById(R.id.button1);
        Button2 = findViewById(R.id.button2);
        Button3 = findViewById(R.id.button3);

        //Model and View Update on Click
        Button1.setOnClickListener(v -> {
            mainModel.setValueAtIndex(0);
        });

        Button2.setOnClickListener(v -> {
            mainModel.setValueAtIndex(1);
        });

        Button3.setOnClickListener(v -> {
            mainModel.setValueAtIndex(2);
        });
        //end

    }

    // This function is to update the view after the values are modified by the model
    @Override
    public void update(Observable o, Object arg) {

        // Changing text of the buttons according to updated values
        Button1.setText("Count: " + mainModel.getValueAtIndex(0));
        Button2.setText("Count: " + mainModel.getValueAtIndex(1));
        Button3.setText("Count: " + mainModel.getValueAtIndex(2));
    }
}