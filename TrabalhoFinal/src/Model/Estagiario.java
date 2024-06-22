/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class Estagiario extends Funcionario{

    private double bolsa;
    private int horasServico;

    public Estagiario(double bolsa, int horasServico, String registro, double salario, String nome, int idade, String endereco, String sexo, double altura, String telefone) {
        super(registro, salario, nome, idade, endereco, sexo, altura, telefone);
        this.bolsa = bolsa;
        this.horasServico = horasServico;
    }
    

    public double getBolsa() {
        return bolsa;
    }

    public void setBolsa(double bolsa) {
        this.bolsa = bolsa;
    }

    public int getHorasServico() {
        return horasServico;
    }

    public void setHorasServico(int horasServico) {
        this.horasServico = horasServico;
    }

}
