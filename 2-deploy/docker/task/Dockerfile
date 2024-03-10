FROM openjdk:17-jdk-alpine
MAINTAINER ylan "pepsiwyl@gmail.com"
ENV TZ=Asia/Shanghai
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo '$TZ' > /etc/timezone
ENV APP_PATH=/app
WORKDIR  $APP_PATH
COPY ./YlanShortLink-Task.jar YlanShortLink-Task.jar
EXPOSE 8003
ENTRYPOINT ["java", "-jar"]
CMD ["YlanShortLink-Task.jar"]