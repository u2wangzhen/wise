##获取列表
#sql("list")
	select id   ,name  ,age  ,sex  ,code  ,parent_name  ,parent_info  ,create_time  ,start_time 	from
    t_student 
#end

##分页
#sql("pageList")
	select id   ,name  ,age  ,sex  ,code  ,parent_name  ,parent_info  ,create_time  ,start_time 	from
	t_student where 1=1 
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
	t_student where 1=1 
	#for(x : params)
		#if(x.value != null && x.value != "")
			and #field(x.key) #para(x.value) 
		#end
	#end
		order by #if(sort != "") #(sort) #else id #end  #if(order != "") #(order) #else desc #end
#end