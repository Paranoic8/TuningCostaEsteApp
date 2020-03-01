package com.example.tuningcostaesteapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.RelativeLayout;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SubCategoriaAdapter extends RecyclerView.Adapter<SubCategoriaAdapter.ViewHolder> {

    private List<SubCategoria> subCategorias;
    private Context context;
    private OnItemClickListener listener;

    public SubCategoriaAdapter(List<SubCategoria> subCategorias,OnItemClickListener listener) {
        this.subCategorias = subCategorias;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_recycler, parent,false);
        this.context=parent.getContext();
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final SubCategoria  subCategoria=subCategorias.get(position);

        holder.setListener(subCategoria,listener);
        holder.tvNombre.setText(subCategoria.getNombre());

        if (String.valueOf(subCategoria.getFotoURL()) !=null){

            /**
             *
             Personalizar uso de las imagens**/
            RequestOptions options=new RequestOptions();
            options.diskCacheStrategy(DiskCacheStrategy.ALL);//almaccena en cache la imagen de origen , despues de transformadada
            options.centerCrop();
            options.placeholder(R.drawable.default_image);//mostrar mientras la imagen carga

            Glide.with(context).load(subCategoria.getFotoURL()).apply(options).into(holder.imgPhoto);
        }else{
            holder.imgPhoto.setImageDrawable(ContextCompat.getDrawable(context,R.drawable.default_image));
        }

    }

    @Override
    public int getItemCount() {
        return this.subCategorias.size();
    }

    public void add(SubCategoria subCategoria){
        if (subCategorias.contains(subCategoria)) {
            subCategorias.add(subCategoria);
            notifyDataSetChanged();
        }

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_photo)
        AppCompatImageView imgPhoto;
        @BindView(R.id.tv_nombre)
        AppCompatTextView tvNombre;
        @BindView(R.id.contentMain)
        RelativeLayout contentMain;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        void setListener(SubCategoria subCategoria, OnItemClickListener listener) {
            contentMain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(subCategoria);
                }
            });

            contentMain.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    listener.onLongItemClick(subCategoria);
                    return false;
                }
            });
        }
    }
}
