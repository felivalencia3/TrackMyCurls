package valencia.java.TrackMyCurls;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class MvcConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("app/build/static/");
        registry.addResourceHandler("/*.js")
                .addResourceLocations("app/build/");
        registry.addResourceHandler("/*.json")
                .addResourceLocations("app/build/");
        registry.addResourceHandler("/*.ico")
                .addResourceLocations("app/build/");
        registry.addResourceHandler("/index.html")
                .addResourceLocations("app/build/index.html");
    }
}
