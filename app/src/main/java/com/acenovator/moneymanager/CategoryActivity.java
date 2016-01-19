package com.acenovator.moneymanager;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.acenovator.moneymanager.helpers.DatabaseHelper;
import com.acenovator.moneymanager.models.Category;

import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private Toolbar toolbar;
    EditText editText;
    Button save;
    DatabaseHelper db = new DatabaseHelper(this);
    // Spinner element
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        toolbar = (Toolbar) findViewById(R.id.toolbar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        editText = (EditText) findViewById(R.id.category);

        save = (Button) findViewById(R.id.btn_save);

        // Spinner element
        spinner = (Spinner) findViewById(R.id.spinner);

        // Spinner click listener
        //spinner.setOnItemSelectedListener(this);

        // Loading spinner data from database
        loadSpinnerData();


        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            String name = editText.getText().toString();
                String type = "Expenses";
                // Inserting Contacts
                Log.d("Insert: ", "Inserting ..");
                db.addCategory(new Category(name, type));
                Log.d("Saved: ","Category Saved");
                editText.setText("");

                Log.d("Reading: ", "Reading all categories..");
                List<Category> categories = db.getAllCategories();

                for (Category cn : categories) {
                    String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Type: " + cn.getType();
                    // Writing Categories to log
                    Log.d("Name: ", log);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_category, menu);
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

    private void loadSpinnerData() {
        // Spinner Drop down elements
        List<Category> categories = db.getAllCategories();

        // Creating adapter for spinner
        ArrayAdapter<Category> dataAdapter = new ArrayAdapter<Category>(this,
                android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);
    }
}
