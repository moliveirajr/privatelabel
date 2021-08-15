package br.com.legus.privatelabel.service.bradesco;

import br.com.legus.privatelabel.util.RSA;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.*;

import static br.com.legus.privatelabel.util.RSA.getPrivateKeyFromString;

public class BradescardSignure {


    private static final String privateKey = "-----BEGIN PRIVATE KEY-----\n" +
            "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDgtZ+AeFbb78N6\n" +
            "ZaxJO2A6yaM7bpRAo1qm0YwvA5OsUoBt9fK0JaJP7qyTs8mqg9RradhXINH+Z+xF\n" +
            "IUSBemzlICETeVs66WyOlet8I2Cv7VISmTex4gSB42atFbV4PPOfL8hERyC2IFWw\n" +
            "PGi6kjvNyvVrComonC9TnNRv4PFabSoe2Xgcvs6WE8yV1O/7H1bWvPyZPu28EIdH\n" +
            "viVxDuEf8kGc843pyAYsa5cO5HbEyEDs8PGqoer0t8jYL7TUzEAYrqYLqqPh60ga\n" +
            "orLfJjIBvcX30G53+pROxjNpARTsV69+r8eobDhPEmrt4PJ3tAJSxnYscuAzZfTX\n" +
            "e9PsOPNRAgMBAAECggEBAJCdMn5adAPtZQ9jWaJznPWYiP2Zp72Fo7SSTTaAhcwz\n" +
            "+EVMMJsxUSlCADy6SwH6/3z1TG6eR6cDuLGwvEbbxDMdH0xKIKVkTiHhaACnP/VY\n" +
            "tSYVBxvqyl3RPGYN/5DXIS6EcM1IPUwYuSzHY9sWe3hwssrlqDwj7+1OlAVAbfNz\n" +
            "8x1WaXOQodhl2IRtuL3FSCQDQfaGrcLCBXseElWOKiYL1XYSqg7Uk1zGAzDYXZe8\n" +
            "Zke/iaP6Lg73xBFYNlI8Z5t554S3bWHOmJtB9JgxF06FpubNLgDhL7UgHhHvRJTz\n" +
            "tTgYuRgfi4ichvwFVp8sw80dZEQWt+QszCAbFRJuWLUCgYEA8KM00YNJ5om49a1T\n" +
            "q4N3unHuHu/cbp2IUDbpRKpgLL9RWDrNjH3kWd58avU5at+MANrpuFuuwCnXKqZU\n" +
            "Rk/MryVHGR5WPXr0gYwAIEvS3c23DPM2RMl5sNLfGG+OeOAcYZn/Zus9iJGzCBPF\n" +
            "BdPyXnxhudsDiz7Y7rD2LUdgIVMCgYEA7w4Z0I8jQs7ElFvbfF8+D2G1ytESAto8\n" +
            "1BfSCOFvOU08cY6Hb1cHuDeQt2l03bRpO3/DP1UbCE9TEsMKrISz2q+Mdcq1bEOa\n" +
            "LjKODtnSB691hyDyb1+Ekb+B9ygzQeTQQ8nchwVxn/CAxx0E370QhXvdBZUAnxQe\n" +
            "/c4nFBneEEsCgYEAojcy/OWHJMzEjYD5PU6ToHD694n0S/EQGhraJzq/OIsD9/kz\n" +
            "5ThcfiSYNLX4rc3ioBTypx/O7qWF8a9MclWLAqqbghhMRIelWcsZrqvOi00Iz8cI\n" +
            "V1iGGygb0mopXdyd5UGdxTBhO7YUPSauk14sLXulmVdFzVFhhY5vdVh/OhcCgYBL\n" +
            "gJ2gpITThfDKltSUzJQSUZ8URsI0im8p4bghu+ngJEfR6d1WyhsTEOGxPCqAF4oh\n" +
            "E7I8H4ohLsSjKV0GrgcMK+PmFDcG0bcxniAGCr/uU3mAS2SmznlVezH2OQkvZ7Br\n" +
            "qKbxMkP36wMRYFX4wIMmVb+yEqSWmclMCj+HdsAPTwKBgQDSjZG66BZzWIfuwvUF\n" +
            "F6G9k20XIPqX/6m6ut4pFLwBZtTZImdwoIj+NUKswluFS74lm4y3mifMLIyEI6lq\n" +
            "unwRU2SQt+U/6V/C33tt2CrsmRbwSaPhRu+BYtyTt7zVXP+7mPOvUm63uqpTpF8I\n" +
            "I5+v7O0zlrOcNWTMhiFLlbYqYQ==\n" +
            "-----END PRIVATE KEY-----\n";

    public static PrivateKey bradescardPrivateKey() {

        PrivateKey keyBradesco = null;
        try {
            keyBradesco = getPrivateKeyFromString (privateKey);
        } catch (IOException | GeneralSecurityException e) {
            e.printStackTrace ( );
        }

        return keyBradesco;
    }

    public static String bradescardSign(String message) {

        String signed = "";
        try {
            signed = RSA.sign (bradescardPrivateKey ( ), message);
        } catch (NoSuchAlgorithmException | InvalidKeyException | SignatureException | UnsupportedEncodingException e) {
            e.printStackTrace ( );
        }
        return signed;
    }
}
