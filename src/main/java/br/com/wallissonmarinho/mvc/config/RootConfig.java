package br.com.wallissonmarinho.mvc.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("br.com.wallissonmarinho.mvc")
@EnableWebMvc
public class RootConfig {

}
