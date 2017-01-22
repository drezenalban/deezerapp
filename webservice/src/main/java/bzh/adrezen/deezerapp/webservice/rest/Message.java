package bzh.adrezen.deezerapp.webservice.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Just a simple rest path to get more info
 * @author drezenalban
 */
@Path("message")
public class Message{

    @GET
    @Path("/helloworld")
    public Response helloWorld(){

        String msg = "";

        try
        {
            msg = "Hello World !";
        }
        catch (Throwable t)
        {
            Response.status(502).build();
        }

        return Response.status(200).entity(msg).build();
    }


}