package aocampos.playlist.playlistsvc.business;

import aocampos.playlist.playlistsvc.feign.MusicClient;
import aocampos.playlist.playlistsvc.model.Playlist;
import aocampos.playlist.playlistsvc.model.Recommendation;
import aocampos.playlist.playlistsvc.service.GeneratePlaylist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

public abstract class BaseTrackSuggest implements TrackSuggest {

    @Autowired
    private MusicClient musicClient;

    @Autowired
    private GeneratePlaylist generatePlaylist;

    @Override
    public Playlist generatePlaylist(String genre) {

        ResponseEntity<Recommendation> tracks = musicClient.getTracks(genre);

        Playlist playlist = generatePlaylist.generatePlaylist(tracks.getBody());

        return playlist;
    }

}
