package nl.stefandv.level_3_assignment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Portal> mData;
    private LayoutInflater mInflater;
    private Context mContext;

    RecyclerViewAdapter(Context context, ArrayList<Portal> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
        this.mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {


        final Portal portal = mData.get(position);
        holder.portalTextView.setText((portal.getPortalTitle()));

        holder.portalTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startWebView(portal.getPortalUrl());

            }
        });


    }

    private void startWebView(String url) {

        Intent intent2 = new Intent(mContext, WebActivity.class);
        String message = url;
        intent2.putExtra("URL", url);
        mContext.startActivity(intent2);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView portalTextView;
        RelativeLayout parentLayout;


        public ViewHolder(View itemView) {
            super(itemView);
            portalTextView = itemView.findViewById(R.id.portalTextView);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            portalTextView.setClickable(true);
        }
    }
}

