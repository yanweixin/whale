package me.whale.utils.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

import java.util.Properties;

public class SpringUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpringUtil.class);

    public static Properties readYaml() {
        LOGGER.info("start reading yaml file");
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        factoryBean.setResources(new ClassPathResource("application.yml"));
        return factoryBean.getObject();
    }

}
