package multipleregions;

import com.gemstone.gemfire.cache.GemFireCache;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.gemfire.CacheFactoryBean;
import org.springframework.data.gemfire.LocalRegionFactoryBean;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableGemfireRepositories
public class Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
		PartnerRepository repository = ctx.getBean(PartnerRepository.class);
		for (Person person : repository.findAll()) {
			System.out.println(person);
		}
    }

	@Bean
	CacheFactoryBean cacheFactoryBean() {
		return new CacheFactoryBean();
	}

	@Bean
	LocalRegionFactoryBean<Person, Long> customerRegionFactory(GemFireCache cache) {
		LocalRegionFactoryBean<Person, Long> factory = new LocalRegionFactoryBean<>();
		factory.setCache(cache);
		factory.setName("customers");
		return factory;
	}

	@Bean
	LocalRegionFactoryBean<Person, Long> partnerRegionFactory(GemFireCache cache) {
		LocalRegionFactoryBean<Person, Long> factory = new LocalRegionFactoryBean<>();
		factory.setCache(cache);
		factory.setName("partners");
		return factory;
	}

}
