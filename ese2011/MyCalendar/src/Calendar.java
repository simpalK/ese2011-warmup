/*Could not find all the Google Data dependencies required for this template from the directory provided.

You may not be able to execute this template (or your future application) without adding the required dependencies.*/

/* INSTRUCTION: This is a command line application. So please execute this template with the following arguments:

		arg[0] = username
		arg[1] = password
*/

/**
 * @author (Your Name Here)
 *
 */
 
import com.google.gdata.client.calendar.CalendarService;
import com.google.gdata.data.calendar.CalendarEntry;
import com.google.gdata.data.calendar.CalendarFeed;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * This is a test template
 */

  public class Calendar {
    
    public static void main(String[] args) {
      
      try {
        
        // Create a new Calendar service
        CalendarService myService = new CalendarService("My Application");
        myService.setUserCredentials(args[0],args[1]);
        
        // Get a list of all entries
        URL metafeedUrl = new URL("http://www.google.com/calendar/feeds/default/allcalendars/full");
        System.out.println("Getting Calendar entries...\n");
        CalendarFeed resultFeed = myService.getFeed(metafeedUrl, CalendarFeed.class);
        List<CalendarEntry> entries = resultFeed.getEntries();
        for(int i=0; i<entries.size(); i++) {
          CalendarEntry entry = entries.get(i);
          System.out.println("\t" + entry.getTitle().getPlainText());
        }
        System.out.println("\nTotal Entries: "+entries.size());
      }
      catch(AuthenticationException e) {
        e.printStackTrace();
      }
      catch(MalformedURLException e) {
        e.printStackTrace();
      }
      catch(ServiceException e) {
        e.printStackTrace();
      }
      catch(IOException e) {
        e.printStackTrace();
      }
    }
  }
