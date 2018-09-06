<#import "/spring.ftl" as spring/>
{
	"_csrf": "${_csrf.token}"
}

<#if Session.SPRING_SECURITY_LAST_EXCEPTION?? && Session.SPRING_SECURITY_LAST_EXCEPTION.message?has_content>
    <h1>Bad credential</h1>
</#if>