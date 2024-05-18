package Pack1;
import java.util.ArrayList;
import java.util.Date;

public class Reserva {
	private int codigo;
	private Hospede hospede;
	private Quarto quarto;
	private Funcionario funcionarioReserva;
	private Funcionario funcionarioFechamento;
	private Date dataEntradaReserva;
	private Date dataSaidaReserva;
	private Date dataCheckin;
	private Date dataCheckout;
	private double valorReserva;
	private double valorPago;
	
	public Boolean cadastro(Reserva R) {
		return true; // TODO:RETORNAR ALGO
	}
	public Boolean editar(Reserva R) {
		return true; // TODO:RETORNAR ALGO
	}
	public Reserva consultar(Reserva R) {
		return null; // TODO:RETORNAR ALGO
	}
	public ArrayList<Reserva> listar(Reserva R) {
		return null; // TODO:RETORNAR ALGO
	}
	
	public void pagarReserva(int valor) {
	// TODO:RETORNAR ALGO
	}
}
