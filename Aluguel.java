import java.util.Date;

import Models.Usuario;

public class Aluguel {
    private Usuario usuario;
    private Carro carro;
    private Date dataAluguel;

    public Aluguel(Usuario usuario, Carro carro) {
        this.usuario = usuario;
        this.carro = carro;
        this.dataAluguel = new Date();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Carro getCarro() {
        return carro;
    }

    public Date getDataAluguel() {
        return dataAluguel;
    }
}
