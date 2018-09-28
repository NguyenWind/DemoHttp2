package com.example.hoanhintern.demohttp2;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.List;

public class DataApdater extends RecyclerView.Adapter<DataApdater.DataItemViewholder> {
    List<Data> data;
    Context context;

    public DataApdater(List<Data> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public DataApdater.DataItemViewholder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView;

        itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_data,parent,false);



        return new DataItemViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(final DataItemViewholder holder, int position) {

        Data dt = data.get(position);
        String name = dt.getName();
        int id = dt.getId();
        String link = dt.getLink();
        String url = dt.getUrl();

        holder.txName.setText(name);
        holder.txId.setText("ID : "+id);
        holder.txLink.setText(link);

        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {

               holder.imageView.setImageBitmap(response);

            }
        }, 0, 0, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.getStackTrace();
            }
        });

        VolleySingleton.getInstance(context).getRequestQueue().add(imageRequest);




        }




    @Override
    public int getItemCount() {
        return data.size();
    }

    public class DataItemViewholder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView txName,txId,txLink;

        public DataItemViewholder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.iv);
            txName = (TextView)itemView.findViewById(R.id.txName);
            txId = (TextView)itemView.findViewById(R.id.txId);
            txLink = (TextView)itemView.findViewById(R.id.txLink);
        }
    }



}



