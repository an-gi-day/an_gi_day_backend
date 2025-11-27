package com.bqtankiet.angiday.application.base;

/**
 * All UseCases must implement this interface to ensure a consistent structure.
 * <br> <b>(IN) Input type</b> - must implement {@link InputModel}
 * <br> <b>(OUT) Output type</b> - must implement {@link OutputModel}
 * @author bqtankiet
 */
public interface DefaultUseCase<IN, OUT> {

    interface InputModel {}
    interface OutputModel {}

    OUT call(IN input);

}
