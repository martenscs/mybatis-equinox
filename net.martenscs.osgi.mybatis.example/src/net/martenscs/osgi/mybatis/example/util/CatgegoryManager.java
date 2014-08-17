package net.martenscs.osgi.mybatis.example.util;

import javax.sql.DataSource;

import net.martenscs.osgi.example.domain.Category;
import net.martenscs.osgi.mybatis.example.mapper.CategoryMapper;

import org.apache.ibatis.session.SqlSession;

public class CatgegoryManager {
	public static Category selectCategoryById(int id) {

		SqlSession sqlSession = ConnectionFactory.getSqlSessionFactory()
				.openSession();
		try {
			CategoryMapper categoryMapper = sqlSession
					.getMapper(CategoryMapper.class);
			return categoryMapper.selectCategoryById(id);
		} finally {
			sqlSession.close();
		}
	}

	public static DataSource getDataSource() {
		return ConnectionFactory.getSqlSessionFactory().getConfiguration()
				.getEnvironment().getDataSource();
	}

}
