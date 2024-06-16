import Models.Cliente;
import Models.Usuario;

import java.util.ArrayList;

public class GerenciadorUsuarios {
    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public boolean cadastrarUsuario(String nome, String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                return false;
            }
        }
        usuarios.add(new Cliente(nome, email, senha));
        return true;
    }

    public Usuario loginUsuario(String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                return usuario;
            }
        }
        return null;
    }
}
