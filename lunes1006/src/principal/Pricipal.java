//sqlite : gstor de base de datos
package principal;
import gestionbd.AsistenteBD;
//como no es un metodo estatico no podemos llamar directamente asi que importamos


public class Pricipal {
    
    public static void main(String[] args){
        
       AsistenteBD abd = new AsistenteBD();
      //abd.crearBD();//crear base de datos, para comprobar hay que entrar a carpeta de archivo
      //abd.crarTabla();//crear tabla, para vee la base de datos completa hay que descagar "sqlite administrator"!!
      abd.insertarDatos(1, "Ana", "Alvarado", 25);
      //abd.mostrarDatos();
     // abd.actualizar(3,"Castillo");
     //abd.eliminar(1);
    }
}
