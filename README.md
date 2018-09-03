# Playlist of the Weather

This project create a playlist based in the current weather of a given city.

## Getting Started

This project use a microservice architecture and it is compound of the projects below.

- [playlist-config-svr](https://github.com/aocampos/playlist-config-svr) 
- [playlist-eureka-svr](https://github.com/aocampos/playlist-eureka-svr)
- [playlist-weather-svc](https://github.com/aocampos/playlist-weather-svc)
- [playlist-music-svc](https://github.com/aocampos/playlist-music-svc)
- [playlist-svc](https://github.com/aocampos/playlist-svc)

### Prerequisites

To use this project is necessary an account on the [Spotify](https://developer.spotify.com/) and [OpenWeatherMap](https://openweathermap.org/).

And have installed the following softwares:

- java 10
- git
- docker
- docker-compose

### Running

Follow the steps below to run the project.

Create the folder playlist.

```
mkdir playlist
``` 

Clone the repository playlist-svc inside the folder playlist.

```
cd playlist && git clone https://github.com/aocampos/playlist-svc.git
```

Clone the others repositories.

```
./playlist-svc/devops/clone-repos.sh
```

Configure the credential of Spotify and OpenWeatherMap account.

- Spotify: fields client-id and client-secret in the file playlist-config-svr/src/main/resources/config/playlist-music-svc/playlist-music-svc.yml

- OpenWeatherMap: field api-key in the file playlist-config-svr/src/main/resources/config/playlist-weather-svc/playlist-weather-svc.yml

Generate the image of the projects.

```
./playlist-svc/devops/generate-images.sh
```

Start the application and wait until all the projects are up.

```
docker-compose -f playlist-svc/devops/docker-compose.yml up -d
```

Execute a call to get a playlist.

```
curl -X GET "http://localhost:8083/playlist/city-name?cityName=London"
```
```
curl -X GET "http://localhost:8083/playlist/coordinate?lon=-0.13&lat=51.51"
```

Stop the application.

```
docker-compose -f playlist-svc/devops/docker-compose.yml down
```
