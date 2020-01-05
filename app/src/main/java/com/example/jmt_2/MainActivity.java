package com.example.jmt_2;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserInfo;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private HomeFragment homeFragment = new HomeFragment();
    private BrowsingFragment browsingFragment = new BrowsingFragment();
    private ReviewFragment reviewFragment = new ReviewFragment();
    private MypageFragment mypageFragment = new MypageFragment();
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.e("test","mainactivity");
        getSupportFragmentManager().beginTransaction().add(R.id.frameLayout, homeFragment).commit();

        bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new NavigationSelectedListener());
        bottomNavigationView.setItemIconTintList(null);





    }



    class NavigationSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, homeFragment).commitAllowingStateLoss();
                    break;
                case R.id.navigation_browsing:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,browsingFragment).commitAllowingStateLoss();
                    break;
                case R.id.navigation_review:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, reviewFragment).commitAllowingStateLoss();
                    break;
                case R.id.navigation_mypage:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, mypageFragment).commitAllowingStateLoss();
                    break;
            }
            return true;
        }
    }
}


