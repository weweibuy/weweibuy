package com.weweibuy.auth.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @ClassName ISpringSocialConfigurer
 * @Description
 * @Author durenhao
 * @Date 2018/12/23 16:55
 **/
public class ISpringSocialConfigurer extends SpringSocialConfigurer {

    private String filterProcessesUrl;

    public ISpringSocialConfigurer(String filterProcessesUrl){
        this.filterProcessesUrl = filterProcessesUrl;
    }

    /**
     * 重新设置SocialAuthenticationFilter 处理的url
     * @param object
     * @param <T>
     * @return
     */
    @Override
    protected <T> T postProcess(T object) {
        SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
        filter.setFilterProcessesUrl(filterProcessesUrl);
        return (T) filter;
    }


}
