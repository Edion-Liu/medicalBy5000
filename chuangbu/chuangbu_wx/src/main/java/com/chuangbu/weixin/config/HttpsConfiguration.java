package com.chuangbu.weixin.config;

import java.io.File;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.Ssl;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Title: WebConfiguration.java
 * @Description: TODO(用一句话描述该文件做什么)
 * @author 361cjx@163.com
 * @date 2017年2月4日 下午8:47:44
 * @version V1.0
 */
//@Configuration
@PropertySource("classpath:/config/tomcat.https.properties")
@EnableConfigurationProperties(HttpsConfiguration.TomcatSslConnectorProperties.class)
public class HttpsConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	private TomcatSslConnectorProperties propertioes ;
	
	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
	    return new EmbeddedServletContainerCustomizer() {
	        @Override
	        public void customize(ConfigurableEmbeddedServletContainer container) {
				propertioes.configurableEmbeddedServletContainer(container);
	        }
	    };
	}
	
	@Bean
	public EmbeddedServletContainerFactory servletContainerFactory() {
	    TomcatEmbeddedServletContainerFactory factory =
	        new TomcatEmbeddedServletContainerFactory() {
	            @Override
	            protected void postProcessContext(Context context) {
	                //SecurityConstraint必须存在，可以通过其为不同的URL设置不同的重定向策略。
	                SecurityConstraint securityConstraint = new SecurityConstraint();
	                securityConstraint.setUserConstraint("CONFIDENTIAL");
	                SecurityCollection collection = new SecurityCollection();
	                collection.addPattern("/*");
	                securityConstraint.addCollection(collection);
	                context.addConstraint(securityConstraint);
	            }
	        };
	    factory.addAdditionalTomcatConnectors(propertioes.createHttpConnector());
	    return factory;
	}
	
	@ConfigurationProperties(prefix = "custom.tomcat.https")
	public static class TomcatSslConnectorProperties {
		private Integer port=8080;
		private Integer sport=8443;
		private Boolean secure = true;
		private String scheme = "http";
		private File keystore;
		private String keystorePassword;
		
		public Integer getPort() {
			return port;
		}

		public void setPort(Integer port) {
			this.port = port;
		}

		public Integer getSport() {
			return sport;
		}

		public void setSport(Integer sport) {
			this.sport = sport;
		}

		public Boolean getSecure() {
			return secure;
		}

		public void setSecure(Boolean secure) {
			this.secure = secure;
		}

		public String getScheme() {
			return scheme;
		}

		public void setScheme(String scheme) {
			this.scheme = scheme;
		}

		public File getKeystore() {
			return keystore;
		}

		public void setKeystore(File keystore) {
			this.keystore = keystore;
		}

		public String getKeystorePassword() {
			return keystorePassword;
		}

		public void setKeystorePassword(String keystorePassword) {
			this.keystorePassword = keystorePassword;
		}

		public  Connector createHttpConnector() {
			Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
			connector.setScheme(scheme);
			connector.setSecure(secure);
			connector.setPort(port);
			connector.setRedirectPort(sport);
		    return connector;
		}
		
		public void configurableEmbeddedServletContainer(ConfigurableEmbeddedServletContainer container) {
			
			Ssl ssl = new Ssl();
            //Server.jks中包含服务器私钥和证书
			ssl.setKeyStore(keystore.getAbsolutePath());
			ssl.setKeyStorePassword(keystorePassword);
			container.setSsl(ssl);
			container.setPort(sport);
		}
	}
}
