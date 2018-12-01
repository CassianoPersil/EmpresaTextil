
package controller;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    private Long Id;
    private String Nome;
    private int Qtde;
    private String Un;
    private double Valor;
    
    //@OneToMany(cascade = CascadeType.ALL,mappedBy = "produto")
    //@JoinColumn(name = "produto_id")
   //@ManyToOne(cascade = CascadeType.ALL)
    public Produto(){
    
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getQtde() {
        return Qtde;
    }

    public void setQtde(int Qtde) {
        this.Qtde = Qtde;
    }

    public String getUn() {
        return Un;
    }

    public void setUn(String Un) {
        this.Un = Un;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }

  
    
    
}
