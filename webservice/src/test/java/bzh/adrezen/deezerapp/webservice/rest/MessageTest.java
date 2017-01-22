package bzh.adrezen.deezerapp.webservice.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import bzh.adrezen.deezerapp.webservice.Main;
import org.glassfish.grizzly.http.server.HttpServer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Simple Test Class
 *  @author drezenalban
 */
public class MessageTest {

    private HttpServer server;
    private WebTarget target;

    @Before
    public void setUp() throws Exception {
        // start the server
        server = Main.startServer();
        // create the client
        Client c = ClientBuilder.newClient();

        target = c.target(Main.BASE_URI);
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    /**
     * Test to see that the message "Hello World !" is sent in the response.
     */
    @Test
    public void testGetIt() {
        String responseMsg = target.path("message/helloworld").request().get(String.class);
        assertEquals("Hello World !", responseMsg);
    }
}