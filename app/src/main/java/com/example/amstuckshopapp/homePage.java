package com.example.amstuckshopapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.ClipData;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class homePage extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Variables
    static final float END_SCALE = 0.7f;
    LinearLayout contentView;
    ImageView menu_icon;

    //Drawer View
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Context context = this;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button logout = findViewById(R.id.logout_button);
        TextView name = findViewById(R.id.name);
        TextView mail = findViewById(R.id.mail);


        //Hooks
        menu_icon = findViewById(R.id.menu_icon);
        contentView = findViewById(R.id.content);

        //Menu Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setCheckedItem(R.id.nav_home);


        navigationDrawer();

        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(this);
        if (signInAccount != null) {
            name.setText(signInAccount.getDisplayName());
            mail.setText(signInAccount.getEmail());
        }


    }

    //Navigation Drawer Functions
    private void navigationDrawer() {
        //Navigation Drawer
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);

        menu_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        animateNavigationDrawer();

    }


    //Navigation Drawer Animation
    private void animateNavigationDrawer() {

        drawerLayout.setScrimColor(getResources().getColor(R.color.animate_colour));
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

                //Scale view based on current slide offset
                final float diffScaledOffSet = slideOffset* (1 - END_SCALE);
                final float offsetScale = 1 - diffScaledOffSet;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);

                //Scale width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaledOffSet / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }


    //Draws back from Navigation Drawer
    @Override
    public void onBackPressed() {

        if(drawerLayout.isDrawerVisible(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else
            super.onBackPressed();
    }


    //Navigation Drawer Handling Menu Click Events
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId())
        {
            case R.id.nav_home:
                showToast("HOME");
                openActivity(homePage.class);
                onBackPressed();
                break;

            case R.id.nav_cart:
                showToast("CART");
                openActivity(Cart.class);
                onBackPressed();
                break;

            case R.id.nav_order:
                showToast("ORDER HISTORY");
                openActivity(OrderHistory.class);
                onBackPressed();
                break;

            case R.id.nav_profile:
                showToast("PROFILE");
                openActivity(Profile.class);
                onBackPressed();
                break;

            case R.id.nav_help:
                showToast("HELP");
                openActivity(Help.class);
                onBackPressed();
                break;

            case R.id.nav_logout:
                onBackPressed2();
                break;

            default:
                return false;
        }
        return true;
    }

    //Message Box for Logout.
    private void onBackPressed2() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to log out?").setCancelable(false).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(getApplicationContext(), SignIn.class);
                startActivity(intent);

            }
        })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    private void showToast(String home) {
        Toast.makeText(context, home, Toast.LENGTH_SHORT).show();
    }

    private void openActivity(Class homePage) {
        startActivity(new Intent(context, homePage));
    }

}