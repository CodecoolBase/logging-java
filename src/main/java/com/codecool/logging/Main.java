package com.codecool.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Thread.sleep(1000);
            logger.trace("main method start");
            logger.debug("main args {}", args);
            logger.info("attempting reading important data from file");
            try (InputStream is = new FileInputStream("A file that doesn't exists.L")) {
                is.read(); // Fails.
                logger.info("successfully read important data from file");
            } catch (IOException ex) {
                logger.error("Something bad happened ...", ex);
            }
            logger.trace("main method end");
        }
    }
}
