package view.componets;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class Sidebar extends VBox {
        public Button btnCliente = new Button("Cliente");
        public Button btnFuncionario = new Button("Funcionários");
        public Button btnQuarto = new Button("Quarto");
        public Button btnReserva = new Button("Reserva");
        public Button btnRelatorio = new Button("Relatórios");

    public Sidebar() {
        //carregamento de imagens
        Image iconCliente = new Image("/view/resources/img/icon.cliente.png");
        Image iconFuncionario = new Image("/view/resources/img/icon.funcionario.png");
        Image iconQuarto = new Image("/view/resources/img/icon.quarto.png");
        Image iconReserva = new Image("/view/resources/img/icon.reserva.png");
        Image iconRelatorio = new Image("/view/resources/img/icon.relatorio.png");


        //Carregamento das fontes
        Font fonteRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/" +
                "Cabin-Regular.ttf"), 14);

        Font fonteNegrito = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/" +
                "Cabin-Bold.ttf"), 15);


            //Objetompara manipular dimensões da imagens já carregadas
            ImageView viewIconCliente = new ImageView(iconCliente);
            viewIconCliente.setFitWidth(30); //Definição de Largura
            viewIconCliente.setFitHeight(30); //Definição de altura

            ImageView viewIconFuncionario = new ImageView(iconFuncionario);
            viewIconFuncionario.setFitWidth(30); //Definição de Largura
            viewIconFuncionario.setFitHeight(30); //Definição de altura

            ImageView viewIconQuarto = new ImageView(iconQuarto);
            viewIconQuarto.setFitWidth(30); //Definição de Largura
            viewIconQuarto.setFitHeight(30); //Definição de altura

            ImageView viewIconReserva = new ImageView(iconReserva);
            viewIconReserva.setFitWidth(30); //Definição de Largura
            viewIconReserva.setFitHeight(30); //Definição de altura

            ImageView viewIconRelatorio = new ImageView(iconRelatorio);
            viewIconRelatorio.setFitWidth(30); //Definição de Largura
            viewIconRelatorio.setFitHeight(30); //Definição de altura


            btnCliente.setGraphic(viewIconCliente);
            btnFuncionario.setGraphic(viewIconFuncionario);
            btnReserva.setGraphic(viewIconReserva);
            btnRelatorio.setGraphic(viewIconRelatorio);
            btnQuarto.setGraphic(viewIconQuarto);
             setSpacing(15);
            setPadding(new Insets(20));

            Label lblMenu = new Label("N O V O T E L");
            lblMenu.setStyle( "-fx-text-fill: white");

            lblMenu.setFont(Font.font(fonteNegrito.getFamily(), 25));


            //Estilização dos Botões (fundo e borda transparentes)
        String styleButton = "-fx-background-color: transparent; " +
                "-fx-border-color: transparent; " +
                "-fx-border-graphic-text-gap: 20px;" +
                "-fx-alignment: center;" +
                "-fx-text-fill: white";

        btnCliente.setStyle(styleButton);
        btnRelatorio.setStyle(styleButton);
        btnReserva.setStyle(styleButton);
        btnQuarto.setStyle(styleButton);
        btnFuncionario.setStyle(styleButton);


        //Objetivo, passar o mouse, trocar o fundo do botão para a cor selecionada

        //Cliente
        btnCliente.setOnMouseEntered(evento ->
                btnCliente.setStyle(styleButton.replace("transparent", "#142170")));
        btnCliente.setOnMouseExited(evento -> btnCliente.setStyle(styleButton));

        //Relatorio
        btnRelatorio.setOnMouseEntered(evento ->
                btnRelatorio.setStyle(styleButton.replace("transparent", "#142170")));
        btnRelatorio.setOnMouseExited(evento -> btnRelatorio.setStyle(styleButton));

        //Reserva
        btnReserva.setOnMouseEntered(evento ->
                btnReserva.setStyle(styleButton.replace("transparent", "#142170")));
        btnReserva.setOnMouseExited(evento -> btnReserva.setStyle(styleButton));

        //Quarto
        btnQuarto.setOnMouseEntered(evento ->
                btnQuarto.setStyle(styleButton.replace("transparent", "#142170")));
        btnQuarto.setOnMouseExited(evento -> btnQuarto.setStyle(styleButton));

        //Funcionario
        btnFuncionario.setOnMouseEntered(evento ->
                btnFuncionario.setStyle(styleButton.replace("transparent", "#142170")));
        btnFuncionario.setOnMouseExited(evento -> btnFuncionario.setStyle(styleButton));




        //Espaçamento esxterno (margem) do componente label até o botão
        setMargin(lblMenu, new Insets(20, 20, 20, 20));


//        btnCliente.setMaxWidth(Double.MAX_VALUE);
//        btnRelatorio.setMaxWidth(Double.MAX_VALUE);
//        btnReserva.setMaxWidth(Double.MAX_VALUE);
//        btnQuarto.setMaxWidth(Double.MAX_VALUE);
//        btnFuncionario.setMaxWidth(Double.MAX_VALUE);

        setStyle("-fx-background-color: #020268; -fx-padding: 30px");
        setSpacing(12);
        getChildren().addAll(lblMenu, btnCliente, btnFuncionario,
                    btnQuarto, btnReserva, btnRelatorio);
        }
}

