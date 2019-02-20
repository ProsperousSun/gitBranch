import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.Map;

public class post {
        public static void main(String[] args) {
            trailRespAll("http://www.518shop.com//product/lista.do");
        }

    public static void trailRespAll(String url) {
        HttpPost httpPost = null;
        long start = System.currentTimeMillis();
        try {
            httpPost = new HttpPost(url);
            httpPost.setHeader("Accept", "application/json");
            CloseableHttpResponse response = HttpClients.createDefault().execute(httpPost);
            int code = response.getStatusLine().getStatusCode();
            HttpEntity responseEntity = response.getEntity();
            if (code == 200) {
                String result = EntityUtils.toString(responseEntity, Consts.UTF_8);
                System.out.println(result);
                System.out.println("-----------------------");
                System.out.println("-----------------------");
                System.out.println("-----------------------");
                System.out.println("-----------------------");
                JSONObject jsonObject = JSON.parseObject(result);
                 Map<String, String> respMap =  JSON.parseObject(result,Map.class);
                System.out.println(jsonObject);
                System.out.println("*******************");
                System.out.println(jsonObject.get("data"));
                System.out.println("-----------");



                System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&");

            }
            // 非200响应也关闭响应流
            EntityUtils.consume(responseEntity);
        } catch (Exception e) {
            // 异常时取消请求
            if (httpPost != null) {
                try {
                    httpPost.abort();
                } catch (Exception ex) {
                    // close quietly
                }

            }
        } finally {
            long cost = System.currentTimeMillis() - start;
            if (null != httpPost) {
                httpPost.releaseConnection();
            }
        }
    }
}
