package application;

import java.io.IOException;
import java.net.URL;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * Main application class.
 */
public class Main extends Application {
    
    @Override
    public void init() {
        System.out.println("Método init() chamado");
    }

    @Override
    public void start(Stage stage) {
        try {
            System.out.println("Iniciando a aplicação...");
            Platform.setImplicitExit(true);
            
            URL location = getClass().getResource("/LoginView.fxml");
            System.out.println("Tentando carregar FXML de: " + location);
            
            if (location == null) {
                throw new IOException("Não foi possível encontrar o arquivo LoginView.fxml");
            }
            
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(location);
            Parent root = fxmlLoader.load();
            
            Scene scene = new Scene(root);
            stage.setTitle("Sistema de Gestão Escolar");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.centerOnScreen();
            
            System.out.println("Mostrando a janela...");
            stage.show();
            
            System.out.println("Interface carregada com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao carregar a interface: " + e.getMessage());
            e.printStackTrace();
            showError("Erro", "Erro ao carregar a interface", e.getMessage());
            Platform.exit();
        }
    }

    @Override
    public void stop() {
        System.out.println("Método stop() chamado");
        Platform.exit();
    }

    private void showError(String title, String header, String content) {
        Platform.runLater(() -> {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle(title);
            alert.setHeaderText(header);
            alert.setContentText(content);
            alert.showAndWait();
        });
    }

    public static void main(String[] args) {
        System.out.println("Iniciando o main()...");
        launch(args);
    }
}
