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

public class ViewActivity extends AppCompatActivity {

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
                Intent openeditor = new Intent(ViewActivity.this,EditActivity.class);
                startActivity(openeditor);
            }
        });

        TextView name=(TextView) findViewById(R.id.name);
        TextView location=(TextView) findViewById(R.id.location);
        TextView description=(TextView) findViewById(R.id.description);

        Person toshow=MainActivity.desired;

        name.setText(toshow.firstname+" "+toshow.lastname);
        location.setText(toshow.location);
        description.setText(toshow.descript);



    }

}
