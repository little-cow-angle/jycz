package gene.recombine.stuhubsys.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.*;

public class JWTUtils {
    private static final String secretKey = "your12561bit1secret1key1must1be1at1least1321chars";

    private static final Key key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

    public static String GenerateJWTCode(HashMap<String,Object> value){
        return Jwts.builder()
            .addClaims(value)
            .signWith(key, SignatureAlgorithm.HS256)
            .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 2))
            .compact();
    }

    public static Claims ParseJWT(String jwt){
        try {
            return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
        } catch (Exception e){
            return null;
        }
    }
}