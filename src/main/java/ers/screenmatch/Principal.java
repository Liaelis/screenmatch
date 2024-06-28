package ers.screenmatch;

public class Principal {
    public static void main(String[] args) {
        Filme meuFilme = new Filme(new Titulo("O poderoso chefão",1970),"Francis Ford Coppol",180);

        meuFilme.getTitulo().getFichaTecnica();

       /* System.out.println(meuFilme.getSomaDasAvaliacoes());
        System.out.println(meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());*/
    }
}
