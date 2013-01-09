/**
 * Copyright 2012, netbreeze GmbH
 */
package ch.wurmlo.week4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GraphFileException extends Exception {

    public GraphFileException(String message, String fileName) {
        super(message.concat(", fileName: " + fileName));
    }

}
