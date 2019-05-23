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

public class EditHeroiActivity extends AppCompatActivity {

    EditText nomeHeroiEditText;
    EditText nomeEditText;
    EditText poderEditText;
    EditText imageURL;
    ImageView capaImage;
    Button botaoAcao;
    Heroi heroi;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_film);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nomeHeroiEditText = (EditText) findViewById(R.id.nomeHeroi);
        nomeEditText = (EditText) findViewById(R.id.generoEditText);
        poderEditText = (EditText) findViewById(R.id.poder);
        capaImage = (ImageView) findViewById(R.id.capa);
        imageURL = (EditText) findViewById(R.id.imageEditText);
        botaoAcao = (Button) findViewById(R.id.botaoAcao);



        Bundle bundle = getIntent().getExtras();
        final int requestCode = bundle.getInt("request_code");
        if (requestCode == 1) {
            heroi = (Heroi) bundle.getSerializable("filme");
            position = bundle.getInt("position");
            tituloEditText.setText(heroi.getTitulo());
            generoEditText.setText(heroi.getGenero());
            anoEditText.setText(String.valueOf(heroi.getAno()));
            imageURL.setText(heroi.getCapa());
            Picasso.get().load(heroi.getCapa()).resize(500, 800).into(capaImage);

            botaoAcao.setText("Atualizar Imagem");
            botaoAcao.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Picasso.get().load(imageURL.getText().toString()).resize(500,800).into(capaImage);



                }
            });
        } else {
            heroi = new Heroi();
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
                    heroi.setTitulo(tituloEditText.getText().toString());
                    heroi.setGenero(generoEditText.getText().toString());
                    heroi.setAno(Integer.valueOf(anoEditText.getText().toString()));
                    Intent returnIntent = new Intent();
                    Bundle returnBundle = new Bundle();
                    returnBundle.putSerializable("filme", heroi);

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