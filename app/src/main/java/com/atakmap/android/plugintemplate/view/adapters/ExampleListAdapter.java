package com.atakmap.android.plugintemplate.view.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.DiffUtil;

import com.atakmap.android.plugintemplate.persistance.example.Example;
import com.atakmap.android.plugintemplate.plugin.R;
import com.atakmap.android.plugintemplate.plugin.databinding.ExampleListItemBinding;
import com.atakmap.android.plugintemplate.viewmodel.ExamplePageViewModel;

public class ExampleListAdapter extends ListAdapter<Example, ExampleListAdapter.ViewHolder> {
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
        Example example = this.getItem(position);
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


    private static final DiffUtil.ItemCallback<Example> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Example>() {
                @Override
                public boolean areItemsTheSame(@NonNull Example oldItem, @NonNull Example newItem) {
                    return false;
                }

                @Override
                public boolean areContentsTheSame(@NonNull Example oldItem, @NonNull Example newItem) {
                    return false;
                }
            };

}
