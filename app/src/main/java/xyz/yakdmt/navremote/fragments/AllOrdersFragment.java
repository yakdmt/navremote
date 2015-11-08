package xyz.yakdmt.navremote.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.adapters.OrderAdapter;
import xyz.yakdmt.navremote.database.DaoTask;
import xyz.yakdmt.navremote.database.Order;

/**
 * Created by yakdmt on 08/11/15.
 */
public class AllOrdersFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;
    private RecyclerView mList;

    public static AllOrdersFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        AllOrdersFragment fragment = new AllOrdersFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_orders, container, false);
        mList = (RecyclerView) view.findViewById(R.id.recycler_view);
        mList.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayList<Order> orders = (ArrayList<Order>) DaoTask.getInstance().getSession().getOrderDao().queryBuilder().list();
        mList.setAdapter(new OrderAdapter(getActivity(), orders));
        return view;
    }

}
