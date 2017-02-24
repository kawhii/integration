package com.carl.breakfast.web.task;

import com.carl.breakfast.dao.admin.goods.GoodsFortifiedDao;
import com.carl.breakfast.dao.order.IGoodsCommentDao;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Carl
 * @date 2017/2/24
 * @since JDK1.7
 * <p>
 * 版权所有.(c)2008-2017.广州市森锐科技股份有限公司
 */
@Component
public class UpdateDBTask {
    protected final Log logger = LogFactory.getLog(UpdateDBTask.class);
    @Autowired
    private IGoodsCommentDao commentDao;

    @Autowired
    private GoodsFortifiedDao goodsFortifiedDao;

    @Scheduled(cron = "0 0 */3 * * ?")
    public void commentGradeCount() {
        logger.debug("开始计算及更新评分分数。");
        commentDao.updateCommentGrade(null);
    }

    @Scheduled(cron = "0 30 */3 * * ?")
    public void updateSales() {
        logger.debug("开始计算销售量及更新数据库");
        goodsFortifiedDao.updateSales();
    }
}
