package Models;

public class Cliente extends Usuario {
    public Cliente(String nome, String email, String senha) {
        setNome(nome);
        setEmail(email);
        setSenha(senha);
    }
}
