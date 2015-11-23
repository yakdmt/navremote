package xyz.yakdmt.navremote.holders;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import xyz.yakdmt.navremote.App;
import xyz.yakdmt.navremote.R;
import xyz.yakdmt.navremote.database.Work;
import xyz.yakdmt.navremote.utils.TextUtil;

/**
 * Created by yakdmt on 08/11/15.
 */
public class WorkHolder extends RecyclerView.ViewHolder {

    private Context mContext;
    @Bind(R.id.work_code) TextView mWorkCode;
    @Bind(R.id.work_type) TextView mWorkType;
    @Bind(R.id.delivery_id) TextView mDelivery;
    @Bind(R.id.cargo_id) TextView mCargo;
    @Bind(R.id.description) TextView mDescription;
    @Bind(R.id.working_place) TextView mWorkingPlace;
    @Bind(R.id.count) TextView mCount;
    @Bind(R.id.comment) TextView mComment;
    @Bind(R.id.actual_finish_date) TextView mFinishDate;
    @Bind(R.id.responsible_worker) TextView mResponsible;
    @Bind(R.id.creator) TextView mCreator;

    public WorkHolder(Context context, View itemView) {
        super(itemView);
        mContext = context;
        ButterKnife.bind(this, itemView);
    }

    public void bind(final Work work) {
        if (!App.bindViews) {
            return;
        }
        mWorkCode.setText(TextUtil.removeNulls("Код: " + work.getWork_code()));
        mWorkType.setText(TextUtil.removeNulls("Тип: "+work.getWork_type()));
        mDelivery.setText(TextUtil.removeNulls("Доставка: "+work.getDelivery_id()));
        mCargo.setText(TextUtil.removeNulls("Груз: "+work.getCargo_id()));
        mDescription.setText(TextUtil.removeNulls(work.getDescription()));
        mWorkingPlace.setText(TextUtil.removeNulls("Место выполнения: "+work.getWorking_place()));
        mCount.setText(TextUtil.removeNulls("Количество: "+work.getCount()));
        mComment.setText(TextUtil.removeNulls("Комментарий: "+work.getComment()));
        mFinishDate.setText(TextUtil.removeNulls("Завершена: "+work.getActual_finish_date()+"; "+work.getActual_finish_time()));
        String dept = "";
        if (!TextUtils.isEmpty(work.getResponsible_department())){
            dept= "("+work.getResponsible_department()+")";
        }
        mResponsible.setText(TextUtil.removeNulls("Отв.: "+work.getResponsible_worker()+dept));
        mCreator.setText(TextUtil.removeNulls("Создал: "+work.getCreator()));
    }


}
