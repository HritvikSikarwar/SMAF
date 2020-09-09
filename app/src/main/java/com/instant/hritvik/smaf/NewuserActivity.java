package com.instant.hritvik.smaf;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

public class NewuserActivity extends AppCompatActivity {

    ImageView logo;
    TextView regestration_heading,first_name_text,last_name_text,username_text,birthdate_text,mobile_text,password_text;
    EditText first_name_edittext,last_name_edittext,username_edittext,birthdate_edittext,mobile_edittext,password_edittext;
    Button login_btn,cancle_btn,newuser_btn;
    String fname,lname,username,date,password,mobile;
    int year;
    int month;
    int day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newuser);
        first_name_edittext = findViewById(R.id.first_name_edittext);
        last_name_edittext = findViewById(R.id.last_name_edittext);
        username_edittext = findViewById(R.id.username_edittext);
        birthdate_edittext = findViewById(R.id.birthdate_edittext);
        mobile_edittext = findViewById(R.id.mobile_edittext);
        password_edittext = findViewById(R.id.password_edittext);
        newuser_btn=findViewById(R.id.newuser_btn);
        newuser_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fname= String.valueOf(first_name_edittext.getText());
                lname= String.valueOf(last_name_edittext.getText());
                username= String.valueOf(username_edittext.getText());
                date= String.valueOf(birthdate_edittext.getText());
                final Calendar calendar = Calendar.getInstance();
                birthdate_edittext.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        year = calendar.get(Calendar.YEAR);
                        month = calendar.get(Calendar.MONTH);
                        day = calendar.get(Calendar.DAY_OF_MONTH);
                        DatePickerDialog datePickerDialog = new DatePickerDialog(NewuserActivity.this, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                birthdate_edittext.setText(SimpleDateFormat.getDateInstance().format(calendar.getTime()));
                            }
                        }, year,month,day);
                        datePickerDialog.show();
                    }
                });
                password= String.valueOf(password_edittext.getText());
                mobile=String.valueOf(mobile_edittext.getText());
                reg();
            }
        });

    }

    void reg(){
        String URLline = getString(R.string.host)+"Register.php";


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLline,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("200")){
                            startActivity(new Intent(NewuserActivity.this,LoginActivity.class));

                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        //displaying the error in toast if occurrs

                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params=new HashMap<String,String>();
                params.put("fname",fname);
                params.put("lname",lname);
                params.put("mobile",mobile);
                params.put("password",password);
                params.put("date",date);
                params.put("username",username);

                return params;
            }
        };

        // request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);

    }
}