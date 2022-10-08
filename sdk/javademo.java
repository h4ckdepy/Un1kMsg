import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class un1kmsg {
    public static void main(String[] args) {
        String sendkey = "";
        String content = "测试javademo";
        String title = "测试javademo";
        Map<String, String> reqMap = new HashMap<>();
        reqMap.put("sendkey", sendkey);
        reqMap.put("content", content);
        reqMap.put("title", title);
        String api = "http://un1kmsg.happysec.cn/index/processmsg/";
        System.out.println(sendPost(api,reqMap,3));
    }

    public static String sendPost(String url, Map<String, String> params, int timeOut){
        String result = "";
        HttpURLConnection httpURLConnection = null;
        InputStream inputStream = null;
        OutputStream outputStream = null;
        BufferedReader reader = null;
        StringBuffer buffer = new StringBuffer();
        try {
            System.setProperty("sun.net.http.allowRestrictedHeaders", "true");
            URL u = new URL(url);
            httpURLConnection = (HttpURLConnection) u.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(timeOut);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.connect();

            outputStream = httpURLConnection.getOutputStream();

            StringBuffer buffer2 = new StringBuffer();
            Set<String> keys = params.keySet();
            for(String key : keys){
                buffer2.append(key);
                buffer2.append("=");
                buffer2.append(URLEncoder.encode(params.get(key),"utf-8"));
                buffer2.append("&");
            }

            String temp = buffer2.toString();
            String body = temp.substring(0, temp.length() - 1);

            outputStream.write(body.getBytes("utf-8"));
            outputStream.flush();
            outputStream.close();
            inputStream = httpURLConnection.getInputStream();
            reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
            String line = null;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }
            result = buffer.toString();
        } catch (Exception e) {

            return "";
        }
        finally {
            if(inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(httpURLConnection != null){
                httpURLConnection.disconnect();
            }
        }
        return result;
    }

}
