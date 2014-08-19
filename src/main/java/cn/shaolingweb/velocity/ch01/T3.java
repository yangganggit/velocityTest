package cn.shaolingweb.velocity.ch01;

import java.io.StringWriter;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import cn.shaolingweb.velocity.U;

public class T3 {

	public static void main(String[] args) {
		 Velocity.init();
		 
		 
		 //创建VelocityContext链
		 VelocityContext context1=new VelocityContext();
		 //设置who变量的值
		 context1.put("firstName", "shao");
		 
		 VelocityContext context2=new VelocityContext(context1);
		 //设置who变量的值
		 context2.put("lastName", "ling");
		 
		 
		 StringWriter writer=new StringWriter();
		 
		 Template tpl=Velocity.getTemplate(U.TPL_PRIFIX+ "t1/t3.vm");
		 
		 tpl.merge(context2, writer);
		 System.out.println(writer.toString());

	}

}
