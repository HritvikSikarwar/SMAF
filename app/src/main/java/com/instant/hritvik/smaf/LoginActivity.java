package com.instant.hritvik.smaf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import javax.xml.validation.ValidatorHandler;

public class LoginActivity extends AppCompatActivity {
    //Initialize Variable
    ImageView logo;
    EditText user_name_edittext,password_edittext;
    Button forgot,login,cancle,newuser;
    String username,password;
    SharedPreferences pref ; // 0 - for private mode
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Assign Variable
        forgot = findViewById(R.id.forgot_password_btn);
        login = findViewById(R.id.login_btn);
        cancle = findViewById(R.id.cancle_btn);
        newuser = findViewById(R.id.newuser_btn);
        user_name_edittext=findViewById(R.id.user_name_edittext);
        password_edittext=findViewById(R.id.password_edittext);
        pref = getApplicationContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        editor = pref.edit();

        String user=  pref.getString("user", null); // getting String
        if(user!=null) {

            finish();
            startActivity(new Intent(LoginActivity.this,DashboardActivity.class));
        }




        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username=String.valueOf(user_name_edittext.getText());
                password=String.valueOf(password_edittext.getText());
                login();
                //  startActivity(new Intent(LoginActivity.this,dashboardActivity.class))  ;

            }
        });
        cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,login.getClass()));
            }
        });
        newuser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,NewuserActivity.class));
            }
        });

        forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,ForgotActivity.class));
            }
        });

    }
    public void openfinduserActivity() {
        Intent intent = new Intent(LoginActivity.this, ForgotActivity.class);
        startActivity(intent);
    }

    void login(){
        String URLline = getString(R.string.host)+"login.php";


        StringRequest stringRequest = new StringRequest(Request.Method.POST, URLline,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(!response.equals("User Not Found")) {
                            editor.putString("user", response);
                            editor.commit();
                            finish();
                            startActivity(new Intent(LoginActivity.this, DashboardActivity.class));


                        }else{
                            Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
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
                params.put("password",password);
                params.put("username",username);

                return params;
            }
        };

        // request queue
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        requestQueue.add(stringRequest);

    }

}