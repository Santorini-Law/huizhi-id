package com.zhihui.id.bizservice;

import com.zhihui.id.bizservice.api.IUserIdGeneration;
import com.zhihui.id.enums.Status;
import com.zhihui.id.model.Result;
import com.zhihui.id.service.api.IdGeneration;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.security.MessageDigest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * user id 生成
 *
 * @author LDZ
 * @date 2020-03-10 21:15
 */
@Slf4j
@Service
public class UserIdGenerationImpl implements IUserIdGeneration {

    @Resource
    IdGeneration idGeneration;

    /**
     * 手机号正则
     */
    private final static Pattern MOBILE = java.util.regex.Pattern.compile("^(13[0-9]|14[5|7]|15[0|1|2|3|4|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\\d{8}$");

    @Override
    public Long generateUserId(String mobile) {
        Matcher matcher = MOBILE.matcher(mobile);
        if (!matcher.matches()) {
            log.error("电话号码 {} 格式错误！", mobile);
        }
        Result result = idGeneration.get("USER_ID");
        if (!result.getStatus().equals(Status.SUCCESS) || result.getId() <= 0L) {
            log.error("生成订单id服务异常 result = {}", result.toString());
            throw new RuntimeException("id生成服务异常");
        }
        char[] mobileChars = mobile.toCharArray();
        String prefix = mobileChars[2] + "" + mobileChars[3] + "" + mobileChars[4];
        String suffix = mobileChars[7] + "" + mobileChars[8] + "" + mobileChars[9];
        String cipher = encryption(mobileChars[0] + "" + mobileChars[1] + "" + mobileChars[5] + "" + mobileChars[6] + "" + mobileChars[10]);

        // user id规则：prefix + id + suffix
        Long userId = new Long(prefix + cipher.substring(0, 2) + result.getId() + cipher.substring(cipher.length() - 3) + suffix);
        log.info("生成 user id = {}", userId);
        return userId;
    }

    /**
     * 0 + 9 = 9  ---> 9
     * 1 + 9 = 10 ---> 0
     * 2 + 9 = 11 ---> 1
     * 输入一个五位数，将其加密后输出。
     * 方法是将该数每一位上的数字加9，然后除以10取余，做为该位上的新数字，
     * 最后将千位和十位上的数字互换，百位和个位上的数字互换，组成加密后的新四位数。
     *
     * @return 加密
     */
    private static String encryption(String leftMobile) {
        char[] leftMobileChars = leftMobile.toCharArray();
        for (int i = 0; i < leftMobileChars.length; i++) {
            int cc = ((leftMobileChars[i] - '0' + 9) % 10);
            leftMobileChars[i] = (char) (cc + '0');
        }
        swap(leftMobileChars, 0, 3);
        swap(leftMobileChars, 1, 4);
        return new String(leftMobileChars);
    }

    private static void swap(char[] array, int i, int j) {
        array[i] = (char) (array[i] ^ array[j]);
        array[j] = (char) (array[i] ^ array[j]);
        array[i] = (char) (array[i] ^ array[j]);
    }

    public static void main(String[] args) {
        System.out.println(629615002000507040L);
        System.out.println(Long.MAX_VALUE);
    }
}
