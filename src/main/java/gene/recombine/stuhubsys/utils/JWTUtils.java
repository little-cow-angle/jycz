package gene.recombine.stuhubsys.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;

public class JWTUtils {
    private static final String secretKey="your12561bit1secret1key1must1be1at1least1321chars";

    public static String GenerateJWTCode(HashMap<String,Object> value){
        return Jwts.builder()
                .addClaims(value)
                .signWith(SignatureAlgorithm.HS256, secretKey) //设置秘钥
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 2))
                .compact();
    }

    public static Claims ParseJWT(String Jwt){
        Claims value;
        try {
           value = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(Jwt).getBody();
        } catch (Exception e){
            return null;
        }
        return value;
    }
}
