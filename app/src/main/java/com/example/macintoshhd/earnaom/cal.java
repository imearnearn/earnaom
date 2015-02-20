package com.example.macintoshhd.earnaom;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


public class cal extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p2);
    }



    public void buttonClicked (View v){
        TextView tv = (TextView)findViewById(R.id.tvOutput);

        EditText Input = (EditText)findViewById(R.id.Input);
        String s = Input.getText().toString();

        RadioGroup From = (RadioGroup)findViewById(R.id.From);
        RadioGroup To = (RadioGroup)findViewById(R.id.To);

        double curr = Double.parseDouble(s);
        int selFrom = From.getCheckedRadioButtonId();
        int selTo = To.getCheckedRadioButtonId();

        if (selFrom == R.id.FrTHB) { // convert currency from Thai baht 1

            if (selTo == R.id.ToBND){
                double result = ( curr *0.04);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToIDR){
                double result = (curr*395.04);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToKHR){
                double result = (curr*124.56);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToVND){
                double result = (curr*654.95);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToLAK){
                double result = (curr*249);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToMMK){
                double result = (curr*31.71);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToMYR){
                double result = (curr * 0.11);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToPHP){
                double result = (curr*1.36);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToSGD){
                double result = (curr*0.04);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToTHB){
                tv.setText(Double.toString(curr));
            }
        }

        if (selFrom == R.id.FrVND) { // convert currency from VND 2

            if (selTo == R.id.ToBND){
                double result = ( curr *0.000064);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToIDR){
                double result = (curr*0.61);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToKHR){
                double result = (curr*0.2);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToTHB){
                double result = (curr*0.0015);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToLAK){
                double result = (curr*0.4);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToMMK){
                double result = (curr*0.05);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToMYR){
                double result = (curr * 0.0002);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToPHP){
                double result = (curr*0.0021);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToSGD){
                double result = (curr*0.000064);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToVND){
                tv.setText(Double.toString(curr));
            }
        }

        if (selFrom == R.id.FrSGD) { // convert currency from singapore 3

            if (selTo == R.id.ToBND){
                double result = ( curr *1);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToIDR){
                double result = (curr*9475.11);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToKHR){
                double result = (curr*2993.39);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToTHB){
                double result = (curr*23.94);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToLAK){
                double result = (curr*5970.66);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToMMK){
                double result = (curr*758.747);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToVND){
                double result = (curr * 15670.99);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToPHP){
                double result = (curr*32.498);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToMYR){
                double result = (curr*2.668);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToSGD){
                tv.setText(Double.toString(curr));
            }
        }

        if (selFrom == R.id.FrIDR) { // convert currency from IDR 4

            if (selTo == R.id.ToBND){
                double result = ( curr *0.0001);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToTHB){
                double result = (curr*0.0025);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToKHR){
                double result = (curr*0.32);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToVND){
                double result = (curr*1.66);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToLAK){
                double result = (curr*0.63);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToMMK){
                double result = (curr*0.08);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToMYR){
                double result = (curr * 0.00028);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToPHP){
                double result = (curr*0.0034);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToSGD){
                double result = (curr*0.0001);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToIDR){
                tv.setText(Double.toString(curr));
            }
        }

        if (selFrom == R.id.FrLAK) { // convert currency from Lao 5

            if (selTo == R.id.ToBND){
                double result = ( curr *0.00012);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToIDR){
                double result = (curr*1.586);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToKHR){
                double result = (curr*0.5);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToVND){
                double result = (curr*2.62);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToTHB){
                double result = (curr*0.004);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToMMK){
                double result = (curr*0.13);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToMYR){
                double result = (curr *0.00045);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToPHP){
                double result = (curr*0.005);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToSGD){
                double result = (curr*0.0002);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToLAK){
                tv.setText(Double.toString(curr));
            }
        }

        if (selFrom == R.id.FrKHR) { // convert currency from Cambodia 6

            if (selTo == R.id.ToBND){
                double result = ( curr *0.00033);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToIDR){
                double result = (curr*3.16558);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToTHB){
                double result = (curr*0.008);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToVND){
                double result = (curr*5.23);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToLAK){
                double result = (curr*2);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToMMK){
                double result = (curr*0.25);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToMYR){
                double result = (curr * 0.0009);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToPHP){
                double result = (curr*0.01);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToSGD){
                double result = (curr*0.00033);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToKHR){
                tv.setText(Double.toString(curr));
            }
        }

        if (selFrom == R.id.FrMMK) { // convert currency from mmk burmese 7

            if (selTo == R.id.ToBND){
                double result = ( curr *0.0013);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToIDR){
                double result = (curr*12.48);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToKHR){
                double result = (curr*3.5);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToVND){
                double result = (curr*20.66);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToLAK){
                double result = (curr*7.87);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToTHB){
                double result = (curr*0.032);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToMYR){
                double result = (curr * 0.004);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToPHP){
                double result = (curr*0.043);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToSGD){
                double result = (curr*0.0013);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToMMK){
                tv.setText(Double.toString(curr));
            }
        }

        if (selFrom == R.id.FrMYR) { // convert currency from MYR 8

            if (selTo == R.id.ToBND){
                double result = ( curr *0.04);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToIDR){
                double result = (curr*395.04);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToKHR){
                double result = (curr*124.56);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToVND){
                double result = (curr*654.95);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToLAK){
                double result = (curr*249);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToMMK){
                double result = (curr*31.71);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToTHB){
                double result = (curr * 0.11);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToPHP){
                double result = (curr*1.36);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToSGD){
                double result = (curr*0.04);
                tv.setText(Double.toString(result));
            }

            if (selTo == R.id.ToMYR){
                tv.setText(Double.toString(curr));
            }
        }

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
}
