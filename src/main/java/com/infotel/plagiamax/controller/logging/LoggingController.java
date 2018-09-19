package com.infotel.plagiamax.controller.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// TODO: Auto-generated Javadoc
/**
 * The Class LoggingController.
 */
@RestController
public class LoggingController {
 
    /** The logger. */
    Logger logger = LoggerFactory.getLogger(LoggingController.class);
 
    /**
     * Index.
     *
     * @return the string
     */
    @RequestMapping("/")
    public String index() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");
 
        return "Howdy! Check out the Logs to see the output...";
    }
}