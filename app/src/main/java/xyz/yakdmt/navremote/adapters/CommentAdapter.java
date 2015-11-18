package xyz.yakdmt.navremote.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.database.Comment;
import xyz.yakdmt.navremote.holders.CommentHolder;

/**
 * Created by yakdmt on 11/11/15.
 */
public class CommentAdapter extends RecyclerView.Adapter{
    private ArrayList<Comment> mFullData = new ArrayList<>();
    private ArrayList<Comment> mData = new ArrayList<>();
    private Context mContext;

    public CommentAdapter(Context context, ArrayList<Comment> items) {
        this.mFullData = items;
        this.mData = items;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        // create a new view
        View v = LayoutInflater.from(mContext)
                .inflate(R.layout.holder_comment, viewGroup, false);
        // set the view's size, margins, paddings and layout parameters
        return new CommentHolder(mContext, v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        ((CommentHolder)viewHolder).bind(mData.get(i));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
