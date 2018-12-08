package com.example.arihant.iiitmdirection;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import ir.mirrajabi.searchdialog.SimpleSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.BaseSearchDialogCompat;
import ir.mirrajabi.searchdialog.core.SearchResultListener;
import ir.mirrajabi.searchdialog.core.Searchable;

public class MainActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//    }

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
    
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       // FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        findViewById(R.id.currentlocation).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v) {
                new SimpleSearchDialogCompat(MainActivity.this, "Search...", "Where are you now ?",
                        null, initData(), new SearchResultListener<Searchable>() {
                    @Override
                    public void onSelected(BaseSearchDialogCompat baseSearchDialogCompat, Searchable searchable, int i) {
                        Toast.makeText(MainActivity.this,""+searchable.getTitle(),Toast.LENGTH_SHORT).show();
                        baseSearchDialogCompat.dismiss();

                    }
                }).show();
            }
        });
        findViewById(R.id.destinationlocation).setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View v) {
                new SimpleSearchDialogCompat(MainActivity.this, "Search...", "Where you want to go ?",
                        null, initData(), new SearchResultListener<Searchable>() {
                    @Override
                    public void onSelected(BaseSearchDialogCompat baseSearchDialogCompat, Searchable searchable, int i) {
                        Toast.makeText(MainActivity.this,""+searchable.getTitle(),Toast.LENGTH_SHORT).show();
                        baseSearchDialogCompat.dismiss();

                    }
                }).show();
            }
        });
    }

    private ArrayList<SearchModel> initData() {
        ArrayList<SearchModel> items = new ArrayList<>();
        items.add(new SearchModel("Main Gate "));
        items.add(new SearchModel("Administrative Block"));
        items.add(new SearchModel("Learning Resource Center"));
        items.add(new SearchModel("New Auditorium"));
        items.add(new SearchModel("B-Block/LT-1"));
        items.add(new SearchModel("A-Block"));
        items.add(new SearchModel("C-Block"));
        items.add(new SearchModel("D-Block"));
        items.add(new SearchModel("E-Block"));
        items.add(new SearchModel("F-Block"));
        items.add(new SearchModel("Hospital"));
        items.add(new SearchModel("Sports Complex"));
        return items;
    }
}
