package za.ac.nwu.accountsystem.translator.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.accountsystem.repo.config.RepositoryConfig;

@Import({RepositoryConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.accountsystem.translator"
})
public class TranslatorConfig {

}