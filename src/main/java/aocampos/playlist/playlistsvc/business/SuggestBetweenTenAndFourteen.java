package aocampos.playlist.playlistsvc.business;

import aocampos.playlist.playlistsvc.model.Playlist;
import org.springframework.stereotype.Component;

@Component
public class SuggestBetweenTenAndFourteen extends BaseTrackSuggest {

    private final String genre = "rock";

    @Override
    public Playlist generatePlaylist() {
        return generatePlaylist(genre);
    }
}
