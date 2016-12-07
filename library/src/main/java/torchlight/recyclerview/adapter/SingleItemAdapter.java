package torchlight.recyclerview.adapter;

import android.databinding.ViewDataBinding;
import android.support.annotation.UiThread;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.Comparator;

import torchlight.recyclerview.adapter.base.BaseRecyclerViewAdapter;
import torchlight.recyclerview.adapter.base.BaseRecyclerViewHolder;

/**
 * Created by torchlight on 2016. 12. 6..
 */

public abstract class SingleItemAdapter<T1 extends ViewDataBinding, T2> extends BaseRecyclerViewAdapter<T2> {

    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final T1 binding = onCreateItemView(parent);
        return new BaseRecyclerViewHolder<T1,T2>(binding) {
            @Override
            public void onBindItemView(T2 item) {
                SingleItemAdapter.this.onBindItemView(binding,item);
            }
        };
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @UiThread
    public void sort(Comparator<? super T2> comparator) {
        Collections.sort(getItems(), comparator);
        notifyItemRangeChanged(0, getItemCount());
    }

    protected abstract T1 onCreateItemView(ViewGroup parent);
    protected abstract void onBindItemView(T1 itemViewDataBinding, final T2 item);

}
