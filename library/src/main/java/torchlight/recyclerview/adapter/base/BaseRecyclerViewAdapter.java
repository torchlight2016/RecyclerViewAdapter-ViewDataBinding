package torchlight.recyclerview.adapter.base;

import android.support.annotation.UiThread;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by torchlight on 2016. 10. 14..
 */

public abstract class BaseRecyclerViewAdapter<T>
        extends RecyclerView.Adapter<BaseRecyclerViewHolder> {

    protected final List<T> mItems;

    protected BaseRecyclerViewAdapter() { mItems = new ArrayList<>(); }

    protected BaseRecyclerViewAdapter(List<T> items) {
        mItems = items;
    }

    @UiThread
    public void add(final T item) {
        mItems.add(item);
        notifyItemInserted(getItemCount() - 1);
    }

    @UiThread
    public void add(final T item, int index) {
        mItems.add(index, item);
        notifyItemInserted(index);
    }

    @UiThread
    public void add(final List<T> itemList) {
        mItems.addAll(itemList);
        notifyItemRangeInserted(getItemCount() -1 - itemList.size() , itemList.size());
    }

    @UiThread
    public void remove(final T item) {
        int position = getPosition(item);
        mItems.remove(item);
        notifyItemRemoved(position);
    }

    @UiThread
    public void remove(int position) {
        if (getItemCount() - 1 >= position)
            mItems.remove(position);
        notifyItemRemoved(position);
    }
    @UiThread
    public void set(final List<T> items){
        mItems.clear();
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    @UiThread
    public void set(int index, final T item){
        mItems.set(index, item);
        notifyItemChanged(index);
    }

    @UiThread
    public void clear() {
        mItems.clear();
        notifyItemRangeRemoved(0, getItemCount());
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    protected T getItem(int position) {
        return mItems.get(position);
    }

    public int getPosition(final T item) {
        return mItems.indexOf(item);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(BaseRecyclerViewHolder holder, int position) {
        holder.onBindItemView(getItem(position));
    }

    @Override
    public abstract BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType);

    @Override
    public abstract int getItemViewType(int position);

}