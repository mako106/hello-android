package com.example.bottomnavigationdemo.Adapter;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.bottomnavigationdemo.Entity.Notification;
import com.example.bottomnavigationdemo.Fragment.NotiFragment;
import com.example.bottomnavigationdemo.R;

import java.util.List;

public class ListNewAdapter extends BaseAdapter {

    private List<Notification> list;
    private Fragment fragment;

    public ListNewAdapter(List<Notification> list, NotiFragment fragment) {
        this.list = list;
        this.fragment = fragment;
    }



    public void reloadData(List<Notification> list) {
        this.list = list;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = fragment.getLayoutInflater();
            view = inflater.inflate(R.layout.item_notification, viewGroup, false);
            ViewHolder holder = new ViewHolder();
            holder.tvTitle = view.findViewById(R.id.noti_title);
            holder.tvDes = view.findViewById(R.id.noti_des);
            holder.tvTime = view.findViewById(R.id.noti_time);
            view.setTag(holder);
        }
        ViewHolder holder = (ViewHolder) view.getTag();
        Notification notification = list.get(i);
        holder.tvTitle.setText(notification.getTitle());
        holder.tvDes.setText(notification.getDescription());
        holder.tvTime.setText(notification.getDate());
        return view;
    }


    static class ViewHolder {
        TextView tvTitle;
        TextView tvDes;
        TextView tvTime;

    }




};
