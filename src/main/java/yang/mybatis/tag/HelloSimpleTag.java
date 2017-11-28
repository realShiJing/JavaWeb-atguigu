package yang.mybatis.tag;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by yangshijing on 2017/11/24 0024.
 */
public class HelloSimpleTag extends SimpleTagSupport {
    private  String value;
    private  String count;

    public void setCount(String count) {
        this.count = count;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public void doTag() throws JspException, IOException {
        PageContext pageContext = (PageContext) getJspContext();
        JspWriter out = pageContext.getOut();
        /*out.print("value:" + value + "count:" + count);*/
        JspFragment jspFragment = getJspBody();
        StringWriter sw = new StringWriter();
        jspFragment.invoke(sw);
        out.print(sw.toString());

    }
}
