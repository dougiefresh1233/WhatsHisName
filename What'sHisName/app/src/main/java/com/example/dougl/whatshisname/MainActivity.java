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
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.sun.deploy.net.HttpResponse;
import com.org.apche.http.*;

import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.util.*;
import java.io.*;


import sun.net.www.http.HttpClient;


public class MainActivity extends AppCompatActivity {

    TextView searchb;
    ListView tacts;

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


        searchb = (TextView) findViewById(R.id.searchBar);
        tacts = (ListView) findViewById(R.id.conList);
        test = (TextView) findViewById(R.id.test);
        tacts.clearChoices();
//        getList();
        //TODO Generate list from server
       // new GetSQLData().execute();
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
        startActivity(viewAct);
    }

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
                HttpURLConnection = httpurl = (HttpURLConnection)URL.openConnection("who-dat-db.cbyst98yimsv.us-west-2.rds.amazonaws.com:3306");


            } catch (Exception e) {
                Log.e("Error connection", "" + Arrays.toString(e.getStackTrace()));
            }
        }

        @Override
        protected void onPostExecute(String s) {
            test.setText(s);
            Toast.makeText(getApplicationContext(), "Ending", Toast.LENGTH_SHORT).show();


        }
    }
}
