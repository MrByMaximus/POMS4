package com.example.poms4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class historyAdapter extends ArrayAdapter<historyItem> {
    private Context mContext;
    int mResource;
    ArrayList<historyItem> history;

    public historyAdapter(Context context, int resource, ArrayList<historyItem> objects){
        super(context,resource,objects);
        mContext=context;
        mResource=resource;
        history=objects;
    }
    @NonNull
    @Override
    public View getView(final int position, View convertView, final ViewGroup parent){
        final Button historyButton;
        String text=getItem(position).historyText;
        LayoutInflater inflater=LayoutInflater.from(mContext);
        convertView=inflater.inflate(mResource,parent,false);
        TextView tvText=(TextView)convertView.findViewById(R.id.textView5);
        historyButton = convertView.findViewById(R.id.button5);
        historyButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        for (int i = 0; i < parent.getChildCount(); i++) {
                            if(i==position) {
                                parent.scrollTo(0,(int)parent.getChildAt(i).getVerticalScrollbarPosition());
                            }
                        }
                    }
                }
        );
        tvText.setText(text);
        return convertView;
    }
}
