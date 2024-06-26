public class Carro {
    private String placa;
    private String modelo;
    private boolean disponivel;

    public Carro(String placa, String modelo) {
        this.placa = placa;
        this.modelo = modelo;
        this.disponivel = true;
    }

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }
}
