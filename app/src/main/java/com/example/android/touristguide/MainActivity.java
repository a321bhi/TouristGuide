package com.example.android.touristguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public final static String EXTRA_MESSAGE = "com.example.touristguide.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    public void loginPage(View view) {
        EditText ed1 = (EditText) findViewById(R.id.logininput);
        EditText ed2 = (EditText) findViewById(R.id.passinput);
        MyDB db = new MyDB(this, null, null, 1);
        String passFromDB = db.getPassFromDB(ed1.getText().toString());
        if ((ed1.getText().toString().compareTo("")) != 0) {
            if (ed2.getText().toString().compareTo(passFromDB) == 0) {
                Intent intent = new Intent(this, HomePage.class);
                //  intent.putExtra("uname", ed1.getText().toString());
                startActivity(intent);
            }
     /*   else{
                int time=10;
                Toast.makeText(this, "Wrong password!", time);
            }*/
            //    }
            //}
            //}
        }
    }
    public void registerPage(View view){
        Intent in1 = new Intent(this, RegisterPage.class);
        startActivity(in1);
    }
}
