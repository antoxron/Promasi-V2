//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.06.15 at 01:29:45 PM CEST 
//


package org.promasi.game.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for taskBridgeModel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="taskBridgeModel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="inputSdObjectId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="inputTaskName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="outputSdObjectId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="outputTaskName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "taskBridgeModel", propOrder = {
    "inputSdObjectId",
    "inputTaskName",
    "outputSdObjectId",
    "outputTaskName"
})
public class TaskBridgeModel {

    protected String inputSdObjectId;
    protected String inputTaskName;
    protected String outputSdObjectId;
    protected String outputTaskName;

    /**
     * Gets the value of the inputSdObjectId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInputSdObjectId() {
        return inputSdObjectId;
    }

    /**
     * Sets the value of the inputSdObjectId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInputSdObjectId(String value) {
        this.inputSdObjectId = value;
    }

    /**
     * Gets the value of the inputTaskName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInputTaskName() {
        return inputTaskName;
    }

    /**
     * Sets the value of the inputTaskName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInputTaskName(String value) {
        this.inputTaskName = value;
    }

    /**
     * Gets the value of the outputSdObjectId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutputSdObjectId() {
        return outputSdObjectId;
    }

    /**
     * Sets the value of the outputSdObjectId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutputSdObjectId(String value) {
        this.outputSdObjectId = value;
    }

    /**
     * Gets the value of the outputTaskName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOutputTaskName() {
        return outputTaskName;
    }

    /**
     * Sets the value of the outputTaskName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOutputTaskName(String value) {
        this.outputTaskName = value;
    }

}
