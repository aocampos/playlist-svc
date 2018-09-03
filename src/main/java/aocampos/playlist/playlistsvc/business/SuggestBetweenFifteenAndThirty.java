package aocampos.playlist.playlistsvc.business;

import aocampos.playlist.playlistsvc.model.Playlist;
import org.springframework.stereotype.Component;

@Component
public class SuggestBetweenFifteenAndThirty extends BaseTrackSuggest {

    private final String genre = "pop";

    @Override
    public Playlist generatePlaylist() {
        return generatePlaylist(genre);
    }
}
