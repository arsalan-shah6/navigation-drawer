package com.app.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
 DrawerLayout drawerLayout;
 Toolbar toolbar;
 NavigationView navigationView;
 ActionBarDrawerToggle actionBarDrawerToggle;

 FragmentManager fragmentManager;
 FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        drawerLayout=findViewById( R.id.drawerlayout );
        toolbar=findViewById( R.id.toolbar );
        navigationView=findViewById( R.id.nevigantion_view );

        setSupportActionBar( toolbar );
        actionBarDrawerToggle=new ActionBarDrawerToggle( this,drawerLayout,toolbar,R.string.open,R.string.close );
        drawerLayout.addDrawerListener( actionBarDrawerToggle );
        actionBarDrawerToggle.setDrawerIndicatorEnabled( true );
        actionBarDrawerToggle.syncState();
        fragmentManager=getSupportFragmentManager();
        fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add( R.id.container_layout,new Fragment() );
        fragmentTransaction.commit();
        navigationView.setNavigationItemSelectedListener( this );




    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                Toast.makeText( this, "tapped", Toast.LENGTH_SHORT ).show();
                drawerLayout.closeDrawer( GravityCompat.START );
                break;

        }

        return true;
    }
}