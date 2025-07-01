package model;
import java.util.Date;

public class Pedidos {
    private int id, user_id, cliente_id;
    private Date data;
    private String pagamento;

    public Pedidos(int user_id, int cliente_id, Date data, String pagamento) {
        this.user_id = user_id;
        this.cliente_id = cliente_id;
        this.data = data;
        this.pagamento = pagamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getCliente_id() {
        return cliente_id;
    }

    public void setCliente_id(int cliente_id) {
        this.cliente_id = cliente_id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getPagamento() {
        return pagamento;
    }

    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }
}
