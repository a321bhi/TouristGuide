package com.example.android.touristguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class interestPage extends AppCompatActivity {

    public int max=0;
    public String Place[] = new String[8];
    public String Selection[]= new String [8];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interest_page);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_interest_page, menu);
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
    public void subinterest(View view){
        Place[0]="Swimming Pool";
        Place[1]="trekking";
        Place[2]="paragliding";
        Place[3]="beach";
        Place[4]="adventurous sports";
        Place[5]="national park";
        Place[6]="aquarium";
/*        RadioGroup rg1 = new RadioGroup(this);
        rg1 = (RadioGroup)findViewById(R.id.a1);
        int id= rg1.getCheckedRadioButtonId();
        View radioButton = rg1.findViewById(id);
        int radioId = rg1.indexOfChild(radioButton);
        RadioButton btn = (RadioButton) rg1.getChildAt(radioId);
        Selection[1] = (String) btn.getText();

        rg1 = (RadioGroup)findViewById(R.id.a2);
        id= rg1.getCheckedRadioButtonId();
        radioButton = rg1.findViewById(id);
        radioId = rg1.indexOfChild(radioButton);
        btn = (RadioButton) rg1.getChildAt(radioId);
        Selection[2] = (String) btn.getText();

        rg1 = (RadioGroup)findViewById(R.id.a3);
        id= rg1.getCheckedRadioButtonId();
        radioButton = rg1.findViewById(id);
        radioId = rg1.indexOfChild(radioButton);
        btn = (RadioButton) rg1.getChildAt(radioId);
        Selection[3] = (String) btn.getText();

        rg1 = (RadioGroup)findViewById(R.id.a4);
        id= rg1.getCheckedRadioButtonId();
        radioButton = rg1.findViewById(id);
        radioId = rg1.indexOfChild(radioButton);
        btn = (RadioButton) rg1.getChildAt(radioId);
        Selection[4] = (String) btn.getText();

        rg1 = (RadioGroup)findViewById(R.id.a5);
        id= rg1.getCheckedRadioButtonId();
        radioButton = rg1.findViewById(id);
        radioId = rg1.indexOfChild(radioButton);
        btn = (RadioButton) rg1.getChildAt(radioId);
        Selection[5] = (String) btn.getText();

        rg1 = (RadioGroup)findViewById(R.id.a6);
        id= rg1.getCheckedRadioButtonId();
        radioButton = rg1.findViewById(id);
        radioId = rg1.indexOfChild(radioButton);
        btn = (RadioButton) rg1.getChildAt(radioId);
        Selection[6] = (String) btn.getText();

        rg1 = (RadioGroup)findViewById(R.id.a7);
        id= rg1.getCheckedRadioButtonId();
        radioButton = rg1.findViewById(id);
        radioId = rg1.indexOfChild(radioButton);
        btn = (RadioButton) rg1.getChildAt(radioId);
        Selection[7] = (String) btn.getText();*/
        int i;
        RadioButton rb[] =new RadioButton[7];
        rb[0]= (RadioButton)findViewById(R.id.t1);
        rb[1]= (RadioButton)findViewById(R.id.t2);
        rb[2]= (RadioButton)findViewById(R.id.t3);
        rb[3]= (RadioButton)findViewById(R.id.t4);
        rb[4]= (RadioButton)findViewById(R.id.t5);
        rb[5]= (RadioButton)findViewById(R.id.t6);
        rb[6]= (RadioButton)findViewById(R.id.t7);
        for (i=0;i<7;i++){
            if (rb[i].isChecked()){
                Selection[max] = Place[i];
                max++;
            }
        }
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("MAX",max);
        intent.putExtra("Locations",Selection);
        intent.putExtra("activity", "interest");
        startActivity(intent);
    }
}
