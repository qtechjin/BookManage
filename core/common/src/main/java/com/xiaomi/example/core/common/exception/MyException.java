package com.xiaomi.example.core.common.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * Created by liujin on 2017/7/18.
 */
public class MyException extends Exception{
    private Throwable nestedException;

    public MyException() {
        super("Error occurred in My Application.");
    }

    public MyException(String message) {
        super(message);
    }

    public MyException(Throwable nestedException) {
        super(nestedException.getMessage());
        this.nestedException = nestedException;
    }

    public MyException(String message, Throwable nestedException) {
        super(message);
        this.nestedException = nestedException;
    }

    public Throwable getNestedException() {
        return this.nestedException;
    }

    public String getMessage() {
        return this.nestedException != null?super.getMessage() + " Nested exception: " + this.nestedException.getMessage():super.getMessage();
    }

    public void printStackTrace() {
        super.printStackTrace();
        if(this.nestedException != null) {
            System.err.print("Nested exception: ");
            this.nestedException.printStackTrace();
        }

    }

    public void printStackTrace(PrintStream out) {
        super.printStackTrace(out);
        if(this.nestedException != null) {
            out.println("Nested exception: ");
            this.nestedException.printStackTrace(out);
        }

    }

    public void printStackTrace(PrintWriter writer) {
        super.printStackTrace(writer);
        if(this.nestedException != null) {
            writer.println("Nested exception: ");
            this.nestedException.printStackTrace(writer);
        }

    }
}
