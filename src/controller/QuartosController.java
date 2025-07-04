package controller;

import dao.QuartosDao;
import model.Quartos;

public class QuartosController {
    private final QuartosDao quartosDao;

    public QuartosController() {
        this.quartosDao = new QuartosDao();
    }


    public boolean verificarInfosQuarto(String nome, String numero, double preco,
                                        int qtd_cama_casal, int qtd_cama_solteiro,
                                        boolean disponivel) {

        Quartos quarto = new Quartos(nome, numero, preco, qtd_cama_solteiro, qtd_cama_casal , disponivel);
        return quartosDao.inserirQuartos(quarto);
    }
}



