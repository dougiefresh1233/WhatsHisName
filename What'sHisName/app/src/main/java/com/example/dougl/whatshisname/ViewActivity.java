package com.example.dougl.whatshisname;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ViewActivity extends AppCompatActivity {

    public List<String> fields;
    public ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToEdit();
            }
        });
        TextView name=(TextView) findViewById(R.id.name);
        TextView location=(TextView) findViewById(R.id.location);
        TextView description=(TextView) findViewById(R.id.description);

        List<String> fields= Arrays.asList("firstname","lastname","location","description");
        populateData(fields);

        name.setText(getField("firstname")+" "+getField("lastname"));
        location.setText(getField("lastname"));
        description.setText(getField("description"));
    }

    private void goToEdit(){
        Intent editScreen = new Intent(this, EditActivity.class);
        startActivity(editScreen);
    }

    void populateData(List<String> fields){
        Bundle extras=getIntent().getExtras();
        for(int i=0;i<fields.size();i++){
            if(extras==null){
                data.add(fields.get(i));
            } else {
                data.add(extras.getString(fields.get(i)));
            }
        }

    }

    String getField(String fieldname){
        if(fields.contains(fieldname)) {
            return data.get(fields.indexOf(fieldname));
        } else {
            Toast.makeText(getApplication().getBaseContext(),"an invalid field was fetched",
                    Toast.LENGTH_LONG).show();
            return null;
        }
    }

}
