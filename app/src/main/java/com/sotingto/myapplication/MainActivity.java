package com.sotingto.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    /*<!-- NavDemo -->*/
    private final String TAG="MainActivity===>";
    private TextView txtOutput;
    private DrawerLayout drawerLayout;
    private NavigationView navView;
    private ActionBarDrawerToggle actionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtOutput = findViewById(R.id.txtOutput);

        // Navigation drawer icon always appear on the action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setNavigationDrawer();

    } //onCreate()

    private void setNavigationDrawer(){
        // drawer layout instance
        drawerLayout = findViewById(R.id.drawerLayout);
        // Toggle the menu icon
        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.nav_open,R.string.nav_close);
        actionBarDrawerToggle.syncState();

        // pass the toggle for the drawer layout listener
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

    } //setNavigationDrawer()

    // override the onOptionsItemSelected() function to implement
    // the item click listener callback to open and close the navigation
    // drawer when the icon is clicked
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Log.d(TAG,"onOptionsItemSelected->" + item.getItemId());

        if (item.getItemId()==R.id.nav_account){
            Log.d(TAG,"onOptionsItemSelected->" + "id=" + R.id.nav_account + "title=" + item.getTitle());
            txtOutput.setText("Account clicked");
        }

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    } //onOptionsItemSelected()

    public void menu1_click(MenuItem m){
        Log.d(TAG,"menu1_click()->" + m.getItemId() + ","+ m.getTitle());
        txtOutput.setText(R.string.msg1);
        txtOutput.setTextColor(Color.RED);
        //drawerLayout.closeDrawers();
    }
    public void menu2_click(MenuItem m){
        Log.d(TAG,"menu2_click()->" + m.getItemId() + ","+ m.getTitle());
        txtOutput.setText(R.string.msg2);
        txtOutput.setTextColor(Color.BLUE);
        //drawerLayout.closeDrawers();
    }
    public void menu3_click(MenuItem m){
        Log.d(TAG,"menu3_click()->" + m.getItemId() + ","+ m.getTitle());
        txtOutput.setText(R.string.msg3);
        txtOutput.setTextColor(Color.GREEN);
        //drawerLayout.closeDrawers();
    }
    public void menu4_click(MenuItem m){
        Log.d(TAG,"menu3_click()->" + m.getItemId() + ","+ m.getTitle());
        txtOutput.setText(R.string.msg4);
        txtOutput.setTextColor(Color.CYAN);
        //drawerLayout.closeDrawers();
    }
    public void close_click(MenuItem m){
        Log.d(TAG,"close_click()->" + m.getItemId() + ","+ m.getTitle());
        drawerLayout.closeDrawers();
    }

    /*<!-- NavDemo -->*/
}