#!/usr/bin/env bash
(cd playlist-config-svr; mvn clean install docker:build)
(cd playlist-eureka-svr; mvn clean install docker:build)
(cd playlist-weather-svc; mvn clean install docker:build)
(cd playlist-music-svc; mvn clean install docker:build)
(cd playlist-svc; mvn clean install docker:build)