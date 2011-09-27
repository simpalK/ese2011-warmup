/*Could not find all the Google Data dependencies required for this template from the directory provided.

Could not find all the external dependencies. 
There are following possibilities:
1. Either a wrong directory for external dependencies was provided
2. Or there was an error downloading the files
3. Or some files are missing from the directory.

You may not be able to execute this template (or your future application) without adding the required dependencies.*/

/* INSTRUCTION: This is a command line application. So please execute this template with the following arguments:

		arg[0] = username
		arg[1] = password
*/

/**
 * @author (Your Name Here)
 *
 */
 
import com.google.gdata.client.docs.DocsService;
import com.google.gdata.data.docs.DocumentListEntry;
import com.google.gdata.data.docs.DocumentListFeed;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * This is a test template
 */

  public class Documents {
    
    public static void main(String[] args) {
      
      try {
        
        // Create a new Documents service
        DocsService myService = new DocsService("My Application");
        myService.setUserCredentials(args[0],args[1]);
        
        // Get a list of all entries
        URL metafeedUrl = new URL("http://docs.google.com/feeds/documents/private/full");
        System.out.println("Getting Documents entries...\n");
        DocumentListFeed resultFeed = myService.getFeed(metafeedUrl, DocumentListFeed.class);
        List<DocumentListEntry> entries = resultFeed.getEntries();
        for(int i=0; i<entries.size(); i++) {
          DocumentListEntry entry = entries.get(i);
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
