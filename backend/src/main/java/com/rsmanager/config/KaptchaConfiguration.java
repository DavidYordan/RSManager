import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.fessional.kaptcha.KaptchaConfig;
import pro.fessional.kaptcha.KaptchaProducer;

@Configuration
public class KaptchaConfiguration {

    @Bean
    public KaptchaProducer kaptchaProducer() {
        KaptchaConfig config = new KaptchaConfig();
        // 配置验证码属性，可以根据需求进行调整
        config.setBorder(false);
        config.setTextProducerFontSize(40);
        config.setImageWidth(200);
        config.setImageHeight(50);
        config.setTextProducerCharLength(5);
        config.setTextProducerFontNames("Arial,Courier");
        config.setNoiseImpl(new pro.fessional.kaptcha.impl.DefaultNoise());
        // 其他配置项...

        return new KaptchaProducer(config);
    }
}
