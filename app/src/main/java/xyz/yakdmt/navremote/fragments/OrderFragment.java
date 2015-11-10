package xyz.yakdmt.navremote.fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.database.Order;

/**
 * Created by yakdmt on 10/11/15.
 */
public class OrderFragment extends Fragment {

    private Order mOrder;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mOrder = (Order) getArguments().getSerializable("order");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        return view;
    }

}
