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
import xyz.yakdmt.navremote.adapters.CommentAdapter;
import xyz.yakdmt.navremote.database.Cargo;
import xyz.yakdmt.navremote.database.Comment;
import xyz.yakdmt.navremote.database.CommentDao;
import xyz.yakdmt.navremote.database.DaoTask;
import xyz.yakdmt.navremote.database.Delivery;

/**
 * Created by yakdmt on 08/11/15.
 */
public class CommentsFragment extends Fragment {

    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;
    private Delivery delivery;
    private Cargo cargo;
    private RecyclerView mList;
    private CommentAdapter mAdapter;

    public static CommentsFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        CommentsFragment fragment = new CommentsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);
        delivery = (Delivery) getArguments().getSerializable("delivery");
        cargo = (Cargo) getArguments().getSerializable("cargo");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_items, container, false);
        mList = (RecyclerView) view.findViewById(R.id.recycler_view);
        mList.setLayoutManager(new LinearLayoutManager(getActivity()));
        ArrayList<Comment> comments = new ArrayList<>();
        if (delivery!=null) {
            comments = (ArrayList<Comment>) DaoTask.getInstance().getSession().getCommentDao().queryBuilder().where(CommentDao.Properties.Object_id.eq(delivery.getId())).list();
        } else if (cargo!=null) {
            comments = (ArrayList<Comment>) DaoTask.getInstance().getSession().getCommentDao().queryBuilder().where(CommentDao.Properties.Object_id.eq(cargo.getId())).list();
        }
        mAdapter = new CommentAdapter(getActivity(), comments);
        mList.setAdapter(mAdapter);
        return view;
    }



}
