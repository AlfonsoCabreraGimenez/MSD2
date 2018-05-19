package diagramaclasesbd;

import Codigo.iUsuario_Registrado;
import Codigo.iAdministrador2;
import Codigo.iUsuario_No_Registrado;

public class BD_Principal implements iUsuario_Registrado, iAdministrador2, iUsuario_No_Registrado {
	public BD_Categorias _bd_categ = new BD_Categorias();
	public BD_Videos _bd_videos = new BD_Videos();
	public BD_Listas_De_Reproduccion _bd_listasrep = new BD_Listas_De_Reproduccion();
	public BD_Comentarios _bd_coment = new BD_Comentarios();
	public BD_Registrados _bd_regis = new BD_Registrados();
	public BD_Administradores _bd_admin = new BD_Administradores();
}