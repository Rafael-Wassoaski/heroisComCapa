package br.com.recyclerviewaula;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class EditFilmActivity extends AppCompatActivity {

    EditText tituloEditText;
    EditText generoEditText;
    EditText anoEditText;
    EditText imageURL;
    ImageView capaImage;
    Button botaoAcao;
    Filme filme;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_film);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tituloEditText = (EditText) findViewById(R.id.tituloEditText);
        generoEditText = (EditText) findViewById(R.id.generoEditText);
        anoEditText = (EditText) findViewById(R.id.anoEditText);
        capaImage = (ImageView) findViewById(R.id.capaImageView);
        imageURL = (EditText) findViewById(R.id.imageEditText);
        botaoAcao = (Button) findViewById(R.id.botaoAcao);



        Bundle bundle = getIntent().getExtras();
        final int requestCode = bundle.getInt("request_code");
        if (requestCode == 1) {
            filme = (Filme) bundle.getSerializable("filme");
            position = bundle.getInt("position");
            tituloEditText.setText(filme.getTitulo());
            generoEditText.setText(filme.getGenero());
            anoEditText.setText(String.valueOf(filme.getAno()));
            imageURL.setText(filme.getCapa());
            Picasso.get().load(filme.getCapa()).resize(500, 800).into(capaImage);

            botaoAcao.setText("Atualizar Imagem");
            botaoAcao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Picasso.get().load(imageURL.getText().toString()).resize(500,800).into(capaImage);



                }
            });
        } else {
            filme = new Filme();
            FloatingActionButton fab = findViewById(R.id.fab);

            botaoAcao.setText("Carregar Imagem");
            botaoAcao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Picasso.get().load(imageURL.getText().toString()).resize(500,800).into(capaImage);



                }
            });
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    filme.setTitulo(tituloEditText.getText().toString());
                    filme.setGenero(generoEditText.getText().toString());
                    filme.setAno(Integer.valueOf(anoEditText.getText().toString()));
                    Intent returnIntent = new Intent();
                    Bundle returnBundle = new Bundle();
                    returnBundle.putSerializable("filme", filme);

                    if (requestCode == 1)
                        returnBundle.putInt("position", position);

                    returnIntent.putExtras(returnBundle);
                    setResult(Activity.RESULT_OK, returnIntent);
                    finish();
                }
            });
        }

    }

}