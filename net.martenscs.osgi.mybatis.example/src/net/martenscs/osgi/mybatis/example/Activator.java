package net.martenscs.osgi.mybatis.example;

import net.martenscs.osgi.example.domain.Category;
import net.martenscs.osgi.mybatis.example.util.CatgegoryManager;
import net.martenscs.osgi.mybatis.example.util.SampleDatabaseInit;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	private static BundleContext context;

	public static BundleContext getContext() {
		return context;
	}

	private SampleDatabaseInit init;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#start(org.osgi.framework.BundleContext
	 * )
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		init = new SampleDatabaseInit();
		init.setDatasource(CatgegoryManager.getDataSource());
		init.create();
		Category category = CatgegoryManager.selectCategoryById(1);
		System.out.println(category.getCategoryName());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.osgi.framework.BundleActivator#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		init.destroy();
	}

}
