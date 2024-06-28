package ers.screenmatch;

public class Serie {

    private Titulo titulo;
    private  int temporadas;
    private int episiodioPorTemporada;
    private int duracaoEmMinuros;
    private  boolean statusAtividade;
    private int minutosPorEpisodio;


    public Serie(Titulo titulo, int temporadas, int episiodioPorTemporada, int minutosPorEpisodio, boolean statusAtividade) {
        this.titulo = titulo;
        this.temporadas = temporadas;
        this.episiodioPorTemporada = episiodioPorTemporada;
        this.minutosPorEpisodio = minutosPorEpisodio;
        this.statusAtividade = statusAtividade;
    }

    public int getDuracaoEmMinuros() {
        duracaoEmMinuros = (minutosPorEpisodio*episiodioPorTemporada)*temporadas;
        return duracaoEmMinuros;
    }


    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public boolean isStatusAtividade() {
        return statusAtividade;
    }

    public void setStatusAtividade(boolean statusAtividade) {
        this.statusAtividade = statusAtividade;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    public int getEpisiodioPorTemporada() {
        return episiodioPorTemporada;
    }

    public void setEpisiodioPorTemporada(int episiodioPorTemporada) {
        this.episiodioPorTemporada = episiodioPorTemporada;
    }
}
