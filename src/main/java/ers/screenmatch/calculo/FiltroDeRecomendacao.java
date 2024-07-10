package ers.screenmatch.calculo;

import ers.screenmatch.modelo.Avalicao;

public class FiltroDeRecomendacao {
    private String recomendacao;


    public void filtra(Avalicao avalicao){
         if(avalicao.getClassificacao() >= 4){
             System.out.printf("Esta entre os preferidos");

         } else if (avalicao.getClassificacao()>=2) {
             System.out.printf("Muito bem avaliado");

         }else {
             System.out.printf("Coloque na sua lista para assistir");
         }
    }
}
