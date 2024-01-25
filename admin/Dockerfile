FROM pepsiwyl920/arm64v8-open-jdk:17.0.10
MAINTAINER ylan "pepsiwyl@gmail.com"
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo '$TZ' > /etc/timezone
ENV APP_PATH=/app
WORKDIR  $APP_PATH
COPY ./target/YlanShortLink-Admin.jar YlanShortLink-Admin.jar
EXPOSE 8002
ENTRYPOINT ["java", "-jar"]
CMD ["YlanShortLink-Admin.jar"]