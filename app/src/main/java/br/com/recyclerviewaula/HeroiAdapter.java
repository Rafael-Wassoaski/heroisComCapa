package br.com.recyclerviewaula;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.Collections;
import java.util.List;

public class HeroiAdapter extends RecyclerView.Adapter {

    private List<Heroi> listaHerois;
    private Actions actions;
    private int posicaoRemovidoRecentemente;
    private Heroi heroisRemovidoRecentemente;

    public HeroiAdapter(List<Heroi> listaHerois, Actions actions) {
        this.listaHerois = listaHerois;
        this.actions = actions;
    }

    public List<Heroi> getListaFilmes() {
        return listaHerois;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row, viewGroup, false);

        HeroiViewHolder holder = new HeroiViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, final int i) {
        HeroiViewHolder holder = (HeroiViewHolder) viewHolder;
        holder.nomeHeroiTextView.setText(listaHerois.get(i).getNomeHeroi());
        holder.poderTextView.setText(listaHerois.get(i).getPoder());
        holder.nomeTextView.setText(String.valueOf(listaHerois.get(i).getNome()));
        Picasso.get().load(String.valueOf(listaHerois.get(i).getCapa())).resize(200,200).into(holder.capaImageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actions.edit(viewHolder.getAdapterPosition());
            }
        });


    }

    public void remover(int position){
        posicaoRemovidoRecentemente = position;
        heroisRemovidoRecentemente = listaHerois.get(position);


        listaHerois.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,this.getItemCount());
        actions.undo();
    }

    public void restaurar(){
        listaHerois.add(posicaoRemovidoRecentemente,heroisRemovidoRecentemente);
        notifyItemInserted(posicaoRemovidoRecentemente);
    }

    public void inserir(Heroi filme){
        listaHerois.add(filme);
        notifyItemInserted(getItemCount());
    }

    public void mover(int fromPosition, int toPosition){
        if (fromPosition < toPosition)
            for (int i = fromPosition; i < toPosition; i++)
                Collections.swap(listaHerois, i, i+1);
        else
            for (int i = fromPosition; i > toPosition; i--)
                Collections.swap(listaHerois, i, i-1);
        notifyItemMoved(fromPosition,toPosition);
    }

    public void updateNomeHeroi(String newNomeHeroi, int position){
        listaHerois.get(position).setNomeHeroi(newNomeHeroi);
        notifyItemChanged(position);
    }

    public void updatePoder(String newPoder, int position){
        listaHerois.get(position).setPoder(newPoder);
        notifyItemChanged(position);
    }

    public void updatNome (String newNome, int position){
        listaHerois.get(position).setNome(newNome);
        notifyItemChanged(position);
    }

    public void updateCapa(String newCapa, int position){
        listaHerois.get(position).setCapa(newCapa);
        notifyItemChanged(position);
    }

    public void update(Heroi heroi, int position){
        listaHerois.get(position).setCapa(heroi.getCapa());
        listaHerois.get(position).setNome(heroi.getNome());
        listaHerois.get(position).setNomeHeroi(heroi.getNomeHeroi());
        listaHerois.get(position).setPoder(heroi.getPoder());
        notifyItemChanged(position);
    }

    @Override
    public int getItemCount() {
        return listaHerois.size();
    }

    public static class HeroiViewHolder extends RecyclerView.ViewHolder {

        TextView nomeHeroiTextView;
        TextView poderTextView;
        TextView nomeTextView;
        ImageView capaImageView;

        public HeroiViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setTag(this);
            nomeHeroiTextView = (TextView) itemView.findViewById(R.id.nomeHeroi);
            poderTextView = (TextView) itemView.findViewById(R.id.poder);
            nomeTextView = (TextView) itemView.findViewById(R.id.nome);
            capaImageView = (ImageView)itemView.findViewById(R.id.capa);
        }

    }

}
