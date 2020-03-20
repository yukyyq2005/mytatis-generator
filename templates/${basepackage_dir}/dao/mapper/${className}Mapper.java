<#assign className=table.className>
<#assign classNameLower=className?uncap_first>
package ${basepackage}.dao.mapper;
import ${basepackage}.dao.model.${className};
<#assign pkn=""><#assign pkt ="">
<#list table.pkColumns as pk>
	<#assign pkn =pk.sqlName?lower_case>
	<#assign pkt =pk.javaType>
</#list>
public interface ${className}Mapper extends Mapper<${className}>{
	
}