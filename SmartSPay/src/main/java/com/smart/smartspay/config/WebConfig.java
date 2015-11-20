/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.smartspay.config;

import com.smart.smartspay.task.WebSiteConfig;
import javax.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 *
 * @author Administrator
 */
@Configuration
@PropertySource("classpath:webSite.properties")
public class WebConfig {
    
    @Resource
    private Environment env;
    
    private static final String httpPath = "httpPath";
    private static final String httpDepotPath = "httpDepotPath";
    
    @Bean
    public WebSiteConfig WebSiteConfig() {
        WebSiteConfig websiteConfig = new WebSiteConfig();
        websiteConfig.setWebSiteHttpPath(env.getProperty(httpPath));
        websiteConfig.setWebSiteHttpDepotPath(env.getProperty(httpDepotPath));
        
        return websiteConfig;
    }
    
}
