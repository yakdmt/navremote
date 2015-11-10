package xyz.yakdmt.navremote;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import xyz.yakdmt.navremote.database.Order;
import xyz.yakdmt.navremote.fragments.OrderFragment;

/**
 * Created by yakdmt on 10/11/15.
 */
public class DetailActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (getIntent().getSerializableExtra("order")!=null) {
            openOrderFragment((Order) getIntent().getSerializableExtra("order"));
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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
