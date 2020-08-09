package com.example.diustudentsupport;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.example.diustudentsupport.db.DBHandler;
import com.example.diustudentsupport.pojo.TeacherInfo;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigation_page5);

 ////////////////////////////////////////db/////////////////////////////////////////////////////////////////////////////////
        DBHandler db = new DBHandler(this);

        //inserting contacts
        Log.d("Insert: ",  "Inserting ..");
        db.addInfo(new TeacherInfo("Ms. Most. Hasna Hena", "HH", "710001450", "Senior Lecturer", "CSE",
                "FSIT", "http://....", "hena.cse@diu.edu.bd", "01719472885"));


        // reading all contacts
        Log.d("Reading: ", "Reading all conatcts...");
        List<TeacherInfo> teacherInfos = db.getAllInfo();

        for (TeacherInfo tn : teacherInfos){
            String log = "id: " + tn.getID() + ",Name: " + tn.getName()
                    + ",Teacher Initial: " + tn.getTeacherInitial() + ",Employee ID: " + tn.getEmployeeID() + ",Designation: " + tn.getDesignation()
                    + ",Department: " + tn.getDepartment() +  ",Fcaulty: " + tn.getFaculty() + ",Web Page: " + tn.getPWebPage() + ",Email: " + tn.getEmail()
                    + ",Cell Phone No: " + tn.getCellPhone();

            // writing contacts to log
            Log.d("Name: ", log);
        }
//////////////////////////////////////////////////////db end/////////////////////////////////////////////////////////////////
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit(); // to show as home page
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                break;
            case R.id.nav_application:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ApplicationFragment()).commit();
                break;
            case R.id.nav_search_teacher_name:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TeacherNameFragment()).commit();
                break;

            case R.id.nav_search_teacher_initial:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TeacherInitialFragment()).commit();
                break;
            case R.id.nav_course:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CourseFragment()).commit();
                break;
            case R.id.nav_developers:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DevelopersFragment()).commit();
                break;

        }
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }
}
