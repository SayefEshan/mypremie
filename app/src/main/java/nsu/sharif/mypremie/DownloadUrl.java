package nsu.sharif.mypremie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class DownloadUrl {

    public String readUrl(String myUrl) throws IOException
    {
        String data="";
        InputStream inputStream=null;
        HttpURLConnection urlConnection= null;

        try{
            URL url=new URL(myUrl);
            urlConnection=(HttpURLConnection)url.openConnection();
            urlConnection.connect();

            inputStream= urlConnection.getInputStream();
            BufferedReader br= new BufferedReader(new InputStreamReader(inputStream));
            StringBuffer sb= new StringBuffer();

            String line="";

            while((line = br.readLine())!=null)
            {
                sb.append(line);
            }

        }catch (MalformedURLException e){

            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            inputStream.close();
            urlConnection.disconnect();
        }

        return data;

    }
}
