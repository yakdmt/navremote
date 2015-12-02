package xyz.yakdmt.navremote.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;
import xyz.yakdmt.navremote.DetailActivity;
import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.adapters.DeliveryAdapter;
import xyz.yakdmt.navremote.database.DaoTask;
import xyz.yakdmt.navremote.database.Delivery;
import xyz.yakdmt.navremote.utils.Events;

/**
 * Created by yakdmt on 11/11/15.
 */
public class AllDeliveriesFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;
    private RecyclerView mList;
    private DeliveryAdapter mAdapter;

    public static AllDeliveriesFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        AllDeliveriesFragment fragment = new AllDeliveriesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
        if (!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_items, container, false);
        mList = (RecyclerView) view.findViewById(R.id.recycler_view);
        mList.setLayoutManager(new LinearLayoutManager(getActivity()));
        refreshData();
        return view;
    }

    private void refreshData(){

        ArrayList<Delivery> deliveries = (ArrayList<Delivery>) DaoTask.getInstance().getSession().getDeliveryDao().queryBuilder()
                .list();
        mAdapter = new DeliveryAdapter(getActivity(), deliveries);
        mList.setAdapter(mAdapter);
    }

    @SuppressWarnings("unused")
    public void onEvent(Events.OnDeliveryClick event) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("delivery", event.getDelivery());
        startActivity(intent);
    }

    @SuppressWarnings("unused")
    public void onEvent(Events.OnDataUpdated event) {
        refreshData();
    }

}
