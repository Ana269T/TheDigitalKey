package com.TheDigitalKey.app.bd;


import jakarta.persistence.*;


@Entity
@Table(name = "Reserva")

public class Reserva { 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 @Column(name = "fecha_entrada")
	 private String fecha_entrada;

	 @Column(name = "fecha_salida")
	 private String fecha_salida;
	 
	 @Column(name = "estado_reserva")
	 private String estado_reserva;

     @Column(name = "precio_total")
	 private int precio_total;
     
     @Column(name = "forma_pago")
	 private String forma_pago;

	 @Column(name = "politica_cancelacion")
	 private String politica_cancelacion;
	 
	 // Definición de la relación ManyToOne con la entidad Usuario
	    @ManyToOne
	    @JoinColumn(name = "usuario_id", referencedColumnName = "id")
	    private Usuario usuario;
	    
	    // Definición de la relación ManyToOne con la entidad Departamento
	    @ManyToOne
	    @JoinColumn(name = "habitacion_id", referencedColumnName = "id")
	    private Habitacion habitacion;

	    
	    // Constructor vacío (necesario para JPA)
	    public Reserva() {
	    }
	   // Constructor 

		public Reserva(Long id, String fecha_entrada, String fecha_salida, String estado_reserva, int precio_total,
				String forma_pago, String politica_cancelacion, Usuario usuario) {
			super();
			this.id = id;
			this.fecha_entrada = fecha_entrada;
			this.fecha_salida = fecha_salida;
			this.estado_reserva = estado_reserva;
			this.precio_total = precio_total;
			this.forma_pago = forma_pago;
			this.politica_cancelacion = politica_cancelacion;
			this.usuario = usuario;
		}
		// Getters y setters 

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getFecha_entrada() {
			return fecha_entrada;
		}

		public void setFecha_entrada(String fecha_entrada) {
			this.fecha_entrada = fecha_entrada;
		}

		public String getFecha_salida() {
			return fecha_salida;
		}

		public void setFecha_salida(String fecha_salida) {
			this.fecha_salida = fecha_salida;
		}

		public String getEstado_reserva() {
			return estado_reserva;
		}

		public void setEstado_reserva(String estado_reserva) {
			this.estado_reserva = estado_reserva;
		}

		public int getPrecio_total() {
			return precio_total;
		}

		public void setPrecio_total(int precio_total) {
			this.precio_total = precio_total;
		}

		public String getForma_pago() {
			return forma_pago;
		}

		public void setForma_pago(String forma_pago) {
			this.forma_pago = forma_pago;
		}

		public String getPolitica_cancelacion() {
			return politica_cancelacion;
		}

		public void setPolitica_cancelacion(String politica_cancelacion) {
			this.politica_cancelacion = politica_cancelacion;
		}

		public Usuario getUsuario() {
			return usuario;
		}

		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}

	   
	    
	    

	    
		
	 

}
