package vagaCerta;

import static spark.Spark.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class UsuarioService {

    public static void main(String[] args) {
        // Serve arquivos da pasta src/main/resources (modo desenvolvimento)
        staticFiles.externalLocation("src/main/resources");

        // Rota: exibir formulário
        get("/form", (req, res) -> renderTemplate("form.html"));

        // Rota: cadastrar usuário
        post("/usuario/inserir", (req, res) -> {
            String nome = req.queryParams("nome");
            String email = req.queryParams("email");
            int idade = Integer.parseInt(req.queryParams("idade"));

            Usuario usuario = new Usuario(nome, email, idade);
            UsuarioDAO dao = new UsuarioDAO();
            dao.inserir(usuario);

            return "Usuário " + nome + " cadastrado com sucesso!";
        });

        // Rota: listar usuários
        get("/usuarios", (req, res) -> {
            UsuarioDAO dao = new UsuarioDAO();
            List<Usuario> lista = dao.listar();

            StringBuilder html = new StringBuilder();
            html.append("<h1>Usuários Cadastrados</h1>");
            html.append("<table border='1'>");
            html.append("<tr><th>ID</th><th>Nome</th><th>Email</th><th>Idade</th></tr>");

            for (Usuario u : lista) {
                html.append("<tr>")
                    .append("<td>").append(u.getId()).append("</td>")
                    .append("<td>").append(u.getNome()).append("</td>")
                    .append("<td>").append(u.getEmail()).append("</td>")
                    .append("<td>").append(u.getIdade()).append("</td>")
                    .append("</tr>");
            }

            html.append("</table>");
            return html.toString();
        });
    }

    // Método que carrega um template HTML da pasta resources
    public static String renderTemplate(String path) {
        try {
            return new String(Files.readAllBytes(Paths.get("src/main/resources/" + path)));
        } catch (IOException e) {
            e.printStackTrace();
            return "Erro ao carregar template: " + path;
        }
    }
}
