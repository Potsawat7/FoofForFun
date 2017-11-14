package th.ac.ku.foodforfun;




import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class NavigationMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DBAccess databaseAccess;
    Template template;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        template = new Template();

//        accessDB();
        this.databaseAccess = DBAccess.getInstance(this);
//        insertFood();
        template.setAllData(getDataFromDB());
//        deleteDB();

        HomePage homePage = new HomePage();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, homePage,"fragment1");
        fragmentTransaction.commit();

//        connectDatabase();

    }

    private void deleteDB() {
        databaseAccess.open();
        databaseAccess.delete();
    }

    private List<FoodInfo> getDataFromDB() {
        databaseAccess.open();
        List<FoodInfo> list = databaseAccess.getAllData();
        databaseAccess.close();
        return list;
    }
    private void insertFood() {
        System.out.println("inserted");
        databaseAccess.open();
        databaseAccess.insertContact(new FoodInfo("padthai","Breakfast","ssss","aaaa","breakfast_pic"));
        databaseAccess.insertContact(new FoodInfo("padJapan","Breakfast","ssss","aaaa","breakfast_pic"));
        databaseAccess.close();

    }

//    private void accessDB() {
//        DBAccess databaseAccess = DBAccess.getInstance(getApplicationContext());
//        databaseAccess.open();
//
//        List<FoodInfo> dataLst =  databaseAccess.getAllData();
//        Log.i("LST", "accessDB: dataLst " + dataLst);
//        template = new Template();
//        template.setAllData(dataLst);
//        databaseAccess.close();
//    }

//    private void connectDatabase() {
//        dataLst = new ArrayList<>();
//        try{
//            Class.forName("org.sqlite.JDBC");
//            String dbURL = "jdbc:sqlite:foodDB.db";
//            Connection conn = DriverManager.getConnection(dbURL);
//            if(conn!=null) {
//                String query = "select * from foodInfo";
//                Statement statement = conn.createStatement();
//                ResultSet resultSet = statement.executeQuery(query);
//
//                while (resultSet.next()){
//                    String name = resultSet.getString(0);
//                    String cate = resultSet.getString(1);
//                    String rec = resultSet.getString(2);
//                    String stp = resultSet.getString(3);
//                    String img = resultSet.getString("imageName");
//                    dataLst.add(new FoodInfo(name,cate,rec,stp,img));
//
//
//                }
//                System.out.println("list size " + dataLst.size());
//            }
//            conn.close();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("ResourceType")
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Home) {
            // Handle the Home action
            setTitle("HOME");
            HomePage homePage = new HomePage();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, homePage,"fragment1");
            fragmentTransaction.commit();
        } else if (id == R.id.nav_breakfast) {
            setTitle("Breakfast");
//            Breakfast breakfast = new Breakfast();

            template.setSearchFor("Breakfast");
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, template,"fragment2");
            fragmentTransaction.commit();
        } else if (id == R.id.nav_lunch) {
            setTitle("Lunch");

//            Template template = new Template();
            template.setSearchFor("Lunch");
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, template,"fragment2");
            fragmentTransaction.commit();
        } else if (id == R.id.nav_dinner) {
            setTitle("Dinner");
//            Template template = new Template();
            template.setSearchFor("Dinner");
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, template,"fragment2");
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_dessert) {
            setTitle("Dessert");

//            Template template = new Template();
            template.setSearchFor("Dessert");
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, template,"fragment5");
            fragmentTransaction.commit();
        }
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
