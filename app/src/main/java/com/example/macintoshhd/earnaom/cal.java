package com.example.macintoshhd.earnaom;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.TextView;



public class cal extends ActionBarActivity {


    StringBuffer expr;
    double mem;
    char recent;

    public void hiscur (View v) {
        if(v.getId()==R.id.currency){
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        if(v.getId()==R.id.history){
            Intent i = new Intent(this, cal.class);
            startActivity(i);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p2);
        expr = new StringBuffer();
        updateExprDisplay();
    }

    public void updateExprDisplay() {
        TextView shownum = (TextView) findViewById(R.id.shownum);
        shownum.setText(expr.toString());

    }

    public void updateAnsDisplay(String s) {
        TextView shownum = (TextView) findViewById(R.id.shownum);
        shownum.setText(s);
    }

    public void equalClicked(View v) {
        expr = new StringBuffer();

        TextView tv = (TextView) findViewById(R.id.shownum);
        String s = tv.getText().toString();
        expr.append(s);
        recalculate();
        updateExprDisplay();

        expr = new StringBuffer();


    }



    public void recalculate() {
        //Calculate the expression and display the output
        //Split expr into numbers and operators

        String e = expr.toString();
        String[] tokens = e.split("((?<=\\+)|(?=\\+))|((?<=\\-)|(?=\\-))|((?<=\\*)|(?=\\*))|((?<=/)|(?=/))");
        if (!tokens[0].equals("")) {

            double result;
            result = Double.parseDouble(tokens[0]);
            for (int i = 1; i < tokens.length - 1; i++) {
                if (tokens[i].equals("+")) {
                    result += Double.parseDouble(tokens[i + 1]);
                } else if (tokens[i].equals("-")) {
                    result -= Double.parseDouble(tokens[i + 1]);
                } else if (tokens[i].equals("*")) {
                    result *= Double.parseDouble(tokens[i + 1]);
                } else if (tokens[i].equals("/")) {
                    result /= Double.parseDouble(tokens[i + 1]);
                }
            }
          expr = new StringBuffer();
            expr.append(result);

        } else {
            updateAnsDisplay(Double.toString(0));
        }
    }




    public void digitClicked(View v) {
        //d = the label of the digit button
        String d = ((TextView) v).getText().toString();
        //append the clicked digit to expr
        expr.append(d);

        //update tvExpr
        updateExprDisplay();


        //calculate the result if possible and update tvAns
        //recalculate();
    }

    public void operatorClicked(View v) {
        //IF the last character in expr is not an operator and expr is not "",
        if (!expr.toString().isEmpty() && !isOperand(expr.charAt(expr.length() - 1))) {
            String d = ((TextView) v).getText().toString();
            //append the clicked digit to expr
           expr.append(d);
            //update tvExpr
            updateExprDisplay();
        }
        //THEN append the clicked operator and updateExprDisplay,
        //ELSE do nothing

    }

    private boolean isOperand(char c) {
        return c == '/' || c == '+' || c == '-' || c == '*';
    }

    public void hkclicked(View v) {
        TextView shownum = (TextView) findViewById(R.id.shownum);
        String s = shownum.getText().toString();
        mem = Double.parseDouble(s)*4.2;

        updateAnsDisplay(Double.toString(mem));
       expr = new StringBuffer();


    }
    public void krclicked(View v) {
        TextView shownum = (TextView) findViewById(R.id.shownum);
        String s = shownum.getText().toString();
        mem = Double.parseDouble(s)*0.03;

        updateAnsDisplay(Double.toString(mem));
        expr = new StringBuffer();


    }
    public void cnlicked(View v) {
        TextView shownum = (TextView) findViewById(R.id.shownum);
        String s = shownum.getText().toString();
        mem = Double.parseDouble(s)*5.22;

        updateAnsDisplay(Double.toString(mem));
        expr = new StringBuffer();

    }
    public void jpclicked(View v) {
        TextView shownum = (TextView) findViewById(R.id.shownum);
        String s = shownum.getText().toString();
        mem = Double.parseDouble(s)*0.27;

        updateAnsDisplay(Double.toString(mem));
        expr = new StringBuffer();

    }





    public void ACClicked(View v) {
        //Clear expr and updateExprDisplay
        expr = new StringBuffer();
        updateExprDisplay();

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
