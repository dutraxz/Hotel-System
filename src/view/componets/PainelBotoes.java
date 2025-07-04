package view.componets;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PainelBotoes extends HBox {

    //criação do objeto
    public Button btnCadastro = new Button("Cadastrar");
    public Button btnAtualizar = new Button("Atualizar");
    public Button btnExcluir = new Button("Excluir");

    public PainelBotoes() {

        //Inserir imagem em container para manipilar tamanho/rendimensionamento
        Image iconBtnCadastrar = new Image(getClass().getResourceAsStream
                ("/view/resources/img/icon.adicionarfunc.png"));
        Image iconBtnAtualizar = new Image(getClass().getResourceAsStream
                ("/view/resources/img/icon.atualizar.png"));
        Image iconBtnExcluir = new Image(getClass().getResourceAsStream
                ("/view/resources/img/icon.deletar.png"));


        ImageView icon1 = new ImageView(iconBtnCadastrar);
        icon1.setFitWidth(25); //Definição de Largura
        icon1.setFitHeight(25); //Definição de altura
//        icon1.setOpacity(0.99); //Definição de opacidade: 0.0 - invisível / 1.0 - opaco

        ImageView icon2 = new ImageView(iconBtnAtualizar);
        icon2.setFitWidth(25);
        icon2.setFitHeight(25);
//        icon2.setOpacity(0.99);

        ImageView icon3 = new ImageView(iconBtnExcluir);
        icon3.setFitWidth(25);
        icon3.setFitHeight(25);
//        icon3.setOpacity(0.9);


        //faz o icon aparecer
        setSpacing(1);

        btnCadastro.setGraphic(icon1);
        btnAtualizar.setGraphic(icon2);
        btnExcluir.setGraphic(icon3);

        String styleButton = "-fx-background-color: transparent;" +
                "-fx-border-color: transparent; " +
                "-fx-border-graphic-text-gap: 15px;" +
                "-fx-alignment: center;" +
                "-fx-cursor: hand;";

        btnCadastro.setStyle(styleButton);
        btnAtualizar.setStyle(styleButton);
        btnExcluir.setStyle(styleButton);

        //Cliente
        btnCadastro.setOnMouseEntered(evento ->
                btnCadastro.setStyle(styleButton.replace("transparent", "white")));
        btnCadastro.setOnMouseExited(evento -> btnCadastro.setStyle(styleButton));

        //Relatorio
        btnAtualizar.setOnMouseEntered(evento ->
                btnAtualizar.setStyle(styleButton.replace("transparent", "white")));
        btnAtualizar.setOnMouseExited(evento -> btnAtualizar.setStyle(styleButton));

        //Reserva
        btnExcluir.setOnMouseEntered(evento ->
                btnExcluir.setStyle(styleButton.replace("transparent", "white")));
        btnExcluir.setOnMouseExited(evento -> btnExcluir.setStyle(styleButton));




        getChildren().addAll(btnCadastro, btnAtualizar, btnExcluir);
    }

}