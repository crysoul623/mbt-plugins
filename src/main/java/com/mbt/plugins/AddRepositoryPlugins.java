/**
 * 
 */
package com.mbt.plugins;

import java.util.List;

import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.TopLevelClass;

/**
 * @author zoro02.lin
 *
 */
public class AddRepositoryPlugins extends PluginAdapter {

	/* (non-Javadoc)
	 * @see org.mybatis.generator.api.Plugin#validate(java.util.List)
	 */
	@Override
	public boolean validate(List<String> warnings) {
		return true;
	}

	public boolean clientGenerated(Interface interfaze, TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
		//import Repository annotation package.
		FullyQualifiedJavaType repositoryAnnotationType = new FullyQualifiedJavaType("org.springframework.stereotype.Repository");
		interfaze.addImportedType(repositoryAnnotationType);
		//add annotation
		interfaze.addAnnotation("@Repository");
		super.clientGenerated(interfaze, topLevelClass, introspectedTable);
        return true;
    }
	
}