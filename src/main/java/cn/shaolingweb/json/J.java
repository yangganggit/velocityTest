package cn.shaolingweb.json;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;


public class J {

	public static void main(String[] args) {
		 List<User> list=new ArrayList<User>();
		 User u1=new User();
		 u1.setName("shaoling");
		 u1.setAge(11);
		 u1.setCreate(new Date());
		 
		 User u2=new User();
		 u2.setName("shao2");
		 u2.setAge(22);
		 u2.setCreate(new Date());
		 
		 list.add(u1);
		 list.add(u2);
		 
		 String json=JSON.toJSONString(list);
		 System.out.println(json);
		 List<User> list2= JSON.parseArray(json, User.class);
		 
		 for (User user : list2) {
			 System.out.println(ToStringBuilder.reflectionToString(user));
		}

	}

}
class User{
	String name;
	int age;
	//使用fastjson格式化方式
	@JSONField(format="yyyy-MM-dd")
	Date create;
	
	public Date getCreate() {
		return create;
	}
	public void setCreate(Date create) {
		this.create = create;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}