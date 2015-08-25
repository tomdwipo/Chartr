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

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class RegisterAkunActivity extends Activity {
    private EditText emailRegistrasi;
    private EditText passwordRegistrasi;
    private EditText passwordRegistrasiUlang;
    private Button signUpRegistrasi;
    private String emailRegistrasiTxt;
    private String passwordRegistrasiTxt;
    private String passwordRegistrasiUlangTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_akun);
        emailRegistrasi = (EditText)findViewById(R.id.emailRegistrasi);
        passwordRegistrasi = (EditText)findViewById(R.id.passwordRegistrasi);
        passwordRegistrasiUlang = (EditText)findViewById(R.id.passwordRegistrasiUlang);
        signUpRegistrasi = (Button)findViewById(R.id.signUpRegisrasi);

        signUpRegistrasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailRegistrasiTxt = emailRegistrasi.getText().toString();
                passwordRegistrasiUlangTxt = passwordRegistrasiUlang.getText().toString();
                passwordRegistrasiTxt = passwordRegistrasi.getText().toString();
                if (emailRegistrasiTxt.equals("")){
                    Toast.makeText(RegisterAkunActivity.this, "insert Your email", Toast.LENGTH_SHORT).show();
                }
                if (passwordRegistrasiTxt.equals("")){
                    Toast.makeText(RegisterAkunActivity.this, "insert Your Password", Toast.LENGTH_SHORT).show();
                }
                if (passwordRegistrasiUlangTxt.equals("")){
                    Toast.makeText(RegisterAkunActivity.this, "Retype your password", Toast.LENGTH_SHORT).show();
                }
                if (passwordRegistrasiUlangTxt.equals(passwordRegistrasiTxt)){

                    Bundle extras = getIntent().getExtras();
                    if (extras!= null){
                        String name = extras.getString("name");
                        String phone = extras.getString("phone");
                        ParseUser userr = new ParseUser();
                        userr.put("fullname", name);
                        userr.put("phone", phone);

                        userr.setEmail(emailRegistrasiTxt);
                        userr.setUsername(emailRegistrasiTxt);
                        userr.setPassword(passwordRegistrasiTxt);
                        userr.signUpInBackground(new SignUpCallback() {
                            @Override
                            public void done(ParseException e) {
                                if (e == null) {
                                    Toast.makeText(RegisterAkunActivity.this, "Successfully Signed up, please log in.", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(RegisterAkunActivity.this, MainActivity.class);
                                    startActivity(intent);

                                } else {
                                    Toast.makeText(getApplicationContext(),
                                            "Sign up Error", Toast.LENGTH_LONG)
                                            .show();
                                }
                            }
                        });

                    }


                }
                else{
                    Toast.makeText(RegisterAkunActivity.this, "your password not match", Toast.LENGTH_SHORT).show();
                }


            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_register_akun, menu);
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
