package encry;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yepei.ye on 2016/4/1.
 * Description:
 */
public class SecurityUtil {
    private static final String defaultCharset = "UTF-8";
    private static final Logger logger = LoggerFactory.getLogger(SecurityUtil.class);

    public static void main(String[] args) {

        String key = "naAFSNMRDVX/wM/im6eOOA==";// 人保的key
        String key2 = "CY40HubuiXHoD/hg7J90bA==";// 太平的key
        String dec = SecurityUtil.AES.encrypt(
                "{\"head\":{\"requestType\":10,\"transactionNo\":\"B9CB5FBB64B55A5640DAF279385215FC\",\"client\":\"qunar\",\"timeStamp\":\"2016-08-15 16:48:49\"},\"body\":{\"orderInfo\":{\"orderNo\":\"sdzj201608151648496921\",\"productType\":\"SPECIAL\",\"subType\":\"\",\"proNo\":\"207101023-AXZLN\",\"productName\":\"史带中老年重疾健康保障计划\",\"policyCount\":1,\"oriUnitPrice\":1898.0000,\"increaseScale\":0.0,\"unitPrice\":1898.0000,\"payPrice\":1898.0000,\"details\":[],\"orderExt\":{},\"beginTime\":\"2016-08-16 00:00:00\",\"endTime\":\"2017-08-15 23:59:59\"},\"applicant\":{\"name\":\"老人四\",\"cardType\":1,\"cardNo\":\"110101194808014372\",\"sex\":1,\"applicantExt\":{},\"birthday\":\"1948-08-01\"},\"insurants\":[{\"insurerKey\":\"sdzj201608151648496921#1\",\"name\":\"老人四\",\"cardType\":1,\"cardNo\":\"110101194808014372\",\"sex\":1,\"policyCount\":1,\"relation\":1,\"insurerExt\":{},\"birthday\":\"1948-08-01\"}],\"targets\":{}}}",
                "test");
        String enc = SecurityUtil.AES.decrypt(dec, "test");
        System.out.println(dec);
        System.out.println(enc);
    }
    public static class MD5 {
        /**
         * Returns a MessageDigest for the given <code>algorithm</code>.
         *
         * @param
         * @return An MD5 digest instance.
         * @throws RuntimeException when a {@link NoSuchAlgorithmException} is
         *                          caught
         */
        static MessageDigest getDigest() {
            try {
                return MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

        /**
         * Calculates the MD5 digest and returns the value as a 16 element
         * <code>byte[]</code>.
         *
         * @param data Data to digest
         * @return MD5 digest
         */
        public static byte[] md5(byte[] data) {
            return getDigest().digest(data);
        }
    }

    public static class AES {
        private static final String KEY_AES = "AES";

        /**
         * 加密
         *
         * @param data 需要加密的内容
         * @param key  加密密码
         * @return
         */
        public static String encrypt(String data, String key) {
            return doAES(data, key, Cipher.ENCRYPT_MODE);
        }

        /**
         * 解密
         *
         * @param data 待解密内容
         * @param key  解密密钥
         * @return
         */
        public static String decrypt(String data, String key) {
            return doAES(data, key, Cipher.DECRYPT_MODE);
        }

        /**
         * 加解密
         *
         * @param data
         * @param key
         * @param mode
         * @return
         */
        private static String doAES(String data, String key, int mode) {
            try {
                if (StringUtils.isBlank(data) || StringUtils.isBlank(key)) {
                    return null;
                }
                boolean encrypt = mode == Cipher.ENCRYPT_MODE;
                byte[] content;
                if (encrypt) {
                    content = data.getBytes(defaultCharset);
                } else {
                    content = Base64.decodeBase64(data);
                }
                SecretKeySpec keySpec = new SecretKeySpec(MD5.md5(key.getBytes(defaultCharset)), KEY_AES);
                Cipher cipher = Cipher.getInstance(KEY_AES);// 创建密码器
                cipher.init(mode, keySpec);// 初始化
                byte[] result = cipher.doFinal(content);
                if (encrypt) {
                    return Base64.encodeBase64String(result);
                } else {
                    return new String(result, defaultCharset);
                }
            } catch (Exception e) {
                logger.error("AES密文处理异常", e);
            }
            return null;
        }
    }
}
