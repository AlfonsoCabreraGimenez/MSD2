package Codigo;

public class Ingreso_Aplicacion extends Ingreso_Aplicacion_ventana{
	public Registrarse _unnamed_Registrarse_;
	public Iniciar_Sesion _unnamed_Iniciar_Sesion_;
	public Cabecera_NR _unnamed_Cabecera_NR_;
	
	Cabecera_Comun cc = new Cabecera_Comun();
	Registrarse reg = new Registrarse();
	Iniciar_Sesion ini = new Iniciar_Sesion();
	
	public Ingreso_Aplicacion() {
		inicializar();
	}
	void inicializar() {
		hInicio.addComponent(cc.inicio);
		hingreso.addComponent(reg.vRegistrarse);
		hingreso.addComponent(ini.vIniciar);
	}
}