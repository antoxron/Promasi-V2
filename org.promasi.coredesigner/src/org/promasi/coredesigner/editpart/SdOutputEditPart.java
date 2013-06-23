package org.promasi.coredesigner.editpart;

import java.beans.PropertyChangeEvent;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.ChopboxAnchor;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.IFigure;

import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.NodeEditPart;
import org.eclipse.gef.Request;

import org.promasi.coredesigner.editpolicies.SdObjectDeletePolicy;
import org.promasi.coredesigner.editpolicies.EditorEditLayoutPolicy;
import org.promasi.coredesigner.editpolicies.SdConnectionPolicy;
import org.promasi.coredesigner.editpolicies.SdDirectEditPolicy;
import org.promasi.coredesigner.figure.SdOutputFigure;
import org.promasi.coredesigner.model.SdConnection;
import org.promasi.coredesigner.model.SdObject;
import org.promasi.coredesigner.model.SdOutput;
/**
 * Represents the controller between the SdOutput model and the SdOutputFigure
 * 
 * @author antoxron
 *
 */
public class SdOutputEditPart extends AbstractEditPart implements NodeEditPart {

	@Override
	protected IFigure createFigure( ) {
		IFigure figure = new SdOutputFigure(); 
		return figure;
	}
	@Override
	protected void createEditPolicies() {
		installEditPolicy( EditPolicy.LAYOUT_ROLE, new EditorEditLayoutPolicy() );
		installEditPolicy( EditPolicy.COMPONENT_ROLE, new SdObjectDeletePolicy() );
		installEditPolicy( EditPolicy.GRAPHICAL_NODE_ROLE, new SdConnectionPolicy() );
		installEditPolicy( EditPolicy.DIRECT_EDIT_ROLE, new SdDirectEditPolicy() );
	}
	@Override
	public List<SdConnection> getModelSourceConnections( ) {
		return ( ( SdObject ) getModel() ).getSourceConnectionArray();
	}
	@Override
	public List<SdConnection> getModelTargetConnections( )  {
		return ( ( SdObject ) getModel() ).getTargetConnectionArray();
	}
	@Override
	protected void refreshVisuals( ){ 
		SdOutputFigure figure = ( SdOutputFigure )getFigure(); 
		SdOutput model = ( SdOutput )getModel(); 
		figure.setName( model.getName() ); 
		figure.setLayout( model.getLayout() ); 
		this.getViewer().setProperty( SdObject.PROPERTY_RENAME, model.getName() );
	} 
	@Override 
	public void propertyChange( PropertyChangeEvent event ) { 
		if ( event.getPropertyName().equals( SdObject.PROPERTY_LAYOUT ) ) {
			refreshVisuals();
		}
		if ( event.getPropertyName().equals( SdObject.SOURCE_CONNECTION ) ) {
			refreshSourceConnections();
		}
		if ( event.getPropertyName().equals( SdObject.TARGET_CONNECTION ) )  {
			refreshTargetConnections();
		}
		if ( event.getPropertyName().equals( SdObject.PROPERTY_ADD ) ) {
			refreshChildren(); 
		}
		if ( event.getPropertyName().equals( SdObject.PROPERTY_REMOVE ) ) {
			this.getViewer().setProperty( SdObject.PROPERTY_REMOVE, "" );
			refreshChildren();
		}
		if ( event.getPropertyName().equals( SdObject.PROPERTY_RENAME ) ) {
			refreshVisuals();
		}
	}
	@Override
	public ConnectionAnchor getSourceConnectionAnchor( ConnectionEditPart connection ) {	
		return new ChopboxAnchor( getFigure() );
	}
	@Override
	public ConnectionAnchor getSourceConnectionAnchor( Request request )  {
		return new ChopboxAnchor( getFigure() );
	}
	@Override
	public ConnectionAnchor getTargetConnectionAnchor( ConnectionEditPart connection ) {
		return new ChopboxAnchor( getFigure() );
	}
	@Override
	public ConnectionAnchor getTargetConnectionAnchor( Request request ) {
		return new ChopboxAnchor( getFigure() );
	}
	@Override
	public List<SdObject> getModelChildren( ) { 
		return new ArrayList<SdObject>(); 
	}
}