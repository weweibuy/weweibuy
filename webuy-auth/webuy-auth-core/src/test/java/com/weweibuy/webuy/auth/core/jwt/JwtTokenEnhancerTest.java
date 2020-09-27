package com.weweibuy.webuy.auth.core.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenEnhancerTest {


    @Test
    public void jwtTokenTest() throws Exception {
        String buildJwtRS256 = buildJwtRS256(100000);
        System.err.println(buildJwtRS256);
    }

    /**
     * 读取资源文件
     *
     * @param fileName 文件的名称
     * @return
     */
    public static String readResourceKey(String fileName) throws IOException {
        Resource resource = new ClassPathResource("key/jwt_rsa_private_key.pem");
        return IOUtils.toString(resource.getInputStream());
    }

    /**
     * 构建token
     *
     * @param ttlMillis 过期的时间-毫秒
     * @return
     * @throws Exception
     */
    public static String buildJwtRS256(long ttlMillis) throws Exception {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.RS256;
        // 读取私钥
        String key = readResourceKey("key/jwt_rsa_private_key.pem");
        // 生成签名密钥
        byte[] keyBytes = (new BASE64Decoder()).decodeBuffer(key);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        // 生成JWT的时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        //创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("userid", "123");
        claims.put("username", "tom");
        claims.put("usertype", "TEST");

        // 生成jwt文件
        JwtBuilder builder = Jwts.builder()
                // 这里其实就是new一个JwtBuilder，设置jwt的body
                // 如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setClaims(claims)
                .setHeaderParam("typ", "JWT")
                .setIssuedAt(now)
                .setSubject("11")
                .signWith(signatureAlgorithm, privateKey);

        // 如果配置了过期时间
        if (ttlMillis >= 0) {
            // 当前时间加上过期的秒数
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            // 设置过期时间
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    /**
     * 解密Jwt内容
     *
     * @param jwt
     * @return
     */
    public static String parseJwtRS256(String jwt) {
        Claims claims = null;
        try {
            // 读取公钥
            String key = readResourceKey("key/jwt_rsa_private_key.pem.pem");
            // 生成签名公钥
            byte[] keyBytes = (new BASE64Decoder()).decodeBuffer(key);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(keySpec);
            claims = Jwts.parser()
                    .setSigningKey(publicKey)
                    .parseClaimsJws(jwt).getBody();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return claims.get("uid", String.class);
    }

}