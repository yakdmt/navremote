package xyz.yakdmt.navremote;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import xyz.yakdmt.navremote.database.DaoTask;
import xyz.yakdmt.navremote.database.Order;
import xyz.yakdmt.navremote.fragments.EditOrderFragment;
import xyz.yakdmt.navremote.fragments.OrderFragment;

/**
 * Created by yakdmt on 10/11/15.
 */
public class CreateActivity extends AppCompatActivity {

    private FloatingActionButton mFab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

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
                Fragment fragment = getFragmentManager().findFragmentByTag(EditOrderFragment.class.getName());
                if (fragment!=null && fragment.isVisible()) {
                    if (((EditOrderFragment)fragment).validateViews()) {
                        App.hideSoftKeyboard(CreateActivity.this);
                        openOrderFragment(((EditOrderFragment) fragment).getOrder());
                    }
                }

                Fragment previewFragment = getFragmentManager().findFragmentByTag(OrderFragment.class.getName());
                if (previewFragment!=null && previewFragment.isVisible()) {
                    Order order = ((OrderFragment)previewFragment).getOrder();
                    DaoTask.getInstance().getSession().getOrderDao().insertOrReplace(order);
                    finish();
                }
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        openEditOrderFragment();
    }


    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount()>1) {
            getFragmentManager().popBackStack();
        } else {
            finish();
        }
    }

    public void openEditOrderFragment() {
        EditOrderFragment editOrderFragment = new EditOrderFragment();
        getFragmentManager().beginTransaction()
                .replace(R.id.container, editOrderFragment, EditOrderFragment.class.getName())
                .addToBackStack(null)
                .commit();
    }

    public void openOrderFragment(Order order){
        OrderFragment orderFragment = new OrderFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("order", order);
        orderFragment.setArguments(bundle);
        getFragmentManager().beginTransaction()
                .replace(R.id.container, orderFragment, OrderFragment.class.getName())
                .addToBackStack(null)
                .commit();
    }


}
