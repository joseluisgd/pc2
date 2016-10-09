package adapters;

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

import java.util.ArrayList;

import clases.Pokemon;

/**
 * Created by jose on 10/8/16.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PokeHolder>{
    private ArrayList<Pokemon> mPokemones;

    public RecyclerAdapter(ArrayList<Pokemon> mPokemones) {
        this.mPokemones = mPokemones;
    }


    @Override
    public RecyclerAdapter.PokeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflatedView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.poke, parent, false);
        return new PokeHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.PokeHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mPokemones.size();
    }

    //1
    public static class PokeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //2
        private ImageView mImagenPokemon;
        private TextView tviNombrePokemon;
        private Pokemon mPokemon;

        //3
        private static final String PHOTO_KEY = "PHOTO";

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
            Intent showPhotoIntent = new Intent(context, CaptureActivity.class);
//          showPhotoIntent.putExtra(PHOTO_KEY, mPhoto);
            context.startActivity(showPhotoIntent);
        }
    }
}
