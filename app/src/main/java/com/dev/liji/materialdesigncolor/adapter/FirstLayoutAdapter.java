package com.dev.liji.materialdesigncolor.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dev.liji.materialdesigncolor.R;
import com.dev.liji.materialdesigncolor.model.MaterialDesignColor;

import java.util.List;

/**
 * Created by liji on 16-6-14.
 */
public class FirstLayoutAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    LayoutInflater mLayoutInflater;
    Context context;
    List<MaterialDesignColor> materialDesignColorList;

    public FirstLayoutAdapter(Context context, List<MaterialDesignColor> materialDesignColorList) {
        mLayoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.materialDesignColorList = materialDesignColorList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new FirstLayoutViewHolder(mLayoutInflater.inflate(R.layout.first_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MaterialDesignColor materialDesignColor = materialDesignColorList.get(position);

        ((FirstLayoutViewHolder) holder).cardbg.setBackgroundColor(materialDesignColor.getMDColor());
        ((FirstLayoutViewHolder) holder).tvName.setText(materialDesignColor.getName());
        ((FirstLayoutViewHolder) holder).tvLevel.setText(materialDesignColor.getLevel());
        ((FirstLayoutViewHolder) holder).tvValue.setText(materialDesignColor.getValue());

    }

    @Override
    public int getItemCount() {
        return materialDesignColorList.size();
    }

    public class FirstLayoutViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;
        TextView tvLevel;
        TextView tvValue;
        RelativeLayout cardbg;

        public FirstLayoutViewHolder(View itemView) {
            super(itemView);
            tvLevel = (TextView) itemView.findViewById(R.id.tv_level);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvValue = (TextView) itemView.findViewById(R.id.tv_value);
            cardbg = (RelativeLayout) itemView.findViewById(R.id.cardbg);
        }
    }
}
