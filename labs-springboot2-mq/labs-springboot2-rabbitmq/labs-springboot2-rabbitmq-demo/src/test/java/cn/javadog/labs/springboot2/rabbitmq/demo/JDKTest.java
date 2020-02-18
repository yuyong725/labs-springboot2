package cn.javadog.labs.springboot2.rabbitmq.demo;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
 * @author 余勇
 * @date 2020年01月21日 00:08:00
 */
public class JDKTest {

	public static void main(String[] args) {

		Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
		for (Entry<Thread, StackTraceElement[]> entry : allStackTraces.entrySet()) {
			System.out.println(String.format("线程名：%s", entry.getKey().getName()));
			for (StackTraceElement element : entry.getValue()) {
				System.out.println(String.format("		element: %s", element.getClassName()));
			}

		}

		Scanner scanner = new Scanner(System.in);
		System.gc();
		String next = scanner.next();
		System.out.println(next);
	}



}
