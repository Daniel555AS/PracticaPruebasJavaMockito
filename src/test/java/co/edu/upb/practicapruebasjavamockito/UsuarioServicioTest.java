package co.edu.upb.practicapruebasjavamockito;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

// Otra forma de habilitar el uso de anotaciones con las pruebas de Mockito:
// @RunWith(MockitoJUnitRunner.class)
public class UsuarioServicioTest {

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Mock
    private UsuarioRepositorio usuarioRepositorio;
    // Otra forma de crear un objeto simulado:
    //@Before
    //public void setUp() {
    //    UsuarioRepositorio usuarioRepositorio = Mockito.mock(UsuarioRepositorio.class);
    //}
    
    @InjectMocks
    UsuarioServicio usuarioServicio;
    // Otra forma de Inyectar un objeto simulado(mock) en otro objeto
    // private UsuarioServicio usuarioServicio;
    //@Before
    //public void setUp(){
    //    usuarioServicio = new UsuarioServicio(usuarioRepositorio);
    //}
    
    @Test
    public void testCrearUsuario() {
        UsuarioDto esperado = new UsuarioDto(1L, "Juan");
        UsuarioDto objetoSimulado = new UsuarioDto(1L, "Juan");
        Mockito.when(usuarioRepositorio.crearUsuario(Mockito.anyString())).thenReturn(objetoSimulado);
        final UsuarioDto resultado = usuarioServicio.crearUsuario("Prueba");
        assertEquals(esperado.nombre, resultado.nombre);
        Mockito.verify(usuarioRepositorio, Mockito.times(1)).crearUsuario("Prueba");
    } // public void testCrearUsuario1()
    
    @Test
    public void testObtenerUsuario() {
        UsuarioDto esperado = new UsuarioDto(1L, "Juan");
        UsuarioDto objetoSimulado = new UsuarioDto(1L, "Juan");
        Mockito.when(usuarioRepositorio.obtenerUsuario(1L)).thenReturn(objetoSimulado);
        final UsuarioDto resultado = usuarioServicio.obtenerUsuario(1L);
        assertEquals(esperado.nombre, resultado.nombre);
        Mockito.verify(usuarioRepositorio, Mockito.times(1)).obtenerUsuario(1L);
    } // public void testObtenerUsuario() 
    
} // public class UsuarioServicioTest
