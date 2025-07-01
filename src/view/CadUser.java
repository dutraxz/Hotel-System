package view; //Package View  (classe que, quando executadas, interagem com o usuário
import javafx.application.Application; //Ciclo de vida da Aplicação (init(), start(), stop() --> launch())
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene; //Classe Scene
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import view.componets.PainelBotoes;
import view.componets.Sidebar;

public class CadUser extends Application {

    public void start(Stage janela) throws Exception {


        PainelBotoes botoes = new PainelBotoes();
            Sidebar menu;
            menu = new Sidebar();
            //- class objeto construtor

            Image ImgIcon = new Image(getClass().getResourceAsStream
                    ("/view/resources/img/user.png"));
            Image ImgLogo = new Image(getClass().getResourceAsStream
                    ("/img/iconNH.png"));

            //Criação de um container principal MainPane
            BorderPane mainPane = new BorderPane();
            mainPane.setLeft(menu);

        ImageView ImgUser = new ImageView(ImgIcon);
        ImgUser.setFitWidth(50);
        ImgUser.setFitHeight(50);
        ImgUser.setOpacity(0.9);


        //Carregamento das fontes
        Font fonteRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/" +
                "JosefinSans-Regular.ttf"), 15);

        Font fonteNegrito = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/" +
                "NotoSans-Bold.ttf"), 50);

        //TITULO
        Label lblTitulo = new Label("Funcionários");
//        lblTitulo.setAlignment(Pos.CENTER);
//        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold"); //tamanho da fonte e cor/negrito
        lblTitulo.setFont(Font.font(fonteNegrito.getFamily(), 25));  //colocar a fonte que eu citei em cima



        HBox TituloBox = new HBox(lblTitulo, ImgUser);
        TituloBox.setSpacing(20); //Espaço
        TituloBox.setPadding(new Insets(20,20,20,20)); //Espaçamento
        TituloBox.setAlignment(Pos.CENTER);

        Label lblNome = new Label("Nome: ");
        TextField txtNome = new TextField();
        txtNome.setMaxWidth(300);

        Label lblSenha = new Label("Senha: ");
        TextField txtSenha= criarMascaraCampo("");
        txtSenha.setMaxWidth(300);

        Label lblEmail = new Label("E-mail: ");
        TextField txtEmail = new TextField();
        txtEmail.setMaxWidth(300);

        Label lblSetor = new Label("Setor: ");
        TextField txtSetor= new TextField();
        txtSetor.setMaxWidth(300);




        ComboBox<String> boxEmail = new ComboBox<>();
        boxEmail.getItems().addAll("@gmail.com", "@outlook.com", "@icloud.com", "hotmail.com");
        boxEmail.setPromptText("Selecione");

        ComboBox<String> boxSetor = new ComboBox<>();
        boxSetor.getItems().addAll("TI", "Almox", "Marketing", "Cozinha");
        boxSetor.setPromptText("Selecione");

        GridPane formGrid = new GridPane();
        formGrid.add(txtNome, 1, 0);
        formGrid.add(lblNome, 0, 0);

        formGrid.add(txtEmail, 1, 1);
        formGrid.add(lblEmail, 0, 1);
        formGrid.add(boxEmail, 2, 1);

        formGrid.add(txtSenha, 1, 2);
        formGrid.add(lblSenha, 0, 2);

        formGrid.add(lblSetor, 0, 3);
        formGrid.add(boxSetor, 1, 3);


        formGrid.add(botoes,1, 4);

        formGrid.setPadding(new Insets(20,20,20,20));

        formGrid.setAlignment(Pos.CENTER);//Centraliza os elementos
        formGrid.setVgap(10); // Espaço/Lacuna Vertical
        formGrid.setHgap(10); // Espaço/Lacuna Horizontal

        //botao so de imagem
        //btnCadastrar.setGraphic(ImgIcon);


        VBox layout = new VBox(15,ImgUser,lblTitulo,formGrid); //Layout inteiro
        layout.setAlignment(Pos.CENTER);
        mainPane.setCenter(layout);

        Scene scene = new Scene(mainPane, 900, 800);
        janela.setTitle("NovoTel - Funcionários");//Titulo janela


        //icone da janela(janela)
        janela.getIcons().add(ImgLogo);
        janela.setScene(scene);
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

    public static void main(String[] args) {
        launch(args);

        }
    }


