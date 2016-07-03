package bean;

import java.io.Serializable;

public class User implements Serializable
{
	private static final long serialVersionUID = 1L;
	private int id;
	public User(int id)
	{
		this.id=id;
	}
	@Override
	public String toString()
	{
		
		return String.valueOf(id);
	}

}
