package com.ajikadev.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
  private List<Person> localDataset;

  // Constructor updated to accept a List of Person objects
  public Adapter(List<Person> localDataset) {
    this.localDataset = localDataset;
  }

  @NonNull
  @Override
  public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    // Inflate the custom layout
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_item_view, parent, false);
    return new ViewHolder(view);
  }

  @Override
  public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
    // Get the person at the current position
    Person person = localDataset.get(position);

    // Set the text of the TextView to the person's full name
    holder.getTextView().setText(person.getFirstName() + " " + person.getLastName());
  }

  @Override
  public int getItemCount() {
    return localDataset.size();
  }

  public static class ViewHolder extends RecyclerView.ViewHolder {
    private final TextView textView;

    public ViewHolder(View view) {
      super(view);
      this.textView = view.findViewById(R.id.tv_name);
    }

    public TextView getTextView() {
      return textView;
    }
  }
}
