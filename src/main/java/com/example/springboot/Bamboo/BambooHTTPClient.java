package com.example.springboot.Bamboo;

import java.io.*;
import javax.net.ssl.*;
import java.net.URL;
import java.util.*;
import java.security.NoSuchAlgorithmException;
import java.security.KeyManagementException;
//import sun.misc.BASE64Encoder;
import org.springframework.web.client.RestTemplate;

public class BambooHTTPClient {
    private String basicAuthUsername="";
    private String basicAuthPassword;
    private TrustManager[] trustManager;
    private	SSLContext sslContext = null;

    public static String slurp (InputStream in) throws IOException {
        StringBuffer out = new StringBuffer();
        byte[] b = new byte[4096];
        for (int n; (n = in.read(b)) != -1;) {
            out.append(new String(b, 0, n));
        }
        return out.toString();
    }

    public BambooHTTPClient() {
        trustManager = new TrustManager[] {new TrustEverythingTrustManager()};

        // Let us create the factory where we can set some parameters for the connection
        try {
            sslContext = SSLContext.getInstance("SSL");
            sslContext.init(null, trustManager, new java.security.SecureRandom());
        } catch (NoSuchAlgorithmException e) {
            // do nothing
        }catch (KeyManagementException e) {
            // do nothing
        }

    }



    public void setBasicAuth(String username, String password) {
        basicAuthUsername=username;
        basicAuthPassword=password;
    }

    public BambooHTTPResponse  sendRequest(BambooHTTPRequest req) throws ClassNotFoundException {
        BambooHTTPResponse ret=new BambooHTTPResponse();
        HttpsURLConnection.setDefaultSSLSocketFactory(sslContext.getSocketFactory());
        try {
            URL url=new URL(req.url);
            HttpsURLConnection connection = (HttpsURLConnection)url.openConnection();
            connection.setHostnameVerifier(new VerifyEverythingHostnameVerifier());


            Set<String> headerKeys=req.headers.keySet();
            for(String key: headerKeys) {
                connection.setRequestProperty(key, req.headers.get( key ) );
            }

            if(!basicAuthUsername.equals("")) {
//                BASE64Encoder enc = new sun.misc.BASE64Encoder();

                String userpassword = basicAuthUsername+":"+basicAuthPassword;
                String encodedAuthorization = Base64.getEncoder().encodeToString(userpassword.getBytes());
                connection.setRequestProperty("Authorization", "Basic "+ encodedAuthorization);
            }


            if(req.content.length()>0) {
                connection.setDoOutput(true);
                OutputStream out=connection.getOutputStream();
                out.write( req.content.getBytes("utf-8") );
            }

            connection.connect();
            ret.statusCode=connection.getResponseCode();
            Map<String, List<String>> fields=connection.getHeaderFields();
            for (String header : fields.keySet()) {
                ret.headers.put(header, connection.getHeaderField(header));
            }
            ret.content=null;
            try {
                ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
//                List<BambooHrEmployee> output=(List<BambooHrEmployee>)in.readObject()
                ret.content = (BambooHrEmployeeRes) in.readObject();
            }
            catch(java.io.IOException e) {
                System.out.println (e.toString());
            }
        }
        catch(java.net.MalformedURLException e) {
            ret.statusCode=0;
            ret.content=null;
        }
        catch(java.io.IOException e) {
            ret.statusCode=0;
            ret.content=null;
        }
        return ret;
    }


}

class TrustEverythingTrustManager implements X509TrustManager {
    public java.security.cert.X509Certificate[] getAcceptedIssuers() {
        return null;
    }

    public void checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {   }
    public void checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {   }
}

class VerifyEverythingHostnameVerifier implements HostnameVerifier {
    public boolean verify(String string, SSLSession sslSession) {
        return true;
    }
}