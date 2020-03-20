import org.springframework.stereotype.Service;

<#assign className=table.className>
<#assign classNameLower=className?uncap_first>
        package ${basepackage}.service.impl;
        {basepackage}.dao.mapper.${className}Mapper;{basepackage}.service.I${className}Service;

@Service
public class ${className}ServiceImpl implements I${className}Service { 
	
	@Autowired
	private ${className}Mapper ${classNameLower}Mapper;
	
}