package controllers;

import play.mvc.*;

import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ListingController extends Controller {

    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    public Result retrieveActiveListings() {
        return ok(index.render("Your new application is ready."));
    }
    
    public Result upsertListing() {
		return null;
    	
    }
    
    public Result removeListing() {
        return ok(index.render("Your new application is ready."));
    }
    
    public Result retrieveListing() {
        return ok(index.render("Your new application is ready."));
    }
    public static Result r() {
    	return ok("Success!");
    }

}
