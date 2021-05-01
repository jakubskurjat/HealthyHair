package com.example.healthyhair;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    List<Cosmetic> data;
    Context context;
    List<ImageView> imageList = new ArrayList<>();

    /**
     * This is a constructor.
     */
    public RecyclerViewAdapter(Context context, List<Cosmetic> data) {
        this.context = context;
        this.data = data;
    }

    /**
     * This override method is called when opening a RecycleViewAdapter.
     *
     * @param parent   represents parent of view group.
     * @param viewType is useless.
     * @return new ViewHolder.
     */
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.cosmetic_row, parent, false);

        return new ViewHolder(view);
    }

    /**
     * This overridden method is called when user scrolls list.
     * It shows us fragment of date list and sets the appropriate image.
     *
     * @param holder   represents actually ViewHolder.
     * @param position is a date position.
     */
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.cosmeticName.setText(data.get(position).getCosmeticName());
        holder.cosmeticSpec.setText(data.get(position).getCosmeticSpec());
        holder.cosmeticType.setText(data.get(position).getCosmeticType());
        holder.cosmeticPorosity.setText(data.get(position).getCosmeticPorosity());
        holder.cosmeticComposition.setText(data.get(position).getCosmeticComposition());
        holder.image.setImageResource(data.get(position).getCosmeticImage());
    }

    /**
     * @return date list size.
     */
    @Override
    public int getItemCount() {
        return data.size();
    }

    /**
     * This is the inner class that represents ViewHolder.
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView cosmeticName, cosmeticSpec, cosmeticType, cosmeticPorosity, cosmeticComposition;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cosmeticName = itemView.findViewById(R.id.cosmeticName);
            cosmeticSpec = itemView.findViewById(R.id.cosmeticSpec);
            cosmeticType = itemView.findViewById(R.id.cosmeticType);
            cosmeticPorosity = itemView.findViewById(R.id.cosmeticPorosity);
            cosmeticComposition = itemView.findViewById(R.id.cosmeticComposition);
            image = itemView.findViewById(R.id.image);
        }
    }
}
