package com.bqtankiet.angiday.application.base;

public interface UseCase<I extends UseCase.InputModel, O extends UseCase.OutputModel> {

    interface InputModel {}
    interface OutputModel {}

    O call();

    UseCase<I,O> with(I input);
}
