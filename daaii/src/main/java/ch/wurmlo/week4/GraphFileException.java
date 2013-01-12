package ch.wurmlo.week4;

public class GraphFileException extends Exception {

    public GraphFileException(String message, String fileName) {
        super(message.concat(", fileName: " + fileName));
    }

}
