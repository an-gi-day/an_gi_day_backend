package com.bqtankiet.angiday.application.base;

/**
 * All UseCases must implement this interface to ensure a consistent structure.
 * <br> <b>(I) Input type</b> - must implement {@link InputModel}
 * <br> <b>(O) Output type</b> - must implement {@link OutputModel}
 * @author bqtankiet
 */
public interface UseCase<I extends UseCase.InputModel, O extends UseCase.OutputModel> {

    interface InputModel {}
    interface OutputModel {}

    O call();

    UseCase<I,O> with(I input);
}
