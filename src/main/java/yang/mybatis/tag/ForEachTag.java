package yang.mybatis.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by yangshijing on 2017/11/24 0024.
 */
public class ForEachTag extends SimpleTagSupport {
    private Collection<?> items;
    private String var;


    public void setItems(Collection<?> items) {
        this.items = items;
    }

    public void setVar(String var) {
        this.var = var;
    }

    @Override
    public void doTag() throws JspException, IOException {
        //遍历集合
        if(items != null) {
            for (Object item : items) {
                //把遍历中的对象放入PageContext域中;键：var 值：正在遍历的对象
                getJspContext().setAttribute(var, item);
                //不对标签体处理，直接输出到页面
                getJspBody().invoke(null);
            }
        }
    }
}
