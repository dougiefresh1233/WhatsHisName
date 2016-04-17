package com.example.dougl.whatshisname;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Console;
import java.net.URL;
import java.sql.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.sourceforge.jtds.jdbc.*;

import org.json.JSONObject;
import org.w3c.dom.Text;

import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.*;
import java.io.*;



public class MainActivity extends AppCompatActivity {

    EditText searchBar;
    ListView tacts;
    Button searchButton;

    public ArrayList<Person> contacts;

    public Person desired;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToAdd();
            }
        });


        searchBar = (EditText) findViewById(R.id.searchBar);
        tacts = (ListView) findViewById(R.id.conList);
        searchButton = (Button) findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new Button.OnClickListener(){public void onClick(View view){conductSearch();}});
        tacts.clearChoices();
        //getList();
        //TODO Generate list from server
        // new GetSQLData().execute();
    }

    private void conductSearch() {
        if(contacts.size()==0){
            Toast.makeText(getApplication().getBaseContext(),"You have no contacts!",Toast.LENGTH_SHORT).show();
            return;
        }
        String query= (String) searchButton.getText();
        List<String> keywords=Arrays.asList(query.split(" "));
        int maxscore=-1;
        Person bestmatch=contacts.get(0);
        int score;
        Person subject;
        String word;
        for(int contact=0;contact<contacts.size();contact++){
            score=0;
            subject=contacts.get(contact);
            for(int keyword=0;keyword<keywords.size();keyword++){
                word=keywords.get(keyword);
                if(subject.firstname.contains(word)) score++;
                if(subject.lastname.contains(word)) score++;
                if(subject.loca.contains(word)) score++;
                if(subject.description.contains(word)) score++;
            }
            if(score>maxscore){
                maxscore=score;
                bestmatch=subject;
            }
        }
        desired=bestmatch;
        goToView();
    }

    public void getList() {


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);

    }

    private void goToAdd() {
        Intent addAct = new Intent(this, AddActivity.class);
        startActivity(addAct);
    }

    private void goToView() {
        Intent viewAct = new Intent(this, ViewActivity.class);
        viewAct.putExtra("firstname",desired.firstname);
        viewAct.putExtra("lastname",desired.lastname);
        viewAct.putExtra("location",desired.loca);
        viewAct.putExtra("description",desired.description);
        startActivity(viewAct);
    }
/*
    class GetSQLData extends AsyncTask<Void, Void, String> {
        @Override
        protected void onPreExecute() {
            Toast.makeText(getApplicationContext(), "Starting", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected String doInBackground(Void... params) {
            InputStream is = null;
            String result = "";
            JSONObject jArray = null;
            try{
                //HttpURLConnection = httpurl = (HttpURLConnection) URL.openConnection("who-dat-db.cbyst98yimsv.us-west-2.rds.amazonaws.com:3306");


            } catch (Exception e) {
                Log.e("Error connection", "" + Arrays.toString(e.getStackTrace()));
            }
        }


        @Override
        protected void onPostExecute(String s) {
            //test.setText(s);
            Toast.makeText(getApplicationContext(), "Ending", Toast.LENGTH_SHORT).show();


        }
    }*/
}
