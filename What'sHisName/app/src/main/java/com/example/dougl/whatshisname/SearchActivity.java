package com.example.dougl.whatshisname;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchActivity extends AppCompatActivity {

    EditText searchBox;
    TextView showResult;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchBox=(EditText) findViewById(R.id.searchBox);
        showResult=(TextView)findViewById(R.id.showResult);
        searchButton=(Button)findViewById(R.id.searchButton);


    }
}
