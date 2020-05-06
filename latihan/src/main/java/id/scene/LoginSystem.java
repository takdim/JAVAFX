package id.scene;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoginSystem extends Application {

    Label lName, lEmail, lPassword;
    Button button;
    TextField tfName, tfEmail;
    PasswordField passwordField;
    Scene scene;
    Stage window;
    String user = "takdim";
    String email = "takdim253@gmail.com";
    String pass = "naruto";

    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Login System");

        Label lRegis = new Label("Registration Form");
        lRegis.setFont(new Font("Comic Sans MS", 20));

        

        lName = new Label("Name      :");
        tfName = new TextField();
        tfName.setMaxWidth(100);
        tfName.setPromptText("Your Name");

        lEmail = new Label("Email       :");
        tfEmail = new TextField();
        tfEmail.setMaxWidth(100);
        tfEmail.setPromptText("Your Email");

        lPassword = new Label("Password :");
        passwordField = new PasswordField();
        passwordField.setPromptText("Your Password");
        passwordField.setMaxWidth(100);

        button = new Button("Submit");

        


        GridPane gridPane = new GridPane();

        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        GridPane.setConstraints(lName, 1, 1);
        GridPane.setConstraints(tfName, 2, 1);
        GridPane.setConstraints(lEmail, 1, 2);
        GridPane.setConstraints(tfEmail, 2, 2);
        GridPane.setConstraints(lPassword, 1, 3);
        GridPane.setConstraints(passwordField, 2, 3);
        GridPane.setConstraints(button, 2, 4);
        gridPane.getChildren().addAll(lName, tfName, lEmail, tfEmail, lPassword, passwordField, button);

        button.setOnAction(new EventHandler<ActionEvent>(){


            String checkUser = tfName.getText().toString();
            String checkEmail = tfEmail.getText().toString();
            String checkPassword = passwordField.getText().toString();
            @Override
            public void handle(ActionEvent event) {
                
                if(tfName.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your Name");
                    return;
                }
                

                if(tfEmail.getText().isEmpty()){
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your Email");
                    return;
                }

                if(passwordField.getText().isEmpty()){
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Form Error!", "Please enter your Password");
                    return;
                }
                
                if(checkUser.equals(user) && checkEmail.equals(email) && checkPassword.equals(pass)){
                    showAlert(Alert.AlertType.CONFIRMATION, gridPane.getScene().getWindow(), "Registration Successful!", "Welcome " + tfName.getText());

                }else{
                    showAlert(Alert.AlertType.ERROR, gridPane.getScene().getWindow(), "Failed Login!", "incorrect user or email or password");
                }

            }
        });

        VBox vBox = new VBox();
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(lRegis, gridPane);

        scene = new Scene(vBox, 350, 350);

        window.setScene(scene);
        window.show();


    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

}