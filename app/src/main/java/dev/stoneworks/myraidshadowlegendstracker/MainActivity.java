package dev.stoneworks.myraidshadowlegendstracker;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import dev.stoneworks.myraidshadowlegendstracker.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String PREFERENCE_FILE = "PrefFileMRSLT";
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        try {
            //Create Database
            SQLiteDatabase dataBase = openOrCreateDatabase("SW_MyRSLT", MODE_PRIVATE, null);

            //Create Table
            dataBase.execSQL("CREATE TABLE IF NOT EXISTS champions (id INT, name VARCHAR, faction VARCHAR, rarity VARCHAR, role VARCHAR, affinity VARCHAR, usability VARCHAR)");

            //Insert Info
            dataBase.execSQL("INSERT INTO champions (id, name, faction, rarity, role, affinity, usability) VALUES (1, 'Lordly Legionary', 'Banner Lords', 'Epic', 'Attack', 'Magic', 'Situational')");
            dataBase.execSQL("INSERT INTO champions (id, name, faction, rarity, role, affinity, usability) VALUES (2, 'Eu', 'Reu Lords', 'Feu', 'Creu', 'Pau', 'HUe')");

            //Retrieve Info
            dataBase.rawQuery()

        } catch (Exception e){
            e.printStackTrace();
        }

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_champions, R.id.nav_equipment, R.id.nav_greathall, R.id.nav_contact, R.id.nav_about)
                .setDrawerLayout(drawer)
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
}