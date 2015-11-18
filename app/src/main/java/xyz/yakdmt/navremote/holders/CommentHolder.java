package xyz.yakdmt.navremote.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.database.Comment;

/**
 * Created by yakdmt on 08/11/15.
 */
public class CommentHolder extends RecyclerView.ViewHolder {

    private Context mContext;
    @Bind(R.id.object) TextView mObject;
    @Bind(R.id.date) TextView mDate;
    @Bind(R.id.author) TextView mAuthor;
    @Bind(R.id.text) TextView mText;


    public CommentHolder(Context context, View itemView) {
        super(itemView);
        mContext = context;
        ButterKnife.bind(this, itemView);
    }

    public void bind(final Comment comment) {
        mObject.setText(comment.getObject_type()+" "+comment.getObject_id());
        mDate.setText(comment.getDate());
        String dept = "";
        if (!TextUtils.isEmpty(comment.getDepartment())) {
            dept = " ("+comment.getDepartment()+")";
        }
        mAuthor.setText(comment.getAuthor()+dept);
        mText.setText(comment.getText());
    }


}
