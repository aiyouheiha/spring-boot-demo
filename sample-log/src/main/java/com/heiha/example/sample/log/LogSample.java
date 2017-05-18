package com.heiha.example.sample.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/5/18 13:34<br>
 * <b>Author:</b> heiha<br>
 */
@Component
public class LogSample {
    private static final Logger LOGGER = LoggerFactory.getLogger(LogSample.class);

    public void log(String logName, String logValue) {
        if (LOGGER.isErrorEnabled()) {
            LOGGER.error("Log name: {}, Log value: {}", logName, logValue);
        }
        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Log name: {}, Log value: {}", logName, logValue);
        }
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("Log name: {}, Log value: {}", logName, logValue);
        }
    }
}
