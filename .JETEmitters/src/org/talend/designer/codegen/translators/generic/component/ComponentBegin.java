package org.talend.designer.codegen.translators.generic.component;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Stack;
import org.talend.components.api.component.ComponentDefinition;
import org.talend.components.api.component.EndpointComponentDefinition;
import org.talend.components.api.component.InputComponentDefinition;
import org.talend.components.api.component.OutputComponentDefinition;
import org.talend.components.api.properties.ComponentProperties;
import org.talend.components.api.container.RuntimeContainer;
import org.talend.daikon.properties.Property;
import org.talend.daikon.NamedThing;
import org.talend.designer.core.generic.model.Component;
import org.talend.core.model.metadata.IMetadataColumn;
import org.talend.core.model.metadata.IMetadataTable;
import org.talend.core.model.metadata.types.JavaType;
import org.talend.core.model.metadata.types.JavaTypesManager;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.core.model.process.IElementParameter;
import org.talend.core.model.process.IConnection;
import org.talend.core.model.process.IConnectionCategory;
import org.talend.core.model.process.EConnectionType;
import org.talend.core.model.process.INode;
import org.talend.core.model.utils.TalendTextUtils;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import org.talend.core.model.process.EParameterFieldType;

public class ComponentBegin
{
  protected static String nl;
  public static synchronized ComponentBegin create(String lineSeparator)
  {
    nl = lineSeparator;
    ComponentBegin result = new ComponentBegin();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = NL + "org.talend.components.api.component.ComponentDefinition def_";
  protected final String TEXT_2 = " =" + NL + "   new ";
  protected final String TEXT_3 = "();";
  protected final String TEXT_4 = NL;
  protected final String TEXT_5 = NL;
  protected final String TEXT_6 = " props_";
  protected final String TEXT_7 = " = (";
  protected final String TEXT_8 = ") def_";
  protected final String TEXT_9 = ".createRuntimeProperties();";
  protected final String TEXT_10 = NL + "                        java.util.List<String> ";
  protected final String TEXT_11 = " = new java.util.ArrayList<String>();";
  protected final String TEXT_12 = NL + "                                ";
  protected final String TEXT_13 = ".add(\"";
  protected final String TEXT_14 = "\");";
  protected final String TEXT_15 = NL + "                                ";
  protected final String TEXT_16 = ".add(";
  protected final String TEXT_17 = ");";
  protected final String TEXT_18 = NL + "                                ";
  protected final String TEXT_19 = ".add(\"\");";
  protected final String TEXT_20 = NL + "                        ((org.talend.daikon.properties.Properties)props_";
  protected final String TEXT_21 = ").setValue(\"";
  protected final String TEXT_22 = "\",";
  protected final String TEXT_23 = ");";
  protected final String TEXT_24 = NL + "                    props_";
  protected final String TEXT_25 = ".setValue(\"";
  protected final String TEXT_26 = "\"," + NL + "                    routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_27 = "));";
  protected final String TEXT_28 = NL + "    \t\t\t\tprops_";
  protected final String TEXT_29 = ".setValue(\"";
  protected final String TEXT_30 = "\"," + NL + "\t                \tTalendDate.parseDate(\"yyyy-MM-dd HH:mm:ss\",";
  protected final String TEXT_31 = "));" + NL + "    \t\t\t\t";
  protected final String TEXT_32 = NL + "                    props_";
  protected final String TEXT_33 = ".setValue(\"";
  protected final String TEXT_34 = "\",";
  protected final String TEXT_35 = NL + "                    ";
  protected final String TEXT_36 = ");";
  protected final String TEXT_37 = NL + "org.talend.components.api.container.RuntimeContainer container_";
  protected final String TEXT_38 = " = new org.talend.components.api.container.RuntimeContainer() {" + NL + "    public Object getComponentData(String componentId, String key) {" + NL + "        return globalMap.get(componentId + \"_\" + key);" + NL + "    }" + NL + "" + NL + "    public void setComponentData(String componentId, String key, Object data) {" + NL + "        globalMap.put(componentId + \"_\" + key, data);" + NL + "    }" + NL + "" + NL + "    public String getCurrentComponentId() {" + NL + "        return \"";
  protected final String TEXT_39 = "\";" + NL + "    }" + NL + "};" + NL;
  protected final String TEXT_40 = NL + "\torg.talend.components.api.component.runtime.SourceOrSink sourceOrSink_";
  protected final String TEXT_41 = " = ((org.talend.components.api.component.EndpointComponentDefinition)def_";
  protected final String TEXT_42 = ").getRuntime();" + NL + "\tsourceOrSink_";
  protected final String TEXT_43 = ".initialize(container_";
  protected final String TEXT_44 = ", props_";
  protected final String TEXT_45 = ");" + NL + "\torg.talend.daikon.properties.ValidationResult vr_";
  protected final String TEXT_46 = " = sourceOrSink_";
  protected final String TEXT_47 = ".validate(container_";
  protected final String TEXT_48 = ");" + NL + "\tif (vr_";
  protected final String TEXT_49 = ".getStatus() == org.talend.daikon.properties.ValidationResult.Result.ERROR ) {" + NL + "\t\tthrow new RuntimeException(vr_";
  protected final String TEXT_50 = ".getMessage());" + NL + "\t}";
  protected final String TEXT_51 = NL + "\t\torg.talend.components.api.component.runtime.Source source_";
  protected final String TEXT_52 = " = (org.talend.components.api.component.runtime.Source)sourceOrSink_";
  protected final String TEXT_53 = ";" + NL + "\t\torg.talend.components.api.component.runtime.Reader reader_";
  protected final String TEXT_54 = " = source_";
  protected final String TEXT_55 = ".createReader(container_";
  protected final String TEXT_56 = ");" + NL + "" + NL + "\t\t";
  protected final String TEXT_57 = NL + "        \t\tboolean initDyn_";
  protected final String TEXT_58 = " = false;" + NL + "        \t\troutines.system.Dynamic dynamic_";
  protected final String TEXT_59 = " = new routines.system.Dynamic();" + NL + "        \t";
  protected final String TEXT_60 = NL + "        \t\tboolean multi_output_is_allowed_";
  protected final String TEXT_61 = " = false;" + NL + "            \t";
  protected final String TEXT_62 = NL + "                org.talend.components.api.component.Connector c_";
  protected final String TEXT_63 = " = null;" + NL + "                for (org.talend.components.api.component.Connector currentConnector : props_";
  protected final String TEXT_64 = ".getAvailableConnectors(null, true)) {" + NL + "                    if (currentConnector.getName().equals(\"";
  protected final String TEXT_65 = "\")) {" + NL + "                        c_";
  protected final String TEXT_66 = " = currentConnector;" + NL + "                    }" + NL + "                    " + NL + "                    if (currentConnector.getName().equals(\"REJECT\")) {//it's better to move the code to javajet" + NL + "                        multi_output_is_allowed_";
  protected final String TEXT_67 = " = true;" + NL + "                    }" + NL + "                }" + NL + "                org.apache.avro.Schema schema_";
  protected final String TEXT_68 = " = props_";
  protected final String TEXT_69 = ".getSchema(c_";
  protected final String TEXT_70 = ", true);" + NL + "" + NL + "                org.talend.daikon.talend6.Talend6OutgoingSchemaEnforcer current_";
  protected final String TEXT_71 = " = new org.talend.daikon.talend6.Talend6OutgoingSchemaEnforcer(schema_";
  protected final String TEXT_72 = ", false);" + NL + "                " + NL + "                // Create a reusable factory that converts the output of the reader to an IndexedRecord." + NL + "                org.talend.daikon.avro.IndexedRecordAdapterFactory<Object, ? extends org.apache.avro.generic.IndexedRecord> factory_";
  protected final String TEXT_73 = " = null;" + NL + "" + NL + "\t\t";
  protected final String TEXT_74 = NL + "                // Iterate through the incoming data." + NL + "                for(boolean available = reader_";
  protected final String TEXT_75 = ".start(); available; available = reader_";
  protected final String TEXT_76 = ".advance()) {//}" + NL + "\t\t";
  protected final String TEXT_77 = NL + "\t\t\t\t\tif(multi_output_is_allowed_";
  protected final String TEXT_78 = ") {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_79 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_80 = " = null;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_81 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_82 = NL + "\t\t\t\t\t\t";
  protected final String TEXT_83 = " = null;" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_84 = NL + "\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\ttry {" + NL + "\t\t\t\t\t\tObject data_";
  protected final String TEXT_85 = " = reader_";
  protected final String TEXT_86 = ".getCurrent();" + NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_87 = NL + "\t\t\t\t\t\t" + NL + "\t\t\t\t\t\tif(multi_output_is_allowed_";
  protected final String TEXT_88 = ") {" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_89 = " = new ";
  protected final String TEXT_90 = "Struct();" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t" + NL + "\t                    // Construct the factory once when the first data arrives." + NL + "\t                    if (factory_";
  protected final String TEXT_91 = " == null)" + NL + "\t                        factory_";
  protected final String TEXT_92 = " = (org.talend.daikon.avro.IndexedRecordAdapterFactory<Object, ? extends org.apache.avro.generic.IndexedRecord>) new org.talend.daikon.avro.AvroRegistry()" + NL + "\t                                .createAdapterFactory(data_";
  protected final String TEXT_93 = ".getClass());" + NL + "\t" + NL + "\t                    // Enforce the outgoing schema on the input." + NL + "\t                    org.apache.avro.generic.IndexedRecord unenforced_";
  protected final String TEXT_94 = " = factory_";
  protected final String TEXT_95 = ".convertToAvro(data_";
  protected final String TEXT_96 = ");" + NL + "\t                    current_";
  protected final String TEXT_97 = ".setWrapped(unenforced_";
  protected final String TEXT_98 = ");" + NL + "\t                    " + NL + "\t                    ";
  protected final String TEXT_99 = NL + "\t\t\t\t\t\t\tif(!initDyn_";
  protected final String TEXT_100 = "){" + NL + "\t\t\t\t\t\t\t\torg.apache.avro.Schema dynSchema_";
  protected final String TEXT_101 = " = current_";
  protected final String TEXT_102 = ".getOutgoingDynamicRuntimeSchema();" + NL + "\t" + NL + "\t\t\t\t\t\t\t\tfor(org.apache.avro.Schema.Field childDynamic_";
  protected final String TEXT_103 = " : dynSchema_";
  protected final String TEXT_104 = ".getFields()){" + NL + "\t\t\t\t\t\t\t\t\troutines.system.DynamicMetadata dynamicMetadata_";
  protected final String TEXT_105 = " = new routines.system.DynamicMetadata();" + NL + "\t\t\t\t\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_106 = ".setName(childDynamic_";
  protected final String TEXT_107 = ".name());" + NL + "\t\t\t\t\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_108 = ".setDbName(childDynamic_";
  protected final String TEXT_109 = ".name());" + NL + "\t\t\t\t\t\t\t    \tString talendType_";
  protected final String TEXT_110 = " = null;" + NL + "\t\t\t\t\t\t\t    \tif(childDynamic_";
  protected final String TEXT_111 = ".schema().getType() == org.apache.avro.Schema.Type.ARRAY){" + NL + "\t\t\t\t\t\t\t    \t\ttalendType_";
  protected final String TEXT_112 = " = \"";
  protected final String TEXT_113 = "\";" + NL + "\t\t\t\t\t\t\t    \t}else if(childDynamic_";
  protected final String TEXT_114 = ".schema().getType() == org.apache.avro.Schema.Type.BOOLEAN){" + NL + "\t\t\t\t\t\t\t    \t\ttalendType_";
  protected final String TEXT_115 = " = \"";
  protected final String TEXT_116 = "\";" + NL + "\t\t\t\t\t\t\t    \t}else if(childDynamic_";
  protected final String TEXT_117 = ".schema().getType() == org.apache.avro.Schema.Type.BYTES){" + NL + "\t\t\t\t\t\t\t    \t\ttalendType_";
  protected final String TEXT_118 = " = \"";
  protected final String TEXT_119 = "\";" + NL + "\t\t\t\t\t\t\t    \t}else if(childDynamic_";
  protected final String TEXT_120 = ".schema().getType() == org.apache.avro.Schema.Type.FIXED){" + NL + "\t\t\t\t\t\t\t    \t\ttalendType_";
  protected final String TEXT_121 = " = \"";
  protected final String TEXT_122 = "\";" + NL + "\t\t\t\t\t\t\t    \t}else if(childDynamic_";
  protected final String TEXT_123 = ".schema().getType() == org.apache.avro.Schema.Type.DOUBLE){" + NL + "\t\t\t\t\t\t\t    \t\ttalendType_";
  protected final String TEXT_124 = " = \"";
  protected final String TEXT_125 = "\";" + NL + "\t\t\t\t\t\t\t    \t}else if(childDynamic_";
  protected final String TEXT_126 = ".schema().getType() == org.apache.avro.Schema.Type.FLOAT){" + NL + "\t\t\t\t\t\t\t    \t\ttalendType_";
  protected final String TEXT_127 = " = \"";
  protected final String TEXT_128 = "\";" + NL + "\t\t\t\t\t\t\t    \t}else if(childDynamic_";
  protected final String TEXT_129 = ".schema().getType() == org.apache.avro.Schema.Type.INT){" + NL + "\t\t\t\t\t\t\t    \t\ttalendType_";
  protected final String TEXT_130 = " = \"";
  protected final String TEXT_131 = "\";" + NL + "\t\t\t\t\t\t\t    \t}else if(childDynamic_";
  protected final String TEXT_132 = ".schema().getType() == org.apache.avro.Schema.Type.LONG){" + NL + "\t\t\t\t\t\t\t    \t\ttalendType_";
  protected final String TEXT_133 = " = \"";
  protected final String TEXT_134 = "\";" + NL + "\t\t\t\t\t\t\t    \t}else if(childDynamic_";
  protected final String TEXT_135 = ".schema().getType() == org.apache.avro.Schema.Type.ENUM){" + NL + "\t\t\t\t\t\t\t    \t\ttalendType_";
  protected final String TEXT_136 = " = \"";
  protected final String TEXT_137 = "\";" + NL + "\t\t\t\t\t\t\t    \t}else if(childDynamic_";
  protected final String TEXT_138 = ".schema().getType() == org.apache.avro.Schema.Type.STRING){" + NL + "\t\t\t\t\t\t\t    \t\ttalendType_";
  protected final String TEXT_139 = " = \"";
  protected final String TEXT_140 = "\";" + NL + "\t\t\t\t\t\t\t    \t}" + NL + "\t\t\t\t\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_141 = ".setType(talendType_";
  protected final String TEXT_142 = ");" + NL + "\t\t\t\t\t\t\t    \tdynamic_";
  protected final String TEXT_143 = ".metadatas.add(dynamicMetadata_";
  protected final String TEXT_144 = ");" + NL + "\t\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\t\tinitDyn_";
  protected final String TEXT_145 = " = true;" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tdynamic_";
  protected final String TEXT_146 = ".clearColumnValues();" + NL + "\t                    ";
  protected final String TEXT_147 = NL + "\t                        \tjava.util.Map<String, Object> dynamicValue_";
  protected final String TEXT_148 = " = (java.util.Map<String, Object>)current_";
  protected final String TEXT_149 = ".get(";
  protected final String TEXT_150 = ");" + NL + "\t                        \tfor(String dynamicValue_Key_";
  protected final String TEXT_151 = " : dynamicValue_";
  protected final String TEXT_152 = ".keySet()){" + NL + "\t                        \t\tdynamic_";
  protected final String TEXT_153 = ".setColumnValue(dynamic_";
  protected final String TEXT_154 = ".getIndex(dynamicValue_Key_";
  protected final String TEXT_155 = "), dynamicValue_";
  protected final String TEXT_156 = ".get(dynamicValue_Key_";
  protected final String TEXT_157 = "));" + NL + "\t                        \t}" + NL + "\t\t\t\t\t\t\t\t";
  protected final String TEXT_158 = ".";
  protected final String TEXT_159 = " = dynamic_";
  protected final String TEXT_160 = ";" + NL + "\t                        ";
  protected final String TEXT_161 = NL + "\t                        \tif(current_";
  protected final String TEXT_162 = ".get(";
  protected final String TEXT_163 = ") == null){" + NL + "\t                        \t\t";
  protected final String TEXT_164 = ".";
  protected final String TEXT_165 = " = ";
  protected final String TEXT_166 = ";" + NL + "\t                        \t}else{" + NL + "\t                        \t\t";
  protected final String TEXT_167 = NL + "\t                        \t\t\t";
  protected final String TEXT_168 = ".";
  protected final String TEXT_169 = " = String.valueOf(current_";
  protected final String TEXT_170 = ".get(";
  protected final String TEXT_171 = "));" + NL + "\t                        \t\t";
  protected final String TEXT_172 = NL + "\t\t                        \t\t";
  protected final String TEXT_173 = ".";
  protected final String TEXT_174 = " = (";
  protected final String TEXT_175 = ")(current_";
  protected final String TEXT_176 = ".get(";
  protected final String TEXT_177 = "));" + NL + "\t\t                        \t";
  protected final String TEXT_178 = NL + "\t                        \t}" + NL + "\t                    \t";
  protected final String TEXT_179 = NL + "\t                    " + NL + "                \t";
  protected final String TEXT_180 = NL + "        \t\t} catch (org.talend.components.api.exception.DataRejectException e_";
  protected final String TEXT_181 = ") {" + NL + "\t\t\t\t\t";
  protected final String TEXT_182 = NL + "\t\t\t\t\tjava.util.Map<String,Object> info_";
  protected final String TEXT_183 = " = e_";
  protected final String TEXT_184 = ".getRejectInfo();" + NL + "\t\t\t\t\tObject data_";
  protected final String TEXT_185 = " = info_";
  protected final String TEXT_186 = ".get(\"talend_record\");" + NL + "\t\t\t\t\t" + NL + "\t\t\t\t\tif(multi_output_is_allowed_";
  protected final String TEXT_187 = ") {" + NL + "\t\t\t\t\t\t";
  protected final String TEXT_188 = " = new ";
  protected final String TEXT_189 = "Struct();" + NL + "\t\t\t\t\t}" + NL + "\t\t\t\t" + NL + "                    // Construct the factory once when the first data arrives." + NL + "                    if (factory_";
  protected final String TEXT_190 = " == null)" + NL + "                        factory_";
  protected final String TEXT_191 = " = (org.talend.daikon.avro.IndexedRecordAdapterFactory<Object, ? extends org.apache.avro.generic.IndexedRecord>) new org.talend.daikon.avro.AvroRegistry()" + NL + "                                .createAdapterFactory(data_";
  protected final String TEXT_192 = ".getClass());" + NL + "" + NL + "                    // Enforce the outgoing schema on the input." + NL + "                    org.apache.avro.generic.IndexedRecord unenforced_";
  protected final String TEXT_193 = " = factory_";
  protected final String TEXT_194 = ".convertToAvro(data_";
  protected final String TEXT_195 = ");" + NL + "                    current_";
  protected final String TEXT_196 = ".setWrapped(unenforced_";
  protected final String TEXT_197 = ");" + NL + "                    ";
  protected final String TEXT_198 = NL + "\t\t\t\t\t\tif(!initDyn_";
  protected final String TEXT_199 = "){" + NL + "\t\t\t\t\t\t\torg.apache.avro.Schema dynSchema_";
  protected final String TEXT_200 = " = current_";
  protected final String TEXT_201 = ".getOutgoingDynamicRuntimeSchema();" + NL + "" + NL + "\t\t\t\t\t\t\tfor(org.apache.avro.Schema.Field childDynamic_";
  protected final String TEXT_202 = " : dynSchema_";
  protected final String TEXT_203 = ".getFields()){" + NL + "\t\t\t\t\t\t\t\troutines.system.DynamicMetadata dynamicMetadata_";
  protected final String TEXT_204 = " = new routines.system.DynamicMetadata();" + NL + "\t\t\t\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_205 = ".setName(childDynamic_";
  protected final String TEXT_206 = ".name());" + NL + "\t\t\t\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_207 = ".setDbName(childDynamic_";
  protected final String TEXT_208 = ".name());" + NL + "\t\t\t\t\t\t    \tString talendType_";
  protected final String TEXT_209 = " = null;" + NL + "\t\t\t\t\t\t    \tif(childDynamic_";
  protected final String TEXT_210 = ".schema().getType() == org.apache.avro.Schema.Type.ARRAY){" + NL + "\t\t\t\t\t\t    \t\ttalendType_";
  protected final String TEXT_211 = " = \"";
  protected final String TEXT_212 = "\";" + NL + "\t\t\t\t\t\t    \t}else if(childDynamic_";
  protected final String TEXT_213 = ".schema().getType() == org.apache.avro.Schema.Type.BOOLEAN){" + NL + "\t\t\t\t\t\t    \t\ttalendType_";
  protected final String TEXT_214 = " = \"";
  protected final String TEXT_215 = "\";" + NL + "\t\t\t\t\t\t    \t}else if(childDynamic_";
  protected final String TEXT_216 = ".schema().getType() == org.apache.avro.Schema.Type.BYTES){" + NL + "\t\t\t\t\t\t    \t\ttalendType_";
  protected final String TEXT_217 = " = \"";
  protected final String TEXT_218 = "\";" + NL + "\t\t\t\t\t\t    \t}else if(childDynamic_";
  protected final String TEXT_219 = ".schema().getType() == org.apache.avro.Schema.Type.FIXED){" + NL + "\t\t\t\t\t\t    \t\ttalendType_";
  protected final String TEXT_220 = " = \"";
  protected final String TEXT_221 = "\";" + NL + "\t\t\t\t\t\t    \t}else if(childDynamic_";
  protected final String TEXT_222 = ".schema().getType() == org.apache.avro.Schema.Type.DOUBLE){" + NL + "\t\t\t\t\t\t    \t\ttalendType_";
  protected final String TEXT_223 = " = \"";
  protected final String TEXT_224 = "\";" + NL + "\t\t\t\t\t\t    \t}else if(childDynamic_";
  protected final String TEXT_225 = ".schema().getType() == org.apache.avro.Schema.Type.FLOAT){" + NL + "\t\t\t\t\t\t    \t\ttalendType_";
  protected final String TEXT_226 = " = \"";
  protected final String TEXT_227 = "\";" + NL + "\t\t\t\t\t\t    \t}else if(childDynamic_";
  protected final String TEXT_228 = ".schema().getType() == org.apache.avro.Schema.Type.INT){" + NL + "\t\t\t\t\t\t    \t\ttalendType_";
  protected final String TEXT_229 = " = \"";
  protected final String TEXT_230 = "\";" + NL + "\t\t\t\t\t\t    \t}else if(childDynamic_";
  protected final String TEXT_231 = ".schema().getType() == org.apache.avro.Schema.Type.LONG){" + NL + "\t\t\t\t\t\t    \t\ttalendType_";
  protected final String TEXT_232 = " = \"";
  protected final String TEXT_233 = "\";" + NL + "\t\t\t\t\t\t    \t}else if(childDynamic_";
  protected final String TEXT_234 = ".schema().getType() == org.apache.avro.Schema.Type.ENUM){" + NL + "\t\t\t\t\t\t    \t\ttalendType_";
  protected final String TEXT_235 = " = \"";
  protected final String TEXT_236 = "\";" + NL + "\t\t\t\t\t\t    \t}else if(childDynamic_";
  protected final String TEXT_237 = ".schema().getType() == org.apache.avro.Schema.Type.STRING){" + NL + "\t\t\t\t\t\t    \t\ttalendType_";
  protected final String TEXT_238 = " = \"";
  protected final String TEXT_239 = "\";" + NL + "\t\t\t\t\t\t    \t}" + NL + "\t\t\t\t\t\t    \tdynamicMetadata_";
  protected final String TEXT_240 = ".setType(talendType_";
  protected final String TEXT_241 = ");" + NL + "\t\t\t\t\t\t    \tdynamic_";
  protected final String TEXT_242 = ".metadatas.add(dynamicMetadata_";
  protected final String TEXT_243 = ");" + NL + "\t\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\t\tinitDyn_";
  protected final String TEXT_244 = " = true;" + NL + "\t\t\t\t\t\t}" + NL + "\t\t\t\t\t\tdynamic_";
  protected final String TEXT_245 = ".clearColumnValues();";
  protected final String TEXT_246 = NL + "                        \tjava.util.Map<String, Object> dynamicValue_";
  protected final String TEXT_247 = " = (java.util.Map<String, Object>)current_";
  protected final String TEXT_248 = ".get(";
  protected final String TEXT_249 = ");" + NL + "                        \tfor(String dynamicValue_Key_";
  protected final String TEXT_250 = " : dynamicValue_";
  protected final String TEXT_251 = ".keySet()){" + NL + "                        \t\tdynamic_";
  protected final String TEXT_252 = ".setColumnValue(dynamic_";
  protected final String TEXT_253 = ".getIndex(dynamicValue_Key_";
  protected final String TEXT_254 = "), dynamicValue_";
  protected final String TEXT_255 = ".get(dynamicValue_Key_";
  protected final String TEXT_256 = "));" + NL + "                        \t}" + NL + "\t\t\t\t\t\t\t";
  protected final String TEXT_257 = ".";
  protected final String TEXT_258 = " = dynamic_";
  protected final String TEXT_259 = ";";
  protected final String TEXT_260 = NL + "                        \tif(current_";
  protected final String TEXT_261 = ".get(";
  protected final String TEXT_262 = ") == null){" + NL + "                        \t\t";
  protected final String TEXT_263 = ".";
  protected final String TEXT_264 = " = ";
  protected final String TEXT_265 = ";" + NL + "                        \t}else{" + NL + "                        \t\t";
  protected final String TEXT_266 = NL + "                        \t\t\t";
  protected final String TEXT_267 = ".";
  protected final String TEXT_268 = " = String.valueOf(current_";
  protected final String TEXT_269 = ".get(";
  protected final String TEXT_270 = "));" + NL + "                        \t\t";
  protected final String TEXT_271 = NL + "\t                        \t\t";
  protected final String TEXT_272 = ".";
  protected final String TEXT_273 = " = (";
  protected final String TEXT_274 = ")(current_";
  protected final String TEXT_275 = ".get(";
  protected final String TEXT_276 = "));" + NL + "\t                        \t";
  protected final String TEXT_277 = NL + "                        \t}" + NL + "                    \t";
  protected final String TEXT_278 = NL + "            \t\t\t";
  protected final String TEXT_279 = ".";
  protected final String TEXT_280 = " = (";
  protected final String TEXT_281 = ")info_";
  protected final String TEXT_282 = ".get(\"";
  protected final String TEXT_283 = "\");" + NL + "            \t\t\t";
  protected final String TEXT_284 = NL + "\t                    " + NL + "\t\t\t\t\t";
  protected final String TEXT_285 = NL + "\t\t\t\t}";
  protected final String TEXT_286 = NL + "\t\torg.talend.components.api.component.runtime.Sink sink_";
  protected final String TEXT_287 = " = (org.talend.components.api.component.runtime.Sink)sourceOrSink_";
  protected final String TEXT_288 = ";" + NL + "\t\torg.talend.components.api.component.runtime.WriteOperation writeOperation_";
  protected final String TEXT_289 = " = sink_";
  protected final String TEXT_290 = ".createWriteOperation();" + NL + "\t\twriteOperation_";
  protected final String TEXT_291 = ".initialize(container_";
  protected final String TEXT_292 = ");";
  protected final String TEXT_293 = NL + "\t\torg.talend.components.api.component.runtime.Writer writer_";
  protected final String TEXT_294 = " = writeOperation_";
  protected final String TEXT_295 = ".createWriter(container_";
  protected final String TEXT_296 = ");" + NL + "\t\twriter_";
  protected final String TEXT_297 = ".open(\"";
  protected final String TEXT_298 = "\");" + NL + "        org.talend.components.api.component.Connector c_";
  protected final String TEXT_299 = " = null;" + NL + "        for (org.talend.components.api.component.Connector currentConnector : props_";
  protected final String TEXT_300 = ".getAvailableConnectors(null, true)) {" + NL + "            if (currentConnector.getName().equals(\"MAIN\")) {" + NL + "                c_";
  protected final String TEXT_301 = " = currentConnector;" + NL + "                break;" + NL + "            }" + NL + "        }" + NL + "        org.apache.avro.Schema designSchema_";
  protected final String TEXT_302 = " = props_";
  protected final String TEXT_303 = ".getSchema(c_";
  protected final String TEXT_304 = ", true);" + NL + "        org.talend.daikon.talend6.Talend6IncomingSchemaEnforcer current_";
  protected final String TEXT_305 = NL + "                = new org.talend.daikon.talend6.Talend6IncomingSchemaEnforcer(designSchema_";
  protected final String TEXT_306 = ");" + NL + "\t";
  protected final String TEXT_307 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    
CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
INode node = (INode)codeGenArgument.getArgument();
String cid = node.getUniqueName();
Component component = (Component)node.getComponent();
ComponentProperties componentProps = node.getComponentProperties();
ComponentDefinition def = component.getComponentDefinition();

List<IMetadataTable> metadatas = node.getMetadataList();
IMetadataTable metadata = null;
List<IMetadataColumn> columnList = null;
boolean hasDynamic = false;
String dynamicColName = null;
int dynamicPos = -1;
if ((metadatas != null) && (metadatas.size() > 0)) { // metadata

	metadata = metadatas.get(0);
	if(metadata != null){
	    columnList = metadata.getListColumns();
		int nbSchemaColumns = columnList.size();

		hasDynamic = false;

		int pos = 0;
		for (IMetadataColumn column : columnList) {
			if (column.getTalendType().equals("id_Dynamic")) {
				hasDynamic = true;
				dynamicPos = pos;
				dynamicColName = column.getLabel();
				break;
			}
			pos++;
		}
	}
}

    stringBuffer.append(TEXT_1);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_2);
    stringBuffer.append( def.getClass().getName());
    stringBuffer.append(TEXT_3);
    
List<Component.CodegenPropInfo> propsToProcess = component.getCodegenPropInfos(componentProps);

    stringBuffer.append(TEXT_4);
    stringBuffer.append(TEXT_5);
    stringBuffer.append( componentProps.getClass().getName());
    stringBuffer.append(TEXT_6);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_7);
    stringBuffer.append( componentProps.getClass().getName());
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_9);
    

for (Component.CodegenPropInfo propInfo : propsToProcess) { // propInfo
	List<NamedThing> properties = propInfo.props.getProperties();
	for (NamedThing prop : properties) { // property
        if (prop instanceof Property) { // if, only deal with valued Properties
            Property property = (Property)prop;
            if (property.getFlags() != null && (property.getFlags().contains(Property.Flags.DESIGN_TIME_ONLY) || property.getFlags().contains(Property.Flags.HIDDEN)))
            	continue;
		    Object value = property.getValue();
            if (value != null && (value instanceof List)) { // if
                    // added for the support of tables
                        String tmpVarName = cid+propInfo.fieldName.replace('.','_')+"_"+property.getName();
                        
    stringBuffer.append(TEXT_10);
    stringBuffer.append(tmpVarName );
    stringBuffer.append(TEXT_11);
    
                        for (String subPropertyValue : (java.util.List<String>)property.getValue()) {
                            if ((property.getType() == Property.Type.BOOLEAN) || (property.getType() == Property.Type.ENUM)) {
                            
    stringBuffer.append(TEXT_12);
    stringBuffer.append(tmpVarName );
    stringBuffer.append(TEXT_13);
    stringBuffer.append(subPropertyValue );
    stringBuffer.append(TEXT_14);
    
                            } else {
                            	if(!"".equals(subPropertyValue)) {
                            
    stringBuffer.append(TEXT_15);
    stringBuffer.append(tmpVarName );
    stringBuffer.append(TEXT_16);
    stringBuffer.append(subPropertyValue );
    stringBuffer.append(TEXT_17);
    
                            	} else {
                            
    stringBuffer.append(TEXT_18);
    stringBuffer.append(tmpVarName );
    stringBuffer.append(TEXT_19);
    
                            	}
                            }
                        }
                        
    stringBuffer.append(TEXT_20);
    stringBuffer.append(cid );
    stringBuffer.append(propInfo.fieldName);
    stringBuffer.append(TEXT_21);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_22);
    stringBuffer.append(tmpVarName );
    stringBuffer.append(TEXT_23);
    
            }  else if (property.isFlag(Property.Flags.ENCRYPT) && ElementParameterParser.canEncryptValue(property.getStringValue())) {
                    
    stringBuffer.append(TEXT_24);
    stringBuffer.append(cid );
    stringBuffer.append(propInfo.fieldName);
    stringBuffer.append(TEXT_25);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_26);
    stringBuffer.append(component.getCodegenValue(property, property.getStringValue()));
    stringBuffer.append(TEXT_27);
    
            } else if (value != null && Property.Type.DATE.equals(property.getType())){
            		
    stringBuffer.append(TEXT_28);
    stringBuffer.append(cid );
    stringBuffer.append(propInfo.fieldName);
    stringBuffer.append(TEXT_29);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_30);
    stringBuffer.append(component.getCodegenValue(property, property.getStringValue()));
    stringBuffer.append(TEXT_31);
    
            } else if (value != null && (!(value instanceof String) || !((String)value).equals(""))) { // if
					
    stringBuffer.append(TEXT_32);
    stringBuffer.append(cid );
    stringBuffer.append(propInfo.fieldName);
    stringBuffer.append(TEXT_33);
    stringBuffer.append(property.getName());
    stringBuffer.append(TEXT_34);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(component.getCodegenValue(property, property.getStringValue()));
    stringBuffer.append(TEXT_36);
    
    		} // if
        }//else may be a ComponentProperties so ignore
	} // property
} // propInfo

    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_39);
    
if (def instanceof EndpointComponentDefinition) {

    stringBuffer.append(TEXT_40);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_41);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_42);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_43);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_44);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_45);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_46);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_47);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_48);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_49);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_50);
    
}

if (metadata != null) {
	if (def instanceof InputComponentDefinition) {

    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
		IConnection main = null;
		List<? extends IConnection> mains = node.getOutgoingConnections(EConnectionType.FLOW_MAIN);
		if(mains!=null && !mains.isEmpty()) {
			main = mains.get(0);
		}
		
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
		
		boolean hasDataOutput = main!=null || reject!=null;
		
		// FIXME - multiple outgoing connections?
		
        if(hasDataOutput) {
        	if(hasDynamic){
        	
    stringBuffer.append(TEXT_57);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    
        	}
        	
        	IConnection schemaSourceConnector = (main!=null ? main : reject);
			String schemaSourceConnectorName = schemaSourceConnector.getMetadataTable().getAttachedConnector();
        	
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
     //take care SourceOrSink.validate will change the schema if it contains include-all-fields, so need to get design Avro schema before validate 
    stringBuffer.append(TEXT_62);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_64);
    stringBuffer.append(schemaSourceConnectorName);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
		}
		
    stringBuffer.append(TEXT_74);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_75);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_76);
    
		if(hasDataOutput) {
		
    stringBuffer.append(TEXT_77);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_78);
    if(main!=null){
    stringBuffer.append(TEXT_79);
    stringBuffer.append(main.getName());
    stringBuffer.append(TEXT_80);
    }
    stringBuffer.append(TEXT_81);
    if(reject!=null){
    stringBuffer.append(TEXT_82);
    stringBuffer.append(reject.getName());
    stringBuffer.append(TEXT_83);
    }
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_86);
    if(main!=null){
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    stringBuffer.append(main.getName());
    stringBuffer.append(TEXT_89);
    stringBuffer.append(main.getName() );
    stringBuffer.append(TEXT_90);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_91);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_92);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_93);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_94);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_95);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_96);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_97);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_98);
    
						if(hasDynamic){
						
    stringBuffer.append(TEXT_99);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_100);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_101);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_102);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_103);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_104);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_105);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_106);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_107);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_108);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_109);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_110);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_111);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_112);
    stringBuffer.append(JavaTypesManager.LIST.getId());
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_115);
    stringBuffer.append(JavaTypesManager.BOOLEAN.getId());
    stringBuffer.append(TEXT_116);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_117);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_118);
    stringBuffer.append(JavaTypesManager.BYTE_ARRAY.getId());
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_120);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_121);
    stringBuffer.append(JavaTypesManager.BYTE_ARRAY.getId());
    stringBuffer.append(TEXT_122);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_123);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_124);
    stringBuffer.append(JavaTypesManager.DOUBLE.getId());
    stringBuffer.append(TEXT_125);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(JavaTypesManager.FLOAT.getId());
    stringBuffer.append(TEXT_128);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_129);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_130);
    stringBuffer.append(JavaTypesManager.INTEGER.getId());
    stringBuffer.append(TEXT_131);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_132);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_133);
    stringBuffer.append(JavaTypesManager.LONG.getId());
    stringBuffer.append(TEXT_134);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_135);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(JavaTypesManager.STRING.getId());
    stringBuffer.append(TEXT_137);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_138);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_139);
    stringBuffer.append(JavaTypesManager.STRING.getId());
    stringBuffer.append(TEXT_140);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_141);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_142);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_143);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_144);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_145);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_146);
    
	                    }
	                    
	                    List<IMetadataColumn> main_output_columnList = main.getMetadataTable().getListColumns();
	                    
	                    for (int i = 0; i < main_output_columnList.size(); i++) {
	                        IMetadataColumn column = main_output_columnList.get(i);
	                        String columnName = column.getLabel();
	                        JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
	                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
	                        if(columnName.equals(dynamicColName)){
	                        
    stringBuffer.append(TEXT_147);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_148);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_149);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_150);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_151);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_152);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_153);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_154);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(main.getName());
    stringBuffer.append(TEXT_158);
    stringBuffer.append(dynamicColName);
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    
	                        }else{
	                        
    stringBuffer.append(TEXT_161);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_162);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_163);
    stringBuffer.append(main.getName());
    stringBuffer.append(TEXT_164);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_165);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_166);
    if(javaType == JavaTypesManager.STRING){
    stringBuffer.append(TEXT_167);
    stringBuffer.append(main.getName());
    stringBuffer.append(TEXT_168);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_171);
    }else{
    stringBuffer.append(TEXT_172);
    stringBuffer.append(main.getName());
    stringBuffer.append(TEXT_173);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_177);
    }
    stringBuffer.append(TEXT_178);
    
	                    	}
	                    }
	                    
    stringBuffer.append(TEXT_179);
    }
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    if(reject!=null){
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(reject.getName());
    stringBuffer.append(TEXT_188);
    stringBuffer.append(reject.getName() );
    stringBuffer.append(TEXT_189);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_190);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_191);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_192);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_193);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_194);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_195);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_196);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_197);
    
					if(hasDynamic){
					
    stringBuffer.append(TEXT_198);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_199);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_200);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_201);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_202);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_203);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_204);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_205);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_206);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_207);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_208);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_209);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_210);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_211);
    stringBuffer.append(JavaTypesManager.LIST.getId());
    stringBuffer.append(TEXT_212);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_213);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_214);
    stringBuffer.append(JavaTypesManager.BOOLEAN.getId());
    stringBuffer.append(TEXT_215);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_216);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_217);
    stringBuffer.append(JavaTypesManager.BYTE_ARRAY.getId());
    stringBuffer.append(TEXT_218);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_219);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_220);
    stringBuffer.append(JavaTypesManager.BYTE_ARRAY.getId());
    stringBuffer.append(TEXT_221);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_222);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_223);
    stringBuffer.append(JavaTypesManager.DOUBLE.getId());
    stringBuffer.append(TEXT_224);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_225);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_226);
    stringBuffer.append(JavaTypesManager.FLOAT.getId());
    stringBuffer.append(TEXT_227);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_228);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_229);
    stringBuffer.append(JavaTypesManager.INTEGER.getId());
    stringBuffer.append(TEXT_230);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_231);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_232);
    stringBuffer.append(JavaTypesManager.LONG.getId());
    stringBuffer.append(TEXT_233);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_234);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_235);
    stringBuffer.append(JavaTypesManager.STRING.getId());
    stringBuffer.append(TEXT_236);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_237);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_238);
    stringBuffer.append(JavaTypesManager.STRING.getId());
    stringBuffer.append(TEXT_239);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_240);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_241);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_242);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_243);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_244);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_245);
    
                    }
                    
                    Set<String> commonColumns = new HashSet<String>();
                    
                    for (int i = 0; i < columnList.size(); i++) {
                        IMetadataColumn column = columnList.get(i);
                        String columnName = column.getLabel();
                        
                        commonColumns.add(columnName);
                        
                        JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                        if(columnName.equals(dynamicColName)){
                        
    stringBuffer.append(TEXT_246);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_247);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_248);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_249);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_250);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_251);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_252);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_253);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_254);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_255);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_256);
    stringBuffer.append(main.getName());
    stringBuffer.append(TEXT_257);
    stringBuffer.append(dynamicColName);
    stringBuffer.append(TEXT_258);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_259);
    
                        }else{
                        
    stringBuffer.append(TEXT_260);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_261);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_262);
    stringBuffer.append(main.getName());
    stringBuffer.append(TEXT_263);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_264);
    stringBuffer.append(JavaTypesManager.getDefaultValueFromJavaType(typeToGenerate));
    stringBuffer.append(TEXT_265);
    if(javaType == JavaTypesManager.STRING){
    stringBuffer.append(TEXT_266);
    stringBuffer.append(main.getName());
    stringBuffer.append(TEXT_267);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_268);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_269);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_270);
    }else{
    stringBuffer.append(TEXT_271);
    stringBuffer.append(main.getName());
    stringBuffer.append(TEXT_272);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_273);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_274);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_275);
    stringBuffer.append(i);
    stringBuffer.append(TEXT_276);
    }
    stringBuffer.append(TEXT_277);
    
                    	}
                    }
                    
                    //pass error columns
            		List<IMetadataColumn> rejectColumns = reject.getMetadataTable().getListColumns();
            		for(IMetadataColumn column : rejectColumns) {
            			String columnName = column.getLabel();
            			
            			JavaType javaType = JavaTypesManager.getJavaTypeFromId(column.getTalendType());
                        String typeToGenerate = JavaTypesManager.getTypeToGenerate(column.getTalendType(), column.isNullable());
                        
            			//error columns
            			if(!commonColumns.contains(columnName)) {
            			
    stringBuffer.append(TEXT_278);
    stringBuffer.append(reject.getName());
    stringBuffer.append(TEXT_279);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_280);
    stringBuffer.append(typeToGenerate);
    stringBuffer.append(TEXT_281);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_282);
    stringBuffer.append(columnName);
    stringBuffer.append(TEXT_283);
    
            			}
            		}
                    
    stringBuffer.append(TEXT_284);
    }
    stringBuffer.append(TEXT_285);
    
		}
	} else if (def instanceof OutputComponentDefinition) {
	
    stringBuffer.append(TEXT_286);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_287);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_288);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_289);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_290);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_291);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_292);
    //create folder for file; create database/table for db
    stringBuffer.append(TEXT_293);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_294);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_295);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_296);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_297);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_298);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_299);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_300);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_301);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_302);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_303);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_304);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_305);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_306);
    
	}
}

    stringBuffer.append(TEXT_307);
    return stringBuffer.toString();
  }
}
