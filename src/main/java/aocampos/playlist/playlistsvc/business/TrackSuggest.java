package aocampos.playlist.playlistsvc.business;

import aocampos.playlist.playlistsvc.model.Playlist;

public interface TrackSuggest {

    Playlist generatePlaylist();

    Playlist generatePlaylist(String genre);
}
