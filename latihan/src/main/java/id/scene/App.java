package id.scene;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Button selectFileBtn = new Button("Select File");

        TextArea textArea = new TextArea();
        textArea.setEditable(false);
        textArea.setWrapText(true);

        selectFileBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FileChooser fileChooser = new FileChooser();
                FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
                fileChooser.getExtensionFilters().add(extensionFilter);
                File file = fileChooser.showOpenDialog(primaryStage);
                if (file != null) {
                    textArea.setText(readFile(file));
                }
            }
        });

        BorderPane root = new BorderPane();
        BorderPane.setAlignment(selectFileBtn, Pos.CENTER);
        BorderPane.setMargin(selectFileBtn, new Insets(10, 5, 5, 5));
        root.setTop(selectFileBtn);
        root.setCenter(textArea);
        root.setPadding(new Insets(10));

        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.setMinWidth(275);
        primaryStage.setMinHeight(300);
        primaryStage.setTitle("File Reader");
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private String readFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;

        try {

            bufferedReader = new BufferedReader(new FileReader(file));

            String text;
            while ((text = bufferedReader.readLine()) != null) {
                stringBuilder.append(text);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return stringBuilder.toString();
    }
}
