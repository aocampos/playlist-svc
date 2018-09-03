package aocampos.playlist.playlistsvc.feign;

import aocampos.playlist.playlistsvc.model.Recommendation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("playlist-music-svc")
public interface MusicClient {

    @GetMapping("track/genre/{genre}")
    ResponseEntity<Recommendation> getTracks(@PathVariable("genre") String genre);
}
