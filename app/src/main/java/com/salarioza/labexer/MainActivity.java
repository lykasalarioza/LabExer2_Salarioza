package com.salarioza.labexer;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etPassword;
    Button btn_shared;
    Button btn_internal;
    Button btn_nxt;
    FileOutputStream fos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.user);
        etPassword = (EditText) findViewById(R.id.pwd);
        btn_shared = (Button) findViewById(R.id.shared);
        btn_internal = (Button) findViewById(R.id.internal);
        btn_nxt = (Button) findViewById(R.id.nxt);

    }
    public void saveshared (View view){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", etName.getText().toString());
        editor.putString("password", etPassword.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data Saved!", Toast.LENGTH_SHORT).show();
    }
    public void saveinternal (View view) {
        String username = etName.getText().toString();
        String space = ("\r\n");
        String password = etPassword.getText().toString();
        try {
            fos = openFileOutput("output.txt", Context.MODE_PRIVATE);
            fos.write(username.getBytes());
            fos.write(space.getBytes());
            fos.write(password.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "Message saved!", Toast.LENGTH_SHORT).show();
    }
    public void Next (View view){
        Intent intent = new Intent(this, Load.class);
        startActivity(intent);
    }
}
