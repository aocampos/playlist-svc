package aocampos.playlist.playlistsvc.feign;

import aocampos.playlist.playlistsvc.model.Temperature;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("playlist-weather-svc")
public interface WeatherClient {

    @GetMapping(value = "/temperature/cityName/{cityName}")
    ResponseEntity<Temperature> getTemperatureByCityName(@PathVariable("cityName") String cityName);

    @GetMapping(value = "/temperature/longitude/{lon}/latitude/{lat}")
    ResponseEntity<Temperature> getTemperatureByCoordinates(@PathVariable("lon") double longitude,
                                                            @PathVariable("lat") double latitude);
}
