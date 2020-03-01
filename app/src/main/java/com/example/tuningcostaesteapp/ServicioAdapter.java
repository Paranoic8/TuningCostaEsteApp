package com.example.tuningcostaesteapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ServicioAdapter extends RecyclerView.Adapter<ServicioAdapter.ViewHolder> {


    private List<Servicio> servicios;
    private Context context;
    private OnItemClickListener listener;

    public ServicioAdapter(List<Servicio> servicios, Context context) {
        this.servicios = servicios;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler_servicios, parent, false);
        this.context = parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Servicio servicio = servicios.get(position);

        holder.tvNombreServicio.setText(servicio.getNombre());

        if (String.valueOf(servicio.getFotoURL()) != null) {

            /**
             *
             Personalizar uso de las imagens**/
            RequestOptions options = new RequestOptions();
            options.diskCacheStrategy(DiskCacheStrategy.ALL);//almaccena en cache la imagen de origen , despues de transformadada
            options.centerCrop();
            options.placeholder(R.drawable.default_image);//mostrar mientras la imagen carga

            Glide.with(context).load(servicio.getFotoURL()).apply(options).into(holder.imgPhotoServicio);
        } else {
            holder.imgPhotoServicio.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.default_image));
        }

        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Boton editar", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

        holder.contentMainServicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Item Click", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.servicios.size();
    }

    public void add(Servicio servicio) {
        if (servicios.contains(servicio)) {
            servicios.add(servicio);
            notifyDataSetChanged();
        }

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_photoServicio)
        AppCompatImageView imgPhotoServicio;
        @BindView(R.id.tv_nombreServicio)
        AppCompatTextView tvNombreServicio;
        @BindView(R.id.btn_edit)
        AppCompatImageView btnEdit;
        @BindView(R.id.contentMainServicio)
        RelativeLayout contentMainServicio;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }
    }
}
