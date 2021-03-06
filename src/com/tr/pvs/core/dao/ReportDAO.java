package com.tr.pvs.core.dao;
// default package

import java.util.List;

import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.tr.pvs.core.dbo.Report;

/**
 	* A data access object (DAO) providing persistence and search support for Report entities.
 			* Transaction control of the save(), update() and delete() operations 
		can directly support Spring container-managed transactions or they can be augmented	to handle user-managed Spring transactions. 
		Each of these methods provides additional information for how to configure it for the desired type of transaction control. 	
	 * @see .Report
  * @author MyEclipse Persistence Tools 
 */
public class ReportDAO extends HibernateDaoSupport  {
	     private static final Logger log = LoggerFactory.getLogger(ReportDAO.class);
		//property constants
	public static final String BBG_FILE = "bbgFile";
	public static final String EDM_STATUS = "edmStatus";
	public static final String BBG_STATUS = "bbgStatus";
	public static final String REPORT_STATUS = "reportStatus";
	public static final String INSERT_DATE = "insertDate";
	public static final String UPDATE_DATE = "updateDate";
	public static final String EDM_FILE = "edmFile";



	protected void initDao() {
		//do nothing
	}
    
    public void save(Report transientInstance) {
        log.debug("saving Report instance");
        try {
            getHibernateTemplate().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(Report persistentInstance) {
        log.debug("deleting Report instance");
        try {
            getHibernateTemplate().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Report findById( java.lang.Integer id) {
        log.debug("getting Report instance with id: " + id);
        try {
            Report instance = (Report) getHibernateTemplate()
                    .get("com.tr.pvs.core.dbo.Report", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(Report instance) {
        log.debug("finding Report instance by example");
        try {
            List results = getHibernateTemplate().findByExample(instance);
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding Report instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from Report as model where model." 
         						+ propertyName + "= ?";
		 return getHibernateTemplate().find(queryString, value);
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}

	public List findByBbgFile(Object bbgFile
	) {
		return findByProperty(BBG_FILE, bbgFile
		);
	}
	
	public List findByEdmStatus(Object edmStatus
	) {
		return findByProperty(EDM_STATUS, edmStatus
		);
	}
	
	public List findByBbgStatus(Object bbgStatus
	) {
		return findByProperty(BBG_STATUS, bbgStatus
		);
	}
	
	public List findByReportStatus(Object reportStatus
	) {
		return findByProperty(REPORT_STATUS, reportStatus
		);
	}
	
	public List findByInsertDate(Object insertDate
	) {
		return findByProperty(INSERT_DATE, insertDate
		);
	}
	
	public List findByUpdateDate(Object updateDate
	) {
		return findByProperty(UPDATE_DATE, updateDate
		);
	}
	
	public List findByEdmFile(Object edmFile
	) {
		return findByProperty(EDM_FILE, edmFile
		);
	}
	

	public List findAll() {
		log.debug("finding all Report instances");
		try {
			String queryString = "from Report";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
	public List findAllByInsertDateDesc() {
		log.debug("finding all Report instances");
		try {
			String queryString = "from Report as model order by model.insertDate desc";
		 	return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public Report merge(Report detachedInstance) {
        log.debug("merging Report instance");
        try {
            Report result = (Report) getHibernateTemplate()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(Report instance) {
        log.debug("attaching dirty Report instance");
        try {
            getHibernateTemplate().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Report instance) {
        log.debug("attaching clean Report instance");
        try {
            getHibernateTemplate().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }

	public static ReportDAO getFromApplicationContext(ApplicationContext ctx) {
    	return (ReportDAO) ctx.getBean("ReportDAO");
	}
}