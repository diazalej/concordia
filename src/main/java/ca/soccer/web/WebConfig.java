package ca.soccer.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.
        DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.
        WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.
        InternalResourceViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;




@Configuration
@EnableWebMvc
@ComponentScan(basePackages={"ca.soccer.web"})
@EnableTransactionManagement
public class WebConfig
        extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver viewResolver() {
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }
    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.defaultContentType(MediaType.TEXT_HTML);
    }
    @Bean
    public ViewResolver cnViewResolver(ContentNegotiationManager cnm) {
        ContentNegotiatingViewResolver cnvr =
                new ContentNegotiatingViewResolver();
        cnvr.setContentNegotiationManager(cnm);
        return cnvr;
    }
    @Bean
    public ViewResolver beanNameViewResolver() {
        return new BeanNameViewResolver();
    }

    @Bean
    public View playersapi() {
        return new MappingJackson2JsonView();
    }
}



