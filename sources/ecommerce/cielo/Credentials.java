package ecommerce.cielo;


import lombok.Getter;
import lombok.AccessLevel;

import lombok.NonNull;

import static ecommerce.cielo.internal.RegexCode.MERCHANT_ID;
import static ecommerce.cielo.internal.RegexCode.MERCHANT_KEY;


@Getter(AccessLevel.PROTECTED)
public class Credentials {

    private final String merchantId;
    private final String merchantKey;

    private static final String INVALID_ERROR = "Credential \"%s\" is in an invalid format";

    public Credentials(@NonNull String merchantId, @NonNull String merchantKey) {

        if (!merchantId.matches(MERCHANT_ID)) {
            throw new IllegalArgumentException(INVALID_ERROR.formatted("merchantId"));
        }
        this.merchantId = merchantId;

        if (!merchantKey.matches(MERCHANT_KEY)) {
            throw new IllegalArgumentException(INVALID_ERROR.formatted("merchantKey"));
        }
        this.merchantKey = merchantKey;

    }

}
