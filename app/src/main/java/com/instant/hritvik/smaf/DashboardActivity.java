package com.instant.hritvik.smaf;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentTransaction;

public class DashboardActivity extends AppCompatActivity {
    private static final String url = "https://smassistant.000webhostapp.com/Retrive.php";


    CardView followers_cardview;
    CardView following_cardview;
    CardView posts_cardview;
    CardView topposts_cardview;
    CardView userprofile_cardview;
    CardView about_cardview;


    //Button logout_btn;


    // For Bottom Navigation Drower
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        followers_cardview = findViewById(R.id.followers_cardview);
        following_cardview = findViewById(R.id.following_cardview);
        posts_cardview = findViewById(R.id.posts_cardview);
        topposts_cardview = findViewById(R.id.topposts_cardview);
        userprofile_cardview = findViewById(R.id.userprofile_cardview);
        about_cardview = findViewById(R.id.about_cardview);

        followers_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DashboardActivity.this, followerslistActivity.class));
            }
        });

        following_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        posts_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        topposts_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        userprofile_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        about_cardview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    BottomNavigationView navigationView = findViewById(R.id.bottamnavigationview_dashboard);
    //  logout_btn = findViewById(R.id.logout_btn);

        /*logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alertbox();
            }
        });
*/
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()

    {
        @Override public boolean onNavigationItemSelected (@NonNull MenuItem menuItem){
        int id = menuItem.getItemId();

        if (id == R.id.DashBoard) {
            DashboardFragment fragment = new DashboardFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.framelayout_dashboard, fragment);
            fragmentTransaction.commit();
            return true;
        } else if (id == R.id.Charts) {
            ChartFragment fragment = new ChartFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.framelayout_dashboard, fragment);
            fragmentTransaction.commit();
            return true;
        } else if (id == R.id.OverView) {
            OverviewFragment fragment = new OverviewFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.framelayout_dashboard, fragment);
            fragmentTransaction.commit();
            return true;
        } else {
            return false;
        }
    }
    });

    //Default fragment selection
        navigationView.setSelectedItemId(R.id.DashBoard);

}



    @Override
    public void onBackPressed() {
//        super.onBackPressed();

        alertbox();
    }

    public void alertbox() {

        AlertDialog.Builder alert = new AlertDialog.Builder(DashboardActivity.this);
        alert.setTitle("Information");
        alert.setCancelable(false);
        alert.setMessage("Are you sure you want to close this appllcation");
        alert.setPositiveButton("Exit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        alert.setNeutralButton("Rate", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(DashboardActivity.this, "Rate is Pressed", Toast.LENGTH_SHORT).show();
            }
        });
        alert.show();
    }


}