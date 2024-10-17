package com.atakmap.android.plugintemplate.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.DiffUtil;

import com.atakmap.android.plugintemplate.persistance.example.ExampleEntity;
import com.atakmap.android.plugintemplate.plugin.R;
import com.atakmap.android.plugintemplate.plugin.databinding.ExampleListItemBinding;
import com.atakmap.android.plugintemplate.viewmodel.ExamplePageViewModel;

public class ExampleListAdapter extends ListAdapter<ExampleEntity, ExampleListAdapter.ViewHolder> {
    private final ExamplePageViewModel viewModel;

    public ExampleListAdapter(ExamplePageViewModel viewModel) {
        super(DIFF_CALLBACK);
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View exampleListItem = inflater.inflate(R.layout.example_list_item, parent, false);
        return new ViewHolder(ExampleListItemBinding.bind(exampleListItem));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ExampleEntity example = this.getItem(position);
        holder.binding.setViewmodel(this.viewModel);
        holder.binding.setExample(example);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final ExampleListItemBinding binding;

        public ViewHolder(@NonNull ExampleListItemBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
    }


    private static final DiffUtil.ItemCallback<ExampleEntity> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<ExampleEntity>() {
                @Override
                public boolean areItemsTheSame(@NonNull ExampleEntity oldItem, @NonNull ExampleEntity newItem) {
                    return newItem.uid.equals(oldItem.uid);
                }

                @Override
                public boolean areContentsTheSame(@NonNull ExampleEntity oldItem, @NonNull ExampleEntity newItem) {
                    // check if value is different
                    return false;
                }
            };

}
