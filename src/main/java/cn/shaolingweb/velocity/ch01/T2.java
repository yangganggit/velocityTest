package cn.shaolingweb.velocity.ch01;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import cn.shaolingweb.velocity.U;

/**
 *  "static content" + "VTL"  + "dynamic data"
 */
public class T2 {

	public static void main(String[] args) {
	 Velocity.init();
	 
	 VelocityContext context=new VelocityContext();
	 //设置who变量的值
	 context.put("who", "shaoling");
	 StringWriter writer=new StringWriter();
	 
	 Template tpl=Velocity.getTemplate(U.TPL_PRIFIX+ "t1/t2.vm");
	 tpl.merge(context, writer);
	 System.out.println(writer.toString());
	}

}
