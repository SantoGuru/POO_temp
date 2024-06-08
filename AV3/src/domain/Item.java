package domain;

public class Item {
	private int codigo;
	private String descricao;
	private double valor;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor){
		this.valor = valor;
	}
	
	
	public Item(int codigo,String descricao,double valor) {
		this.setCodigo(codigo);
		this.setDescricao(descricao);
		this.setValor(valor);
	}
	
	@Override
	public String toString(){
		return this.getCodigo()+","+this.getDescricao()+","+this.getValor();
	};
	
    public void toObject(String s) {
        String[] dados = s.split(",");
        if (dados.length == 3) {
            this.setCodigo(Integer.parseInt(dados[0]));
            this.setDescricao(dados[1]);
            this.setValor(Double.parseDouble(dados[2]));
        } else {
            System.out.println("Classe: "+this.getClass().getName()+"\nERRO: String de entrada inválida.");
        }
    }
	
}
