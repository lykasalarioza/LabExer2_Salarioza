package com.salarioza.labexer;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class Load extends AppCompatActivity {


    Button loadint;
    Button loadshared;
    Button btnback;
    Button btnclear;
    TextView tvdisplay;
    FileInputStream fis;
    BufferedReader br;
    String user;
    String pwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);

        loadshared = (Button) findViewById(R.id.load_shared;
        loadint = (Button) findViewById(R.id.load_int);
        btnback = (Button) findViewById(R.id.back);
        btnclear = (Button) findViewById(R.id.clear);
        tvdisplay = (TextView) findViewById(R.id.tv_display);
    }
    public void cleardisp (View view) {
        tvdisplay.setText("");
    }
    public void loadSharedpref (View view) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());;
        String user = preferences.getString("username","");
        String pwd = preferences.getString("password","");
        tvdisplay.setText("The password of " + user + " is " + pwd);
    }
    public void loadIntStore (View view) throws IOException {
        String read = "";
        try{
            fis = openFileInput("output.txt");
            br = new BufferedReader(new InputStreamReader(fis));
            if ((read = br.readLine()) != null)
                user = read;
            if ((read = br.readLine()) != null)
                pwd = read;
            fis.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
        tvdisplay.setText("The password of " + user + " is " + pwd);
    }
}