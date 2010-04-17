/**
 *
 */
package org.promasi.server.core.game;

import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;

import javax.naming.ConfigurationException;

import org.apache.commons.lang.NullArgumentException;
import org.promasi.shell.Shell;

/**
 * @author m1cRo
 *
 */
public class GameModel
{
	private Shell _gameShell;

	public GameModel(String xmlModel)throws NullArgumentException,IllegalArgumentException
	{
		if(xmlModel==null)
		{
			throw new NullArgumentException("Wrong argument xmlModel==null");
		}

		if(xmlModel.isEmpty())
		{
			throw new IllegalArgumentException("Wrong argument xmlModel.isEmpty()");
		}
	}

	public String toXML()
	{
		ByteArrayOutputStream outputStream=new ByteArrayOutputStream();
		XMLEncoder xmlEncoder=new XMLEncoder(outputStream);
		xmlEncoder.writeObject(this);
		xmlEncoder.close();
		String temp=outputStream.toString();
		String result=new String("");
		for(int i=0;i<temp.length();i++)
		{
			char ch=temp.charAt(i);
			if(ch!='\n' && ch!='\r')
			{
				result=result+ch;
			}
		}
		return result;
	}

	public boolean start()
	{
		try {
			_gameShell.start();
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
