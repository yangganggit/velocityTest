package cn.shaolingweb.velocity.ch02_settingRuntime;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import cn.shaolingweb.velocity.U;

/**
 * two ways to set the Velocity configuration parameters 
 * when first initializing the Velocity runtime.
 * ===================
 * 常见属性：
 * input.encoding=ISO-8859-1
 * output.encoding=ISO-8859-1
 * parser.pool.size=20
 * runtime.interpolate.literals
 * 
 */
public class T1 {

	public static void main(String[] args) {
		// set some properties
		Properties props = new Properties();
		props.put("input.encoding", "utf-8");
		// initialize Velocity,硬编码，不推荐
		//Velocity.init(props);
		
//		Velocity.init(U.TPL_PRIFIX+"t2/velocity.properties");
		Velocity.init(U.TPL_PRIFIX+ "t2/velocity.properties");
		
		// get the template
		Template template =
		Velocity.getTemplate(U.TPL_PRIFIX+ "t2/t1.vm");
		// create a context for Velocity
		VelocityContext context = new VelocityContext();
		// create the output
		Writer writer = new StringWriter();
		template.merge(context, writer);
		// write out
		System.out.println(writer.toString());
	}

}
