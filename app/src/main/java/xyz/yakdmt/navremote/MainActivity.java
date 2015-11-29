package xyz.yakdmt.navremote;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.File;

import xyz.yakdmt.navremote.database.Cargo;
import xyz.yakdmt.navremote.database.CargoDao;
import xyz.yakdmt.navremote.database.Checkpoint;
import xyz.yakdmt.navremote.database.CheckpointDao;
import xyz.yakdmt.navremote.database.Client;
import xyz.yakdmt.navremote.database.Comment;
import xyz.yakdmt.navremote.database.Contact;
import xyz.yakdmt.navremote.database.DaoTask;
import xyz.yakdmt.navremote.database.Delivery;
import xyz.yakdmt.navremote.database.Document;
import xyz.yakdmt.navremote.database.Order;
import xyz.yakdmt.navremote.database.OrderDao;
import xyz.yakdmt.navremote.database.Product;
import xyz.yakdmt.navremote.database.RouteRow;
import xyz.yakdmt.navremote.database.Work;
import xyz.yakdmt.navremote.fragments.AllCargoesFragment;
import xyz.yakdmt.navremote.fragments.AllDeliveriesFragment;
import xyz.yakdmt.navremote.fragments.AllOrdersFragment;
import xyz.yakdmt.navremote.tasks.GetFilesTask;
import xyz.yakdmt.navremote.tasks.ParseTask;
import xyz.yakdmt.navremote.utils.Constants;
import xyz.yakdmt.navremote.utils.TextUtil;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ViewPager mViewPager;
    PagerAdapter mPagerAdapter;
    TabLayout mTabLayout;
    Toolbar mToolbar;
    AppBarLayout mAppBar;
    FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mFab = (FloatingActionButton) findViewById(R.id.fab);
        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                try {
                    SchemeParser.getInstance().doParse(MainActivity.this);
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }*/
                openCreateActivity();
            }
        });

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.app_name);
        mAppBar = (AppBarLayout) findViewById(R.id.app_bar);
        setSupportActionBar(mToolbar);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(),
                MainActivity.this));
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position>0) {
                    mFab.hide();
                } else {
                    mFab.show();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (!checkFiles()) {
            refreshData(true);
        }
    }

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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_sync) {
            refreshData(true);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private class MainPagerAdapter extends FragmentStatePagerAdapter {
        final int PAGE_COUNT = 3;
        private String tabTitles[] = new String[] { "Заявки", "Грузы", "Доставки" };
        private Context context;

        public MainPagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return AllOrdersFragment.newInstance(position);
                case 1:
                    return AllCargoesFragment.newInstance(position);
                default:
                    return AllDeliveriesFragment.newInstance(position);
            }
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitles[position];

        }
    }
     public void addTestData() {

         Client client1 = new Client("cl10001");
         Client client2 = new Client("cl10002");
         DaoTask.getInstance().getSession().getClientDao().insertOrReplace(client1);
         DaoTask.getInstance().getSession().getClientDao().insertOrReplace(client2);

         Contact contact1 = new Contact("contac01");
         Contact contact2 = new Contact("contac02");
         DaoTask.getInstance().getSession().getContactDao().insertOrReplace(contact1);
         DaoTask.getInstance().getSession().getContactDao().insertOrReplace(contact2);
         for (int i=0; i<10; i++) {
             Order order = new Order("10000"+String.valueOf(i));
             order.setDate("23/03/2015");
             order.setTime("14:30:23");
             order.setState("не обработана");
             /*
             StringBuilder departureBuilder = new StringBuilder();
             departureBuilder.append(order.getDeparture_country_name());
             departureBuilder.append(", ");
             departureBuilder.append(order.getDeparture_checkpoint_name());
             departureBuilder.append(", ");
             departureBuilder.append(order.getDeparture_checkpoint_address());
             mDeparture.setText(TextUtil.removeNulls(departureBuilder);
             mDateTime.setText(TextUtil.removeNulls(order.getDate() + " " + order.getTime());
             mDeclarant.setText(TextUtil.removeNulls(order.getDeclarant_code());
             StringBuilder arrivalBuilder = new StringBuilder();
             arrivalBuilder.append(order.getDestination_country_name());
             arrivalBuilder.append(", ");
             arrivalBuilder.append(order.getDestination_checkpoint_name());
             arrivalBuilder.append(", ");
             arrivalBuilder.append(order.getDestination_checkpoint_address());
             mArrival.setText(TextUtil.removeNulls(arrivalBuilder);
             mWeight.setText(TextUtil.removeNulls(order.getBrutto_weight() + " кг.");
             mVolume.setText(TextUtil.removeNulls(order.getVolume()+" м^3");
             mCount.setText(TextUtil.removeNulls(order.getCount());
             mClientName.setText(TextUtil.removeNulls(order.getClient_name());
             mCargoDesc.setText(TextUtil.removeNulls(order.getCargo_description());
             mDepartureDate.setText(TextUtil.removeNulls(order.getDeparture_date());
             */
             DaoTask.getInstance().getSession().getOrderDao().insertOrReplace(order);
         }

         for (int i=0; i<10; i++) {
             Cargo cargo = new Cargo("20000"+String.valueOf(i));
             Order order = DaoTask.getInstance()
                     .getSession()
                     .getOrderDao()
                     .queryBuilder()
                     .where(OrderDao.Properties.Id.eq("10000"+String.valueOf(i)))
                     .unique();


             DaoTask.getInstance().getSession().getCargoDao().insertOrReplace(cargo);
         }

         for (int j=0; j<5; j++) {
             Checkpoint checkpoint = new Checkpoint();
             checkpoint.setId("point" + j);
             checkpoint.setName("point" + j);
             DaoTask.getInstance().getSession().getCheckpointDao().insertOrReplace(checkpoint);
         }

         for (int i=0; i<10; i++) {
             Delivery delivery = new Delivery("30000"+String.valueOf(i));
             Cargo cargo = DaoTask.getInstance()
                     .getSession()
                     .getCargoDao()
                     .queryBuilder()
                     .where(CargoDao.Properties.Id.eq("20000"+String.valueOf(i)))
                     .unique();

             for (int j=0; j<5; j++) {
                 RouteRow routeRow = new RouteRow();
                 routeRow.setDelivery_id("30000" + i);
                 routeRow.setString_number(String.valueOf(j));
                 routeRow.setId(routeRow.getDelivery_id()+routeRow.getString_number());
                 routeRow.setPosition(String.valueOf(10 - j));
                 routeRow.setAddress("address");
                 Checkpoint checkpoint = DaoTask.getInstance().getSession().getCheckpointDao().queryBuilder().where(CheckpointDao.Properties.Id.eq("point" + j)).unique();

                 DaoTask.getInstance().getSession().getRouteRowDao().insertOrReplace(routeRow);
             }
             DaoTask.getInstance().getSession().getDeliveryDao().insertOrReplace(delivery);
         }

         for (int i=0; i<10; i++) {
             Work work = new Work(String.valueOf(i));
             work.setCargo_id("20000"+i);
             work.setDelivery_id("30000"+i);

             DaoTask.getInstance().getSession().getWorkDao().insertOrReplace(work);
         }

         for (int i=0; i<10; i++) {
             Comment comment = new Comment(String.valueOf(i));
             comment.setObject_id("20000" + i);

             DaoTask.getInstance().getSession().getCommentDao().insertOrReplace(comment);
         }

         for (int i=0; i<10; i++) {
             Comment comment = new Comment(String.valueOf(10+i));
             comment.setObject_id("30000"+i);
             comment.setText(TextUtil.removeNulls("comment" + comment.getId()));
             DaoTask.getInstance().getSession().getCommentDao().insertOrReplace(comment);
         }

         for (int i=0; i<10; i++) {
             Product product = new Product("10000"+i+"100");
             product.setOrder_id("10000"+i);
             product.setString_number("100");
             Product product2 = new Product("10000"+i+"200");
             product.setId(product.getOrder_id() + product.getString_number());
             product2.setOrder_id("10000" + i);
             product2.setString_number("200");
             DaoTask.getInstance().getSession().getProductDao().insertOrReplace(product);
             DaoTask.getInstance().getSession().getProductDao().insertOrReplace(product2);
         }

         for (int i=0; i<10; i++) {
             Document document = new Document();
             document.setOrderId("10000" + i);
             document.setDocument_path("path");
             DaoTask.getInstance().getSession().getDocumentDao().insertOrReplace(document);
         }

     }

    public void openCreateActivity(){
        Intent intent= new Intent(this, CreateActivity.class);
        startActivity(intent);
    }

    public void refreshData(boolean downloadNewFiles){
        ProgressDialog progress = new ProgressDialog(this);
        progress.setCancelable(false);
        progress.setMessage("Загрузка...");
        if (downloadNewFiles || !checkFiles()) {
            new GetFilesTask(this, progress).execute();
        } else {
            new ParseTask(this, progress).execute();

        }
    }

    public boolean checkFiles(){
        for (String filename : Constants.FILENAME_ARRAY) {
            File output = new File(App.getContext().getFilesDir()+"/"+filename+ Constants.FILE_EXTENSION);
            if (!output.exists()) {
                return false;
            }
            if (output.length()==0) {
                return false;
            }
        }
        return true;
    }


}

