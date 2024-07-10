package ers.screenmatch.principal;

import ers.screenmatch.calculo.CalculadoraDeTempo;
import ers.screenmatch.calculo.FiltroDeRecomendacao;
import ers.screenmatch.modelo.Filme;
import ers.screenmatch.modelo.Serie;
import ers.screenmatch.modelo.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme(new Titulo("O poderoso chefão",1970,180),"Francis Ford Coppol");
        Filme meuFilme2 = new Filme(new Titulo("Avatar",2023,200),"James Cameron");
        meuFilme.getTitulo().getFichaTecnica();
        meuFilme.getTitulo().avalia(10);
        Filme filme = new Filme(new Titulo("Divertidamente",2010,150), "Pixar");
        Serie serie = new Serie(new Titulo("Lost", 2000),8,20,30,false);
        CalculadoraDeTempo calculadoraDeTempo = new CalculadoraDeTempo();
        calculadoraDeTempo.inclui(meuFilme.getTitulo());
        calculadoraDeTempo.inclui(meuFilme2.getTitulo());
        System.out.printf("tempo calculadora "+calculadoraDeTempo.getTempoTotal()+"\n");
        FiltroDeRecomendacao filtro = new FiltroDeRecomendacao();
        filtro.filtra(meuFilme.getTitulo());
        ArrayList<Titulo> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(meuFilme.getTitulo());
        listaDeFilmes.add(meuFilme2.getTitulo());
        listaDeFilmes.add(filme.getTitulo());
        listaDeFilmes.add(serie.getTitulo());

      //  System.out.printf(listaDeFilmes.toString());
       // System.out.printf(listaDeFilmes.get(0).toString());
       /* System.out.println(meuFilme.getSomaDasAvaliacoes());
        System.out.println(meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());*/


        System.out.println(listaDeFilmes);
        Collections.sort(listaDeFilmes);
        System.out.println(listaDeFilmes);
        listaDeFilmes.sort(Comparator.comparing(Titulo:: getAnoDeLancamento));
        System.out.println(listaDeFilmes);


        ArrayList<String> buscaPorArtista = new ArrayList<>();
        buscaPorArtista.add("Adam Sandler");
        buscaPorArtista.add("Agelina Joli");
        buscaPorArtista.add("Tom Cruise");
        buscaPorArtista.add("Natali Portman");
        buscaPorArtista.add("Robert Patisson");
        buscaPorArtista.add("Nicole Kidman");
        System.out.println(buscaPorArtista);
        Collections.sort(buscaPorArtista);
        System.out.println(buscaPorArtista);
    }
}
