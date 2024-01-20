FROM nginx:1.19
MAINTAINER ylan "pepsiwyl@gmail.com"
ENV APP_PATH=/app
WORKDIR  $APP_PATH
COPY ./dist  /usr/share/nginx/html/
COPY ./nginx/default.conf /etc/nginx/conf.d/default.conf
EXPOSE 80