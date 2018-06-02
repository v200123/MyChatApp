package com.study.lc.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.viewHolder> {
    private List<Msg> MsgList;

    public MsgAdapter(List<Msg> List){
        MsgList = List;
    }
    static class viewHolder extends RecyclerView.ViewHolder {
        LinearLayout leftLayout;
        LinearLayout rightLayout;
        TextView leftMsg;
        TextView rightMsg;
        ImageView Topic_image;
        public viewHolder(View itemView) {
            super(itemView);
            leftLayout = itemView.findViewById(R.id.left_layout);
            rightLayout = itemView.findViewById(R.id.right_layout);
            leftMsg = itemView.findViewById(R.id.left_msg);
            rightMsg = itemView.findViewById(R.id.right_msg);
            Topic_image = itemView.findViewById(R.id.TOP_image);
        }
    }

    @NonNull
    @Override
    public MsgAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.msg_items,parent,false);

        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MsgAdapter.viewHolder holder, int position) {
        Msg msg = MsgList.get(position);
        if (msg.getType() == Msg.TYPE_RECEIVED) {
// 如果是收到的消息，则显示左边的消息布局，将右边的消息布局隐藏
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getName());
        } else if(msg.getType() == Msg.TYPE_SENT) {
// 如果是发出的消息，则显示右边的消息布局，将左边的消息布局隐藏
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightMsg.setText(msg.getName());
    }
    }

    @Override
    public int getItemCount() {
        return MsgList.size();
    }
}





class Msg{
        public static final int TYPE_RECEIVED = 0;
        public static final int TYPE_SENT = 1;
    private Date date;
    private String Name;
    private int image;


    private int type;
    public Msg(Date date, String name, int image,int type) {
        this.date = date;
        Name = name;
        this.image = image;
        this.type = type;
    }
    public int getType() {
        return type;
    }


    public Date getDate() {
        return date;
    }

    public String getName() {
        return Name;
    }

    public int getImage() {
        return image;
    }


}
