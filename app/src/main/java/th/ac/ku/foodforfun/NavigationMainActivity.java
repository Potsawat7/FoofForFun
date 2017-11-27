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


import java.util.List;

public class NavigationMainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    DBAccess databaseAccess;

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


//        accessDB();
        this.databaseAccess = DBAccess.getInstance(this);
//        insertFood();

//        deleteDB();

        HomePage homePage = new HomePage();
        homePage.lstAll = getDataFromDB();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, homePage,"fragment1");
        fragmentTransaction.commit();

        setFab();
//        connectDatabase();

    }

    private void setFab() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setTitle("HOME");
                HomePage homePage = new HomePage();
                homePage.lstAll = getDataFromDB();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, homePage,"fragment1");
                fragmentTransaction.commit();
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
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
            homePage.lstAll = getDataFromDB();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, homePage,"fragment1");
            fragmentTransaction.commit();
        } else if (id == R.id.nav_breakfast) {
            setTitle("Breakfast");
//            Breakfast breakfast = new Breakfast();
            Template template = new Template();
            template.setSearchFor("Breakfast");
            template.setAllData(getDataFromDB());
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, template,"fragment2");
            fragmentTransaction.commit();
        } else if (id == R.id.nav_lunch) {
            setTitle("Lunch");

            Template template = new Template();
            template.setSearchFor("Lunch");
            template.setAllData(getDataFromDB());
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, template,"fragment2");
            fragmentTransaction.commit();
        } else if (id == R.id.nav_dinner) {
            setTitle("Dinner");
            Template template = new Template();
            template.setSearchFor("Dinner");
            template.setAllData(getDataFromDB());
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, template,"fragment2");
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_grill) {
            setTitle("Grill");

            Template template = new Template();
            template.setSearchFor("Grill");
            template.setAllData(getDataFromDB());
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, template,"fragment2");
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_dessert) {
            setTitle("Dessert");

            Template template = new Template();
            template.setSearchFor("Dessert");
            template.setAllData(getDataFromDB());
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frameLayout, template,"fragment2");
            fragmentTransaction.commit();
        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void insertFood() {
        System.out.println("inserted");
        databaseAccess.open();
        //breakfast
        databaseAccess.insertContact(new FoodInfo("เครปอาหารเช้า","Breakfast",
                "แป้งสาลีอเนกประสงค์ 1/2 ถ้วย," +
                "น้ำตาลทราย 1/2 ช้อนโต๊ะ," + "เกลือป่น 1/4 ช้อนชา," + "นมสด 3/4 ถ้วย," + "ไข่ไก่ 2 ฟอง," + "เนยสดละลาย 1 1/2 ช้อนโต๊ะ," + "แฮมสไลซ์ หรือเบคอน 4-5 แผ่น," + "ไข่ไก่ 4-5 ฟอง," + "พริกไทยป่น เล็กน้อย," + "พาสลีย์หรือผักชีสำหรับแต่ง",
                "ใส่แป้งสาลีอเนกประสงค์ น้ำตาลทราย เกลือป่น นมสด ไข่ไก่ 2 ฟอง และเนยสดละลายลงในเครื่องผสมแป้ง ตีผสมด้วยความเร็วสูง ประมาณ 30 วินาที จากนั้นพักแป้งทิ้งไว้ 15 นาที,นำกระทะเทฟลอนขึ้นตั้งไฟปานกลางค่อนข้างอ่อน ใส่เนยลงไป จากนั้นตักส่วนผสมแป้งใส่ลงในกระทะ กรอกแป้งเป็นแผ่นบาง รอจนแป้งสุกเป็นสีน้ำตาลอ่อน ด้านละประมาณ 1-2 นาที จากนั้นตักขึ้น ทำจนหมด เตรียมไว้,เปิดเตาอบที่อุณหภูมิ 350 องศาฟาเรนไฮต์ เตรียมไว้,นำเครปวางลงบนแผ่นรองอบ วางแฮมสไลซ์ลงตรงกลางของแป้งเครป ตอกไข่ไก่ลงบนแฮม พับมุมแป้งเค้กลงบนไข่ขาวทั้ง 4 มุมเป็นสี่เหลี่ยมจัตุรัส (ใช้ไข่ขาวเป็นตัวยึดแป้ง) โรยเกลือป่น และพริกไทยป่น ทำจนครบ จากนั้นนำเข้าเตาอบ นานประมาณ 10-12 นาที นำออกจากเตา แต่งด้วยพาสลีย์ โรยพริกไทย พร้อมเสิร์ฟ","bk_crep"));
        databaseAccess.insertContact(new FoodInfo("ข้าวต้มกุ้งเวียดนาม","Breakfast","กุ้งแชบ๊วย,น้ำมันงา,เกลือ,น้ำซุปไก่,หอมใหญ่หั่นเสี้ยว,ข้าวสวย,โคนต้นหอมหั่นท่อน,ใบต้นหอมซอย,หอมแดงเจียว,พริกไทยบด","ล้างกุ้ง แกะเปลือก เด็ดหัวไว้หาง แล้วผ่าหลังดึงเส้นดำออก เติมน้ำมันงาและเกลือคลุกเคล้าให้ทั่ว หมักนานประมาณ 15 นาที," +
                "ต้มน้ำซุปในหม้อด้วยไฟกลางจนเดือด ใส่หอมใหญ่ต้มจนสุกใสและน้ำซุปมีรสหวาน จากนั้นตักหอมใหญ่ออก,ใส่ข้าวสวยลงต้มจนน้ำซุปขุ่นขาวเป็นน้ำแป้งเล็กน้อย ปรุงรสด้วยเกลือ,เมื่อเดือดอีกครั้งใส่กุ้ง ต้มพอกุ้งสุกใส่โคนต้นหอม ใบต้นหอม (แบ่งไว้โรยหน้าเล็กน้อย) ปิดไฟ,ตักใส่ถ้วย โรยหอมแดงเจียว ใบต้นหอม และพริกไทย","bk_kaotom"));
        databaseAccess.insertContact(new FoodInfo("แมคมัฟฟิน","Breakfast","ขนมปังอิงลิชมัฟฟิน 1 ชิ้น," +
                "เบคอนม," + "เนยสำหรับทาขนมปัง," + "ไข่ไก่ 1 ฟอง," + "เชดดาร์ชีส 1 แผ่น," + "ผักโขมลวกสุก," + "ผักสดตามชอบ (เช่น มะเขือเทศหั่นแว่น, ผักสลัด)," + "เกลือป่น," + "พริกไทยป่น","นำขนมปังอิงลิชมัฟฟินมาสไลซ์ครึ่งออกเป็น 2 แผ่น ทาเนยตรงด้านที่เป็นรอยผ่าให้ทั่วแผ่น ทาทั้ง 2 แผ่น (ทาปริมาณมาก-น้อย ตามชอบ) พักไว้,ทำไข่ดาว โดยนำกระทะขึ้นตั้งไฟอ่อน ๆ แล้วทาเนยลงไป พอเนยละลายตอกไข่ไก่ลงไปทอดให้สุกตามชอบ ตักขึ้นใส่จาน พักไว้,ทอดเบคอน โดยใส่เนยลงในกระทะใบเดิม รอจนเนยละลายแล้วนำเบคอนลงทอดจนสุกเหลือง ตักขึ้นพักไว้,ปิ้งขนมปังโดยนำขนมปังด้านที่ทาเนยวางลงในกระทะ รอให้เนยละลายและซึมเข้าขนมปัง จากนั้นกลับด้านขนมปังแล้วนำขึ้นไปพักไว้ 1 ชิ้น,ประกอบร่างแมคมัฟฟิน โดยวางผักโขมลวกสุกลงบนขนมปัง ตามด้วยมะเขือเทศ เบคอนทอด และไข่ดาว โรยเกลือป่น และพริกไทยป่นเล็กน้อย จากนั้นวางเชดดาร์ชีสทับลงไป สุดท้ายประกบด้วยขนมปังอิงลิชมัฟฟินอีกหนึ่งแผ่น กดเบา ๆ ตักใส่จาน พร้อมเสิร์ฟ","bk_macmuffin"));
        databaseAccess.insertContact(new FoodInfo("ออมเล็ต","Breakfast","ไข่ไก่ 2 ฟองม,เบคอนหั่นเป็นชิ้นเล็ก ๆ 1 เส้น,เกลือ และพริกไทยดำสำหรับปรุงรส,หอมใหญ่หั่นเต๋าเล็ก 1/2 ลูก,พริกฝรั่งหั่นเต๋า 1/2 ลูก,เนยสด 1 ช้อนโต๊ะ,พาร์มาซานชีสขูดฝอย 10 กรัม"
                ,"ตีผสมไข่ไก่กับเกลือ และพริกไทยดำ,ตั้งกระทะพอร้อน ใส่เนยลงผัดกับเบคอน หอมใหญ่ และพริกฝรั่งจนสุก เทส่วนผสมไข่ลงไป ใช้ไฟปานกลาง คนผสมจนไข่เริ่มสุก ใส่พาร์มาซานชีส กรอกไข่ให้เป็นทรงรี ตักใส่จาน เสิร์ฟคู่กับซอสมะเขือเทศ ขนมปัง ชา หรือกาแฟ","bk_omlet"));
        //lunch
        databaseAccess.insertContact(new FoodInfo("ปลาดอร์ลี่ทอดยำผักชี","Lunch","เนื้อปลาดอร์ลี่    300 กรัม," +
                "ผักชีซอย    1/2 ถ้วยตวง," +
                "พริกสดสีแดงโขลก    7 เม็ด," +
                "หอมแดงซอย    1/4 ถ้วยตวง," +
                "น้ำมะนาว    2 1/2 ช้อนโต๊ะ," +
                "น้ำตาลทราย    1 ช้อนโต๊ะ," +
                "น้ำปลา    1 1/2 ช้อนโต๊ะ," +
                "ไข่ไก่    1 ฟอง," +
                "แป้งสาลีอเนกประสงค์สำหรับคลุก," +
                "เกล็ดขนมปังสำหรับคลุก," +
                "น้ำมันพืชสำหรับทอด","ผสมพริกสด น้ำมะนาว น้ำตาลทราย น้ำปลา หอมแดง ผักชี คนพอเข้ากันพักไว้,นำเนื้อปลาดอร์ลี่คลุกแป้งสาลี ไข่ไก่ และเกล็ด - ขนมปังให้ทั่ว นำลงทอดในน้ำมันพืชร้อนไฟปาน - กลาง จนสุกเหลืองทั้ง 2 ด้าน ตักขึ้นพักไว้ให้ สะเด็ดน้ำมัน,ใส่เนื้อปลาที่ทอดไว้ในอ่างผสม ราดด้วยน้ำยำที่ ผสมไว้ในข้อที่ 1 คลุกเคล้าให้เข้ากัน ตักใส่ภาชนะ จัดเสิร์ฟ","lun_dolli"));
        databaseAccess.insertContact(new FoodInfo("ไก่อบซอส","Lunch","ปีกไก่    500 กรัม," +
                "ซอสสเต๊กสำเร็จรูป    3 ช้อนโต๊ะ," +
                "เนยสดชนิดเค็ม    1 ช้อนโต๊ะ," +
                "พริกหวานสีเขียว สีแดง สีเหลืองหั่นชิ้น    150 กรัม"
                ,"ผสมปีกไก่ เนยสด ซอสสเต๊ก คลุกเคล้าให้เข้ากัน หมักทิ้งไว้ 20 - 30 นาที,นำปีกไก่ที่หมักได้ที่ใส่ภาชนะ ตามด้วยพริกหวาน นำเข้าอบที่อุณหภูมิ 180 องศาเซลเซียส เวลาประมาณ  20 - 30 นาที หรือจนไก่สุก จัดใส่ภาชนะ จัดเสิร์ฟ","lun_kaiop"));
        databaseAccess.insertContact(new FoodInfo("น้ำพริกปลาทูผักสด","Lunch","ปลาทูนึ่งขนาดกลาง    1 ตัว," +
                "หอมแดงหั่นหยาบ    1/2 ถ้วยตวง," +
                "กระเทียมกลีบเล็ก    1/4 ถ้วยตวง," +
                "พริกสดสีแดง     10 เม็ด,"+ "พริกชี้ฟ้าสีเขียวหั่นท่อนสั้น    2 เม็ด,"+"น้ำปลา    1 ช้อนโต๊ะ,"+"น้ำมะนาว    2 ช้อนโต๊ะ,"+"น้ำตาลทราย    1 1/2 ช้อนชา"
                ,"นำใบตองห่อปลาทู ปิ้งบนเตาไฟจนเหลืองมีกลิ่นหอม แกะเอาแต่เนื้อพักไว้,ใส่หอมแดง กระเทียม พริกสด และพริกชี้ฟ้า ลงในกระทะ คั่วด้วยไฟอ่อนจนสุกเหลือง ตักใส่ครกโขลกให้ละเอียด,ใส่เนื้อปลาทูปิ้งโขลกพอเข้ากัน ปรุงรสด้วย น้ำมะนาว น้ำปลา น้ำตาลทราย คนพอเข้ากัน ตักใส่ภาชนะ จัดเสิร์ฟพร้อมผักสดต่าง ๆ","lun_numprik"));
        databaseAccess.insertContact(new FoodInfo("ปลาย่างเนยปาปริก้า","Lunch","เนื้อปลากะพง (น้ำหนักประมาณ 250 กรัม)    1 ชิ้น," +
                "เนยสดชนิดเค็ม    1 ช้อนโต๊ะ," +
                "มายองเนส    6 ช้อนโต๊ะ," +
                "ปาปริก้า    2  ช้อนชา,"+ "พาร์สเลย์สับหยาบ    1/2 ช้อนชา,"+"น้ำมันพืชเล็กน้อย,"+"เกลือป่นหยาบสำหรับโรย,"+"พริกไทยดำป่นสำหรับโรย"
                ,"ผสมมายองเนส ปาปริก้า พาร์สเลย์ คนพอ เข้ากันพักไว้,ตั้งกระทะใส่น้ำมันพืช นำเนื้อปลากะพงลงกริลล์ โรยเกลือป่น พริกไทยดำ พอทั่ว กริลล์จนปลามี  ลักษณะเหลืองกรอบ,ใส่เนยสดพอละลาย ตักขึ้นใส่ภาชนะ จัดเสิร์ฟ พร้อมซอสมายองเนสปาปริก้า","lun_papika"));
        //Dinner

        databaseAccess.close();

    }

}
