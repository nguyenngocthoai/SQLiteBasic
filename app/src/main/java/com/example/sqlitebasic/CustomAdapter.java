package com.example.sqlitebasic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<User> users;

    public CustomAdapter(Context context, int layout, List<User> users) {
        this.context = context;
        this.layout = layout;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }
    private class ViewHolder {
        TextView txtId, txtName;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(layout, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.txtId = convertView.findViewById(R.id.id);
            viewHolder.txtName = convertView.findViewById(R.id.name);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }
        User user= users.get(position);
        viewHolder.txtId.setText(user.getId());
        viewHolder.txtName.setText(user.getName());
        return convertView;
    }
}
