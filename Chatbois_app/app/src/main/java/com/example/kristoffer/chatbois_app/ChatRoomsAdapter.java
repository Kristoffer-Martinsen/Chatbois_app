package com.example.kristoffer.chatbois_app;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Kristoffer on 10/18/2017.
 */

public class ChatRoomsAdapter extends RecyclerView.Adapter<ChatRoomsAdapter.ViewHolder>{
    private List<String> messages;

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            txtHeader = (TextView) v.findViewById(R.id.firstLine);
            txtFooter = (TextView) v.findViewById(R.id.secondLine);
        }
    }

    public void add(int position, String item) {
        messages.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        messages.remove(position);
        notifyItemRemoved(position);
    }

    public ChatRoomsAdapter(List<String> myDataset) {
        messages = myDataset;
    }

    // Create new views (invoked by layout manager)
    @Override
    public ChatRoomsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.row_layout, parent, false);

        // Set the view's size, margin, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String name = messages.get(position);
        holder.txtHeader.setText(name);
        holder.txtHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                remove(position);
            }
        });

        holder.txtFooter.setText("Footer: " + name);
    }

    /*
    @Override
    public void changeActivity(View view) {
        Intent intent = new Intent(this, ChatActivity.class);

    }*/



    // Return the size of your dataset
    @Override
    public int getItemCount() {
        return messages.size();
    }
}
