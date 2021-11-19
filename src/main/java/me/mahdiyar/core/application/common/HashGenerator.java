package me.mahdiyar.core.application.common;

import lombok.SneakyThrows;
import org.springframework.security.crypto.codec.Hex;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;

public class HashGenerator {
    @SneakyThrows
    public static String generateHash(String data) {
        return generateHash(data.getBytes(StandardCharsets.UTF_8));
    }

    @SneakyThrows
    public static String generateHash(byte[] data) {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(data);
        return new String(Hex.encode(hash));
    }
}
