package xyz.yakdmt.navremote;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
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

import org.xmlpull.v1.XmlPullParserException;

import xyz.yakdmt.navremote.database.Cargo;
import xyz.yakdmt.navremote.database.DaoTask;
import xyz.yakdmt.navremote.database.Delivery;
import xyz.yakdmt.navremote.database.Order;
import xyz.yakdmt.navremote.database.OrderDao;
import xyz.yakdmt.navremote.fragments.AllCargoesFragment;
import xyz.yakdmt.navremote.fragments.AllDeliveriesFragment;
import xyz.yakdmt.navremote.fragments.AllOrdersFragment;
import xyz.yakdmt.navremote.utils.SchemeParser;

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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                try {
                    SchemeParser.getInstance().doParse(MainActivity.this);
                } catch (XmlPullParserException e) {
                    e.printStackTrace();
                }
            }
        });

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.app_name);
        mAppBar = (AppBarLayout) findViewById(R.id.app_bar);
        setSupportActionBar(mToolbar);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);
        mViewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager(),
                MainActivity.this));
        mTabLayout = (TabLayout) findViewById(R.id.tab_layout);
        mTabLayout.setupWithViewPager(mViewPager);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        addTestData();
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
        if (id == R.id.action_settings) {
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
     public void addTestData(){
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
             mDeparture.setText(departureBuilder);
             mDateTime.setText(order.getDate() + " " + order.getTime());
             mDeclarant.setText(order.getDeclarant_code());
             StringBuilder arrivalBuilder = new StringBuilder();
             arrivalBuilder.append(order.getDestination_country_name());
             arrivalBuilder.append(", ");
             arrivalBuilder.append(order.getDestination_checkpoint_name());
             arrivalBuilder.append(", ");
             arrivalBuilder.append(order.getDestination_checkpoint_address());
             mArrival.setText(arrivalBuilder);
             mWeight.setText(order.getBrutto_weight() + " кг.");
             mVolume.setText(order.getVolume()+" м^3");
             mCount.setText(order.getCount());
             mClientName.setText(order.getClient_name());
             mCargoDesc.setText(order.getCargo_description());
             mDepartureDate.setText(order.getDeparture_date());
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
             if (order != null) {
                 order.setCargo(cargo);
             }
             DaoTask.getInstance().getSession().getCargoDao().insertOrReplace(cargo);
         }

         for (int i=0; i<10; i++) {
             Delivery delivery = new Delivery("30000"+String.valueOf(i));
             DaoTask.getInstance().getSession().getDeliveryDao().insertOrReplace(delivery);
         }
     }
}
