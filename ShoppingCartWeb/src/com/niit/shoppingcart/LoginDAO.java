package com.niit.shoppingcart;
//DAO->Data Access Object
    public class LoginDAO {
	public boolean isvaliduser(String id,String pwd)
	{
		if(id.equals("niit")&&pwd.equals("niit"))
		{
			
			return true;
		}
		else
		{
			return false;
		}
	}

}
