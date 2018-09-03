package aocampos.playlist.playlistsvc.business;

import aocampos.playlist.playlistsvc.model.Playlist;
import org.springframework.stereotype.Component;

@Component
public class SuggestAboveThirty extends BaseTrackSuggest {

    private final String genre = "party";

    @Override
    public Playlist generatePlaylist() {
        return generatePlaylist(genre);
    }
}
