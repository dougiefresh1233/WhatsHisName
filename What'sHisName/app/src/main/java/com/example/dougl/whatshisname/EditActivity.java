package com.example.dougl.whatshisname;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity {

    private String name;
    private String description;
    private EditText editName;
    private EditText editDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        editName = (EditText) findViewById(R.id.editName);
        editDescription = (EditText) findViewById(R.id.editDescription);
        Button saveButton = (Button) findViewById(R.id.saveButton);
        //parseData();
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editName.getText().toString();
                description = editDescription.getText().toString();
                //TODO Send stuff to server and *change* other entry
                goBack();
            }
        });
    }

    ///<summary>
    ///Goes back to Main Activity
    ///</summary>
    private void goBack(){
        NavUtils.navigateUpFromSameTask(this);
    }

    ///<summary>
    ///Unpacks passed in intent and updates respective text fields
    ///</summary>
    private void parseData(){
        Intent input = getIntent();
    }
}
