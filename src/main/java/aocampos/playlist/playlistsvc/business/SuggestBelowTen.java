package aocampos.playlist.playlistsvc.business;

import aocampos.playlist.playlistsvc.model.Playlist;
import org.springframework.stereotype.Component;

@Component
public class SuggestBelowTen extends BaseTrackSuggest {

    private final String genre = "classical";

    @Override
    public Playlist generatePlaylist() {
        return generatePlaylist(genre);
    }
}
