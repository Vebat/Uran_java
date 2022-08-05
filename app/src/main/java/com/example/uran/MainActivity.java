package com.example.uran;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.uran.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       setSupportActionBar(binding.appBarMain.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }



    public void manual1clicked(View v) {  //  method for opening windows of manuals by the click on layout.
        switch(v.getId()) {
            case R.id.frameone:
                    Intent intent = new Intent(this, Manualone.class);
                startActivity(intent);
                break;
            default:
                break;
        }
        }
    public void manual2clicked(View v) {
        switch(v.getId()) {
            case R.id.frametwo:
                Intent intent = new Intent(this, Manualtwo.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void manual3clicked(View v) {
        switch(v.getId()) {
            case R.id.framethree:
                Intent intent = new Intent(this, Manualthree.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void manual4clicked(View v) {
        switch(v.getId()) {
            case R.id.framefour:
                Intent intent = new Intent(this, Manualfour.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void manual5clicked(View v) {
        switch(v.getId()) {
            case R.id.framefive:
                Intent intent = new Intent(this, Manualfive.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void manual6clicked(View v) {
        switch(v.getId()) {
            case R.id.framesix:
                Intent intent = new Intent(this, Manualsix.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

    public void manual7clicked(View v) {
        switch(v.getId()) {
            case R.id.frameseven:
                Intent intent = new Intent(this, Manualseven.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
    public void manual8clicked(View v) {
        switch(v.getId()) {
            case R.id.frameeight:
                Intent intent = new Intent(this, Manualeight.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }


    public void channelclicked(View view) {


    }

    public void cardclicked(View view) {
       android.content.ClipboardManager clipboardManager = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);

        String number="5228600586359368";
        ClipData clipData = ClipData.newPlainText("number",number);

        Toast toast = Toast.makeText(getApplicationContext(),
                "Номер карты скопирован",
                Toast.LENGTH_SHORT);
        toast.show();
    }


}

