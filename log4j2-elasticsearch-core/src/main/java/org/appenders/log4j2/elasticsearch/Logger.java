package org.appenders.log4j2.elasticsearch;

public interface Logger {

    void error(String messageFormat, Object... parameters);
    void warn(String messageFormat, Object...parameters);
    void info(String messageFormat, Object... parameters);
    void debug(String messageFormat, Object...parameters);
    void trace(String messageFormat, Object...parameters);

}
