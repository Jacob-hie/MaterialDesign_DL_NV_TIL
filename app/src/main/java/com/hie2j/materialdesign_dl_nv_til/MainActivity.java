package com.hie2j.materialdesign_dl_nv_til;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private TextView tx_content;
    private LinearLayout id_ll_left;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.id_dl_root);
        id_ll_left = findViewById(R.id.id_ll_left);
        tx_content = findViewById(R.id.txt_content);
        navigationView = findViewById(R.id.id_nv_root);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.icon_a:
                        Toast.makeText(MainActivity.this, "about clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.icon_b:
                        Toast.makeText(MainActivity.this, "before clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.icon_c:
                        Toast.makeText(MainActivity.this, "cart clicked", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.icon_d:
                        Toast.makeText(MainActivity.this, "dall clicked", Toast.LENGTH_SHORT).show();
                        break;
                }
                return false;
            }
        });

        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View view, float v) {
                id_ll_left.setRotation(360 * v);
                tx_content.setScaleX(2 * v + 1);
                tx_content.setScaleY(2 * v + 1);
            }

            @Override
            public void onDrawerOpened(@NonNull View view) {

            }

            @Override
            public void onDrawerClosed(@NonNull View view) {

            }

            @Override
            public void onDrawerStateChanged(int i) {

            }
        });

        findViewById(R.id.btn_left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(Gravity.START);
                tx_content.setText("左侧按钮点击");
            }
        });
        findViewById(R.id.btn_openLeft).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.START);
            }
        });
        findViewById(R.id.btn_openRight).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.END);
            }
        });
    }
}
