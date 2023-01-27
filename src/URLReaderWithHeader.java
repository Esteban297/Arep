import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class URLReaderWithHeader {
    public static void main(String[] args) throws Exception {
        URL siteURL = new URL("http://www.google.com/");
        URLConnection urlConnection = siteURL.openConnection();
        Map<String, List<String>> headers = urlConnection.getHeaderFields();
        Set<Map.Entry<String, List<String>>> entrySet = headers.entrySet();
        for (Map.Entry<String, List<String>> entry : entrySet) {
            String headerName = entry.getKey();
            if (headerName != null) {
                System.out.print(headerName + ":");
            }
            List<String> headerValues = entry.getValue();
            for (String value : headerValues) {
                System.out.print(value);
            }
            System.out.println("");
        }
        System.out.println("-------message-body------");
        try (BufferedReader reader
                     = new BufferedReader(new InputStreamReader(siteURL.openStream()))) {
            String inputLine = null;
            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
            }
        } catch (IOException x) {
            System.err.println(x);

        }
    }
}





