package org.talend.designer.codegen.translators.generic.component;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import org.talend.components.api.component.ComponentDefinition;
import org.talend.designer.core.generic.model.Component;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.EConnectionType;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.utils.TalendTextUtils;

public class ComponentMain
{
  protected static String nl;
  public static synchronized ComponentMain create(String lineSeparator)
  {
    nl = lineSeparator;
    ComponentMain result = new ComponentMain();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "// main of generic (used only for output components)" + NL;
  protected final String TEXT_2 = NL + NL + "    // OUTPUT" + NL;
  protected final String TEXT_3 = NL + "                ";
  protected final String TEXT_4 = " = null;";
  protected final String TEXT_5 = NL + "        // METADATA";
  protected final String TEXT_6 = NL + "                if (current_";
  protected final String TEXT_7 = ".needsInitDynamicColumns()) {" + NL + "                    // Initialize the dynamic columns when they are first encountered." + NL + "                    for (routines.system.DynamicMetadata dm_";
  protected final String TEXT_8 = " : ";
  protected final String TEXT_9 = ".";
  protected final String TEXT_10 = ".metadatas) {" + NL + "                        current_";
  protected final String TEXT_11 = ".initDynamicColumn(" + NL + "                                dm_";
  protected final String TEXT_12 = ".getName(), dm_";
  protected final String TEXT_13 = ".getDbName()," + NL + "                                dm_";
  protected final String TEXT_14 = ".getType(), dm_";
  protected final String TEXT_15 = ".getDbType()," + NL + "                                dm_";
  protected final String TEXT_16 = ".getDbTypeId(), dm_";
  protected final String TEXT_17 = ".getLength()," + NL + "                                dm_";
  protected final String TEXT_18 = ".getPrecision(), dm_";
  protected final String TEXT_19 = ".getFormat()," + NL + "                                dm_";
  protected final String TEXT_20 = ".getDescription(), dm_";
  protected final String TEXT_21 = ".isKey()," + NL + "                                dm_";
  protected final String TEXT_22 = ".isNullable()," + NL + "                                dm_";
  protected final String TEXT_23 = ".getRefFieldName(), dm_";
  protected final String TEXT_24 = ".getRefModuleName());" + NL + "                    }" + NL + "                    current_";
  protected final String TEXT_25 = ".initDynamicColumnsFinished();" + NL + "                }";
  protected final String TEXT_26 = NL + "                        current_";
  protected final String TEXT_27 = ".put(\"";
  protected final String TEXT_28 = "\", ";
  protected final String TEXT_29 = ".";
  protected final String TEXT_30 = ");";
  protected final String TEXT_31 = NL + "                        for (int i = 0; i < ";
  protected final String TEXT_32 = ".";
  protected final String TEXT_33 = ".getColumnCount(); i++) {" + NL + "                            current_";
  protected final String TEXT_34 = ".put(";
  protected final String TEXT_35 = ".";
  protected final String TEXT_36 = ".getColumnMetadata(i).getName(),";
  protected final String TEXT_37 = NL + "                                    ";
  protected final String TEXT_38 = ".";
  protected final String TEXT_39 = ".getColumnValue(i));" + NL + "                        }";
  protected final String TEXT_40 = NL + "                " + NL + "                Object data_";
  protected final String TEXT_41 = " = current_";
  protected final String TEXT_42 = ".createIndexedRecord();" + NL + "                " + NL + "                try {" + NL + "                \twriter_";
  protected final String TEXT_43 = ".write(data_";
  protected final String TEXT_44 = ");" + NL + "                \t";
  protected final String TEXT_45 = NL + "                \t\t";
  protected final String TEXT_46 = " = new ";
  protected final String TEXT_47 = "Struct();" + NL + "                \t\t";
  protected final String TEXT_48 = NL + "\t                \t\t";
  protected final String TEXT_49 = ".";
  protected final String TEXT_50 = " = ";
  protected final String TEXT_51 = ".";
  protected final String TEXT_52 = ";" + NL + "\t                \t\t";
  protected final String TEXT_53 = NL + "                } catch (org.talend.components.api.exception.DataRejectException e_";
  protected final String TEXT_54 = ") {" + NL + "                \t";
  protected final String TEXT_55 = NL + "                \t\t";
  protected final String TEXT_56 = " = new ";
  protected final String TEXT_57 = "Struct();" + NL + "                \t\t";
  protected final String TEXT_58 = NL + "\t                \t\t";
  protected final String TEXT_59 = ".";
  protected final String TEXT_60 = " = ";
  protected final String TEXT_61 = ".";
  protected final String TEXT_62 = ";" + NL + "\t                \t\t";
  protected final String TEXT_63 = NL + "                \t\t" + NL + "                \t\tjava.util.Map<String,Object> info_";
  protected final String TEXT_64 = " = e_";
  protected final String TEXT_65 = ".getRejectInfo();" + NL + "                \t\t" + NL + "                \t\t";
  protected final String TEXT_66 = NL + "                \t\t\t";
  protected final String TEXT_67 = ".";
  protected final String TEXT_68 = " = (";
  protected final String TEXT_69 = ")info_";
  protected final String TEXT_70 = ".get(\"";
  protected final String TEXT_71 = "\");" + NL + "                \t\t\t";
  protected final String TEXT_72 = NL + "                }";
  protected final String TEXT_73 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
Component component = (Component)node.getComponent();
ComponentDefinition def = component.getComponentDefinition();

if(def instanceof org.talend.components.api.component.OutputComponentDefinition){
    
    stringBuffer.append(TEXT_2);
    
    List<? extends IConnection> outgoingConns = node.getOutgoingSortedConnections();
    if (outgoingConns!=null){
        for (int i = 0; i < outgoingConns.size(); i++) {
            IConnection outgoingConn = outgoingConns.get(i);
            if (outgoingConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
            
    stringBuffer.append(TEXT_3);
    stringBuffer.append(outgoingConn.getName());
    stringBuffer.append(TEXT_4);
    
            }
        }
    }

    List<IMetadataTable> metadatas = node.getMetadataList();
    IMetadataTable metadata;
    if ((metadatas != null) && (metadatas.size() > 0) && (metadata = metadatas.get(0)) != null) { // metadata
        List<IMetadataColumn> columnList = metadata.getListColumns();
        int dynamicPos = -1;
        for (int i = 0; i < columnList.size(); i++) {
            if (columnList.get(i).getTalendType().equals("id_Dynamic")) {
                dynamicPos = i;
                break;
            }
        }
        
    stringBuffer.append(TEXT_5);
    

        List< ? extends IConnection> conns = node.getIncomingConnections();
        for (IConnection conn : conns) { // conn
            // If there are dynamic columns in the schema, they need to be
            // initialized into the runtime schema of the actual IndexedRecord
            // provided to the component.
            if (dynamicPos != -1)  {
                
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_9);
    stringBuffer.append(columnList.get(dynamicPos).getLabel());
    stringBuffer.append(TEXT_10);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_25);
    
            }

            if (conn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) { // conn line style
                for (int i = 0; i < columnList.size(); i++) { // column
                    IMetadataColumn column = columnList.get(i);
                    if (dynamicPos != i) {
                        
    stringBuffer.append(TEXT_26);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_27);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_28);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_29);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_30);
    
                    } else {
                        
    stringBuffer.append(TEXT_31);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_32);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_35);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_36);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_38);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_39);
    
                    }
                } // column
                
    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    
                	//pass the main flow
                	IConnection main = null;
                	List<? extends IConnection> mains = node.getOutgoingConnections(EConnectionType.FLOW_MAIN);
                	if(mains!=null && !mains.isEmpty()) {
                		main = mains.get(0);
                		
    stringBuffer.append(TEXT_45);
    stringBuffer.append(main.getName());
    stringBuffer.append(TEXT_46);
    stringBuffer.append(main.getName() );
    stringBuffer.append(TEXT_47);
    
                		for (IMetadataColumn column : columnList) {
	                		
    stringBuffer.append(TEXT_48);
    stringBuffer.append(main.getName());
    stringBuffer.append(TEXT_49);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_50);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_51);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_52);
    
                		}
                		
                		//TODO how to pass the additional columns in output connection? like salesforce_id
                	}
                	
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    
                	//pass the reject flow
                	//the method below can't wrok now, TODO fix it
                	//List<? extends IConnection> rejects = node.getOutgoingConnections(EConnectionType.REJECT);
                	
                	IConnection reject = null;
                	for(IConnection outConn : node.getOutgoingConnections()) {
                		if(!outConn.getLineStyle().hasConnectionCategory(IConnectionCategory.DATA)) {
                			continue;
                		}
                		
                		if(main!=null && main.getName().equals(outConn.getName())) {
                			continue;
                		}
                		
                		reject = outConn;
                		
                		break;
                	}
                	
                	if(reject!=null) {
                		Set<String> commonColumns = new HashSet<String>();
                		
    stringBuffer.append(TEXT_55);
    stringBuffer.append(reject.getName());
    stringBuffer.append(TEXT_56);
    stringBuffer.append(reject.getName() );
    stringBuffer.append(TEXT_57);
    
                		for (IMetadataColumn column : columnList) {
                			commonColumns.add(column.getLabel());
	                		
    stringBuffer.append(TEXT_58);
    stringBuffer.append(reject.getName());
    stringBuffer.append(TEXT_59);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_60);
    stringBuffer.append(conn.getName());
    stringBuffer.append(TEXT_61);
    stringBuffer.append(column.getLabel());
    stringBuffer.append(TEXT_62);
    
                		}
                		
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    
                		//pass error columns
                		List<IMetadataColumn> rejectColumns = reject.getMetadataTable().getListColumns();
                		for(IMetadataColumn column : rejectColumns) {
                			String columnName = column.getLabel();
                			
                			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
	                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
	                        
                			//error columns
                			if(!commonColumns.contains(columnName)) {
                			
    stringBuffer.append(TEXT_66);
    stringBuffer.append(reject.getName());
    stringBuffer.append(TEXT_67);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_71);
    
                			}
                		}
                	}
                	
    stringBuffer.append(TEXT_72);
    
            } // conn line style
        } // conn
    } // metadata
} // canStart

    stringBuffer.append(TEXT_73);
    return stringBuffer.toString();
  }
}
