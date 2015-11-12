package xyz.yakdmt.navremote.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.database.Delivery;

/**
 * Created by yakdmt on 10/11/15.
 */
public class DeliveryFragment extends Fragment {

    private Delivery mDelivery;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDelivery = (Delivery) getArguments().getSerializable("delivery");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delivery, container, false);

        return view;
    }

}
