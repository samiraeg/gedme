package liias.desarrolloweb.libros;


import liias.desarrolloweb.libros.Modelo.Usuario;
import liias.desarrolloweb.libros.Service.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class LibrosApplication implements CommandLineRunner{

     @Autowired
    private IUsuarioService usuarioService;
     
	public static void main(String[] args) {
		SpringApplication.run(LibrosApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
//        System.out.println("Hola coder");
//        LOG.info("Hola coder desde consola");
//        LOG.warn("Advertencia");
  //  usuarioService.Salvar(new Usuario("pepe", "martinez", "13345678901", "ADMIN2", "12345", "ADMIN", true));
//      usuarioService.Salvar(new Usuario("SARANo", "PEREZ", "12345678900", "Especialista2", "1234576", "Especialista", true));
//      usuarioService.Salvar(new Usuario("Alejandra", "MOnagas", "12345678901", "Usuario2", "1234587", "Usuario", true));


    }
     @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
