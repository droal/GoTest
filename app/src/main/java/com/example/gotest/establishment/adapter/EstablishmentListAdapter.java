package com.example.gotest.establishment.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gotest.R;
import com.example.gotest.api.establishment.Establishment;
import com.example.gotest.databinding.RecyclervItemBinding;

import java.util.List;


public class EstablishmentListAdapter extends RecyclerView.Adapter<EstablishmentListAdapter.EstablishmentListViewHolder> {

    private List<Establishment> establishment;

    public void refreshList(List<Establishment> establishment){
        this.establishment = establishment;
        notifyDataSetChanged();
    }

/****Adapter metods**/
    @NonNull
    @Override
    public EstablishmentListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EstablishmentListViewHolder(RecyclervItemBinding.inflate(LayoutInflater.from(parent.getContext()),
                parent, false));
    }


    @Override
    public void onBindViewHolder(@NonNull EstablishmentListViewHolder holder, int position) {

        if(establishment.get(position).getNombre() != null){
            holder.binding.itemName.setVisibility(View.VISIBLE);
            holder.binding.itemName.setText(establishment.get(position).getNombre());
        }else{
            holder.binding.itemName.setVisibility(View.GONE);
        }


        if(establishment.get(position).getCiudadestablecimiento() != null){
            holder.binding.itemCiudad.setVisibility(View.VISIBLE);
            holder.binding.itemCiudad.setText(establishment.get(position).getCiudadestablecimiento());
        }else{
            holder.binding.itemCiudad.setVisibility(View.GONE);
        }

        if(establishment.get(position).getDireccion() != null){
            holder.binding.itemDir.setVisibility(View.VISIBLE);
            holder.binding.itemDir.setText(establishment.get(position).getDireccion());
        }else{
            holder.binding.itemDir.setVisibility(View.GONE);
        }

        if(establishment.get(position).getHorario() != null){
            holder.binding.itemHorario.setVisibility(View.VISIBLE);
            holder.binding.itemHorario.setText(establishment.get(position).getHorario());
        }else{
            holder.binding.itemHorario.setVisibility(View.GONE);
        }

        if(establishment.get(position).getHorario() != null){
            holder.binding.itemHorario.setVisibility(View.VISIBLE);
            holder.binding.itemHorario.setText(establishment.get(position).getHorario());
        }else{
            holder.binding.itemHorario.setVisibility(View.GONE);
        }


        if(establishment.get(position).getTarifaMoto() != null){
            holder.binding.itemTarMoto.setVisibility(View.VISIBLE);
            holder.binding.itemTarMoto.setText(establishment.get(position).getTarifaMoto());
        }else{
            holder.binding.itemTarMoto.setVisibility(View.GONE);
            holder.binding.itemMotoIm.setVisibility(View.GONE);
        }

        if(establishment.get(position).getTarifaVehiculo() != null){
            holder.binding.itemTarCarro.setVisibility(View.VISIBLE);
            holder.binding.itemTarCarro.setText(establishment.get(position).getTarifaVehiculo());
        }else{
            holder.binding.itemTarCarro.setVisibility(View.GONE);
            holder.binding.itemCarIm.setVisibility(View.GONE);
        }


        if(establishment.get(position).getImageurl() == null){
            holder.binding.itemImage.setImageResource(R.drawable.establecimiento);
        }else {
            Glide.with(holder.binding.itemImage.getContext())
                    .load(establishment.get(position).getImageurl())
                    .error(R.drawable.establecimiento)
                    .circleCrop()
                    .into(holder.binding.itemImage);
        }
    }

    @Override
    public int getItemCount() {
        if(establishment != null){
            return establishment.size();
        }
        return 0;
    }
/****Adapter metods**/

    class EstablishmentListViewHolder extends RecyclerView.ViewHolder{

        RecyclervItemBinding binding;

        private EstablishmentListViewHolder(@NonNull RecyclervItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;

        }
    }
}
