package xyz.yakdmt.navremote;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import xyz.yakdmt.navremote.database.Cargo;
import xyz.yakdmt.navremote.database.Checkpoint;
import xyz.yakdmt.navremote.database.Client;
import xyz.yakdmt.navremote.database.Contact;
import xyz.yakdmt.navremote.database.Delivery;
import xyz.yakdmt.navremote.database.Order;
import xyz.yakdmt.navremote.fragments.CargoFragment;
import xyz.yakdmt.navremote.fragments.DeliveryFragment;
import xyz.yakdmt.navremote.fragments.OrderFragment;
import xyz.yakdmt.navremote.fragments.RouteFragment;

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
        if (getIntent().getSerializableExtra("cargo")!=null) {
            openCargoFragment((Cargo) getIntent().getSerializableExtra("cargo"));
        }
        if (getIntent().getSerializableExtra("delivery")!=null) {
            openDeliveryFragment((Delivery) getIntent().getSerializableExtra("delivery"));
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

    public void openCargoFragment(Cargo cargo){
        CargoFragment cargoFragment = new CargoFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("cargo", cargo);
        cargoFragment.setArguments(bundle);
        getFragmentManager().beginTransaction()
                .replace(R.id.container, cargoFragment, CargoFragment.class.getName())
                .addToBackStack(null)
                .commit();
    }

    public void openDeliveryFragment(Delivery delivery){
        DeliveryFragment deliveryFragment = new DeliveryFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("delivery", delivery);
        deliveryFragment.setArguments(bundle);
        getFragmentManager().beginTransaction()
                .replace(R.id.container, deliveryFragment, DeliveryFragment.class.getName())
                .addToBackStack(null)
                .commit();
    }

    public void openClientFragment(Client client){

    }

    public void openContactFragment(Contact contact){

    }

    public void openRouteFragment(Delivery delivery){
        RouteFragment routeFragment = new RouteFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("delivery", delivery);
        routeFragment.setArguments(bundle);
        getFragmentManager().beginTransaction()
                .replace(R.id.container, routeFragment, DeliveryFragment.class.getName())
                .addToBackStack(null)
                .commit();
    }

    public void showCheckpointDialog(Checkpoint checkpoint){
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("Пункт " + checkpoint.getId());
        // создаем view из dialog.xml
        View view = getLayoutInflater()
                .inflate(R.layout.content_checkpoint, null);
        adb.setView(view);

        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText(checkpoint.getName());
        TextView countryCode = (TextView) view.findViewById(R.id.country_code);
        countryCode.setText(checkpoint.getCountry_code());
        TextView type = (TextView) view.findViewById(R.id.type);
        type.setText(checkpoint.getType());
        TextView cityName = (TextView) view.findViewById(R.id.city_name);
        cityName.setText(checkpoint.getCity_name());
        TextView info = (TextView) view.findViewById(R.id.info);
        info.setText(checkpoint.getInfo());
        adb.create().show();
    }

    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount()>1) {
            getFragmentManager().popBackStack();
        } else {
            finish();
        }
        return;
    }

}
