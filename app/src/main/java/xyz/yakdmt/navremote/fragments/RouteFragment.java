package xyz.yakdmt.navremote.fragments;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;
import xyz.yakdmt.navremote.DetailActivity;
import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.adapters.RouteAdapter;
import xyz.yakdmt.navremote.database.DaoTask;
import xyz.yakdmt.navremote.database.Delivery;
import xyz.yakdmt.navremote.database.RouteRow;
import xyz.yakdmt.navremote.database.RouteRowDao;
import xyz.yakdmt.navremote.utils.Events;

/**
 * Created by yakdmt on 08/11/15.
 */
public class RouteFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;
    private Delivery delivery;
    private RecyclerView mList;
    private RouteAdapter mAdapter;

    public static RouteFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        RouteFragment fragment = new RouteFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
        delivery = (Delivery) getArguments().getSerializable("delivery");
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
        ArrayList<RouteRow> routeRows = (ArrayList<RouteRow>) DaoTask.getInstance().getSession().getRouteRowDao().queryBuilder().where(RouteRowDao.Properties.Delivery_id.eq(delivery.getId())).list();
        mAdapter = new RouteAdapter(getActivity(), routeRows);
        mList.setAdapter(mAdapter);
        return view;
    }

    @SuppressWarnings("unused")
    public void onEvent(Events.OnOrderClick event) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("order", event.getOrder());
        startActivity(intent);
    }



}
