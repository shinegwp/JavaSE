package com.shine.objectoriented;
/**
* @author 高伟鹏 
* @email gaoweipeng3@gmail.com
* @version 创建时间：2018年8月9日 下午3:24:36
* @describe
*/
public class InnerClassTest {

	public class InnerClassB{//内部类
		
	}
    protected class InnerClassB1{
		
	}
    class InnerClassB2{
    	
    }
    private class InnerClassB3{
    	
    }
    
    
    static class InnerClassD {//与成员内部类相同，可以被所有访问修饰符访问，且不依赖于外部类，不能使用外部类中的非静态成员和方法
    	
    }
   
	public static void main(String[] args) {
		class InnewClassC{//局部内部类，和匿名内部类一样，只能访问局部final常量
			
		}
//		public class InnewClassC1{//局部内部类只能被abstract final修饰
//			
//		}
		
	    
		
		new Runnable(){//匿名内部类，唯一一个没有构造器的类；

			@Override
			public void run() {
				// TODO Auto-generated method stub
				
			}
			
		};
	}
}
class InnerClassA{
	
}
//public class InnerClassA1{//一个文件中只能有一个public的非内部类
//	
//}
//protected class InnerClassA2{//非内部类只能被public abstract final修饰
//	
//}
