package com.example.tuningcostaesteapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DisenoAdapter extends RecyclerView.Adapter<DisenoAdapter.ViewHolder> {



    private List<Diseno> disenos;
    private Context context;
    private OnItemClickListener listener;

    public DisenoAdapter(List<Diseno> disenos, Context context) {
        this.disenos = disenos;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_diseno, parent, false);
        this.context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Diseno diseno = disenos.get(position);

        holder.tvNombreDiseno.setText(diseno.getNombre());
        holder.tvDescripcionDiseno.setText(diseno.getDescripcion());

        if (String.valueOf(diseno.getFotoURL()) != null) {

            /**
             *
             Personalizar uso de las imagens**/
            RequestOptions options = new RequestOptions();
            options.diskCacheStrategy(DiskCacheStrategy.ALL);//almaccena en cache la imagen de origen , despues de transformadada
            options.centerCrop();
            options.placeholder(R.drawable.default_image);//mostrar mientras la imagen carga

            Glide.with(context).load(diseno.getFotoURL()).apply(options).into(holder.imgPhotoDiseno);

        } else {
            holder.imgPhotoDiseno.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.default_image));
        }


        holder.contentMainDiseno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Item Click", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();// TODO: 01/03/2020 direccionar a detalle de servicio
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.disenos.size();
    }

    public void add(Diseno diseno) {
        if (disenos.contains(diseno)) {
            disenos.add(diseno);
            notifyDataSetChanged();
        }

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_photoDiseno)
        AppCompatImageView imgPhotoDiseno;
        @BindView(R.id.tv_nombreDiseno)
        TextView tvNombreDiseno;
        @BindView(R.id.tv_descripcionDiseno)
        TextView tvDescripcionDiseno;
        @BindView(R.id.contentMainDiseno)
        RelativeLayout contentMainDiseno;


        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
