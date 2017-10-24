package com.example.kristoffer.chatbois_app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Kristoffer on 10/18/2017.
 */

public class ChatRoomsAdapter extends RecyclerView.Adapter<ChatRoomsAdapter.ChatRoomViewHolder>{
    List<Conversation> conversations = new ArrayList<>();
    Context context;
    ConversationClickListener listener;

    public interface OnClickListener{
        void onClick(int position);
    }

    public ChatRoomsAdapter(Context context) {
        this.context = context;
    }

    public void setOnClickListener(ConversationClickListener listener) {
        this.listener = listener;
    }


    @Override
    public ChatRoomsAdapter.ChatRoomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_layout, parent, false);
        return new ChatRoomViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ChatRoomsAdapter.ChatRoomViewHolder holder, int position) {
        String d = conversations.get(position).getVersion();
        String id = conversations.get(position).getId();
        holder.txtHeader.setText(id);
        holder.txtFooter.setText(d);

    }

    @Override
    public int getItemCount() {
        return conversations.size();
    }

    public void setData(List<Conversation> conversation) {
        this.conversations = conversation;
        notifyDataSetChanged();
    }


    public class ChatRoomViewHolder extends RecyclerView.ViewHolder {
        public TextView txtHeader;
        public TextView txtFooter;
        public View layout;

        public ChatRoomViewHolder(View view) {
            super(view);
            this.txtHeader = view.findViewById(R.id.firstLine);
            this.txtFooter = view.findViewById(R.id.secondLine);
            this.layout = view;

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(listener != null) {
                        listener.onClick(context, conversations.get(getAdapterPosition()));
                    }
                }

            });
        }
    }
}
