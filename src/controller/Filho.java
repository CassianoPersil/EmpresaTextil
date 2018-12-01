package controller;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Filho implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    
    //@ManyToOne - Nesse caso está sendo dito que
    //poderá haver Muitos (Many) filhos para cada Funcionario(One)
    //O cascade está relacionado com as operações de INSERT, UPDATE e DELETE
    //O Type.ALL está informando que quasiuquer destas operações está executado em 
    //cascata, ou seja, quando inserir funcionário será automaticamente inserido
    //um filho.
    @ManyToOne(cascade = CascadeType.ALL)
    private Funcionario funcionario;
    
    public Filho() {
        
    }

    public Filho(Long id, String nome, Funcionario funcionario) {
        this.id = id;
        this.nome = nome;
        this.funcionario = funcionario;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    
    
}
