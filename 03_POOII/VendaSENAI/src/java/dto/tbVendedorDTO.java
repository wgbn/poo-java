package dto;

import java.util.Date;


public class tbVendedorDTO {
    private int idvendedor;
    private String nomevendedor;
    private Date dtnascimento;

    public tbVendedorDTO() {
    }

    public tbVendedorDTO(int idvendedor, String nomevendedor, Date dtnascimento) {
        this.idvendedor = idvendedor;
        this.nomevendedor = nomevendedor;
        this.dtnascimento = dtnascimento;
    }

    public int getIdvendedor() {
        return idvendedor;
    }

    public void setIdvendedor(int idvendedor) {
        this.idvendedor = idvendedor;
    }

    public String getNomevendedor() {
        return nomevendedor;
    }

    public void setNomevendedor(String nomevendedor) {
        this.nomevendedor = nomevendedor;
    }

    public Date getDtnascimento() {
        return dtnascimento;
    }

    public void setDtnascimento(Date dtnascimento) {
        this.dtnascimento = dtnascimento;
    }
    
    
    
}
