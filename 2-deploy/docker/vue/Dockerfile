FROM nginx:1.19
MAINTAINER ylan "pepsiwyl@gmail.com"
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo '$TZ' > /etc/timezone
ENV APP_PATH=/app
WORKDIR  $APP_PATH
COPY ./dist  /usr/share/nginx/html/
COPY ./nginx.conf /etc/nginx/nginx.conf

EXPOSE 80