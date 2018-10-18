package com.example.zambo.taskapp.Activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.zambo.taskapp.Fragments.AlertFragment;
import com.example.zambo.taskapp.Fragments.EmailFragment;
import com.example.zambo.taskapp.Fragments.InfoFragment;
import com.example.zambo.taskapp.Fragments.TryFragment;
import com.example.zambo.taskapp.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, CompoundButton.OnCheckedChangeListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar();

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navview);

        setFragmentByDefault();

        navigationView.setNavigationItemSelectedListener(this);

        Switch switchBtn = (Switch) navigationView.getMenu().findItem(R.id.switch_in_nav_options).getActionView();
        switchBtn.setOnCheckedChangeListener(this);

    }

    private void setToolbar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setFragmentByDefault() {
        changeFragment(new EmailFragment(), navigationView.getMenu().getItem(0));
    }

    private void changeFragment(Fragment fragment, MenuItem item) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
        item.setChecked(true);
        getSupportActionBar().setTitle(item.getTitle());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        boolean fragmentTransaction = false;
        Fragment fragment = null;

        switch (item.getItemId()) {

            case R.id.menu_mail:
                fragment = new EmailFragment();
                fragmentTransaction = true;
                break;
            case R.id.menu_alert:
                fragment = new AlertFragment();
                fragmentTransaction = true;
                break;
            case R.id.menu_info:
                fragment = new InfoFragment();
                fragmentTransaction = true;
                break;
            case R.id.menu_try:
                fragment = new TryFragment();
                fragmentTransaction = true;
                break;
        }


        if (fragmentTransaction) {
            changeFragment(fragment, item);
            drawerLayout.closeDrawers();
        }
        return true;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
        if (checked) {
            Toast.makeText(MainActivity.this, "The option is checked", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "The option is unchecked", Toast.LENGTH_SHORT).show();
        }
    }
}
