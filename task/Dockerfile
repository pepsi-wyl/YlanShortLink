FROM pepsiwyl920/arm64v8-open-jdk:17.0.10
MAINTAINER ylan "pepsiwyl@gmail.com"
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo '$TZ' > /etc/timezone
ENV APP_PATH=/app
WORKDIR  $APP_PATH
COPY ./target/YlanShortLink-Task.jar YlanShortLink-Task.jar
EXPOSE 8003
ENTRYPOINT ["java", "-jar"]
CMD ["YlanShortLink-Task.jar"]