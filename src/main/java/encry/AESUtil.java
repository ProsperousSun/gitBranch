package encry;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AESUtil {
    private static final Logger logger = LoggerFactory.getLogger(AESUtil.class);
    private static final String defaultCharset = "UTF-8";
    private static final String KEY_AES = "AES";
    private static final String KEY_MD5 = "MD5";
    private static MessageDigest md5Digest;

    static {
        try {
            md5Digest = MessageDigest.getInstance(KEY_MD5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

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
            if (StringUtils.isEmpty(data) || StringUtils.isEmpty(key)) {
                return null;
            }
            boolean encrypt = mode == Cipher.ENCRYPT_MODE;
            byte[] content;
            if (encrypt) {
                content = data.getBytes(defaultCharset);
            } else {
                content = Base64.decodeBase64(data);
            }
            SecretKeySpec keySpec = new SecretKeySpec(md5Digest.digest(key.getBytes(defaultCharset)), KEY_AES);
            Cipher cipher = Cipher.getInstance(KEY_AES);
            cipher.init(mode, keySpec);
            byte[] result = cipher.doFinal(content);
            if (encrypt) {
            	result = Base64.encodeBase64(result);
            }
            return new String(result, defaultCharset);
        } catch (Exception e) {
            logger.error("AES密文处理异常", e);
        }
        return null;
    }
    
    /**
     * 
     * @Title: main   
     * @Description: 测试
     */
    public static void main(String[] args) {
		String data="{\"key\":\"value\"}";
		String key="123456";
		
		System.out.println("data ="+data);
		//加密
		String result= AESUtil.encrypt(data, key);
		System.out.println("result ="+result);
		//解密
//		String dataResult=AESUtil.decrypt(result, key);
//		System.out.println("dataResult ="+dataResult);
		
	}
}
