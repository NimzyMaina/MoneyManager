package com.acenovator.moneymanager;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class DashboardActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        toolbar = (Toolbar) findViewById(R.id.toolbar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);

        // Dashboard Add Expense button
        Button btn_minus = (Button) findViewById(R.id.btn_minus);

        // Dashboard Add Income button
        Button btn_plus = (Button) findViewById(R.id.btn_plus);

        // Dashboard View Income button
        Button btn_income = (Button) findViewById(R.id.btn_income);

        // Dashboard View Expense button
        Button btn_expense = (Button) findViewById(R.id.btn_expense);

        btn_minus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
//                Intent i = new Intent(getApplicationContext(), NewsFeedActivity.class);
//                startActivity(i);
                Context context = getApplicationContext();
                CharSequence text = "You Clicked Add Expenses";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        btn_plus.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
//                Intent i = new Intent(getApplicationContext(), NewsFeedActivity.class);
//                startActivity(i);
                Context context = getApplicationContext();
                CharSequence text = "You Clicked Add Income";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        btn_income.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
//                Intent i = new Intent(getApplicationContext(), NewsFeedActivity.class);
//                startActivity(i);
                Context context = getApplicationContext();
                CharSequence text = "You Clicked View Income";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

        btn_expense.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                // Launching News Feed Screen
//                Intent i = new Intent(getApplicationContext(), NewsFeedActivity.class);
//                startActivity(i);
                Context context = getApplicationContext();
                CharSequence text = "You Clicked View Expenses";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
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
}
