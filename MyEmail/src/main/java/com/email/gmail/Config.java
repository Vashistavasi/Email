package com.email.gmail;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactoryBean;

@Configuration
public class Config  {
	
	 @Bean
     public FreeMarkerConfigurationFactoryBean getFreeMarkerConfig() {
         FreeMarkerConfigurationFactoryBean bean = new FreeMarkerConfigurationFactoryBean();
         bean.setTemplateLoaderPath("classpath:/templates");

         return bean;
     }

}
