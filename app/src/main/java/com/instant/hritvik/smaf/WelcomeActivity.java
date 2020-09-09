package com.instant.hritvik.smaf;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewPager;
    private int[] layouts ={R.layout.activity_screen_1,R.layout.activity_screen_2,R.layout.activity_screen_3};
    private MypagerAdapter mypagerAdapter;

    private LinearLayout dotslayout;
    private ImageView[] dots;
    private Button btn_next,btn_skip;
    public WelcomeActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (new PrefrenceManager(this).checkpreference())
        {
            loadlogin();
        }

        //to make status bar transparent

        if (Build.VERSION.SDK_INT>19)
        {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
        else {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS) ;
        }

        setContentView(R.layout.activity_welcome);

        viewPager = (ViewPager) findViewById(R.id.View_pager);
        mypagerAdapter = new MypagerAdapter(layouts,this);
        viewPager.setAdapter(mypagerAdapter);
        dotslayout = (LinearLayout)findViewById(R.id.layoutDots);
        btn_next = (Button)findViewById(R.id.btn_next);
        btn_skip = (Button)findViewById(R.id.btn_skip);
        btn_next.setOnClickListener(this);
        btn_skip.setOnClickListener(this);

        createdots(0);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                createdots(position);

                if (position==layouts.length-1)
                {
                    btn_next.setText("Start");
                    btn_skip.setVisibility(View.INVISIBLE);
                }
                else
                {
                    btn_next.setText("Next");
                    btn_skip.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void createdots(int current_position){

        if (dotslayout!=null)
            dotslayout.removeAllViews();
        dots = new ImageView[layouts.length];

        for (int i = 0; i<layouts.length; i++)
        {
            dots[i] = new ImageView(this);
            if (i==current_position){
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.active_dots));
            }
            else{
                dots[i].setImageDrawable(ContextCompat.getDrawable(this,R.drawable.default_dots));
            }

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(4,0,4,0);

            dotslayout.addView(dots[i],params);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn_next:
                loadnextslide();
                break;
            case R.id.btn_skip:
                loadlogin();
                new PrefrenceManager(this).writepreference();
                break;
        }

    }

  private void loadlogin()
    {
        startActivity(new Intent(this,LoginActivity.class));
        finish();
    }

    private void loadnextslide()
    {
        int next_slide = viewPager.getCurrentItem()+1;
        if (next_slide < layouts.length)
        {
            viewPager.setCurrentItem(next_slide);
        }
        else
        {
            loadlogin();
            new PrefrenceManager(this).writepreference();
        }
    }
}
