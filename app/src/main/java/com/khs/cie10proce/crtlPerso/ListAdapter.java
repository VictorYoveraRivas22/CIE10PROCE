package com.khs.cie10proce.crtlPerso;

import android.content.Context;
import android.media.Image;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.khs.cie10proce.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

 private List<List_Element> mdata;
 private LayoutInflater minflater;
 private Context context;


 public ListAdapter(List<List_Element> itemList, Context context){
     this.minflater=LayoutInflater.from(context);
     this.context=context;
     this.mdata=itemList;

 }


    @Override
    public int getItemCount() {
        return this.mdata.size();
    }


    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= minflater.inflate(R.layout.list_element,null);
           return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final  ListAdapter.ViewHolder holder,final int position) {

     holder.bindData(mdata.get(position));

     holder.iconfavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("estoy aqui","aca");
                boolean xd=mdata.get(position).getFavorito();

                if (xd){
                    mdata.get(position).setFavorito(false);
                    holder.iconfavorite.setImageResource(R.drawable.ic_baseline_star_border_24);
                }else{
                    mdata.get(position).setFavorito(true);
                    holder.iconfavorite.setImageResource(R.drawable.ic_baseline_star_24);
                }
               }
        });



    }

    public void setItem(List<List_Element> item){ mdata=item;}


    public class ViewHolder extends  RecyclerView.ViewHolder{
        private TextView txtcodigo,txttip,txtciedescrip;
        private ImageView iconfavorite;
        private  ImageView iconview3;

        //falta agregar edad minima, maxima activo y otros

        ViewHolder(View view){
            super(view);
            iconfavorite= view.findViewById(R.id.iconfavorite);
            iconview3= view.findViewById(R.id.iconview3);
            txtcodigo= view.findViewById(R.id.txtcodigo);
            txttip= view.findViewById(R.id.txttip);
            txtciedescrip= view.findViewById(R.id.txtciedescrip);
        }
        void bindData(final List_Element item){
            if (item.getFavorito()){
                iconfavorite.setImageResource(R.drawable.ic_baseline_star_24);
            }else{
                iconfavorite.setImageResource(R.drawable.ic_baseline_star_border_24);
            }
            txtcodigo.setText(item.getCodigo());
            txttip.setText(item.getTipocie());
            txtciedescrip.setText(item.getDescripcion());
        }
    }




}
