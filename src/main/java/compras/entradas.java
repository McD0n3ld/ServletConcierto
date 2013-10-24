package compras;

public class entradas {
	private int id_entrada;
	private String nombre_concierto;
	private boolean estado;
	private String tipo;
	private String cantidad;

	public int getId_entrada() {
		return id_entrada;
	}

	public void setId_entrada(int id_entrada) {
		this.id_entrada = id_entrada;
	}

	public String getNombre_concierto() {
		return nombre_concierto;
	}

	public void setNombre_concierto(String nombre_concierto) {
		this.nombre_concierto = nombre_concierto;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getCantidad() {
		return cantidad;
	}

	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}

}
