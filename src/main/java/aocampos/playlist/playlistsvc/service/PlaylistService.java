package aocampos.playlist.playlistsvc.service;

import aocampos.playlist.playlistsvc.business.TrackSuggest;
import aocampos.playlist.playlistsvc.business.factory.TrackSuggestFactory;
import aocampos.playlist.playlistsvc.feign.WeatherClient;
import aocampos.playlist.playlistsvc.model.Playlist;
import aocampos.playlist.playlistsvc.model.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlaylistService {

    private final WeatherClient weatherClient;
    private final TrackSuggestFactory trackSuggestFactory;

    @Autowired
    public PlaylistService(WeatherClient weatherClient,
                           TrackSuggestFactory trackSuggestFactory) {
        this.weatherClient = weatherClient;
        this.trackSuggestFactory = trackSuggestFactory;
    }

    public Playlist getPlaylistByCityName(String cityName) {
        ResponseEntity<Temperature> temperature = weatherClient.getTemperatureByCityName(cityName);

        return getPlaylist(temperature.getBody());
    }

    public Playlist getPlaylistByCoordinates(double longitude, double latitude) {
        ResponseEntity<Temperature> temperature = weatherClient.getTemperatureByCoordinates(longitude, latitude);

        return getPlaylist(temperature.getBody());
    }

    private Playlist getPlaylist(Temperature temperature) {
        TrackSuggest trackSuggest = trackSuggestFactory.getInstance(temperature);

        Playlist playlist = trackSuggest.generatePlaylist();

        return playlist;
    }
}
