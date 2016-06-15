package com.dev.liji.materialdesigncolor.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.dev.liji.materialdesigncolor.R;
import com.dev.liji.materialdesigncolor.model.MaterialDesignColor;
import com.dev.liji.materialdesigncolor.utils.JLogUtils;
import com.dev.liji.materialdesigncolor.widget.ColorCircleView;

import java.util.List;

/**
 * Created by liji on 16-6-14.
 */
public class SecondLayoutHorizonalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    LayoutInflater mLayoutInflater;
    Context context;
    onItemClickListener listener;
    List<MaterialDesignColor> materialDesignColorList;

    public SecondLayoutHorizonalAdapter(Context context, List<MaterialDesignColor> materialDesignColorList) {
        mLayoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.materialDesignColorList = materialDesignColorList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SecondLayoutViewHolder(mLayoutInflater.inflate(R.layout.item_second_layout_horizonal, parent, false));
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        MaterialDesignColor materialDesignColor = materialDesignColorList.get(position);
        ((SecondLayoutViewHolder) holder).circle.setCircleSoildColor(materialDesignColor.getMDColor());
    }

    @Override
    public int getItemCount() {
        return materialDesignColorList.size();
    }


    public interface onItemClickListener {
        void onItemClick(View view, int posititon);
    }

    public void setOnItemClickListener(onItemClickListener listener) {
        this.listener = listener;
    }

    public class SecondLayoutViewHolder extends RecyclerView.ViewHolder {

        ColorCircleView circle;

        public SecondLayoutViewHolder(View itemView) {
            super(itemView);
            circle = (ColorCircleView) itemView.findViewById(R.id.circle);
        }
    }
}
