package domain;

public class CategoriaItem {
	private Item item;
	private Categoria categoria;
	private int quantidade;

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	};
	
	public CategoriaItem(Item item,Categoria categoria,int quantidade){
		this.setItem(item);
		this.setCategoria(categoria);
		this.setQuantidade(quantidade);
	}
	@Override
	public String toString(){
		return this.getItem().getCodigo()+","+this.getCategoria().getCodigo()+","+this.getQuantidade();
	};
	
    public void toObject(String s) {
        String[] dados = s.split(",");
        if (dados.length == 3) {
        	Item item = new Item(0, "", 0.0); item.toObject(dados[0]);
            this.setItem(item);
            Categoria categoria = new Categoria(0, "", 0.0); categoria.toObject(dados[1]);
            this.setCategoria(categoria);
            this.setQuantidade(Integer.parseInt(dados[2]));
        } else {
            System.out.println("Classe: "+this.getClass().getName()+"\nERRO: String de entrada inválida.");
        }
    }
}
