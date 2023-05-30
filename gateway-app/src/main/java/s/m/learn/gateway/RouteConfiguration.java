package s.m.learn.gateway;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class RouteConfiguration extends RouteBuilder {

    @Override
    public void configure() {
        from("platform-http:/rest-app/{pathParam}*")
                .bean(RouteConfiguration.class, "removeFirstPathSegment")
                .toD("http://localhost:8001?bridgeEndpoint=true");
    }

    public void removeFirstPathSegment(Exchange exchange) {
        String path = exchange.getIn().getHeader(Exchange.HTTP_PATH, String.class);
        String newPath = path.substring(path.indexOf("/", 1));
        System.out.println("-->>> "+newPath);
        exchange.getIn().setHeader(Exchange.HTTP_PATH, newPath);
    }


}
