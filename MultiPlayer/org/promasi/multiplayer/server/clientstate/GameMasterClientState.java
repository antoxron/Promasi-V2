/**
 *
 */
package org.promasi.multiplayer.server.clientstate;

import java.net.ProtocolException;

import org.apache.commons.lang.NullArgumentException;
import org.promasi.multiplayer.AbstractClientState;
import org.promasi.multiplayer.ProMaSiClient;
import org.promasi.multiplayer.game.Game;
import org.promasi.multiplayer.server.ProMaSi;
import org.promasi.network.protocol.request.RequestBuilder;
import org.promasi.network.protocol.request.StartGameRequest;
import org.promasi.network.protocol.response.InternalErrorResponse;
import org.promasi.network.protocol.response.StartGameResponse;
import org.promasi.network.protocol.response.WrongProtocolResponse;

/**
 * @author m1cRo
 *
 */
public class GameMasterClientState extends AbstractClientState {

	/**
	 *
	 */
	private ProMaSi _promasi;

	/**
	 *
	 */
	private Game _game;

	/**
	 *
	 * @param promasi
	 * @param game
	 * @throws NullArgumentException
	 */
	public GameMasterClientState(ProMaSi promasi,Game game)throws NullArgumentException
	{
		if(promasi==null)
		{
			throw new NullArgumentException("Wrong argument promasi==null");
		}

		if(game==null)
		{
			throw new NullArgumentException("Wrong argument game==null");
		}
		_promasi=promasi;
		_game=game;
	}

	/* (non-Javadoc)
	 * @see org.promasi.server.client.state.IClientState#onReceive(org.promasi.server.core.ProMaSiClient, java.lang.String)
	 */
	@Override
	public void onReceive(ProMaSiClient client, String recData)throws NullArgumentException {
		if(client==null)
		{
			throw new NullArgumentException("Wrong argument client==null");
		}

		if(recData==null)
		{
			throw new NullArgumentException("Wrong argument client==null");
		}
		try
		{
			Object object=RequestBuilder.buildRequest(recData);
			if(object instanceof StartGameRequest)
			{
				changeClientState(client,new PlayingGameClientState(_promasi,_game.getGameId()));
				_game.startGame("Game started");
				client.sendMessage(new StartGameResponse(_game.getGameId()).toXML());
			}
			else
			{
				client.sendMessage(new WrongProtocolResponse().toXML());
				client.disonnect();
			}
		}
		catch(ProtocolException e)
		{
			client.sendMessage(new WrongProtocolResponse().toXML());
			client.disonnect();
		}
		catch(NullArgumentException e)
		{
			client.sendMessage(new InternalErrorResponse().toXML());
			client.disonnect();
		}
		catch(IllegalArgumentException e)
		{
			client.sendMessage(new InternalErrorResponse().toXML());
			client.disonnect();
		}
	}

}