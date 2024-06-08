package domain;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Consumo {
	private Item item;
	private Reserva reserva;
	private int quantidadeSolicitada;
	private Date dataConsumo;
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	public int getQuantidadeSolicitada() {
		return quantidadeSolicitada;
	}
	public void setQuantidadeSolicitada(int quantidadeSolicitada) {
		this.quantidadeSolicitada = quantidadeSolicitada;
	}
	public Date getDataConsumo() {
		return dataConsumo;
	}
	public void setDataConsumo(Date dataConsumo) {
		this.dataConsumo = dataConsumo;
	}
	public Consumo(Item item, Reserva reserva, int quantidadeSolicitada, Date dataConsumo) {
		this.setItem(item);
		this.setReserva(reserva);
		this.setQuantidadeSolicitada(quantidadeSolicitada);
		this.setDataConsumo(dataConsumo);
	}

	@Override
	public String toString(){
		//TODO: TERMINAR DE IMPLEMETAR
		return this.getItem().getCodigo()
		+","+this.getReserva()
		+","+this.getQuantidadeSolicitada()
		+","+this.getDataConsumo();
	};
	
    public void toObject(String s) {
        String[] dados = s.split(",");
        if (dados.length == 4) {
        	Item item = new Item(0, "", 0.0); item.toObject(dados[0]);this.setItem(item);
            // reserva dados[1]
            this.setQuantidadeSolicitada(Integer.parseInt(dados[2]));
            SimpleDateFormat SDF = new SimpleDateFormat("yyyy-MM-dd");
            try {
				Date newdate = SDF.parse(dados[3]);
				this.setDataConsumo(newdate);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        } else {
            System.out.println("Classe: "+this.getClass().getName()+"\nERRO: String de entrada inválida.");
        }
    }
}
