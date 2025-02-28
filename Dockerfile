FROM registry.access.redhat.com/ubi8/ubi-minimal

WORKDIR /work/
RUN chown 2000 /work \
    && chmod "g+rwX" /work \
    && chown 2000:2000 /work

COPY --chown=2000:2000 target/*-runner /work/application

EXPOSE 9000
USER 2000

CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]