/**
 * 
 */
package com.ahstu.cels.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @description 此类的描述
 * @author 阚伟剑
 * @createDate 下午3:45:25
 * @version ver1.0
 * 
 */
public class InputUtil {
	
	private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	/**
	 * 根据用户的提示，获取一个整数
	 * @param msg 提示信息
	 * @return
	 */
	 public synchronized static int getInt(String msg) {
		int result = 0;
		try {
			// 输出提示信息
			System.out.println(msg);
			String line = br.readLine(); // 把用户的输入当成是字符串，整行读取
			if (line != null && line.trim().length() > 0) {
				result = Integer.parseInt(line);
			}else {
				System.out.println(" >> 输入的全是空白字符，请重输入");
				return getInt(msg);
			}
			
		}catch (IOException e) {
			System.out.println(e.getMessage());
			// 回调自己
			return getInt(msg);
		}catch (RuntimeException e) {
			System.out.println(" >> 读到的不是整数");
			//回调自己
			return getInt(msg);
		}
		//返回读到的整数
		return result;
	}
	 
	 /******
	  * 从键盘读取一个字符
	  * @param msg
	  * @return
	  */
	public synchronized static char getChar(String msg) {
		char result = ' ';
		try {
			//提示
			System.out.println(msg);
			//读取
			String line = br.readLine();
			//取出第一个字母
			result = line.charAt(0);
			//判断是否是字母
			if (!Character.isLetter(result)) {
				// 重新调用自己
				System.out.println("警告，输入的不是字母");
				return getChar(msg);
			}
		} catch (IOException e) {
			System.out.println("error, IO错误");
			return getChar(msg);
		}
		// 返回
		return result;
	}
}
