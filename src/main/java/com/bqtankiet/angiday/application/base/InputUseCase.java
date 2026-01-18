package com.bqtankiet.angiday.application.base;

public interface InputUseCase<I, O> {
    O call(I input);
}
