package xyz.yakdmt.navremote.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import xyz.yakdmt.navremote.App;
import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.database.DaoTask;
import xyz.yakdmt.navremote.database.Order;
import xyz.yakdmt.navremote.utils.TextUtil;

/**
 * Created by yakdmt on 10/11/15.
 */
public class EditOrderFragment extends Fragment {

    private Order order;

    @Bind(R.id.client_name) TextView mClientName;
    @Bind(R.id.cargo_desc) EditText mCargoDesc;
    @Bind(R.id.departure_date) EditText mDepartureDate;

    @Bind(R.id.id) TextView mId;
    @Bind(R.id.date_time) TextView mDateTime;
    @Bind(R.id.declarant) TextView mDeclarant;

    @Bind(R.id.departure_country_name) EditText mDepartureCountryName;
    @Bind(R.id.departure_checkpoint_name) EditText mDepartureCheckpointName;
    @Bind(R.id.departure_checkpoint_address) EditText mDepartureCheckpointAddress;

    @Bind(R.id.arrival_country_name) EditText mArrivalCountryName;
    @Bind(R.id.arrival_checkpoint_name) EditText mArrivalCheckpointName;
    @Bind(R.id.arrival_checkpoint_address) EditText mArrivalCheckpointAddress;

    @Bind(R.id.weight) EditText mWeight;
    @Bind(R.id.volume) EditText mVolume;
    @Bind(R.id.count) EditText mCount;

    @Bind(R.id.documentsRef) TextView mDocumentsRef;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_edit_order, container, false);
        ButterKnife.bind(this, view);
        if (!App.bindViews) {
            return view;
        }
        order = new Order(DaoTask.getInstance().getNewOrderId());
        order.setDate(TextUtil.getCurrentDate());
        order.setTime(TextUtil.getCurrentTime());
        //from holder
        mId.setText(TextUtil.removeNulls(order.getId()));
        mDateTime.setText(TextUtil.removeNulls(order.getDate() + " " + order.getTime()));
        /*Client client = DaoTask.getInstance().getSession().getClientDao().load(App.currentClientId);
        if (client!=null) {
            mClientName.setText(order.getClient_name());
        }*/

        return view;
    }


    public boolean validateViews(){
        return true;
    }

    public Order getOrder(){
        order.setClient_id(App.currentClientId);
        order.setClient_name("ОАО КнААПО");
        return order;
    }


}
