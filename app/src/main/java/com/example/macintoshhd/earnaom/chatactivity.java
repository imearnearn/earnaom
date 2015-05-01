package com.example.macintoshhd.earnaom;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class chatactivity extends ActionBarActivity implements  Runnable{

    int timestamp = 0;
    ArrayList<Map<String, String>> data;
    SimpleAdapter adapter;
    String name;
    long lastUpdate = 0;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatactivity);
        data = new ArrayList<Map<String, String>>();
        adapter = new SimpleAdapter(this,
                data,
                android.R.layout.simple_list_item_2,
                new String[] {"user", "message"},
                new int[] {android.R.id.text1, android.R.id.text2});
        ListView l = (ListView)findViewById(R.id.listView);
        l.setAdapter(adapter);
        LoadMessageTask task = new LoadMessageTask();
        task.execute();

        handler = new Handler();
        handler.postDelayed(this, 30000);
    }

    @Override
    public void run() {
        LoadMessageTask task = new LoadMessageTask();
        task.execute();
        handler.postDelayed(this,30000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(this);
    }

    public void buttonClicked(View v) {
        EditText etName = (EditText)findViewById(R.id.etName);
        name = etName.getText().toString().trim();
        EditText etDeparture = (EditText)findViewById(R.id.etDeparture);
        String departure = etDeparture.getText().toString().trim();
        EditText etArrival = (EditText)findViewById(R.id.etArrival);
        String arrival = etArrival.getText().toString().trim();
        EditText etCountry = (EditText)findViewById(R.id.etCountry);
        String country = etCountry.getText().toString().trim();
        EditText etExpenses = (EditText)findViewById(R.id.etExpenses);
        String expenses = etExpenses.getText().toString().trim();

        PostMessageTask p = new PostMessageTask();
        p.execute(name,departure,arrival,country,expenses);

    }

    class LoadMessageTask extends AsyncTask<String, Void, Boolean> {

        @Override
        protected Boolean doInBackground(String... params) {
            BufferedReader reader;
            StringBuilder buffer = new StringBuilder();
            String line;

            try {
                Log.e("LoadMessageTask", "" + timestamp);
                URL u = new URL("http://ict.siit.tu.ac.th/~u5522781285/fetch.php?time="
                        + timestamp);
                HttpURLConnection h = (HttpURLConnection)u.openConnection();
                h.setRequestMethod("GET");
                h.setDoInput(true);
                h.connect();

                int response = h.getResponseCode();
                if (response == 200) {
                    reader = new BufferedReader(new InputStreamReader(h.getInputStream()));
                    while((line = reader.readLine()) != null) {
                        buffer.append(line);
                    }

                    Log.e("LoadMessageTask", buffer.toString());
                    //Parsing JSON and displaying messages

                    //To append a new message:
                    //Map<String, String> item = new HashMap<String, String>();
                    //item.put("user", u);
                    //item.put("message", m);
                    //data.add(0, item);
                    JSONObject json = new JSONObject(buffer.toString());
                    boolean res = json.getBoolean("response");
                    String error = json.getString("errmsg");
                    if(res){
                        timestamp = json.getInt("timestamp");
                        JSONArray msg = json.getJSONArray("msg");

                        for (int i=0;i<msg.length();i++){
                            Map<String, String> item = new HashMap<String, String>();
                            JSONObject msgcon = msg.getJSONObject(i);
                            item.put("user","Name : " + " " + msgcon.getString("name") + " " + "Country :" + " " + msgcon.getString("country"));
                            item.put("message","Departure : " +msgcon.getString("departure")+ " "+ "Arrival : " +msgcon.getString("arrival")+
                                    " "+"Expenses : " +msgcon.getString("expenses"));
                            data.add(0,item);
                        }

                        return true;
                    }
                }
            } catch (MalformedURLException e) {
                Log.e("LoadMessageTask", "Invalid URL");
            } catch (IOException e) {
                Log.e("LoadMessageTask", "I/O Exception");
            } catch (JSONException e) {
                Log.e("LoadMessageTask", "Invalid JSON");
            }
            return false;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {
                adapter.notifyDataSetChanged();
                lastUpdate = System.currentTimeMillis();
                Toast t = Toast.makeText(chatactivity.this.getApplicationContext(),
                        "Updated the timeline",
                        Toast.LENGTH_SHORT);
                t.show();
            }
        }
    }

    class PostMessageTask extends AsyncTask<String, Void, Boolean> {
        String line;
        StringBuilder buffer = new StringBuilder();

        @Override
        protected Boolean doInBackground(String... params) {
            String name = params[0];
            String departure = params[1];
            String arrival = params[2];
            String country = params[3];
            String expenses = params[4];
            HttpClient h = new DefaultHttpClient();
            HttpPost p = new HttpPost("http://ict.siit.tu.ac.th/~u5522781285/post.php");

            List<NameValuePair> val = new ArrayList<NameValuePair>();
            val.add(new BasicNameValuePair("name",name));
            val.add(new BasicNameValuePair("departure",departure));
            val.add(new BasicNameValuePair("arrival",arrival));
            val.add(new BasicNameValuePair("country",country));
            val.add(new BasicNameValuePair("expenses",expenses));

            try{

                p.setEntity(new UrlEncodedFormEntity(val));
                HttpResponse response = h.execute(p);
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(response.getEntity().getContent()));
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                JSONObject json = new JSONObject(buffer.toString());
                boolean res = json.getBoolean("response");
                if (res)
                    return true;
                else
                    return false;


            } catch (UnsupportedEncodingException e) {
                Log.e("Error", "Invalid encoding");
            } catch (ClientProtocolException e) {
                Log.e("Error", "Error in posting a message");
            } catch (IOException e) {
                Log.e("Error", "I/O Exception");
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return false;
        }

        @Override
        protected void onPostExecute(Boolean result) {
            if (result) {
                Toast t = Toast.makeText(chatactivity.this.getApplicationContext(),
                        "Successfully post your status",
                        Toast.LENGTH_SHORT);
                t.show();
            }
            else {
                Toast t = Toast.makeText(chatactivity.this.getApplicationContext(),
                        "Unable to post your status",
                        Toast.LENGTH_SHORT);
                t.show();
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chatactivity, menu);
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
