package ecommerce.cielo.config;


import lombok.AccessLevel;
import lombok.Getter;

import lombok.NonNull;


@Getter(AccessLevel.PROTECTED)
public class Credentials {

    private final String merchantId;
    private final String merchantKey;

    private static final String INVALID_ERROR = "Credential \"%s\" is in an invalid format";

    private static final String REGEX_ID = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
    private static final String REGEX_KEY = "^[a-zA-Z0-9]{40}$";

    public Credentials(@NonNull String merchantId, @NonNull String merchantKey) {

        if (!merchantId.matches(REGEX_ID)) {
            throw new IllegalArgumentException(INVALID_ERROR.formatted("merchantId"));
        }
        this.merchantId = merchantId;

        if (!merchantKey.matches(REGEX_KEY)) {
            throw new IllegalArgumentException(INVALID_ERROR.formatted("merchantKey"));
        }
        this.merchantKey = merchantKey;

    }

}
