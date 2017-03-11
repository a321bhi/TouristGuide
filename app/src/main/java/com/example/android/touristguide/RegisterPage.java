package com.example.android.touristguide;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class RegisterPage extends AppCompatActivity {
    public static String filename = "MyFirstApp";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register_page, menu);
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
    public void reg(View view ){
        String userName = ((EditText)findViewById(R.id.unameinput)).getText().toString();
        String name = ((EditText)findViewById(R.id.nameinput)).getText().toString();
        String pass = ((EditText)findViewById(R.id.passinput)).getText().toString();
        String mob = ((EditText)findViewById(R.id.mobinput)).getText().toString();
        String email = ((EditText)findViewById(R.id.emailinput)).getText().toString();
        String dob = ((EditText)findViewById(R.id.dobinput)).getText().toString();
//        EditText ed= (EditText)findViewById(R.id.dobinput);
  //      String dob = ed.getText().toString();
        UserCredentials uc= new UserCredentials(name, mob, email, dob, userName, pass);
        MyDB db = new MyDB(this, null, null, 1  );
        db.addUser(uc);
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
