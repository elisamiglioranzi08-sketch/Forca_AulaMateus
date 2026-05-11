package com.example.forca_integrado;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;

public class TelaJogo extends AppCompatActivity implements View.OnClickListener {

    private ImageView imagem;
    private int indiceListaImagens;
    private Arraylist<Integer> ListaImagens, ListaIdsButtons;
    private ArrayList<String> ListaPalavras;
    private Button b1;
    private TextView texto;
    private String palavra;
    private char[] estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela_jogo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        imagem = findViewById(R.id.imageView2);
        indiceListaImagens = -1;
        ListaImagens = new Arraylist<Integer>();
        ListaImagens.add(R.drawable.forca_1_9);
        ListaImagens.add(R.drawable.forca_2_9);
        ListaImagens.add(R.drawable.forca_3_9);
        ListaImagens.add(R.drawable.forca_4_9);
        ListaImagens.add(R.drawable.forca_5_9);
        ListaImagens.add(R.drawable.forca_6_9);
        ListaImagens.add(R.drawable.forca_7_9);
        ListaImagens.add(R.drawable.forca_9_9);
        ListaImagens.add(R.drawable.forca_10_9);
        ListaImagens.add(R.drawable.forca_11_9);

        ListaPalavras = new ArrayList<String>();
        ListaPalavras.add("CAIXA");
        ListaPalavras.add("SUPERMERCADO");
        ListaPalavras.add("COMPUTADOR");
        ListaPalavras.add("INSTITUTO");
        ListaPalavras.add("CELEBRIDADE");
        ListaPalavras.add("HIMALAIA");
        ListaPalavras.add("FESTIVAL");
        ListaPalavras.add("SHAKIRA");
        ListaPalavras.add("COMPUTAÇÃO");
        ListaPalavras.add("CORINTHIANS");
        ListaPalavras.add("PENTEADEIRA");
        ListaPalavras.add("ESCRIVANINHA");

        texto = findViewById(R.id.textView3);

        ListaIdsButtons = new Arraylist<Integer>();
        ListaIdsButtons.add(R.id.id1);
        ListaIdsButtons.add(R.id.id2);
        ListaIdsButtons.add(R.id.id3);
        ListaIdsButtons.add(R.id.id4);
        ListaIdsButtons.add(R.id.id5);
        ListaIdsButtons.add(R.id.id6);
        ListaIdsButtons.add(R.id.id7);
        ListaIdsButtons.add(R.id.id8);
        ListaIdsButtons.add(R.id.id9);
        ListaIdsButtons.add(R.id.id10);
        ListaIdsButtons.add(R.id.id11);
        ListaIdsButtons.add(R.id.id12);
        ListaIdsButtons.add(R.id.id13);
        ListaIdsButtons.add(R.id.id14);
        ListaIdsButtons.add(R.id.id15);
        ListaIdsButtons.add(R.id.id16);
        ListaIdsButtons.add(R.id.id17);
        ListaIdsButtons.add(R.id.id18);
        ListaIdsButtons.add(R.id.id19);
        ListaIdsButtons.add(R.id.id20);
        ListaIdsButtons.add(R.id.id21);
        ListaIdsButtons.add(R.id.id22);
        ListaIdsButtons.add(R.id.id23);
        ListaIdsButtons.add(R.id.id24);
        ListaIdsButtons.add(R.id.id25);
        ListaIdsButtons.add(R.id.id26);

        for (int j = 0; j<ListaIdsButtons.size(); j++){
            Button b = findViewById(ListaIdsButtons.get(j));
            b.setOnClickListener(this);
        }
        inicializaJogo();
    }

    public void inicializaJogo(){
        imagem.setImageResource(R.drawable.forca_0_9);
        indiceListaImagens = 0;
        palavra = sorteiaPalavra();
        estado = new char[palavra.length()];
        for(int i = 0; i<estado.length; i++) {
            estado[i] = '_';
        }
        atualizaTexto();
    }

    public void verificarLetra(char c){
        boolean status = false;
        for(int i=0; i<palavra.length(); i++){
            if( palavra.charAt(i)==c ){
                status = true;
                estado[i] = c;
            }
        }
        if(!status){
            atualizaForca();
        }
        else{
            atualizaTexto();
        }
    }

    public void atualizaTexto(){
        String temporaria = new String();
        temporaria = "";
        for(int i = 0; i<estado.length; i++){
            temporaria += estado[i] + " ";
        }
        texto.setText(temporaria);
    }
    public String sorteiaPalavra (){
        String retorno = new String();
        Collections.shuffle(ListaPalavras);
        retorno = ListaPalavras.get(0);
        return retorno;
    }
    public void atualizaForca(){
        indiceListaImagens++;
        imagem.setImageResource(ListaImagens.get(indiceListaImagens));
    }

    @Override
    public void onClick(View view) {
        Button b = (Button) view;
        verificarLetra(b.getText().toString().charAt(0));
        b.setEnabled(false);
    }
}