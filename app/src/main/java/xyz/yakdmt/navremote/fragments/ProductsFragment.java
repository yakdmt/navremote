package xyz.yakdmt.navremote.fragments;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.adapters.ProductAdapter;
import xyz.yakdmt.navremote.database.DaoTask;
import xyz.yakdmt.navremote.database.Order;
import xyz.yakdmt.navremote.database.Product;
import xyz.yakdmt.navremote.database.ProductDao;

/**
 * Created by yakdmt on 08/11/15.
 */
public class ProductsFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;
    private Order order;
    private RecyclerView mList;
    private ProductAdapter mAdapter;

    public static ProductsFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        ProductsFragment fragment = new ProductsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
        order = (Order) getArguments().getSerializable("order");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detailed_items, container, false);
        mList = (RecyclerView) view.findViewById(R.id.recycler_view);
        mList.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayList<Product> products = (ArrayList<Product>) DaoTask.getInstance().getSession().getProductDao().queryBuilder().where(ProductDao.Properties.Order_id.eq(order.getId())).list();
        mAdapter = new ProductAdapter(getActivity(), products);
        mList.setAdapter(mAdapter);
        return view;
    }



}
