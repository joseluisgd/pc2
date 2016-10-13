package adapters;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.jose.pokemong.CaptureActivity;
import com.example.jose.pokemong.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import clases.Pokemon;

/**
 * Created by jose on 10/8/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PokeHolder>{
    private ArrayList<Pokemon> mPokemones;
    private Context context;
    private String username;



    public RecyclerAdapter(ArrayList<Pokemon> mPokemones,Context context,String username) {
        this.mPokemones = mPokemones;
        this.context= context;
        this.username=username;

    }


    @Override
    public RecyclerAdapter.PokeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.poke, parent, false);
        return new PokeHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.PokeHolder holder, int position) {

        holder.tviNombrePokemon.setText(mPokemones.get(position).getName());
        Picasso.with(context).load(mPokemones.get(position).getImg()).into(holder.mImagenPokemon);
        holder.url = mPokemones.get(position).getImg();
        holder.idPoke=mPokemones.get(position).getId();
        holder.username=username;
        holder.nombrePoke=mPokemones.get(position).getName();
        holder.tipo=mPokemones.get(position).getType();
        holder.nivel=mPokemones.get(position).getNivel();
        holder.descripcion=mPokemones.get(position).getDescription();
        /*
        Log.i("RecyclerAdapter","size: " + size);
        Log.i("RecyclerAdapter","position: " + position);
        int i=0;
        i++;
        Log.i("RecyclerAdapter","i: " + i);
        if(position==size-1){

            progress.dismiss();
        }
        */



    }

    @Override
    public int getItemCount() {
        return mPokemones.size();
    }

    //1
    public static class PokeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //2
        //private int i=0;
        private ImageView mImagenPokemon;
        private TextView tviNombrePokemon;
        private Pokemon mPokemon;
        private String url="";
        private int idPoke=0;
        private String username;
        private String nombrePoke;
        private String tipo;
        private int nivel;
        private String descripcion;


        //3
        //private static final String PHOTO_KEY = "PHOTO";

        //4
        public PokeHolder(View v) {
            super(v);
            mImagenPokemon = (ImageView) v.findViewById(R.id.imgPoke);
            tviNombrePokemon = (TextView) v.findViewById(R.id.tviNombrePoke);
            v.setOnClickListener(this);
        }

        //5
        @Override
        public void onClick(View v) {
            Context context = itemView.getContext();
            Intent intent = new Intent(context, CaptureActivity.class);
            intent.putExtra("url",url);
            intent.putExtra("idPoke",idPoke);
            intent.putExtra("username",username);
            intent.putExtra("nombrepoke",nombrePoke);
            intent.putExtra("tipo",tipo);
            intent.putExtra("nivel",nivel);
            intent.putExtra("descripcion",descripcion);
            context.startActivity(intent);
        }
    }
}
