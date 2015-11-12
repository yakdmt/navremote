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
import xyz.yakdmt.navremote.adapters.CargoAdapter;
import xyz.yakdmt.navremote.database.Cargo;
import xyz.yakdmt.navremote.database.DaoTask;
import xyz.yakdmt.navremote.utils.Events;

/**
 * Created by yakdmt on 11/11/15.
 */
public class AllCargoesFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;
    private RecyclerView mList;
    private CargoAdapter mAdapter;

    public static AllCargoesFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        AllCargoesFragment fragment = new AllCargoesFragment();
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
        ArrayList<Cargo> cargoes = (ArrayList<Cargo>) DaoTask.getInstance().getSession().getCargoDao().queryBuilder().list();
        mAdapter = new CargoAdapter(getActivity(), cargoes);
        mList.setAdapter(mAdapter);
        return view;
    }

    @SuppressWarnings("unused")
    public void onEvent(Events.OnCargoClick event) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("cargo", event.getCargo());
        startActivity(intent);
    }

}
