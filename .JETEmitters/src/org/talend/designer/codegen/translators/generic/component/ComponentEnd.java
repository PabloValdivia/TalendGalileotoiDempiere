package org.talend.designer.codegen.translators.generic.component;

import org.talend.components.api.component.ComponentDefinition;
import org.talend.designer.core.generic.model.Component;
import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import java.util.List;

public class ComponentEnd
{
  protected static String nl;
  public static synchronized ComponentEnd create(String lineSeparator)
  {
    nl = lineSeparator;
    ComponentEnd result = new ComponentEnd();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "// end of generic" + NL;
  protected final String TEXT_2 = NL + "\t} // while";
  protected final String TEXT_3 = NL + NL + "\treader_";
  protected final String TEXT_4 = ".close();";
  protected final String TEXT_5 = NL + "\twriter_";
  protected final String TEXT_6 = ".close();";
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
Component component = (Component)node.getComponent();
ComponentDefinition def = component.getComponentDefinition();

IMetadataTable metadata = null;
List<IMetadataTable> metadatas = node.getMetadataList();
if ((metadatas != null) && (metadatas.size() > 0)) {
	metadata = metadatas.get(0);
}

if (metadata == null) {
	return stringBuffer.toString();
}

if(def instanceof org.talend.components.api.component.InputComponentDefinition){

    stringBuffer.append(TEXT_2);
    

    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    
}else if(def instanceof org.talend.components.api.component.OutputComponentDefinition){
// Output

    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_6);
    
}

    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
