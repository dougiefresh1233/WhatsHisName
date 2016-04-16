package com.example.dougl.whatshisname;

import android.content.Intent;
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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import net.sourceforge.jtds.jdbc.*;




public class MainActivity extends AppCompatActivity {

    TextView searchb;
    ListView tacts;

    public ArrayList<Person> contacts;

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


        searchb = (TextView)findViewById(R.id.searchBar);
        tacts = (ListView)findViewById(R.id.conList);
        tacts.clearChoices();
        //TODO populate tacts from server
        



    }

    public void getList()
    {
        Connection conn = null;
        try{
            String driver = "net.sourceforge.jtds.jdbc.Driver";
            Class.forName(driver).newInstance();

            conn = DriverManager.getConnection("whatshisname.databases.windows.net");
            Statement state1 = conn.createStatement();
            ResultSet re = state1.executeQuery("select * from contacts");

            
        }
        catch(Exception e)
        {
            Log.w("Error connection", "" + e.getMessage());
        }
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

    private void goToAdd(){
        Intent addAct = new Intent(this, AddActivity.class);
        startActivity(addAct);
    }
    private void goToView(){
        Intent viewAct = new Intent(this, ViewActivity.class);
        startActivity(viewAct);
    }
}
