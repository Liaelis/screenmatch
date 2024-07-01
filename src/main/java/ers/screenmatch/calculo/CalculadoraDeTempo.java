package ers.screenmatch.calculo;

import ers.screenmatch.Filme;
import ers.screenmatch.Serie;
import ers.screenmatch.Titulo;

public class CalculadoraDeTempo {

    private int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

    public void inclui(Titulo t){
        tempoTotal+= t.getDuracaoEmMinutos();
    }

}
