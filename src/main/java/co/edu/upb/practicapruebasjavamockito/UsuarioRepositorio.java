
package co.edu.upb.practicapruebasjavamockito;

public interface UsuarioRepositorio {
    
    UsuarioDto crearUsuario(String nombre);
    UsuarioDto obtenerUsuario(Long id);
    
} // public interface UsuarioRepositorio 
