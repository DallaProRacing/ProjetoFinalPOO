
package Model;

public class Fazenda {
    private String IdFazenda;
    private String NomeFazenda;
    private String EnderecoFazenda;
    private String PrincRacaAnimal;
    private String QuantAnimais;
    private String IDUsuario;
    
    private String[] colunas = new String[]{"IDFAZENDA", "NOME", "ENDERECO","RAÇA DE ANIMAIS" ,"QUANTIDADE","IDUSUARIO"};

    public String getIDUsuario() {
        return IDUsuario;
    }

    public void setIDUsuario(String IDUsuario) {
        this.IDUsuario = IDUsuario;
    }

    public String getPrincRacaAnimal() {
        return PrincRacaAnimal;
    }

    public void setPrincRacaAnimal(String PrincRacaAnimal) {
        this.PrincRacaAnimal = PrincRacaAnimal;
    }

    public Fazenda() {
    }
    public String getIdFazenda() {
        return IdFazenda;
    }

    public void setIdFazenda(String IdFazenda) {
        this.IdFazenda = IdFazenda;
    }

    public String getNomeFazenda() {
        return NomeFazenda;
    }

    public void setNomeFazenda(String NomeFazenda) {
        this.NomeFazenda = NomeFazenda;
    }

    public String getEnderecoFazenda() {
        return EnderecoFazenda;
    }

    public void setEnderecoFazenda(String EnderecoFazenda) {
        this.EnderecoFazenda = EnderecoFazenda;
    }

    public String getQuantAnimais() {
        return QuantAnimais;
    }

    public void setQuantAnimais(String QuantAnimais) {
        this.QuantAnimais = QuantAnimais;
    }

    public String[] getColunas() {
        return colunas;
    }

    public void setColunas(String[] colunas) {
        this.colunas = colunas;
    }
    
}
