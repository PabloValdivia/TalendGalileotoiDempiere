package org.talend.designer.codegen.translators.cloud;

import org.talend.core.model.process.INode;
import org.talend.core.model.process.ElementParameterParser;
import org.talend.designer.codegen.config.CodeGeneratorArgument;
import java.util.Map;
import java.util.List;

public class TAmazonEMRManageBeginJava
{
  protected static String nl;
  public static synchronized TAmazonEMRManageBeginJava create(String lineSeparator)
  {
    nl = lineSeparator;
    TAmazonEMRManageBeginJava result = new TAmazonEMRManageBeginJava();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "";
  protected final String TEXT_2 = NL + "\tint count_";
  protected final String TEXT_3 = " = 0;" + NL + "\tcom.amazonaws.services.elasticmapreduce.model.HadoopJarStepConfig hadoopConfig1_";
  protected final String TEXT_4 = " = null;" + NL + "\tcom.amazonaws.services.elasticmapreduce.model.StepConfig customStep_";
  protected final String TEXT_5 = " = null;" + NL + "" + NL + "\tjava.util.List<com.amazonaws.services.elasticmapreduce.model.StepConfig> steps_";
  protected final String TEXT_6 = " = new java.util.ArrayList<com.amazonaws.services.elasticmapreduce.model.StepConfig>();";
  protected final String TEXT_7 = NL + NL + "\tcount_";
  protected final String TEXT_8 = "++;" + NL + "" + NL + "\thadoopConfig1_";
  protected final String TEXT_9 = " = new com.amazonaws.services.elasticmapreduce.model.HadoopJarStepConfig()" + NL + "\t\t\t  ";
  protected final String TEXT_10 = NL + "\t\t      .withMainClass(";
  protected final String TEXT_11 = ")" + NL + "\t\t      ";
  protected final String TEXT_12 = NL + "\t\t      " + NL + "\t\t      .withJar(";
  protected final String TEXT_13 = ")" + NL + "\t\t\t  " + NL + "\t\t\t  ";
  protected final String TEXT_14 = "\t\t      " + NL + "\t\t      .withArgs(";
  protected final String TEXT_15 = ")" + NL + "\t\t      ";
  protected final String TEXT_16 = NL + "\t\t      " + NL + "\t\t      ;" + NL + "    " + NL + "\tcustomStep_";
  protected final String TEXT_17 = " = new com.amazonaws.services.elasticmapreduce.model.StepConfig(\"Step_\" + count_";
  protected final String TEXT_18 = ", hadoopConfig1_";
  protected final String TEXT_19 = ")" + NL + "\t\t   .withActionOnFailure(";
  protected final String TEXT_20 = ")" + NL + "\t\t   .withName(";
  protected final String TEXT_21 = ");" + NL + "" + NL + "\tsteps_";
  protected final String TEXT_22 = ".add(customStep_";
  protected final String TEXT_23 = ");    " + NL;
  protected final String TEXT_24 = NL;
  protected final String TEXT_25 = NL + "\t        " + NL + "\t";
  protected final String TEXT_26 = NL + "\t" + NL + "\t";
  protected final String TEXT_27 = " " + NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_28 = " = routines.system.PasswordEncryptUtil.decryptPassword(";
  protected final String TEXT_29 = ");";
  protected final String TEXT_30 = NL + "\tfinal String decryptedPassword_";
  protected final String TEXT_31 = " = ";
  protected final String TEXT_32 = "; ";
  protected final String TEXT_33 = NL + "   \t" + NL + "   \tcom.amazonaws.auth.AWSCredentials credentials_";
  protected final String TEXT_34 = " = new com.amazonaws.auth.BasicAWSCredentials(";
  protected final String TEXT_35 = ",decryptedPassword_";
  protected final String TEXT_36 = ");" + NL + "   \t" + NL + "\tcom.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceClient emr_";
  protected final String TEXT_37 = " = new com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduceClient(credentials_";
  protected final String TEXT_38 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_39 = NL + "\temr_";
  protected final String TEXT_40 = ".setRegion(com.amazonaws.regions.RegionUtils.getRegion(";
  protected final String TEXT_41 = "));" + NL + "\t";
  protected final String TEXT_42 = NL + NL + "\t";
  protected final String TEXT_43 = NL + "\t\tcom.amazonaws.services.elasticmapreduce.model.ListClustersRequest request_";
  protected final String TEXT_44 = " = new com.amazonaws.services.elasticmapreduce.model.ListClustersRequest()" + NL + "\t\t\t.withClusterStates(" + NL + "\t\t\t\tcom.amazonaws.services.elasticmapreduce.model.ClusterState.BOOTSTRAPPING," + NL + "\t\t\t\tcom.amazonaws.services.elasticmapreduce.model.ClusterState.STARTING," + NL + "\t\t\t\tcom.amazonaws.services.elasticmapreduce.model.ClusterState.RUNNING," + NL + "\t\t\t\tcom.amazonaws.services.elasticmapreduce.model.ClusterState.WAITING" + NL + "\t\t\t)" + NL + "\t\t;" + NL + "    \tcom.amazonaws.services.elasticmapreduce.model.ListClustersResult result_";
  protected final String TEXT_45 = " = emr_";
  protected final String TEXT_46 = ".listClusters(request_";
  protected final String TEXT_47 = ");" + NL + "    \tjava.util.List<com.amazonaws.services.elasticmapreduce.model.ClusterSummary> clusters_";
  protected final String TEXT_48 = " = result_";
  protected final String TEXT_49 = ".getClusters();" + NL + "    \t" + NL + "    \tjava.util.List<String> ids_";
  protected final String TEXT_50 = " = new java.util.ArrayList<String>();" + NL + "    \t" + NL + "    \t";
  protected final String TEXT_51 = NL + "    \tfor(com.amazonaws.services.elasticmapreduce.model.ClusterSummary summary_";
  protected final String TEXT_52 = " : clusters_";
  protected final String TEXT_53 = ") {" + NL + "\t\t\t";
  protected final String TEXT_54 = NL + "\t\t\t\tids_";
  protected final String TEXT_55 = ".add(summary_";
  protected final String TEXT_56 = ".getId());" + NL + "\t\t\t";
  protected final String TEXT_57 = NL + "\t\t\t\tif(";
  protected final String TEXT_58 = ".equals(summary_";
  protected final String TEXT_59 = ".getName())) {" + NL + "\t\t\t\t\tids_";
  protected final String TEXT_60 = ".add(summary_";
  protected final String TEXT_61 = ".getId());" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_62 = NL + "\t\t\t\tif(";
  protected final String TEXT_63 = ".equals(summary_";
  protected final String TEXT_64 = ".getId())) {" + NL + "\t\t\t\t\tids_";
  protected final String TEXT_65 = ".add(summary_";
  protected final String TEXT_66 = ".getId());" + NL + "\t\t\t\t}" + NL + "\t\t\t";
  protected final String TEXT_67 = NL + "    \t}" + NL + "    \t" + NL + "    \tcom.amazonaws.services.elasticmapreduce.model.TerminateJobFlowsRequest request2_";
  protected final String TEXT_68 = " = new com.amazonaws.services.elasticmapreduce.model.TerminateJobFlowsRequest();" + NL + "    \tif(!ids_";
  protected final String TEXT_69 = ".isEmpty()) {" + NL + "    \t\trequest2_";
  protected final String TEXT_70 = ".withJobFlowIds(ids_";
  protected final String TEXT_71 = ");" + NL + "    \t\temr_";
  protected final String TEXT_72 = ".terminateJobFlows(request2_";
  protected final String TEXT_73 = ");\t" + NL + "    \t} else {" + NL + "    \t\t";
  protected final String TEXT_74 = NL + "    \t\t\tthrow new RuntimeException(\"can't find any running cluster\");" + NL + "    \t\t";
  protected final String TEXT_75 = NL + "    \t\t\tthrow new RuntimeException(\"can't find any running cluster with name : \" + ";
  protected final String TEXT_76 = ");" + NL + "    \t\t";
  protected final String TEXT_77 = NL + "    \t\t\tthrow new RuntimeException(\"can't find any running cluster with id : \" + ";
  protected final String TEXT_78 = ");" + NL + "    \t\t";
  protected final String TEXT_79 = NL + "    \t}" + NL + "    \t" + NL + "\t";
  protected final String TEXT_80 = NL + "\tcom.amazonaws.services.elasticmapreduce.util.StepFactory stepFactory_";
  protected final String TEXT_81 = " = new com.amazonaws.services.elasticmapreduce.util.StepFactory();" + NL + "" + NL + "\tcom.amazonaws.services.elasticmapreduce.model.StepConfig enabledebugging_";
  protected final String TEXT_82 = " = new com.amazonaws.services.elasticmapreduce.model.StepConfig()" + NL + "    \t.withName(\"Enable debugging\")" + NL + "    \t.withActionOnFailure(" + NL + "    \t\tcom.amazonaws.services.elasticmapreduce.model.ActionOnFailure.TERMINATE_JOB_FLOW" + NL + "    \t)" + NL + "    \t.withHadoopJarStep(stepFactory_";
  protected final String TEXT_83 = ".newEnableDebuggingStep());" + NL + "" + NL + "\tsteps_";
  protected final String TEXT_84 = ".add(0, enabledebugging_";
  protected final String TEXT_85 = ");" + NL + "" + NL + "\t";
  protected final String TEXT_86 = NL + "\t";
  protected final String TEXT_87 = "\tString[] applications_";
  protected final String TEXT_88 = " = " + NL + "\t";
  protected final String TEXT_89 = NL + "\t\t{\"Ganglia\",\"Hadoop\",\"Hive\",\"Hue\",\"Mahout\",\"Pig\",\"Spark\"}" + NL + "\t\t";
  protected final String TEXT_90 = NL + "\t\t{\"Ganglia\",\"Hadoop\",\"Hive\",\"Hue\",\"Mahout\",\"Pig\",\"Spark\"}" + NL + "\t\t";
  protected final String TEXT_91 = NL + "\t\t{\"Hadoop\",\"Hive\",\"Hue\",\"Mahout\",\"Pig\",\"Spark\"}" + NL + "\t\t";
  protected final String TEXT_92 = NL + "\t\t{\"Hadoop\",\"Hive\",\"Mahout\",\"Pig\",\"Spark\"}" + NL + "\t\t";
  protected final String TEXT_93 = NL + "\t\t{\"Ganglia\",\"Hadoop\",\"Hive\",\"Pig\"}" + NL + "\t\t";
  protected final String TEXT_94 = NL + "\t\t{\"Ganglia\",\"Hadoop\",\"Hive\",\"Pig\"}" + NL + "\t\t";
  protected final String TEXT_95 = NL + "\t\t{\"Hadoop\",\"Hive\",\"Pig\"}" + NL + "\t\t";
  protected final String TEXT_96 = NL + "\t\t{\"Hadoop\",\"Hive\",\"Pig\"}" + NL + "\t\t";
  protected final String TEXT_97 = NL + "\t\t{\"Hadoop\",\"Hive\",\"Presto-Sandbox\"}" + NL + "\t\t";
  protected final String TEXT_98 = NL + "\t\t{\"Hadoop\",\"Hive\",\"Presto-Sandbox\"}" + NL + "\t\t";
  protected final String TEXT_99 = NL + "\t\t{\"Hadoop\",\"Hive\",\"Presto-Sandbox\"}" + NL + "\t\t";
  protected final String TEXT_100 = NL + "\t\t{\"Ganglia\",\"Hadoop\",\"Spark\"}" + NL + "\t\t";
  protected final String TEXT_101 = NL + "\t\t{\"Ganglia\",\"Hadoop\",\"Spark\"}" + NL + "\t\t";
  protected final String TEXT_102 = NL + "\t\t{\"Hadoop\",\"Spark\"}" + NL + "\t\t";
  protected final String TEXT_103 = NL + "\t\t{\"Hadoop\",\"Spark\"}" + NL + "\t\t";
  protected final String TEXT_104 = NL + "\t;" + NL + "\t" + NL + "    java.util.List<com.amazonaws.services.elasticmapreduce.model.Application> apps_";
  protected final String TEXT_105 = " = new java.util.ArrayList<com.amazonaws.services.elasticmapreduce.model.Application>();" + NL + "\tfor(String application_";
  protected final String TEXT_106 = " : applications_";
  protected final String TEXT_107 = ") {" + NL + "    \tcom.amazonaws.services.elasticmapreduce.model.Application app_";
  protected final String TEXT_108 = " = new com.amazonaws.services.elasticmapreduce.model.Application();" + NL + "    \tapp_";
  protected final String TEXT_109 = ".withName(application_";
  protected final String TEXT_110 = ");" + NL + "    \tapps_";
  protected final String TEXT_111 = ".add(app_";
  protected final String TEXT_112 = ");" + NL + "    }" + NL + "\t";
  protected final String TEXT_113 = NL + "\tcom.amazonaws.services.elasticmapreduce.model.RunJobFlowRequest request_";
  protected final String TEXT_114 = " = new com.amazonaws.services.elasticmapreduce.model.RunJobFlowRequest()" + NL + "    \t.withName(";
  protected final String TEXT_115 = ")" + NL + "    \t";
  protected final String TEXT_116 = NL + "    \t.withLogUri(";
  protected final String TEXT_117 = ")" + NL + "    \t";
  protected final String TEXT_118 = NL + "    \t" + NL + "    \t";
  protected final String TEXT_119 = NL + "    \t\t.withAmiVersion(";
  protected final String TEXT_120 = ")" + NL + "    \t";
  protected final String TEXT_121 = NL + "    \t\t.withReleaseLabel(";
  protected final String TEXT_122 = ")" + NL + "    \t";
  protected final String TEXT_123 = NL + "    \t" + NL + "    \t";
  protected final String TEXT_124 = NL + "    \t\t.withApplications(apps_";
  protected final String TEXT_125 = ")" + NL + "    \t";
  protected final String TEXT_126 = NL + "    \t" + NL + "    \t.withSteps(steps_";
  protected final String TEXT_127 = ")" + NL + "    \t" + NL + "    \t.withServiceRole(";
  protected final String TEXT_128 = ")" + NL + "    \t.withJobFlowRole(";
  protected final String TEXT_129 = ")" + NL + "    \t" + NL + "    \t";
  protected final String TEXT_130 = NL + "    \t.withVisibleToAllUsers(true)" + NL + "    \t";
  protected final String TEXT_131 = NL + "    \t" + NL + "    \t.withInstances(" + NL + "    \t\tnew com.amazonaws.services.elasticmapreduce.model.JobFlowInstancesConfig()" + NL + "    \t\t\t.withInstanceCount(";
  protected final String TEXT_132 = ")" + NL + "    \t\t\t";
  protected final String TEXT_133 = NL + "    \t\t\t.withEc2KeyName(";
  protected final String TEXT_134 = ")" + NL + "    \t\t\t";
  protected final String TEXT_135 = NL + "    \t\t\t.withMasterInstanceType(";
  protected final String TEXT_136 = ")" + NL + "    \t\t\t.withSlaveInstanceType(";
  protected final String TEXT_137 = ")" + NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_138 = NL + "    \t\t\t.withPlacement(new com.amazonaws.services.elasticmapreduce.model.PlacementType().withAvailabilityZone(";
  protected final String TEXT_139 = "))" + NL + "    \t\t\t";
  protected final String TEXT_140 = NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_141 = NL + "    \t\t\t.withEmrManagedMasterSecurityGroup(";
  protected final String TEXT_142 = ")" + NL + "    \t\t\t";
  protected final String TEXT_143 = NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_144 = NL + "    \t\t\t.withAdditionalMasterSecurityGroups(";
  protected final String TEXT_145 = ".split(\",\"))" + NL + "    \t\t\t";
  protected final String TEXT_146 = NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_147 = NL + "    \t\t\t.withEmrManagedSlaveSecurityGroup(";
  protected final String TEXT_148 = ")" + NL + "    \t\t\t";
  protected final String TEXT_149 = NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_150 = NL + "    \t\t\t.withAdditionalSlaveSecurityGroups(";
  protected final String TEXT_151 = ".split(\",\"))" + NL + "    \t\t\t";
  protected final String TEXT_152 = NL + "    \t\t\t" + NL + "    \t\t\t";
  protected final String TEXT_153 = NL + "    \t\t\t.withTerminationProtected(true)" + NL + "    \t\t\t";
  protected final String TEXT_154 = NL + "    \t\t\t" + NL + "    \t\t\t.withKeepJobFlowAliveWhenNoSteps(";
  protected final String TEXT_155 = ")" + NL + "    \t);" + NL + "" + NL + "\tcom.amazonaws.services.elasticmapreduce.model.RunJobFlowResult result_";
  protected final String TEXT_156 = " = emr_";
  protected final String TEXT_157 = ".runJobFlow(request_";
  protected final String TEXT_158 = ");" + NL + "\t" + NL + "\t";
  protected final String TEXT_159 = NL + "\tlog.info(\"";
  protected final String TEXT_160 = " - cluster status : \" + result_";
  protected final String TEXT_161 = ");" + NL + "\t";
  protected final String TEXT_162 = NL + "\t" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_163 = "_CLUSTER_FINAL_ID\", result_";
  protected final String TEXT_164 = ".getJobFlowId());" + NL + "\tglobalMap.put(\"";
  protected final String TEXT_165 = "_CLUSTER_FINAL_NAME\", ";
  protected final String TEXT_166 = ");" + NL + "\t" + NL + "\t";
  protected final String TEXT_167 = NL + "\t\tboolean clusterIsAlive_";
  protected final String TEXT_168 = " = false;" + NL + "        System.out.println(\"Wating for cluster to become available.\");" + NL + "        while (true) {" + NL + "            com.amazonaws.services.elasticmapreduce.model.DescribeClusterResult result2_";
  protected final String TEXT_169 = " = emr_";
  protected final String TEXT_170 = ".describeCluster(" + NL + "            \tnew com.amazonaws.services.elasticmapreduce.model.DescribeClusterRequest()" + NL + "               \t\t.withClusterId(result_";
  protected final String TEXT_171 = ".getJobFlowId())" + NL + "            );" + NL + "            String status_";
  protected final String TEXT_172 = " = result2_";
  protected final String TEXT_173 = ".getCluster().getStatus().getState();" + NL + "            if (\"WAITING\".equalsIgnoreCase(status_";
  protected final String TEXT_174 = ") || \"RUNNING\".equalsIgnoreCase(status_";
  protected final String TEXT_175 = ")) {" + NL + "            \tclusterIsAlive_";
  protected final String TEXT_176 = " = true;" + NL + "                break;" + NL + "            } else if(\"TERMINATED\".equalsIgnoreCase(status_";
  protected final String TEXT_177 = ")) {" + NL + "                break;" + NL + "            } else if(\"TERMINATED_WITH_ERRORS\".equalsIgnoreCase(status_";
  protected final String TEXT_178 = ")) {" + NL + "            \tSystem.err.println(\"Fail to start the cluster.\");" + NL + "            \tbreak;" + NL + "            } else {" + NL + "                System.out.print(\".\");" + NL + "                Thread.sleep(2000);" + NL + "            }" + NL + "        }" + NL + "\t";
  protected final String TEXT_179 = NL + NL + "\t";
  protected final String TEXT_180 = NL + "\t\tboolean waitForStep_";
  protected final String TEXT_181 = " = clusterIsAlive_";
  protected final String TEXT_182 = " && (steps_";
  protected final String TEXT_183 = ".size() > 1);" + NL + "\t\t" + NL + "\t\tif(waitForStep_";
  protected final String TEXT_184 = ") {" + NL + "        \tSystem.out.println(\"Wating for steps to complete.\");" + NL + "        }" + NL + "        " + NL + "        while (waitForStep_";
  protected final String TEXT_185 = ") {" + NL + "            com.amazonaws.services.elasticmapreduce.model.DescribeClusterResult result2_";
  protected final String TEXT_186 = " = emr_";
  protected final String TEXT_187 = ".describeCluster(" + NL + "            \tnew com.amazonaws.services.elasticmapreduce.model.DescribeClusterRequest()" + NL + "               \t\t.withClusterId(result_";
  protected final String TEXT_188 = ".getJobFlowId())" + NL + "            );" + NL + "            String status_";
  protected final String TEXT_189 = " = result2_";
  protected final String TEXT_190 = ".getCluster().getStatus().getState();" + NL + "            if (\"WAITING\".equalsIgnoreCase(status_";
  protected final String TEXT_191 = ") || \"TERMINATED\".equalsIgnoreCase(status_";
  protected final String TEXT_192 = ") || \"TERMINATING\".equalsIgnoreCase(status_";
  protected final String TEXT_193 = ")) {" + NL + "            \tbreak;" + NL + "            } else if(\"TERMINATED_WITH_ERRORS\".equalsIgnoreCase(status_";
  protected final String TEXT_194 = ")) {" + NL + "            \tSystem.err.println(\"Fail to complete steps.\");" + NL + "            \tbreak;" + NL + "            } else {" + NL + "                System.out.print(\".\");" + NL + "                Thread.sleep(2000);" + NL + "            }" + NL + "        }" + NL + "\t";
  protected final String TEXT_195 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    
	CodeGeneratorArgument codeGenArgument = (CodeGeneratorArgument) argument;
	INode node = (INode)codeGenArgument.getArgument();
	String cid = node.getUniqueName();
	
	class ParameterUtil {
		boolean isValid(String parameterValue) {
			return parameterValue!=null && !parameterValue.isEmpty() && !"\"\"".equals(parameterValue);
		}
	}
	
	ParameterUtil parameterUtil = new ParameterUtil();
	
	List<Map<String, String>> lines = (List<Map<String, String>>)ElementParameterParser.getObjectValue(node, "__STEP_TABLE__");

    stringBuffer.append(TEXT_2);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_6);
    
	for (int i=0; i<lines.size(); i++) {
	Map<String, String> line = lines.get(i);

    stringBuffer.append(TEXT_7);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_9);
    if(parameterUtil.isValid(line.get("MAIN_CLASS"))){
    stringBuffer.append(TEXT_10);
    stringBuffer.append( line.get("MAIN_CLASS") );
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    stringBuffer.append( line.get("JAR") );
    stringBuffer.append(TEXT_13);
    if(parameterUtil.isValid(line.get("ARGS"))){
    stringBuffer.append(TEXT_14);
    stringBuffer.append( line.get("ARGS") );
    stringBuffer.append(TEXT_15);
    }
    stringBuffer.append(TEXT_16);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_19);
    stringBuffer.append( line.get("ACTION_ON_FAILURE") );
    stringBuffer.append(TEXT_20);
    stringBuffer.append( line.get("NAME") );
    stringBuffer.append(TEXT_21);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_22);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_23);
    
	}

    stringBuffer.append(TEXT_24);
    
	String action = ElementParameterParser.getValue(node, "__ACTION__");
	String region = ElementParameterParser.getValue(node, "__REGION__");
	String cluster_name = ElementParameterParser.getValue(node, "__CLUSTER_NAME__");
	String cluster_version = ElementParameterParser.getValue(node, "__CLUSTER_VERSION__");
	
	String service_role = ElementParameterParser.getValue(node, "__SERVICE_ROLE__");
	String jobflow_role = ElementParameterParser.getValue(node, "__JOBFLOW_ROLE__");
	
	boolean enable_log = "true".equals(ElementParameterParser.getValue(node, "__ENABLE_LOG__"));
	String log_url = ElementParameterParser.getValue(node, "__LOG_URL__");
	
	boolean enable_key_pair = "true".equals(ElementParameterParser.getValue(node, "__ENABLE_KEY_PAIR__"));
	String key_pair = ElementParameterParser.getValue(node, "__KEY_PAIR__");
	
	int instance_count = Integer.parseInt(ElementParameterParser.getValue(node, "__INSTANCE_COUNT__"));
	
	String master_instance_type = ElementParameterParser.getValue(node, "__MASTER_INSTANCE_TYPE__");
	String slave_instance_type = ElementParameterParser.getValue(node, "__SLAVE_INSTANCE_TYPE__");
	
	boolean visible_to_all_users = "true".equals(ElementParameterParser.getValue(node, "__VISIBLE_TO_ALL_USERS__"));
	
	boolean termination_protected = "true".equals(ElementParameterParser.getValue(node, "__TERMINATION_PROTECTED__"));
	
	String master_security_group = ElementParameterParser.getValue(node, "__MASTER_SECURITY_GROUP__");
	String additional_master_security_groups = ElementParameterParser.getValue(node, "__ADDITIONAL_MASTER_SECURITY_GROUPS__");
	String slave_security_group = ElementParameterParser.getValue(node, "__SLAVE_SECURITY_GROUP__");
	String additional_slave_security_groups = ElementParameterParser.getValue(node, "__ADDITIONAL_SLAVE_SECURITY_GROUPS__");
	
	boolean wait_for_cluster_ready = "true".equals(ElementParameterParser.getValue(node, "__WAIT_FOR_CLUSTER_READY__"));
	boolean wait_for_steps_complete = "true".equals(ElementParameterParser.getValue(node, "__WAIT_FOR_STEPS_COMPLETE__"));
	
	String accesskey = ElementParameterParser.getValue(node, "__ACCESS_KEY__");
	
	String availability_zone = ElementParameterParser.getValue(node, "__AVAILABILITY_ZONE__");
	
	boolean isLog4jEnabled = "true".equals(ElementParameterParser.getValue(node.getProcess(), "__LOG4J_ACTIVATE__"));

	boolean keep_alive = "true".equals(ElementParameterParser.getValue(node, "__KEEP_ALIVE__"));

    stringBuffer.append(TEXT_25);
    
	String passwordFieldName = "__SECRET_KEY__";
	
    stringBuffer.append(TEXT_26);
    if (ElementParameterParser.canEncrypt(node, passwordFieldName)) {
    stringBuffer.append(TEXT_27);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_28);
    stringBuffer.append(ElementParameterParser.getEncryptedValue(node, passwordFieldName));
    stringBuffer.append(TEXT_29);
    } else {
    stringBuffer.append(TEXT_30);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_31);
    stringBuffer.append( ElementParameterParser.getValue(node, passwordFieldName));
    stringBuffer.append(TEXT_32);
    }
    stringBuffer.append(TEXT_33);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_34);
    stringBuffer.append(accesskey);
    stringBuffer.append(TEXT_35);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_36);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_37);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_38);
    
	if(region!=null && !region.isEmpty() && !"DEFAULT".equalsIgnoreCase(region)){
	
    stringBuffer.append(TEXT_39);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_40);
    stringBuffer.append(region);
    stringBuffer.append(TEXT_41);
    
	}
	
    stringBuffer.append(TEXT_42);
    
	if("STOP".equals(action)) {
	
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
    
    	String predicates = ElementParameterParser.getValue(node, "__PREDICATES__");
    	String name = ElementParameterParser.getValue(node, "__NAME_OF_CLUSTER__");
    	String id = ElementParameterParser.getValue(node, "__ID_OF_CLUSTER__");
    	
    stringBuffer.append(TEXT_51);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_52);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_53);
    
			if("RUNNING".equals(predicates)) {
			
    stringBuffer.append(TEXT_54);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_55);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_56);
    
			} else if("RUNNING_WITH_NAME".equals(predicates)) {
			
    stringBuffer.append(TEXT_57);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_58);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_59);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_60);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_61);
    
			} else if("RUNNING_WITH_ID".equals(predicates)) {
			
    stringBuffer.append(TEXT_62);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_63);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_64);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_65);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_66);
    
			}
			
    stringBuffer.append(TEXT_67);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_68);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_69);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_70);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_71);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_72);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_73);
    
    		if("RUNNING".equals(predicates)) {
    		
    stringBuffer.append(TEXT_74);
    
    		} else if("RUNNING_WITH_NAME".equals(predicates)) {
    		
    stringBuffer.append(TEXT_75);
    stringBuffer.append(name);
    stringBuffer.append(TEXT_76);
    
    		} else if("RUNNING_WITH_ID".equals(predicates)) {
    		
    stringBuffer.append(TEXT_77);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_78);
    
    		}
    		
    stringBuffer.append(TEXT_79);
    
		return stringBuffer.toString();
	}
	
    stringBuffer.append(TEXT_80);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_81);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_82);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_83);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_84);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_85);
    
	boolean setApps = cluster_version!=null && "\"emr-4.2.0\",\"emr-4.1.0\",\"emr-4.0.0\",\"emr-4.5.0\"".contains(cluster_version);
	if(setApps) {
	
    stringBuffer.append(TEXT_86);
    stringBuffer.append(TEXT_87);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_88);
    
	String application = ElementParameterParser.getValue(node, "__APPLICATION__");
	if("ALL_APPLICATIONS".equals(application)) {
		if("\"emr-4.5.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_89);
    
		} else if("\"emr-4.2.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_90);
    
		} else if("\"emr-4.1.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_91);
    
		} else if("\"emr-4.0.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_92);
    
		}
	} else if("CORE_HADOOP".equals(application)) {
		if("\"emr-4.5.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_93);
    
		} else if("\"emr-4.2.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_94);
    		
		} else if("\"emr-4.1.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_95);
    
		} else if("\"emr-4.0.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_96);
    
		}
	} else if("PRESTO_SANDBOX".equals(application)) {
		if("\"emr-4.5.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_97);
    
		} else if("\"emr-4.2.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_98);
    
		} else if("\"emr-4.1.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_99);
    
		}
	} else if("SPARK".equals(application)) {
		if("\"emr-4.5.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_100);
    
		} else if("\"emr-4.2.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_101);
    
		} else if("\"emr-4.1.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_102);
    
		} else if("\"emr-4.0.0\"".equals(cluster_version)) {
		
    stringBuffer.append(TEXT_103);
    
		}
	}
	
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
    
	}
	
    stringBuffer.append(TEXT_113);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_114);
    stringBuffer.append(cluster_name);
    stringBuffer.append(TEXT_115);
    if(enable_log){
    stringBuffer.append(TEXT_116);
    stringBuffer.append(log_url);
    stringBuffer.append(TEXT_117);
    }
    stringBuffer.append(TEXT_118);
    
    	if(cluster_version!=null && cluster_version.length()>1){
    		if(Character.isDigit(cluster_version.charAt(1))) {//AMI version
    	
    stringBuffer.append(TEXT_119);
    stringBuffer.append(cluster_version);
    stringBuffer.append(TEXT_120);
    
    		} else {//EMR version
    	
    stringBuffer.append(TEXT_121);
    stringBuffer.append(cluster_version);
    stringBuffer.append(TEXT_122);
    
    		}
    	}
    	
    stringBuffer.append(TEXT_123);
    
    	if(setApps) {
    	
    stringBuffer.append(TEXT_124);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_125);
    
    	}
    	
    stringBuffer.append(TEXT_126);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_127);
    stringBuffer.append(service_role);
    stringBuffer.append(TEXT_128);
    stringBuffer.append(jobflow_role);
    stringBuffer.append(TEXT_129);
    if(visible_to_all_users){
    stringBuffer.append(TEXT_130);
    }
    stringBuffer.append(TEXT_131);
    stringBuffer.append(instance_count);
    stringBuffer.append(TEXT_132);
    if(enable_key_pair){
    stringBuffer.append(TEXT_133);
    stringBuffer.append(key_pair);
    stringBuffer.append(TEXT_134);
    }
    stringBuffer.append(TEXT_135);
    stringBuffer.append(master_instance_type);
    stringBuffer.append(TEXT_136);
    stringBuffer.append(slave_instance_type);
    stringBuffer.append(TEXT_137);
    if(parameterUtil.isValid(availability_zone)){
    stringBuffer.append(TEXT_138);
    stringBuffer.append(availability_zone);
    stringBuffer.append(TEXT_139);
    }
    stringBuffer.append(TEXT_140);
    if(parameterUtil.isValid(master_security_group)){
    stringBuffer.append(TEXT_141);
    stringBuffer.append(master_security_group);
    stringBuffer.append(TEXT_142);
    }
    stringBuffer.append(TEXT_143);
    if(parameterUtil.isValid(additional_master_security_groups)){
    stringBuffer.append(TEXT_144);
    stringBuffer.append(additional_master_security_groups);
    stringBuffer.append(TEXT_145);
    }
    stringBuffer.append(TEXT_146);
    if(parameterUtil.isValid(slave_security_group)){
    stringBuffer.append(TEXT_147);
    stringBuffer.append(slave_security_group);
    stringBuffer.append(TEXT_148);
    }
    stringBuffer.append(TEXT_149);
    if(parameterUtil.isValid(additional_slave_security_groups)){
    stringBuffer.append(TEXT_150);
    stringBuffer.append(additional_slave_security_groups);
    stringBuffer.append(TEXT_151);
    }
    stringBuffer.append(TEXT_152);
    if(termination_protected) {
    stringBuffer.append(TEXT_153);
    }
    stringBuffer.append(TEXT_154);
    stringBuffer.append(keep_alive);
    stringBuffer.append(TEXT_155);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_156);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_157);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_158);
    if(isLog4jEnabled) {
    stringBuffer.append(TEXT_159);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_160);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_161);
    }
    stringBuffer.append(TEXT_162);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_163);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_164);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_165);
    stringBuffer.append(cluster_name);
    stringBuffer.append(TEXT_166);
    
	if(wait_for_cluster_ready) {
	
    stringBuffer.append(TEXT_167);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_168);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_169);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_170);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_171);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_172);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_173);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_174);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_175);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_176);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_177);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_178);
    
	}
	
    stringBuffer.append(TEXT_179);
    
	if(wait_for_steps_complete && wait_for_cluster_ready) {
	
    stringBuffer.append(TEXT_180);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_181);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_182);
    stringBuffer.append(cid );
    stringBuffer.append(TEXT_183);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_184);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_185);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_186);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_187);
    stringBuffer.append(cid);
    stringBuffer.append(TEXT_188);
    stringBuffer.append(cid);
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
    
	}
	
    stringBuffer.append(TEXT_195);
    return stringBuffer.toString();
  }
}
