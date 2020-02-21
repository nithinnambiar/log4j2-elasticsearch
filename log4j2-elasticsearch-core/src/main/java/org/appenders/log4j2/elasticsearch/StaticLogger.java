package org.appenders.log4j2.elasticsearch;

public class StaticLogger {

    private static Logger logger;

    public static Logger getLogger() {
        if (logger == null) {
            throw new IllegalStateException("Logger not bound");
        }
        return logger;
    }

    public static void setLogger(Logger logger) {
        StaticLogger.logger = logger;
    }

}
