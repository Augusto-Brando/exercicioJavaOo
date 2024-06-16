import java.util.ArrayList;

public class GerenciadorCarros {
    private ArrayList<Carro> carros = new ArrayList<>();

    public void adicionarCarro(String placa, String modelo) {
        carros.add(new Carro(placa, modelo));
    }

    public Carro getCarro(String placa) {
        for (Carro carro : carros) {
            if (carro.getPlaca().equals(placa)) {
                return carro;
            }
        }
        return null;
    }

    public ArrayList<Carro> getTodosCarros() {
        return carros;
    }
}
