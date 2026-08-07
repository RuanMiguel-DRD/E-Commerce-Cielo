package ecommerce.cielo.internal;


public final class RegexCode {

    // Common Regex
    public static final String UUID4 = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-4[0-9a-fA-F]{3}-[89abAB][0-9a-fA-F]{3}-[0-9a-fA-F]{12}$";

    // Specific Regex
    public static final String BIN = "^[0-9]{6,8}$";
    public static final String PAYMENT_ID = UUID4;
    public static final String RECURRENT_PAYMENT_ID = UUID4;
    public static final String TRANSACTIONAL_ID = "^[a-zA-Z0-9]{20}$"; 

    // Credentials
    public static final String MERCHANT_ID = UUID4;
    public static final String MERCHANT_KEY = "^[a-zA-Z0-9]{40}$";

    private RegexCode() {
        throw new UnsupportedOperationException("This class is an internal utility class and cannot be instantiated");
    }

}
