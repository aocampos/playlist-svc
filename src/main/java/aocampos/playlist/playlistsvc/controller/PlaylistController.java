package aocampos.playlist.playlistsvc.controller;

import aocampos.playlist.playlistsvc.model.Playlist;
import aocampos.playlist.playlistsvc.service.PlaylistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    private final PlaylistService playlistService;

    @Autowired
    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @GetMapping(value = "/city-name")
    public Playlist getPlaylistByCityName(@RequestParam("cityName") String cityName) {
        return playlistService.getPlaylistByCityName(cityName);
    }

    @GetMapping(value = "/coordinate")
    public Playlist getPlaylistByCoodinate(@RequestParam("lon") double longitude,
                                           @RequestParam("lat") double latitude) {
        return playlistService.getPlaylistByCoordinates(longitude, latitude);
    }
}
