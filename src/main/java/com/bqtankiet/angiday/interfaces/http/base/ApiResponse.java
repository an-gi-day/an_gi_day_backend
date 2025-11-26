package com.bqtankiet.angiday.interfaces.http.base;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private int code;
    private boolean success;
    private String message;
    private T data;
    private List<String> errors;
    private LocalDateTime timestamp = LocalDateTime.now();
    private Map<?, ?> metadata = null;

    public ApiResponse() {
    }

    public ApiResponse(int code, boolean success, String message, T data, List<String> errors) {
        this.code = code;
        this.success = success;
        this.message = message;
        this.data = data;
        this.errors = errors;
    }

    // SUCCESS
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, true, "success", data, null);
    }

    // ERRORS
    public static <T> ApiResponse<T> error(int code, String... errors) {
        return new ApiResponse<>(code, false, "error", null, List.of(errors));
    }

    public static <T> ApiResponse<T> errorWithMessage(int code, String message, String... errors) {
        return new ApiResponse<>(code, false, message, null, List.of(errors));
    }
}
