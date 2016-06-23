package com.lecloud.ipregion.common.util;

import java.util.concurrent.locks.ReentrantLock;

import org.apache.commons.configuration.ConfigurationUtils;
import org.apache.commons.configuration.FileConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;

/**
 * commons项目，读取配置文件
 */
public class PropertiesUtil {
    // 并发访问锁
	private static final ReentrantLock lock = new ReentrantLock();
	private static FileConfiguration instance = null;

	private PropertiesUtil(){}

	private static void init(String fileName){

		lock.lock();
		try {
			if (instance == null) {
				instance = new PropertiesConfiguration();
				instance.setEncoding("utf-8");
				instance.setURL(PropertiesUtil.class.getResource(fileName));
				instance.setReloadingStrategy(new FileChangedReloadingStrategy());//使用文件内容发送变化重新加载策略

				try {
					instance.load();
					ConfigurationUtils.dump(instance, System.out);
				} catch (Exception e) {
					e.printStackTrace(System.out);
				}
			}
		} finally {
			lock.unlock();
		}
	}


	/**
	 * 取得配置文件实例
	 * @return 配置文件实例
	 */
	public static FileConfiguration getInstance(String fileName) {
	    if (instance == null) {
            init(fileName);
        }
        return instance;
    }
}



//使用
FileConfiguration properties = PropertiesUtil.getInstance("/config.properties");
String param = properties.getString("参数名称");

