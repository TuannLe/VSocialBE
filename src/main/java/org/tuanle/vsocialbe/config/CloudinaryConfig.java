package org.tuanle.vsocialbe.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CloudinaryConfig {
    @Bean
    public Cloudinary cloudinary() {
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "vsocial",
                "api_key", "315754697383886",
                "api_secret", "XQnyAuXPp-GR8ubJk8uffo_6vKU",
                "secure", true
        ));
    }
}
