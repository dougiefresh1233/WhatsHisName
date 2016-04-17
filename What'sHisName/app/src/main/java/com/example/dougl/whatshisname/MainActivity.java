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

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import net.sourceforge.jtds.jdbc.*;
import org.w3c.dom.Text;



public class MainActivity extends AppCompatActivity {

    TextView searchb;
    ListView tacts;
    TextView test;

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
        //Connection conn = null;

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

    class GetSQLData extends AsyncTask<Void, Void, String> {
        @Override
        protected void onPreExecute() {
            Toast.makeText(getApplicationContext(), "Starting", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected String doInBackground(Void... params) {
            try {
                //String driver = "net.sourceforge.jtds.jdbc.Driver";
                Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
                Connection conn = DriverManager.getConnection("jdbc:sqlserver://whatshisname.database.windows.net;databaseName=whats-his-name;encrypt=false;user=habeebh;password=gig3m@ggie$");
                Statement state1 = conn.createStatement();
                ResultSet re = state1.executeQuery("select * from contacts");

                String test1 = re.getString(2);
                conn.close();

                return test1;
            /**/
                //return "YAAY"  ;
            } catch (Exception e) {
                Log.e("Error connection", "" + Arrays.toString(e.getStackTrace()));
            }

            return "Not working";
        }

        @Override
        protected void onPostExecute(String s) {
            test.setText(s);
            Toast.makeText(getApplicationContext(), "Ending", Toast.LENGTH_SHORT).show();


        }
    }
}
