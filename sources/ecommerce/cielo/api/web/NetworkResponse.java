package ecommerce.cielo.api.web;


import lombok.Getter;

import java.net.http.HttpResponse;


@Getter
public class NetworkResponse<T> {

    private final boolean success;
    private final int statusCode;
    private final T body;
    private final NetworkError error;
    private final Exception exception;
    private final HttpResponse<T> rawResponse;

    private NetworkResponse(
            boolean success,
            int statusCode,
            T body,
            NetworkError error,
            Exception exception,
            HttpResponse<T> rawResponse) {

        this.success = success;
        this.statusCode = statusCode;
        this.body = body;
        this.error = error;
        this.exception = exception;
        this.rawResponse = rawResponse;
    }

    public static <T> NetworkResponse<T> success(HttpResponse<T> response) {
        return new NetworkResponse<>(true, response.statusCode(), response.body(), null, null, response);
    }

    public static <T> NetworkResponse<T> error(NetworkError error, Exception ex) {
        return new NetworkResponse<>(false, -1, null, error, ex, null);
    }

}
