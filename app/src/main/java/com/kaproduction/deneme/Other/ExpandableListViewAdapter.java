package com.kaproduction.deneme.Other;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.kaproduction.deneme.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by reis on 28/10/16.
 */

public class ExpandableListViewAdapter extends BaseExpandableListAdapter {

    private Context ctx;
    private HashMap<String, List<String>> Pratik_Bilgiler_Category;
    private List<String> Pratik_Bilgiler_List;

    public ExpandableListViewAdapter(Context ctx, HashMap<String, List<String>> category, List<String> list) {
        this.ctx = ctx;
        Pratik_Bilgiler_Category = category;
        Pratik_Bilgiler_List = list;
    }

    @Override
    public int getGroupCount() {
        return Pratik_Bilgiler_List.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return Pratik_Bilgiler_Category.get(Pratik_Bilgiler_List.get(i)).size();
    }

    @Override
    public Object getGroup(int i) {
        return Pratik_Bilgiler_List.get(i);
    }

    @Override
    public Object getChild(int parent, int child) {
        return Pratik_Bilgiler_Category.get(Pratik_Bilgiler_List.get(parent)).get(child);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int parent, int child) {
        return child;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int parent, boolean isExpanded, View convertview, ViewGroup parentview) {
        String group_title = (String) getGroup(parent);
        if(convertview == null)
        {
            LayoutInflater inflator = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflator.inflate(R.layout.expandable_parent_layout, parentview,false);
        }
        TextView parent_textview = (TextView) convertview.findViewById(R.id.parent_txt);
        parent_textview.setTypeface(null, Typeface.BOLD);
        parent_textview.setText(group_title);
        return convertview;
    }

    @Override
    public View getChildView(int parent, int child, boolean lastChild, View convertview,
                             ViewGroup parentview) {
        String child_title =  (String) getChild(parent, child);
        if(convertview == null)
        {
            LayoutInflater inflator = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflator.inflate(R.layout.expandable_child_layout, parentview,false);
        }
        ImageView imageView = (ImageView) convertview.findViewById(R.id.imageChild);
        imageView.setImageResource(R.mipmap.ic_action_action_assignment_turned_in);

        TextView child_textview = (TextView) convertview.findViewById(R.id.child_txt);
        child_textview.setText(child_title);


        return convertview;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

   

}
