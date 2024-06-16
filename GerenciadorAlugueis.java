import java.util.ArrayList;

import Models.Usuario;

public class GerenciadorAlugueis {
    private ArrayList<Aluguel> alugueis = new ArrayList<>();

    public void alugarCarro(Usuario usuario, Carro carro) {
        if (carro.isDisponivel()) {
            alugueis.add(new Aluguel(usuario, carro));
            carro.setDisponivel(false);
            System.out.println("Carro alugado com sucesso!");
        } else {
            System.out.println("Carro não está disponível.");
        }
    }

    public ArrayList<Aluguel> getAlugueisUsuario(Usuario usuario) {
        ArrayList<Aluguel> alugueisUsuario = new ArrayList<>();
        for (Aluguel aluguel : alugueis) {
            if (aluguel.getUsuario().equals(usuario)) {
                alugueisUsuario.add(aluguel);
            }
        }
        return alugueisUsuario;
    }
}
