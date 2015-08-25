package com.androbos.chartr;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterProfileActivity extends Activity {
    private EditText nameSignUp;
    private EditText phoneSignUp;
    private Button lanjutSignUp;
    private String nameSignUptxt;
    private String phoneSignUptxt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_profile);
        nameSignUp = (EditText)findViewById(R.id.usernameSignUp);
        phoneSignUp = (EditText)findViewById(R.id.phoneSignUp);
        lanjutSignUp = (Button)findViewById(R.id.lanjutSignUp);
        lanjutSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nameSignUptxt = nameSignUp.getText().toString();
                phoneSignUptxt = phoneSignUp.getText().toString();
                if (nameSignUptxt.equals("")||phoneSignUptxt.equals("")){
                    Toast.makeText(RegisterProfileActivity.this, "Insert Your phoneNumber and Your yourName", Toast.LENGTH_SHORT).show();
                }else{
                    Intent RegisterPRofile = new Intent(RegisterProfileActivity.this , RegisterAkunActivity.class);
                    RegisterPRofile.putExtra("name", nameSignUptxt);
                    RegisterPRofile.putExtra("phone",phoneSignUptxt);
                    startActivity(RegisterPRofile);
                }


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register_profile, menu);
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
