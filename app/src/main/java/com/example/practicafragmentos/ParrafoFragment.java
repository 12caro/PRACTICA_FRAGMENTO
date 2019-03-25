package com.example.practicafragmentos;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ParrafoFragment extends Fragment {

    final static String ARG_POSITION = "position";
    int mCurrentPosition = -1;

    @Override
    public void onStart() {
        super.onStart();
        Bundle args = getArguments();
        if (args != null) {
            updateParrafoView(args.getInt(ARG_POSITION));
            updateDetallesView(args.getInt(ARG_POSITION));
            updateTituloView(args.getInt(ARG_POSITION));
           updateImagenView(args.getInt(ARG_POSITION));
        } else if (mCurrentPosition != -1) {
            updateParrafoView(mCurrentPosition);
            updateDetallesView(mCurrentPosition);
            updateTituloView(mCurrentPosition);
           updateImagenView(args.getInt(ARG_POSITION));
        }
    }

    public void updateTituloView(int position) {
        TextView titulo = (TextView) getActivity().findViewById(R.id.txt_titulo);
        titulo.setText(Contenido.Titulos[position]);
        mCurrentPosition = position;
    }


    public void updateParrafoView(int position) {
        TextView parrafo = (TextView) getActivity().findViewById(R.id.txt_fragmento);
        parrafo.setText(Contenido.Parrafos[position]);
        mCurrentPosition = position;
    }

    public void updateDetallesView(int position) {
        TextView detalle = (TextView) getActivity().findViewById(R.id.txt_detalle);
        detalle.setText(Contenido.Detalles[position]);
        mCurrentPosition = position;
    }



      public void updateImagenView(int position) {
      ImageView mImage = (ImageView) getActivity().findViewById(R.id.img_imagen);
        mImage.setImageResource(Contenido.sImages[position]);
      mCurrentPosition = position;
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt(ARG_POSITION);
        }
        return inflater.inflate(R.layout.fragment_parrafo, container, false);
    }


    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION, mCurrentPosition);
    }
}



