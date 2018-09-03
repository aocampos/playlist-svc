package aocampos.playlist.playlistsvc.business.factory;

import aocampos.playlist.playlistsvc.business.TrackSuggest;
import aocampos.playlist.playlistsvc.model.Temperature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class TrackSuggestFactory {

    private final ApplicationContext applicationContext;

    @Autowired
    public TrackSuggestFactory(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public TrackSuggest getInstance(Temperature temperature) {

        double degree = temperature.getTemperature();

        if (degree > 30.0) {
            return (TrackSuggest) applicationContext.getBean("suggestAboveThirty");
        } else if (degree >= 15.0 && degree <= 30.0) {
            return (TrackSuggest) applicationContext.getBean("suggestBetweenFifteenAndThirty");
        } else if (degree >= 10.0 && degree <= 14.0) {
            return (TrackSuggest) applicationContext.getBean("suggestBetweenTenAndFourteen");
        } else if (degree < 10.0) {
            return (TrackSuggest) applicationContext.getBean("suggestBelowTen");
        }

        return null;
    }
}
