package ers.screenmatch;

import ers.screenmatch.calculo.CalculadoraDeTempo;
import ers.screenmatch.calculo.FiltroDeRecomendacao;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme(new Titulo("O poderoso chefão",1970,180),"Francis Ford Coppol");
        Filme meuFilme2 = new Filme(new Titulo("Avatar",2023,200),"James Cameron");
        meuFilme.getTitulo().getFichaTecnica();
        meuFilme.getTitulo().avalia(10);

        Serie serie = new Serie(new Titulo("Lost", 200),8,20,30,false);
        CalculadoraDeTempo calculadoraDeTempo = new CalculadoraDeTempo();
        calculadoraDeTempo.inclui(meuFilme.getTitulo());
        calculadoraDeTempo.inclui(meuFilme2.getTitulo());
        System.out.printf("tempo calculadora "+calculadoraDeTempo.getTempoTotal()+"\n");
        FiltroDeRecomendacao filtro = new FiltroDeRecomendacao();
        filtro.filtra(meuFilme.getTitulo());

       /* System.out.println(meuFilme.getSomaDasAvaliacoes());
        System.out.println(meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());*/
    }
}
