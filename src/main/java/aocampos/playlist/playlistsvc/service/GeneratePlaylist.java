package aocampos.playlist.playlistsvc.service;

import aocampos.playlist.playlistsvc.model.Playlist;
import aocampos.playlist.playlistsvc.model.Recommendation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneratePlaylist {

    public Playlist generatePlaylist(Recommendation recommendation) {

        Playlist playlist = new Playlist();

        List<String> tracksName = recommendation.getTracks().stream().map(tracks -> {
            String artists = tracks.getArtists().stream()
                    .map(artist -> artist.getName()).collect(Collectors.joining(","));

            return artists + " - " + tracks.getName();
        }).collect(Collectors.toList());

        playlist.setTrackName(tracksName);

        return playlist;
    }

}
