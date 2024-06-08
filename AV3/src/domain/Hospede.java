package domain;
import java.util.ArrayList;

public class Hospede extends Pessoa{
	private String enderecoCompleto;
	
	public Boolean editar(Hospede H) {
		return true; // TODO:RETORNAR ALGO
	}
	public Hospede consultar(Hospede H) {
		return null; // TODO:RETORNAR ALGO
	}
	public ArrayList<Hospede> listar(Hospede H) {
		return null; // TODO:RETORNAR ALGO
	}
	
	public Hospede(String cpf, String nome, String email,String endereco){
		super(cpf,nome,email);
		this.setEnderecoCompleto(endereco);
	}
	
	public String getEnderecoCompleto() {
		return enderecoCompleto;
	}
	public void setEnderecoCompleto(String enderecoCompleto) {
		this.enderecoCompleto = enderecoCompleto;
	}
	
	@Override
	public String toString(){
		return this.getCPF()+","+this.getNome()+","+this.getEmail()+","+this.getEnderecoCompleto();
	};
	
    public void toObject(String s) {
        String[] dados = s.split(",");
        if (dados.length == 4) {
            this.setCPF(dados[0]);
            this.setNome(dados[1]);
            this.setEmail(dados[2]);
            this.setEnderecoCompleto(dados[3]);
        } else {
            System.out.println("Classe: "+this.getClass().getName()+"\nERRO: String de entrada inválida.");
        }
    }
	
}