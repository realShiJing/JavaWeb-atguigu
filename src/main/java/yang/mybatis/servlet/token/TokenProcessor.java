package yang.mybatis.servlet.token;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * Created by yangshijing on 2017/11/23 0023.
 */
public class TokenProcessor {
    //表单隐藏域的name属性值
    private static final String TOKEN_KEY = "TOKEN_KEY";
    //Session域中的属性值
    private static final String TRANSACTION_TOKEN_KEY = "TRANSACTION_TOKEN_KEY";

    private static TokenProcessor instance = new TokenProcessor();

    private long previous;

    protected TokenProcessor() {
        super();
    }
    //单例模式
    public static TokenProcessor getInstance() {
        return instance;
    }
    //判断表单提交请求是否重复
    public synchronized boolean isTokenValid(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session == null) {
            return false;
        }
        //从Session域中获取标识值
        String saved = (String) session.getAttribute(TRANSACTION_TOKEN_KEY);

        if (saved == null) {
            return false;
        }

        String token = request.getParameter(TOKEN_KEY);

        if (token == null) {
            return false;
        }

        return saved.equals(token);
    }
    //移除Session域中的token
    public synchronized void resetToken(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session == null) {
            return;
        }

        session.removeAttribute(TRANSACTION_TOKEN_KEY);
    }
    //将token保存到Session域中并返回token
    public synchronized String saveToken(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String token = generateToken(request);

        if (token != null) {
            session.setAttribute(TRANSACTION_TOKEN_KEY, token);
        }

        return token;
    }

    public synchronized String generateToken(HttpServletRequest request) {
        HttpSession session = request.getSession();

        return generateToken(session.getId());
    }

    public synchronized String generateToken(String id) {
        try {
            long current = System.currentTimeMillis();

            if (current == previous) {
                current++;
            }

            previous = current;

            byte[] now = new Long(current).toString().getBytes();
            MessageDigest md = MessageDigest.getInstance("MD5");

            md.update(id.getBytes());
            md.update(now);

            return toHex(md.digest());
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    private String toHex(byte[] buffer) {
        StringBuffer sb = new StringBuffer(buffer.length * 2);

        for (int i = 0; i < buffer.length; i++) {
            sb.append(Character.forDigit((buffer[i] & 0xf0) >> 4, 16));
            sb.append(Character.forDigit(buffer[i] & 0x0f, 16));
        }

        return sb.toString();
    }
}
