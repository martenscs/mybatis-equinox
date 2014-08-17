package net.martenscs.osgi.mybatis.example.util;

import java.io.IOException;
import java.io.Reader;

import net.martenscs.osgi.mybatis.example.Activator;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class ConnectionFactory {
	private static SqlSessionFactory factory;

	static {

	}

	public static SqlSessionFactory getSqlSessionFactory() {
		Reader reader = null;
		if (factory == null) {
			try {
				reader = Resources
						.getResourceAsReader(Activator.class.getClassLoader(),
								"database-config.xml");
			} catch (IOException e) {
				throw new RuntimeException(e.getMessage());
			}
			try {
				factory = new SqlSessionFactoryBuilder().build(reader);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return factory;
	}
}