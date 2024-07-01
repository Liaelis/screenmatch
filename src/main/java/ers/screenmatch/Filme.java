package ers.screenmatch;

public class Filme {

   private Titulo titulo;

   private String diretor;

    public Filme(Titulo titulo, String diretor) {
        this.titulo = titulo;
        this.diretor = diretor;

    }



    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
}
