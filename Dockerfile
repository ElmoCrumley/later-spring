# sdk
FROM amazoncorretto:21-alpine
# COPY <файл/директория> <путь-внутри-контейнера>
# альтернативный вариант записи:
# COPY ["<файл/директория>", "<путь-внутри-контейнера>"]
COPY target/*.jar later-spring.jar
ENTRYPOINT ["java","-jar","/later-spring.jar"]
# docker system prune -a -f всё удалить