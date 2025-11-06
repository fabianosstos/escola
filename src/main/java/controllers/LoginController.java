package controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utils.AlertUtils;

public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private Button btnEntrar;

    @FXML
    private void autenticar() {
        String usuario = txtUsuario.getText().trim();
        String senha = txtSenha.getText();

        // Validar campos vazios
        if (usuario.isEmpty()) {
            AlertUtils.showError("Erro de validação", "O campo usuário é obrigatório.");
            txtUsuario.requestFocus();
            return;
        }

        if (senha.isEmpty()) {
            AlertUtils.showError("Erro de validação", "O campo senha é obrigatório.");
            txtSenha.requestFocus();
            return;
        }

        // Validar credenciais
        if (usuario.equals("admin") && senha.equals("123")) {
            AlertUtils.showSuccess("Login realizado", "Bem-vindo ao Sistema Escolar, " + usuario + "!");
            ((Stage) btnEntrar.getScene().getWindow()).close();
        } else {
            AlertUtils.showError("Erro de autenticação", "Usuário ou senha inválidos.\nVerifique suas credenciais e tente novamente.");
            txtSenha.clear();
            txtSenha.requestFocus();
        }
    }
}
