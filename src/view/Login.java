package view; //Package View  (classe que, quando executadas, interagem com o usuário

import javafx.application.Application; //Ciclo de vida da Aplicação (init(), start(), stop() --> launch())
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; //Classe Scene
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;


public class Login extends Application {

    private  boolean senhaVisivel = false;

    public static void main(String[]
                                    args) {
        launch(args); //Inicializa o JavaFX

    }

    @Override
    public void start(Stage janela) throws Exception {

        //Carregamento das fontes
        Font fonteRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/" +
                "JosefinSans-Regular.ttf"), 15);

        Font fonteNegrito = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/" +
                "NotoSans-Bold.ttf"), 50);

        //Carregamento das Imagens
        Image IconOlho = new Image(getClass().getResourceAsStream
                ("/img/icon.olho3.png"));
        Image IconOlhoAberto = new Image(getClass().getResourceAsStream
                ("/img/icon.olho1.png"));

        Image ImgLogo = new Image(getClass().getResourceAsStream
                ("/img/Imglogo.png"));

        //Criação de um container principal StackPane
        StackPane menudireito = new StackPane();
        menudireito.setPrefWidth(400);
        menudireito.setStyle("-fx-background-image: url('/view/resources/img/capahotel1.jpg'); -fx-background-repeat: stretch; -fx-background-size: cover");

//        ImageView ImgOlho = new ImageView(IconOlho);
//        ImgOlho.setFitWidth(18);
//        ImgOlho.setFitHeight(18);
//
//
//        ImageView ImgOlhoAberto = new ImageView(IconOlhoAberto);
//        ImgOlho.setFitWidth(18);
//        ImgOlho.setFitHeight(18);

        //TITULO
        Label lblTitulo = new Label(" Olá, Seja Bem Vindo! \n" +
                "        Faça Seu Login");
        lblTitulo.setAlignment(Pos.CENTER_RIGHT);
//        lblTitulo.setLineSpacing(100);
        lblTitulo.setFont(Font.font(fonteNegrito.getFamily(), 25));  //colocar a fonte que eu citei em cima
        lblTitulo.setStyle("-fx-text-fill: #020268"); //tamanho da fonte e cor/negrito

        HBox TituloBox = new HBox(lblTitulo);
        TituloBox.setSpacing(30); //Espaço
        TituloBox.setPadding(new Insets(10, 10, 10, 10)); //Espaçamento
        TituloBox.setAlignment(Pos.CENTER_RIGHT);


        //Aba de User
        Label lblUsername = new Label("Usuário");
        lblUsername.setFont(Font.font(fonteNegrito.getFamily(), 14));
        lblUsername.setStyle("-fx-text-fill: #4a4646");
        TextField txtUsername = new TextField();
        txtUsername.setMaxWidth(300);
        txtUsername.setPromptText("Digite seu Nome");



        //Senha
        Label lblPassword = new Label("Senha");
        lblPassword.setFont(Font.font(fonteNegrito.getFamily(), 14));
        lblPassword.setStyle("-fx-text-fill: #4a4646");

        //Senha oculta
        PasswordField campoPassword = new PasswordField();
        campoPassword.setPromptText("Digite sua senha");


        //senha visivel (inicialmente visivel)
        TextField pfSenhaVisivel = new PasswordField();
        pfSenhaVisivel.setPromptText("Digite sua senha");
        pfSenhaVisivel.setVisible(false);
        pfSenhaVisivel.setManaged(false);
        pfSenhaVisivel.setMaxWidth(300);

        //Sicronizar o texto dos dois campos
        pfSenhaVisivel.textProperty().bindBidirectional(pfSenhaVisivel.textProperty());


        //Botão com estiloButton

        ImageView OlhoAberto = new ImageView(new Image(getClass().getResourceAsStream("/img/icon.olho1.png")));
        ImageView OlhoFechado = new ImageView(new Image(getClass().getResourceAsStream("/img/icon.olho1.png")));
        OlhoAberto.setFitWidth(50);
        OlhoAberto.setFitHeight(50);

        OlhoFechado.setFitWidth(50);
        OlhoFechado.setFitHeight(50);

        Button btnLogin = new Button();
        btnOlho.setGraphic(OlhoAberto);
        btnOlho.setStyle("");
        btnOlho.setOnA





        Button toggleBtn = new Button();
        toggleBtn.setGraphic(viewOlhoAberto);
        toggleBtn.setStyle("-fx-background-color: transparent;");

        botaoLogin.setStyle("-fx-background-color: transparent");

        toggleBtn.setOnAction(viewOlhoFechado);

        PasswordField campoSenha = new PasswordField();
        campoSenha.setPromptText("Digite sua senha");
        TextField txtSenha = new TextField();
        txtSenha.setPromptText("Digite sua senha");
        txtSenha.setVisible(false);
        txtSenha.setManaged(false);
        Button btnEyeOpen = new Button();
        btnEyeOpen.setGraphic(viewImgEyeOpen);
        btnEyeOpen.setStyle("-fx-background-color: transparent; -fx-cursor: hand;");
        btnEyeOpen.setMaxSize(15, 15);
        StackPane senha123 = new StackPane();
        senha123.setPrefWidth(200);
        senha123.getChildren().addAll(txtSenha, campoSenha);
        StackPane.setMargin(btnEyeOpen, new Insets(0, 0, 0, 0));
        final boolean[] clicado = {false};
        btnEyeOpen.setOnMouseClicked(evento -> {
            if (clicado[0]) {
                btnEyeOpen.setGraphic(viewImgEyeClosed);
                campoSenha.setText(txtSenha.getText());
                campoSenha.setVisible(true);
                campoSenha.setManaged(true);
                txtSenha.setVisible(false);
            } else {
                btnEyeOpen.setGraphic(viewImgEyeOpen);
                txtSenha.setText(campoSenha.getText());
                txtSenha.setVisible(true);
                txtSenha.setManaged(true);
                campoSenha.setVisible(false);
            }
            clicado[0] = !clicado[0];
        });


        //se a senha esta visivel ou seja senhaVisivel = true
        if (senhaVisivel) {

            //Setw o texto de txtSenha que esta visivel para senha (PasswordFiled)
            botaoLogin.setText(txtPassword.getText());

            //Exibe novamente senha(passwordFiled) e o inclui no layout
                    botaoLogin.setVisible(true);
                    botaoLogin.setManaged(true);

                    //Oculta o txtSenha(TextField) e o retira do layout para não ocupar espaço
                    txtPassword.setVisible(false);
                    txtPassword.setManaged(false);

                    //Troca o icone do botao para o olho fechado, indicando que a senha pode ser novamente vista ao clicar
                    toggleBtn.setGrapich(viewOlhoAberto);

                    //Atualiza a variavel de controle indicando qyue a senha não eesta visivel
                    senhaVisivel = false;

                }else

                    //seta o texto de senha (PasswordField - invisivel) para o txtSenha (TextField - visivel)
                    txtPassword.setText(senha.getText());

                    //Exibe o componente txtSenha )texto visivel) e o inclui no layout
                    txtPassword.setVisible(true);
                    txtPassword.setManaged(true);

                    //Oculta o componente senha (PasswordField - invisivel) e o retira do layout
                    senha.setVisible(false);
                    senha.setManaged(false);

                    //Troca o icone do botão para olho fechado, iundicando que a senha pode ser novamente oculta ao clicar
                    toogletbn.setGrapic(viewOlhoFechado);

                    //Atualiza a variavel de controle indicando que a senha nao esta visivel
                    senhaVisivel = true;


        botaoLogin = new Button("Entre");
        botaoLogin.setFont(Font.font(fonteNegrito.getFamily(), 5));
        botaoLogin.setStyle("""
    -fx-background-color: #020268;    
    -fx-text-fill: white;    
    -fx-font-size: 13px;
    -fx-font-weight: bold;
    -fx-background-radius: 13px;    
    -fx-padding: 5px 70px;    
    -fx-cursor: hand;""");


        //Alinhamento
        GridPane gridForm = new GridPane();
        gridForm.setHgap(10);
        gridForm.setVgap(15);
        gridForm.setAlignment(Pos.CENTER);
        gridForm.add(lblUsername, 0, 0);
        gridForm.add(txtUsername, 1, 0);
        gridForm.add(lblPassword, 0, 1);
        gridForm.add(txtPassword, 1, 1);
        gridForm.add(botaoLogin, 2, 1);

        gridForm.add(ImgOlho, 2, 1);
        gridForm.add(campoPassword, 1, 1);
        gridForm.add(botaoLogin, 1, 2);


        VBox boxLogin = new VBox(20, lblTitulo, gridForm, botaoLogin);
        boxLogin.setAlignment(Pos.CENTER);
        boxLogin.setPadding(new Insets(20));
        boxLogin.setStyle("-fx-background-color: #ffffff; -fx-border-radius: 0px; -fx-background-radius: 0px;");
        boxLogin.setPrefWidth(600);
        //botao so de imagem
        //btnCadastrar.setGraphic(ImgIcon);


//        menudireito.setCenter(layout);


        HBox layout = new HBox(menudireito, boxLogin);

        Scene scene = new Scene(layout, 1000, 700);
        janela.setTitle("NovoTel - Clientes");//Titulo janela
        //icone da janela(janela)
        janela.getIcons();
        janela.setScene(scene);
        janela.getIcons().add(ImgLogo);
        janela.setResizable(false); //impede ela de redimencionar
        janela.show();


    }

//Metodo para criar um campo de texto com máscara
private TextField criarMascaraCampo(String mascara) {
    TextField txtMascara = new TextField();
    txtMascara.textProperty().addListener((observable, oldValue, newValue) ->
    {
        String value = newValue.replaceAll("[^0-9]", "");
        StringBuilder formatacaoCampo = new StringBuilder();
        int index = 0;
        for (char caracter : mascara.toCharArray()){
            if (caracter == '#') {
                if (index < value.length()) {
                    formatacaoCampo.append(value.charAt(index));
                    index++;
                }
                else {
                    break;
                }
            }
            else {
                formatacaoCampo.append(caracter);
            }
        }
        txtMascara.setText(formatacaoCampo.toString());
    });
    return txtMascara;
}
}



