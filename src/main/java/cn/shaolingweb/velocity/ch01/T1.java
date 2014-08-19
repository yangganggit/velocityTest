package cn.shaolingweb.velocity.ch01;

import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import cn.shaolingweb.velocity.Data;
import cn.shaolingweb.velocity.U;

/**
 * Velocity:模板+变量
 * @author shaoling
 *
 */
public class T1 {

	public static void main(String[] args) {
		//initializes the Velocity runtime with the default set of parameters.
		//可传参数
		Properties props = new Properties();
		props.put("input.encoding", "utf-8");
		 Velocity.init(props);
		
		 
		 Data data=new Data();
		 data.setName("shaoling...");
		
		 //get the template
		 String tpl=U.TPL_PRIFIX+"t1/t1.vm";
		 Template tplObj=Velocity.getTemplate(tpl);
		 
		// create a context for Velocity,pass data from Java to velocity runtime when rendering
		 VelocityContext ctx=new VelocityContext();
		 ctx.put("d", data);
		 ctx.put("name", "shaoling");
		 //==========test s========
		 
		 //==========test e========
		 
		 StringWriter writer=new StringWriter();
		 
		 tplObj.merge(ctx, writer);
		 System.out.println(writer.toString());
	}

}

