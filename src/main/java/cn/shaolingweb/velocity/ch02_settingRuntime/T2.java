package cn.shaolingweb.velocity.ch02_settingRuntime;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import cn.shaolingweb.velocity.U;

/**
 * 日志
 *runtime.log.logsystem.class=org.apache.velocity.runtime.log.SimpleLog4JLogSystem
 */
public class T2 {
	public static void main(String[] args) {
		// set some properties
		Properties props = new Properties();
		props.put("runtime.log.logsystem.class", "org.apache.velocity.runtime.log.SimpleLog4JLogSystem");
		Velocity.init(props);
		
		// get the template
		Template template =
		Velocity.getTemplate(U.TPL_PRIFIX+ "t2/t2.vm");
		// create a context for Velocity
		VelocityContext context = new VelocityContext();
		// create the output
		Writer writer = new StringWriter();
		template.merge(context, writer);
		// write out
		System.out.println(writer.toString());
	}
}
