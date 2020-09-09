package com.instant.hritvik.smaf;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class userAdapter extends RecyclerView.Adapter<userAdapter.userViewHolder> {
    private Context context;
    private User[] data;
    public userAdapter(Context context, User[] data)
    {
        this.context = context;
        this.data = data;

    }

    @NonNull
    @Override
    public userViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_userlayout,parent,false);
        return new userViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull userViewHolder holder, int position) {
        final User user = data[position];
        holder.username.setText(user.getUsername());
        holder.follower.setText(user.getUsername());
        holder.following.setText(user.getUsername());
        holder.media.setText(user.getUsername());
        Glide.with(holder.profil_pic.getContext()).load(user.getProfilePic()).into(holder.profil_pic);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Was Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class userViewHolder extends RecyclerView.ViewHolder {
        ImageView profil_pic;
        TextView username;
        TextView follower;
        TextView following;
        TextView media;

        public userViewHolder(@NonNull View itemView) {
            super(itemView);
            profil_pic = (ImageView) itemView.findViewById(R.id.profil_pic);
            username = (TextView) itemView.findViewById(R.id.username);
            follower = (TextView) itemView.findViewById(R.id.follower);
            following = (TextView) itemView.findViewById(R.id.following);
            media = (TextView) itemView.findViewById(R.id.media);

        }
    }
}
