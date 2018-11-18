##获取列表
#sql("list")
	select id   ,name  ,age  ,sex  ,code  ,parent_name  ,parent_info  ,create_time  ,start_time 	from
    t_student where 1=1 and age<>1
    #if(ids!=null&&ids!="") and  id in (#(ids)) #end
    #if(name!=null&&name!="") and  name like '%#(name)%' #end
     #if(name2!=null&&name2!="") and  name = '#(name2)' #end
    #if(sex!=null&&sex!="") and  sex = #(sex) #end
    #if(parent_info!=null&&parent_info!="") and  parent_info like '%#(parent_info)%' #end
    order by create_time desc
#end

##分页
#sql("pageList")
	select id   ,name  ,age  ,sex  ,code  ,parent_name  ,parent_info  ,create_time  ,start_time 	from
	t_student where 1=1 and age<>1
	#for(x : params)
		#if(x.value != null && x.value != "")
			and #field(x.key) #para(x.value) 
		#end
	#end
		order by #if(sort != "") #(sort) #else id #end  #if(order != "") #(order) #else desc #end
#end

##分页1
#sql("pageList1")
	select id   ,name  ,age  ,sex  ,code  ,parent_name  ,parent_info  ,create_time  ,start_time 	from
	t_student where 1=1 and age<>1
	#for(x : params)
		#if(x.value != null && x.value != "")
			and #field(x.key) '%#(x.value)%'
		#end
	#end
		order by #if(sort != "") #(sort) #else id #end  #if(order != "") #(order) #else desc #end
#end