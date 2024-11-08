FROM open-liberty:24.0.0.10-kernel-slim-java11-openj9

USER root

COPY --chown=1001:0 postgresql-42.7.3.jar /opt/ol/wlp/usr/shared/resources/
COPY --chown=1001:0 server.xml /config/
RUN features.sh

COPY --chown=1001:0 liberty-batch-ear.ear /config/apps/
RUN configure.sh

USER 1001
