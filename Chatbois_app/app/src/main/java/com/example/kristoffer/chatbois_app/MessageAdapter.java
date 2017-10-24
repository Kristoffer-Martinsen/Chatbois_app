package com.example.kristoffer.chatbois_app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kristoffer on 10/24/2017.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.MessageViewHolder>{
    List<Message> messages= new ArrayList<>();
    Context context;
    MessageAdapter.OnClickListener listener;

    public interface OnClickListener{
        void onClick(int position);
    }

    @Override
    public MessageAdapter.MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new MessageAdapter.MessageViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MessageAdapter.MessageViewHolder holder, int position) {
        String name = messages.get(position).getName();
        String text = messages.get(position).getText();
        holder.txtHeader.setText(name);
        holder.txtFooter.setText(text);

    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    public void setData(List<Message> messages) {
        this.messages = messages;
        notifyDataSetChanged();
    }


    public class MessageViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;

        public MessageViewHolder(View view) {
            super(view);
            this.txtHeader = view.findViewById(R.id.firstLine);
            this.txtFooter = view.findViewById(R.id.secondLine);
            this.layout = view;

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null) {
                        listener.onClick(getAdapterPosition());
                    }
                }
            });
        }
    }

}
