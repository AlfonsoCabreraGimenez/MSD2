package Codigo;

public class Perfil_Ajeno_A extends Perfil_Ajeno_A_ventana {
	//private Boton _eliminarUsuarioB;
	public Usuario2 _unnamed_Usuario2_;
	public Video2 _unnamed_Video2_;
	public Conf_Eliminar_Usuario _unnamed_Conf_Eliminar_Usuario_;
	
	Cabecera_Comun cc = new Cabecera_Comun();
	Cabecera_R cr = new Cabecera_R();
	
	public Perfil_Ajeno_A(){
		inicializar();
	}
	
	void inicializar(){
		hCabeceraComunInicio.addComponent(cc);
		hCabeceraGeneral.addComponent(cr);
		
	}
}