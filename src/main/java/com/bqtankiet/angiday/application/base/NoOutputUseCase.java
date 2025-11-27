package com.bqtankiet.angiday.application.base;

/**
 * @author bqtankiet
 * @param <IN>
 */
public interface NoOutputUseCase<IN> {

    void call(IN input);
}
