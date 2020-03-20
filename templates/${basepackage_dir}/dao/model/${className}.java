package ${basepackage}.dao.model;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

//${table.tableAlias}
@Table(name="${table.sqlName?lower_case}")
<#assign pk={}>
<#list table.pkColumns as pp>
	<#assign pk=pp>
</#list>
public class ${table.className} implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	<@properties/>
	<@functionget/>
	<@functionset/>
}
<#macro properties><#list table.columns as cc>
<#if cc.pk==true>
	//主键编号
	@Id 
	@Column(name="${cc.sqlName?lower_case}")	
<#if cc.javaType=='java.lang.Integer'>
	@GeneratedValue(strategy = GenerationType.IDENTITY)
<#elseif cc.javaType=='java.lang.Long'>
	@GeneratedValue(strategy = GenerationType.IDENTITY)
</#if>
	private ${cc.javaType} ${cc.columnNameLower};	
<#else>
	//${cc.columnAlias}
	@Column(name="${cc.sqlName?lower_case}")	
	private ${cc.javaType} ${cc.columnNameLower};
</#if></#list>

</#macro>

<#macro functionget><#list table.columns as cc><#if cc.pk>
	public ${cc.javaType} get${cc.columnName}() {
		return ${cc.columnNameLower};
	}
<#else>
	public ${cc.javaType} get${cc.columnName}() {
		return ${cc.columnNameLower};
	}
</#if></#list></#macro>

<#macro functionset><#list table.columns as cc><#if cc.pk>
	public void set${cc.columnName}(${cc.javaType} ${cc.columnNameLower}) {
		this.${cc.columnNameLower}=${cc.columnNameLower};
	}
<#else>
	public void set${cc.columnName}(${cc.javaType} ${cc.columnNameLower}) {
		this.${cc.columnNameLower}=${cc.columnNameLower};
	}
</#if></#list></#macro>



