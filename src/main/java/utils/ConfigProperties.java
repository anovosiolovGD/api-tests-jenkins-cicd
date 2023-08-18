package utils;

import org.aeonbits.owner.Config;
@Config.Sources({"file:./src/main/resources/application.properties"})
public interface ConfigProperties extends Config {

    String url();

    String key();

    String token();
}
