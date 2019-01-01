package com.weweibuy.config;

/**
 * oauth2 资源服务器配置
 * @ClassName OAuth2ResourceConfig
 * @Description
 * @Author durenhao
 * @Date 2018/12/31 14:29
 **/
//@Slf4j
//public class OAuth2ResourceConfig extends ResourceServerConfigurerAdapter {
//
//    @Autowired
//    private ResourceServerProperties resourceServerProperties;
//
//    @Bean
//    public TokenStore tokenStore() {
//        return new JwtTokenStore(jwtAccessTokenConverter());
//    }
//
//    @Bean
//    public JwtAccessTokenConverter jwtAccessTokenConverter() {
//        JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
//        converter.setVerifierKey("");// 非对称加密， 使用公钥验签
//        return converter;
//    }
//
//    private String getPubKey() {
//        Resource resource = new ClassPathResource("pubkey.txt");
//        try (BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
//            System.out.println("本地公钥");
//            return br.lines().collect(Collectors.joining("\n"));
//        } catch (IOException e) {
//            log.error("获取公钥失败 {}", e.getMessage());
//            throw new RuntimeException("获取公钥失败", e);
//        }
//    }
//
//}
