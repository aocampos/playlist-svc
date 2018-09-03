package aocampos.playlist.playlistsvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class PlaylistSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlaylistSvcApplication.class, args);
	}
}
