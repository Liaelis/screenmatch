package ers.screenmatch.modelo;

import com.google.gson.annotations.SerializedName;
import ers.screenmatch.excecao.ErroDeConversaoDeAnoException;

public class Titulo implements Avalicao, Comparable<Titulo> {


    private String nome;

    private int anoDeLancamento;
    private boolean incluidoNoPlano;
    private double somaDasAvaliacoes;
    private int totalDeAvaliacoes;
    private int duracaoEmMinutos;

    public Titulo(String nome, int anoDeLancamento, int duracaoEmMinutos) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
        this.duracaoEmMinutos = duracaoEmMinutos;
    }
    public Titulo(TituloOmdb tituloOmdb){
        this.nome = tituloOmdb.title();
        if(tituloOmdb.year().length() > 4) {
            throw new ErroDeConversaoDeAnoException("Não consegui converter o ano " +
                    "porque tem mais de 04 caracteres.");
        }
        this.anoDeLancamento = Integer.valueOf(tituloOmdb.year());
      //  this.duracaoEmMinutos = Integer.valueOf(tituloOmdb.runTime().substring(0,2));
    }
    public Titulo(String nome, int anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;

    }
    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public boolean isIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public void setIncluidoNoPlano(boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }


    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public void avalia(double nota) {
        this.somaDasAvaliacoes += nota;
        this.totalDeAvaliacoes += 1;
    }

    @Override
    public double pegaMedia() {
        double media = this.somaDasAvaliacoes / this.totalDeAvaliacoes;
        return media;
    }

    @Override
    public void getFichaTecnica() {
        System.out.println(nome);
        System.out.println(anoDeLancamento);
    }

    @Override
    public int getClassificacao() {
       return (int) (pegaMedia()/2);
    }

    @Override
    public int compareTo(Titulo outroTitulo) {

        return this.getNome().compareTo(outroTitulo.getNome());
    }
    @Override
    public String toString() {
        return "Filme: " + this.getNome() + " (" + this.getAnoDeLancamento() + ")";
    }
}
