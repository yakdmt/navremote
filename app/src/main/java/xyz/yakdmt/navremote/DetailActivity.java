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
import xyz.yakdmt.navremote.fragments.ClientFragment;
import xyz.yakdmt.navremote.fragments.CommentsFragment;
import xyz.yakdmt.navremote.fragments.DeliveryFragment;
import xyz.yakdmt.navremote.fragments.OrderFragment;
import xyz.yakdmt.navremote.fragments.RouteFragment;
import xyz.yakdmt.navremote.fragments.WorksFragment;

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
        ClientFragment clientFragment = new ClientFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("client", client);
        clientFragment.setArguments(bundle);
        getFragmentManager().beginTransaction()
                .replace(R.id.container, clientFragment, ClientFragment.class.getName())
                .addToBackStack(null)
                .commit();
    }

    public void openRouteFragment(Delivery delivery){
        RouteFragment routeFragment = new RouteFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("delivery", delivery);
        routeFragment.setArguments(bundle);
        getFragmentManager().beginTransaction()
                .replace(R.id.container, routeFragment, RouteFragment.class.getName())
                .addToBackStack(null)
                .commit();
    }

    public void openWorksFragment(Cargo cargo){
        WorksFragment worksFragment = new WorksFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("cargo", cargo);
        worksFragment.setArguments(bundle);
        getFragmentManager().beginTransaction()
                .replace(R.id.container, worksFragment, WorksFragment.class.getName())
                .addToBackStack(null)
                .commit();
    }

    public void openWorksFragment(Delivery delivery){
        WorksFragment worksFragment = new WorksFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("delivery", delivery);
        worksFragment.setArguments(bundle);
        getFragmentManager().beginTransaction()
                .replace(R.id.container, worksFragment, WorksFragment.class.getName())
                .addToBackStack(null)
                .commit();
    }

    public void openCommentsFragment(Cargo cargo){
        CommentsFragment commentsFragment = new CommentsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("cargo", cargo);
        commentsFragment.setArguments(bundle);
        getFragmentManager().beginTransaction()
                .replace(R.id.container, commentsFragment, CommentsFragment.class.getName())
                .addToBackStack(null)
                .commit();
    }

    public void openCommentsFragment(Delivery delivery){
        CommentsFragment commentsFragment = new CommentsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("delivery", delivery);
        commentsFragment.setArguments(bundle);
        getFragmentManager().beginTransaction()
                .replace(R.id.container, commentsFragment, CommentsFragment.class.getName())
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

    public void showContactDialog(Contact contact){
        AlertDialog.Builder adb = new AlertDialog.Builder(this);
        adb.setTitle("Контакт " + contact.getId());
        View view = getLayoutInflater()
                .inflate(R.layout.content_contact, null);
        adb.setView(view);

        TextView name = (TextView) view.findViewById(R.id.name);
        name.setText(contact.getName());
        TextView firmName = (TextView) view.findViewById(R.id.firm_name);
        firmName.setText(contact.getFirm_name());
        TextView phone = (TextView) view.findViewById(R.id.phone);
        phone.setText(contact.getPhone());
        TextView mobilePhone = (TextView) view.findViewById(R.id.mobile_phone);
        mobilePhone.setText(contact.getMobile_phone());
        TextView manager = (TextView) view.findViewById((R.id.manager));
        manager.setText(contact.getManager_code());
        TextView index = (TextView) view.findViewById(R.id.index);
        index.setText(contact.getPostal_index());
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
