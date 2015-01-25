import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HttpPutFormContentFilter;

import javax.servlet.Filter;

@RestController
@EnableAutoConfiguration
public class Example {

    @RequestMapping("/")
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Example.class, args);
    }

    @Bean
    public FilterRegistrationBean servletFilterBean () {

        Filter filter = new HttpPutFormContentFilter();

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        registrationBean.setFilter(filter);
        registrationBean.addServletNames("dispatcherServlet");

        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean pathFilterBean () {

        Filter filter = new CharacterEncodingFilter();

        FilterRegistrationBean registrationBean = new FilterRegistrationBean();

        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns("/");

        return registrationBean;
    }
}