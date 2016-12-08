package torchlight.recyclerview.adapter;


import torchlight.recyclerview.adapter.base.BaseRecyclerViewAdapter;

/**
 * Created by torchlight on 2016. 12. 6..
 */

public abstract class MultiItemAdapter extends BaseRecyclerViewAdapter<Object> {

    @Override
    public int getItemViewType(int position) {
        return getItemViewType(getItem(position));
    }

    public abstract int getItemViewType(Object item);
}
