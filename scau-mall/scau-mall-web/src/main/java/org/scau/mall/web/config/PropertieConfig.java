package org.scau.mall.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertieConfig {

    @Value("${domain.url}")
    public String domainUrl;
}
