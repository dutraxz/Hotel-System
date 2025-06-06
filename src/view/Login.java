package view; //Package View  (classe que, quando executadas, interagem com o usuário

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Login extends Application {
    private boolean darkMode = false;
    private Scene scene;

    @Override
    public void start(Stage janela) throws Exception {

        //Carregamento das fontes
        Font fonteRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/" +
                "JosefinSans-Regular.ttf"), 15);

        Font fonteNegrito = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/" +
                "NotoSans-Bold.ttf"), 50);

        //Carregamento das Imagens
        Image ImgLogo = new Image(getClass().getResourceAsStream
                ("/img/Imglogo.png"));

        //Configuração do layout principal
        BorderPane mainPane = new BorderPane();


//        //Criação de um container principal StackPane
//        StackPane menudireito = new StackPane();
//        menudireito.setPrefWidth(400);
//        menudireito.setStyle("-fx-background-image: url('/view/resources/img/capahotel1.jpg'); -fx-background-repeat: stretch; -fx-background-size: cover");


        //TITULO
        Label lblTitulo = new Label(" Olá, Seja Bem Vindo! \n" +
                "        Faça Seu Login");
        lblTitulo.setAlignment(Pos.CENTER_RIGHT);
//        lblTitulo.setLineSpacing(100);
        lblTitulo.setFont(Font.font(fonteNegrito.getFamily(), 25));  //colocar a fonte que eu citei em cima
        lblTitulo.setStyle("-fx-text-fill: #020268"); //tamanho da fonte e cor/negrito

        HBox headerBox = new HBox(lblTitulo);
        headerBox.setSpacing(30); //Espaço
        headerBox.setPadding(new Insets(10, 10, 10, 10)); //Espaçamento
        headerBox.setAlignment(Pos.CENTER_RIGHT);

        //Formulário de login
        GridPane loginGrid = new GridPane();
        loginGrid.setPrefSize(200, 150);
        loginGrid.setMaxSize(30, 20);
        loginGrid.setMinSize(200, 150);
        loginGrid.setAlignment(Pos.TOP_CENTER);
        loginGrid.setHgap(10);
        loginGrid.setVgap(10);
        loginGrid.setPadding(new Insets(20));


        //Aba de User
        Label lblUsername = new Label("Usuário");
        lblUsername.setFont(Font.font(fonteNegrito.getFamily(), 14));
        lblUsername.setStyle("-fx-text-fill: #4a4646");
        TextField txtUsername = new TextField();
        txtUsername.setMaxWidth(300);
        txtUsername.setPromptText("Digite seu Nome");


        Label lblEmail = new Label("E-mail");
        lblEmail.setFont((Font.font(fonteNegrito.getFamily(), 15)));
        TextField txtEmail = new TextField();
        txtEmail.setMaxWidth(300);
        txtEmail.setPromptText("Digite seu Email");

        //Senha
        Label lblSenha = new Label("Senha");
        lblSenha.setFont(Font.font(fonteNegrito.getFamily(), 14));
        lblSenha.setStyle("-fx-text-fill: #4a4646");

        //Senha oculta
        PasswordField pfSenha = new PasswordField();
        pfSenha.setPromptText("Digite sua senha");


        //senha visivel (inicialmente visivel)
        TextField tfSenhaVisivel = new PasswordField();
        tfSenhaVisivel.setPromptText("Digite sua senha");
        tfSenhaVisivel.setVisible(false);
        tfSenhaVisivel.setManaged(false);
        tfSenhaVisivel.setMaxWidth(300);

        //Sicronizar o texto dos dois campos
        tfSenhaVisivel.textProperty().bindBidirectional(pfSenha.textProperty());


        //Botão  de mostrar ou ocultar o olho
        ImageView eyeOpen = new ImageView(new Image(getClass().getResourceAsStream("/img/icon.olho1.png")));
        ImageView eyeClosed = new ImageView(new Image(getClass().getResourceAsStream("/img/icon.olho1.png")));
        eyeOpen.setFitWidth(50);
        eyeOpen.setFitHeight(50);

        eyeClosed.setFitWidth(50);
        eyeClosed.setFitHeight(50);

        Button btnEye = new Button();
        btnEye.setGraphic(eyeClosed);
        btnEye.setStyle("-fx-background-color: transparent; -fx-cursor: hand;");
        btnEye.setOnAction(e -> {

            boolean isVisible = tfSenhaVisivel.isVisible();
            tfSenhaVisivel.setVisible(!isVisible);
            tfSenhaVisivel.setManaged(!isVisible);
            pfSenha.setVisible(isVisible);
            pfSenha.setManaged(isVisible);
            btnEye.setGraphic(isVisible ? eyeOpen : eyeClosed);

        });

        //Hbox contendo apenas o campo (visivel ou não) e o botão fora do campo
        StackPane senhaFieldPane = new StackPane(pfSenha, tfSenhaVisivel, btnEye);
        senhaFieldPane.setPrefWidth(100);
        senhaFieldPane.setMaxWidth(Double.MAX_VALUE);
        StackPane.setMargin(btnEye, new Insets(0, 0, 0, 120));

        HBox senhaBox = new HBox(senhaFieldPane);
        senhaBox.setAlignment(Pos.CENTER_LEFT);
        senhaBox.setSpacing(10);
//        senhaBox.setSpacing(120);


        //Botão de Login
        Button btnLogin = new Button("Entrar");
        btnLogin.setStyle("-fx-background-color: #77777; -fx-text-fill: #4a1c1c; -fx-font-weight: bold; -fx-cursor: hand;");
        btnLogin.setMaxWidth(300);
//        btnLogin.setAlignment(Pos.CENTER_LEFT);


        //Mensagem de status
        Text txtStatus = new Text();
        txtStatus.setFill(Color.RED);

        // Adicionando componentes ao grid
        loginGrid.setAlignment(Pos.CENTER);
        loginGrid.add(lblEmail, 0, 0);
        loginGrid.add(txtEmail, 1, 0);
        loginGrid.add(lblSenha, 0, 1);

        loginGrid.add(btnLogin, 1, 1);
        loginGrid.add(txtStatus, 0, 2);
        loginGrid.add(senhaFieldPane, 1, 1);


        //Container principal do formulário
        VBox loginBox = new VBox(20, headerBox, loginGrid);
        loginBox.setAlignment(Pos.CENTER);
        loginBox.setPadding(new Insets(10));
        loginBox.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);" + "-fx-border-color: #020268; -fx-border-width: 2px;" + "-fx-border-radius: 3px; -fx-background-radius: 10px");
        loginBox.setMaxWidth(300);
        loginBox.setPadding(new Insets(20));

        //Layout com imagens de fundo
        StackPane root = new StackPane();
        root.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);");
        root.getChildren().add(loginBox);
        root.setAlignment(Pos.CENTER_RIGHT);

        //Configurações da cena
        Scene scene = new Scene(root, 800, 600);
        janela.setTitle("NovoHotel - Login");
        janela.getIcons().add(ImgLogo);
        janela.setScene(scene);
        janela.show();


        //Ação do botão de login
        btnLogin.setOnAction(e -> {
            String email = txtEmail.getText();
            String senha = pfSenha.getText();
            if (email.isEmpty() || senha.isEmpty()) {
                txtStatus.setText("Email e senha são obrigatorios!");
                txtStatus.setFill(Color.RED);
            } else if (validarLogin(email, senha)) {
                txtStatus.setText("Login com sucesso!");
                txtStatus.setFill(Color.RED);
            } else {
                txtStatus.setText("Credenciais inválidas!");
                txtStatus.setFill(Color.RED);
            }
        });
    }

    private boolean validarLogin (String email, String senha) {
        //Logica de validação simples (substitua por uma verificação real)
        return email.equals("victor0896@gmail.com") && senha.equals("vitao123");
    }

    private void toggleDarkMode (BorderPane mainPane) {
        darkMode = !darkMode;
        if (darkMode) {
            applyDarkTheme(mainPane);
        } else {
            applyLightTheme(mainPane);
        }
    }

    private void applyDarkTheme (Pane...panes){
        for (Pane pane : panes) {
            pane.setStyle("-fx-background-color: rgba(60, 60, 60, 0.9);" + "-fx-border-color: #3f1988; -fx-border-width: 2px; " + "-fx-border-radius: 10px; -fx-background-radius: 10px;");
        }
    }

    private void applyLightTheme (Pane...panes){
        for (Pane pane : panes) {
            pane.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);" + "-fx-border-color: #1b7c9a; -fx-border-width: 2px; " + "-fx-border-radius: 10px; -fx-background-radius: 10px;");
        }
    }
    public static void main (String[]args){
        launch(args);
    }

}

    ////        menudireito.setCenter(layout);
    ////Metodo para criar um campo de texto com máscara
//private TextField criarMascaraCampo(String mascara) {
//    TextField txtMascara = new TextField();
//    txtMascara.textProperty().addListener((observable, oldValue, newValue) ->
//    {
//        String value = newValue.replaceAll("[^0-9]", "");
//        StringBuilder formatacaoCampo = new StringBuilder();
//        int index = 0;
//        for (char caracter : mascara.toCharArray()){
//            if (caracter == '#') {
//                if (index < value.length()) {
//                    formatacaoCampo.append(value.charAt(index));
//                    index++;
//                }
//                else {
//                    break;
//                }
//            }
//            else {
//                formatacaoCampo.append(caracter);
//            }
//        }
//        txtMascara.setText(formatacaoCampo.toString());
//    });
//    return txtMascara;
//}
//}


//

//

//        //Alinhamento
//        GridPane gridForm = new GridPane();
//        gridForm.setHgap(10);
//        gridForm.setVgap(15);
//        gridForm.setAlignment(Pos.CENTER);
//        gridForm.add(lblUsername, 0, 0);
//        gridForm.add(txtUsername, 1, 0);
//        gridForm.add(lblPassword, 0, 1);
//        gridForm.add(pfSenha, 1, 1);
//        gridForm.add(btnLogin, 2, 1);
//
//        gridForm.add(ImgOlho, 2, 1);
//        gridForm.add(pfSenha, 1, 1);

//        gridForm.add(btnLogin, 1, 2);


//        VBox boxLogin = new VBox(20, lblTitulo, gridForm, botaoLogin);
//        boxLogin.setAlignment(Pos.CENTER);
//        boxLogin.setPadding(new Insets(20));
//        boxLogin.setStyle("-fx-background-color: #ffffff; -fx-border-radius: 0px; -fx-background-radius: 0px;");
//        boxLogin.setPrefWidth(600);
//        //botao so de imagem
//        //btnCadastrar.setGraphic(ImgIcon);
//
//
//
//
//        HBox layout = new HBox(menudireito, boxLogin);
//
//        Scene scene = new Scene(layout, 1000, 700);
//        janela.setTitle("NovoTel - Clientes");//Titulo janela
//        //icone da janela(janela)
//        janela.getIcons();
//        janela.setScene(scene);
//        janela.getIcons().add(ImgLogo);
//        janela.setResizable(false); //impede ela de redimencionar
//        janela.show();
//
//
//    }
//


