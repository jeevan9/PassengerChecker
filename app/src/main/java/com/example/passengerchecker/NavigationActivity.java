package com.example.passengerchecker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NavigationActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    EditText ta1;
    public static String selected_date="";


//    Login l1=new Login();
  //  TextView nav_header_name,nav_header_mailid;
    /* public  NavigationActivity(String name,String mailid)
     {
         this.name=name;
         this.mailid=mailid;
     }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
       /* nav_header_name= (TextView) findViewById(R.id.nav_name);
        nav_header_mailid= (TextView) findViewById(R.id.nav_mailid);
        nav_header_name.setText(l1.name);
        nav_header_mailid.setText(l1.emailid);*/

    }
    public void setDate(View v)
    {
        DialogFragment fragment=new DatePickerFragment();
        //DialogFragment fragment1=new TimePickerFragment();
        fragment.show(getSupportFragmentManager(), "Date Picker");
        //fragment1.show(getSupportFragmentManager(), "Time Picker");
    }
    public void getDate(int year, int month,int day)
    {
        EditText t1=(EditText) findViewById(R.id.editText1);
        t1.setText(year+"-"+(month+1)+"-"+day);
    }

public void sub(View v)
{
    ta1= (EditText) findViewById(R.id.editText1);
String sdate=ta1.getText().toString();
    selected_date=sdate;
    //Toast.makeText(this,sdate,Toast.LENGTH_SHORT).show();
    DateVerification d1=new DateVerification(this);

    d1.execute(sdate,Login.logged_in_user);
}

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
    /*
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.navigation, menu);
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

      */
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

         if (id == R.id.chp) {
            Intent i=new Intent(this,PasswordChangeActivity.class);
            startActivity(i);
        }
        else if (id == R.id.fp) {
            Intent i=new Intent(this,PasswordSetActivity.class);
            startActivity(i);
        }
        else if (id == R.id.logout) {
            Intent i=new Intent(this,MainActivity.class);
            startActivity(i);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
