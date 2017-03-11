package com.example.android.touristguide;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class HomePage extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
      /*  if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment()).commit();
        }*/
        Intent intent = getIntent();
        String id= intent.getStringExtra("uname");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
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
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() { }
/*
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_display_message,
                    container, false);
            return rootView;
        }*/
    }
    public void interest(View view){
        Intent intent = new Intent(this, interestPage.class);
        startActivity(intent);
    }
    public void openmap(View view){
        //EditText ed1 = (EditText)findViewById(R.id.search);
        //Button button = (Button)findViewById(R.id.search_button);
        //String search = ed1.getText().toString();
        //intent.putExtra("search",search);
        //ed1.setVisibility(View.INVISIBLE);
        //button.setVisibility(View.INVISIBLE);
        //intent.putExtra("activity","homepage");
        Intent intent = new Intent(this,MapsActivity.class);
        intent.putExtra("activity", "location");
        startActivity(intent);
    }
    public void makeVisible(View view){
        EditText ed1 = (EditText)findViewById(R.id.search);
        ed1.setVisibility(View.VISIBLE);
        Button button = (Button)findViewById(R.id.search_button);
        button.setVisibility(View.VISIBLE);
    }
}
