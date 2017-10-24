input {
  kafka {
    bootstrap_servers => "${bootstrap_servers}"
    topics => "${topics}"
    group_id => "${group_id}"
  }
}

filter {
  csv {
    autogenerate_column_names => "${autogenerate_column_names}"
    columns => [<#list columns1 as column>"${column}"<#if column_has_next>, </#if></#list>]
    convert => {
      <#list converts1?keys as key>
      "${key}" => "${converts1["${key}"]}"
      </#list>
    }
    separator => "|"
  }  

  if [logtype] == "${logtype}" {
    csv {
      autogenerate_column_names => "${autogenerate_column_names}"
      columns => [<#list columns2 as column>"${column}"<#if column_has_next>, </#if></#list>]
      convert => {
        <#list converts2?keys as key>
          "${key}" => "${converts2["${key}"]}"
        </#list>
      }
      separator => "|"
      add_field => {"tmp" => "%{logtime}" }
      remove_field => [<#list removeFields as field>"${field}"<#if field_has_next>, </#if></#list>]
    }
  }
  else {
    drop {}
  }

  mutate {
    split => ["tmp", " "]
    add_field => { "date" => "%{tmp[0]}"}
    remove_field => ["tmp"]
  }
}

output {
  if [logtype] == "${logtype}" {
      elasticsearch {
        action => "index"
        document_type => "%{logtype}"
        hosts => [<#list hosts as host>"${host}"<#if host_has_next>, </#if></#list>]
        index => "${index}"
        template_name => "${template_name}"
        routing => "${routing}"
    }
  }
}