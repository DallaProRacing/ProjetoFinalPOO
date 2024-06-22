/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class Funcionario extends Pessoa{
    private String registro;
    private double salario;

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
    

    public Funcionario(String registro, double salario, String nome, int idade, String endereco, String sexo, double altura, String telefone) {
        super(nome, idade, endereco, sexo, altura, telefone);
        this.registro = registro;
        this.salario = salario;
    }
    
    @Override
    public String geteNome(){
        return getNome();
    }
}
