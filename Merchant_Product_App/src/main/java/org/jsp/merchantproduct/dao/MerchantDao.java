package org.jsp.merchantproduct.dao;
import javax.persistence.*;
import org.jsp.merchantproduct.dto.Merchant;

public class MerchantDao 
{
	EntityManagerFactory fac=Persistence.createEntityManagerFactory("dev");
	EntityManager man=fac.createEntityManager();
	public Merchant saveMerchant(Merchant m) 
	{
		EntityTransaction tran=man.getTransaction();
		tran.begin();
		man.persist(m);
		tran.commit();
		return m;
	}

	public Merchant updateMerchant(Merchant m)
	{
		
		EntityTransaction tran=man.getTransaction();
		tran.begin();
		
		Merchant mdb=man.find(Merchant.class, m.getId());
		if(mdb!=null)
		{
			mdb.setName(m.getName());
			mdb.setPhone(m.getPhone());
			mdb.setGst_num(m.getGst_num());
			mdb.setEmail(m.getEmail());
			mdb.setPassword(m.getPassword());
			
			tran.commit();
			return mdb;
		}
		
		else
		{
			return null;
		}
	}

	public Merchant findMerchantById(int id) 
	{
	
		
	       return	man.find(Merchant.class, id);
		
	}

	public Merchant verifyMerchantByEmailAndPassword(String em, String pw) 
	{
		
		Query q=man.createQuery("select m from Merchant m where m.email=?1 and m.password=?2");
		q.setParameter(1, em);
		q.setParameter(2, pw);
		
		try {
			Merchant m=(Merchant) q.getSingleResult();
			return m;
		} catch (NoResultException e) 
		{
			return null;
		}
		
		
		
		
	}
	

}







