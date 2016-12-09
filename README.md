# RecyclerViewAdapter-ViewDataBinding
RecyclerView Adapter with Data Binding Library
##Data Binding Library
https://developer.android.com/topic/libraries/data-binding/index.html

##Gradle Dependency
``` groovy
compile 'torchlight.recyclerview.adapter:recyclerview-adapter-viewdatabinding:1.0.1'
```


##Usage
### SingleItemAdapter Sample
``` groovy
public class SingleItemSampleAdapter extends SingleItemAdapter<ListItem1Binding,Item1> {

    @Override
    protected ListItem1Binding onCreateItemView(ViewGroup parent) {
        return DataBindingUtil.bind(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_1, parent, false));
    }

    @Override
    protected void onBindItemView(ListItem1Binding viewDataBinding, Item1 item) {
        viewDataBinding.text.setText(item.getText());
    }
}
```

``` groovy
mSingleItemSampleAdapter = new SingleItemSampleAdapter();

List<Item1> list = new ArrayList<Item1>();
list.add(new Item1("Item1"))
...
mSingleItemSampleAdapter.set(list);
```
### MultiItemAdapter Sample
``` groovy
public class MultiItemSampleAdapter extends MultiItemAdapter {

    public static final int VIEW_TYPE_1 = 100;
    public static final int VIEW_TYPE_2 = 101;
    @Override
    public int getItemViewType(Object item) {
        int viewType = 0;
        if(item instanceof Item1)
            viewType = VIEW_TYPE_1;
        else if(item instanceof Item2)
            viewType = VIEW_TYPE_2;
        return viewType;
    }

    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseRecyclerViewHolder holder = null;

        switch (viewType){
            case VIEW_TYPE_1:
                holder =  new Item1ViewHolder(parent, R.layout.list_item_1);
                break;
            case VIEW_TYPE_2:
                ListItem2Binding binding2 = DataBindingUtil.bind(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_2, parent, false));
                holder = new Item2ViewHolder(binding2);
                break;
        }
        return holder;
    }

    static class Item1ViewHolder extends BaseRecyclerViewHolder<ListItem1Binding,Item1>{

        public Item1ViewHolder(ViewGroup parent, @LayoutRes int layoutId) {
            super(parent, layoutId);
        }

        @Override
        public void onBindItemView(Item1 item1) {
            getItemViewDataBinding().text.setText(item1.getText());
        }
    }
    static class Item2ViewHolder extends BaseRecyclerViewHolder<ListItem2Binding,Item2>{

        public Item2ViewHolder(ListItem2Binding viewDataBinding) {
            super(viewDataBinding);
        }

        @Override
        public void onBindItemView(Item2 item2) {
            getItemViewDataBinding().text1.setText(item2.getTitle());
            getItemViewDataBinding().text2.setText(item2.getContent());
        }
    }
}
```


``` groovy
mMultiItemSampleAdapter = new MultiItemSampleAdapter();

List list = new ArrayList();
list.add(new Item1("Item1"));
list.add(new Item2("Item2","Sample"));
...
mMultiItemSampleAdapter.set(list);
```
