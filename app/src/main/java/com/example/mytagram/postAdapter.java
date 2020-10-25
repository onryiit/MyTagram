package com.example.mytagram;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class postAdapter  extends BaseAdapter {
    List<post> posts;
    private LayoutInflater inflater;
    public postAdapter (Activity activity,List<post> posts){
        this.posts=posts;
        inflater =(LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return posts.size();
    }

    @Override
    public Object getItem(int position) {
        return posts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       View rowview;
       rowview=inflater.inflate(R.layout.row,null);
        EditText txtMessage =(EditText) rowview.findViewById(R.id.message);
        TextView txtLocation =(TextView) rowview.findViewById(R.id.location);
        ImageView imageView = (ImageView) rowview.findViewById(R.id.picture);

        post post =posts.get(position);
        txtMessage.setText(post.getMessage());
        if (post.getLocation()!= null){
            txtLocation.setText(post.getLocation().getLatitude() + " " + post.getLocation().getLatitude() );

        }
        return rowview;
    }
}
