package Codigo;

public class Perfil_Propio_R extends Perfil_Propio_R_ventana{
	/*private Label _nombreL;
	private Label _emailL;
	private Label _apellidoL;
	private Label _fechaNacimientoL;
	private Boton _modificarDatosB;
	private Boton _crearListaRepB;
	private Boton _modificarVideoB;
	private Borrar _borrarVideoB;*/
	public Video2 _unnamed_Video2_;
	public Usuario2 _unnamed_Usuario2_;
	public Cabecera_R _unnamed_Cabecera_R_;
	public Crear_Lista_Reproduccion _unnamed_Crear_Lista_Reproduccion_;
	public Modificar_Datos_Usuario _unnamed_Modificar_Datos_Usuario_;
	public Conf_Eliminar_Video _unnamed_Conf_Eliminar_Video_;

	Cabecera_Comun cc = new Cabecera_Comun();
	Cabecera_R cr = new Cabecera_R();
	Video2 v2 = new Video2();
	
	public Perfil_Propio_R(){
		inicializar();
	}
	
	void inicializar(){
		hCabeceraInicio.addComponent(cc.inicio);
		hCabeceraRegistrado.addComponent(cr.avatar);
		hCabeceraRegistrado.addComponent(cr.botonSubirVideo);
		hCabeceraRegistrado.addComponent(cr.botonCerrarSesion);
		hPanel.addComponent(v2.vVerticalVideoGeneral);
		
	}
	public void borrarVideo() {
		throw new UnsupportedOperationException();
	}

	public void cargarPerfilPropioR() {
		throw new UnsupportedOperationException();
	}
}