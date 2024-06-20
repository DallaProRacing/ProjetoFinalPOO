
package Model;


public class Medicamento {
    
    private String IdMed;
    private String nomeMed;
    private String Tipo;
    private String Quantidade;
    private String Observacao;
    private String IDFazenda;
    
    private String[] colunas = new String[]{"IDMED", "NOME", "TIPO", "QUANTIDADE", "OBSERVACAO","IDFazenda"};

    public String getIDFazenda() {
        return IDFazenda;
    }

    public void setIDFazenda(String IDFazenda) {
        this.IDFazenda = IDFazenda;
    }

    public String getNomeMed() {
        return nomeMed;
    }

    public void setNomeMed(String nomeMed) {
        this.nomeMed = nomeMed;
    }

    public Medicamento(){
        
    }
    public String getIdMed() {
        return IdMed;
    }

    public void setIdMed(String IdMed) {
        this.IdMed = IdMed;
    }

   
    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getQuantidade() {
        return Quantidade;
    }

    public void setQuantidade(String Quantidade) {
        this.Quantidade = Quantidade;
    }

    public String getObservacao() {
        return Observacao;
    }

    public void setObservacao(String Observacao) {
        this.Observacao = Observacao;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    
    
}
