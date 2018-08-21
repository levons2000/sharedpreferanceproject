package com.example.hp.sharedpreferenceproject;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private Context context;
    private List<UserModel> list;

    UserAdapter(Context context, List<UserModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item_style, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.textName.setText(list.get(position).getName());
        holder.textSurname.setText(list.get(position).getSurname());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder {
        private TextView textName;
        private TextView textSurname;

        private UserViewHolder(View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.item_name);
            textSurname = itemView.findViewById(R.id.item_surname);
        }
    }
}
